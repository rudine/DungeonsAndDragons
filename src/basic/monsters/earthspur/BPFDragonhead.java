package basic.monsters.earthspur;

import static basic.ruleobjects.AbilityTypes.CHA;
import static basic.ruleobjects.AbilityTypes.DEX;
import static basic.ruleobjects.AbilityTypes.STR;
import static basic.ruleobjects.Skill.Athletics;
import static basic.ruleobjects.Skill.Intimidation;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.SpecialAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.attack.types.builders.SpecialAttackBuilder;
import basic.monsters.AbstractEnemy;
import basic.monsters.interfaces.PreparesForNextTurn;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.AbilityTypes;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.Range;
import basic.ruleobjects.SavingThrow;
import basic.ruleobjects.modifiers.SaveModifier;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.services.DiceService;

public class BPFDragonhead extends AbstractEnemy implements PreparesForNextTurn{

	public BPFDragonhead() {
		setAlive(true);
		setArmorClass(15);
		setHitpointsOnCreation(DiceService.throwD8(9) + 18);
		setSpeed("30 feet, 6 vakjes");
		setAbilityScores(new AbilityScores(16, 16, 14, 10, 12, 15));
		addToSpecialAbilities(SpecialAbility.Brave);
		setAttacks();
		setSpecialAttacks();
		setAttacksOnAttackAction(2);
		setSpecialAttacksOnAction(1);
		addToSaveModifiers(new SaveModifier(STR, 5), new SaveModifier(DEX, 5));
		addToSkills(new SkillModifier(5, Athletics), new SkillModifier(4, Intimidation));
	}
	
	@Override
	protected void setAttacks() {
		MeleeAttackBuilder meleeBuilder = new MeleeAttackBuilder();
		MeleeAttack burningMaul = meleeBuilder.setWeaponName("Burning maul") //
					.setToHit(5)//
					.addDamageComponent(new DamageComponent(2, 6, 3, DamageType.BLUDGEONING))//
					.addDamageComponent(new DamageComponent(1, 6, 0, DamageType.FIRE))//
					.build();
		addToAvailableAttacks(burningMaul);
	}
	
	private void setSpecialAttacks() {
		SpecialAttackBuilder AOEBuilder = new SpecialAttackBuilder();
		SpecialAttack blowFire = AOEBuilder.setAreaOfEffect("10 foot cone")//
				.addDamageComponent(new DamageComponent(4, 8, 0, DamageType.FIRE))//
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
		specialAttacks.stream().filter(SpecialAttack::hasRecharge).forEach(SpecialAttack::recharge);
	}

	private String getBlowFireText() {
		return "Blow Fire (Recharge 6, dragon head fighter). The boar pit fighter spits "
				+ "a mouthful of oil over the burning maul, exhaling fire in a 10-foot cone. "
				+ "Each creature in that area must make a DC 15 Dexterity saving throw, "
				+ "taking 18 (4d8) fire damage on a failed save, or half as much damage " + "on a successful save.";
	}
}
