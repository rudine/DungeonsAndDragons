package basic.monsters.earthspur;

import static basic.ruleobjects.AbilityTypes.CHA;
import static basic.ruleobjects.AbilityTypes.DEX;
import static basic.ruleobjects.AbilityTypes.STR;
import static basic.ruleobjects.Skill.Athletics;
import static basic.ruleobjects.Skill.Intimidation;

import basic.attacktypes.MeleeAttack;
import basic.attacktypes.MeleeAttackBuilder;
import basic.attacktypes.SpecialAttack;
import basic.attacktypes.SpecialAttackBuilder;
import basic.monsters.AbstractEnemy;
import basic.monsters.PreparesForNextTurn;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.AbilityTypes;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.Range;
import basic.ruleobjects.SavingThrow;
import basic.ruleobjects.modifiers.SaveModifier;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.services.DiceService;

public class BPFDragonHead extends AbstractEnemy implements PreparesForNextTurn{

	public BPFDragonHead() {
		setAlive(true);
		setAC(15);
		setHitpoints(DiceService.throwD8(9) + 18);
		setSpeed("30 feet, 6 vakjes");
		setAbilityScores(new AbilityScores(16, 16, 14, 10, 12, 15));
		addToSpecialAbilities(SpecialAbility.Brave);
		setAttacks();
		setSpecialAttacks();
		setAttacksOnAttackAction(2);
		setSpecialAttacksOnAction(1);
		addToSaveModifiers(new SaveModifier(STR, 5), new SaveModifier(DEX, 5));
		addToSkills(new SkillModifier(5, Athletics, STR), new SkillModifier(4, Intimidation, CHA));
	}
	
	private void setAttacks() {
		MeleeAttackBuilder meleeBuilder = new MeleeAttackBuilder();
		MeleeAttack burningMaul = meleeBuilder.setWeaponName("Burning maul") //
					.setBaseDamage(3 + 3)// FIXME including 3 fire damage
					.setToHit(5)//
					.setDamageDie(6)//
					.setTimesToThrowDamageDie(2)//
					.setDamageType(DamageType.BLUDGEONING)//
					.setDescription("including 3 FIRE dmg")//
					.build();
		addToAvailableAttacks(burningMaul);
	}
	
	private void setSpecialAttacks() {
		SpecialAttackBuilder AOEBuilder = new SpecialAttackBuilder();
		SpecialAttack blowFire = AOEBuilder.setAreaOfEffect("10 foot cone")//
				.setBaseDamage(0)//
				.setDamageDie(8)//
				.setTimesToThrowDamageDie(4)//
				.setDamageType(DamageType.FIRE)//
				.setSavingThrow(new SavingThrow(15, AbilityTypes.DEX))//
				.setHalfDamageWhenSaved(true)//
				.setWeaponName("Blow Fire")//
				.setDescription(getBlowFireText())//
				.setRecharge(true)//
				.setAvailable(true)//
				.setAvailabilityDie(6)//
				.setSuccesRange(new Range(6, 6))//
				.build();
		addToSpecialAttacks(blowFire);
	}

	@Override
	public void prepareForNextTurn() {
		specialAttacks.stream().filter(a -> a.hasRecharge()).forEach(a -> a.recharge());
	}

	private String getBlowFireText() {
		return "Blow Fire (Recharge 6, dragon head fighter). The boar pit fighter spits "
				+ "a mouthful of oil over the burning maul, exhaling fire in a 10-foot cone. "
				+ "Each creature in that area must make a DC 15 Dexterity saving throw, "
				+ "taking 18 (4d8) fire damage on a failed save, or half as much damage " + "on a successful save.";
	}
}
