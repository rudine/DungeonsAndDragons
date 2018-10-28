package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.SpecialAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.attack.types.builders.SpecialAttackBuilder;
import basic.monsters.interfaces.PreparesForNextTurn;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.AbilityTypes;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.Range;
import basic.ruleobjects.SavingThrow;
import basic.services.DiceService;

public class Chimera extends AbstractEnemy implements PreparesForNextTurn{
	
	private String description = "Can be replaced by fire breath";
	
	public Chimera() {
		setAlive(true);
		setAC(14);
		setHitpoints(DiceService.throwD10(12) + 48);
		setSpeed("30 feet, 6 vakjes. Fly 60 ft, 12 vakjes");
		setAbilityScores(new AbilityScores(19, 11, 19, 3, 14, 10));
		setAttacks();
		setAttacksOnAttackAction(3);
		setSpecialAttacks();
		setSpecialAttacksOnAction(1);
	}

	private void setAttacks() {
		MeleeAttackBuilder biteBuilder = new MeleeAttackBuilder();
		MeleeAttack bite = biteBuilder.setWeaponName("Bite") //
					.setToHit(7)//
					.addDamageComponent(new DamageComponent(2, 6, 4, DamageType.PIERCING))//
					.setDescription(description)//
					.build();
		addToAvailableAttacks(bite);
		MeleeAttackBuilder hornsBuilder = new MeleeAttackBuilder();
		MeleeAttack horns = hornsBuilder.setWeaponName("Horns") //
					.setToHit(7)//
					.addDamageComponent(new DamageComponent(1, 12, 4, DamageType.BLUDGEONING))//
					.setDescription(description)//
					.build();
		addToAvailableAttacks(horns);
		MeleeAttackBuilder clawsBuilder = new MeleeAttackBuilder();
		MeleeAttack claws = clawsBuilder.setWeaponName("Claws") //
					.setToHit(7)//
					.addDamageComponent(new DamageComponent(2, 6, 4, DamageType.SLASHING))//
					.build();
		addToAvailableAttacks(claws);
	}

	private void setSpecialAttacks() {
		SpecialAttackBuilder AOEBuilder = new SpecialAttackBuilder();
		SpecialAttack fireBreath = AOEBuilder.setAreaOfEffect("15 foot cone")//
				.addDamageComponent(new DamageComponent(7, 8, 0, DamageType.FIRE))//
				.setSavingThrow(new SavingThrow(15, AbilityTypes.DEX))//
				.setHalfDamageWhenSaved(true)//
				.setWeaponName("Fire Breath")//
				.setDescription(getFireBreathText())//
				.setRecharge(true)//
				.setAvailable(true)//
				.setAvailabilityDie(6)//
				.setSuccesRange(new Range(5, 6))//
				.build();
		addToSpecialAttacks(fireBreath);
	}
	
	private String getFireBreathText() {
		return "Fire Breath (Recharge 5–6). The dragon head exhales fire in a 15-foot cone."
				+ " Each creature in that area must make a DC 15 Dexterity saving throw,"
				+ " taking 31 (7d8) fire damage on a failed save, or half as much damage"
				+ " on a successful one.";
	}
	
	@Override
	public void prepareForNextTurn() {
		specialAttacks.stream().filter(a -> a.hasRecharge()).forEach(a -> a.recharge());
	}
}
