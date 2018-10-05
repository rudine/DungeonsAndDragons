package basic.monsters;

import basic.attacktypes.MeleeAttack;
import basic.attacktypes.MeleeAttackBuilder;
import basic.attacktypes.SpecialAttack;
import basic.attacktypes.SpecialAttackBuilder;
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
					.setBaseDamage(4)
					.setToHit(7)//
					.setDamageDie(6)//
					.setTimesToThrowDamageDie(2)//
					.setDamageType(DamageType.PIERCING)//
					.setDescription(description)//
					.build();
		addToAvailableAttacks(bite);
		MeleeAttackBuilder hornsBuilder = new MeleeAttackBuilder();
		MeleeAttack horns = hornsBuilder.setWeaponName("Horns") //
					.setBaseDamage(4)
					.setToHit(7)//
					.setDamageDie(12)//
					.setTimesToThrowDamageDie(1)//
					.setDamageType(DamageType.BLUDGEONING)//
					.setDescription(description)//
					.build();
		addToAvailableAttacks(horns);
		MeleeAttackBuilder clawsBuilder = new MeleeAttackBuilder();
		MeleeAttack claws = clawsBuilder.setWeaponName("Claws") //
					.setBaseDamage(4)
					.setToHit(7)//
					.setDamageDie(6)//
					.setTimesToThrowDamageDie(2)//
					.setDamageType(DamageType.SLASHING)//
					.build();
		addToAvailableAttacks(claws);
	}

	private void setSpecialAttacks() {
		SpecialAttackBuilder AOEBuilder = new SpecialAttackBuilder();
		SpecialAttack fireBreath = AOEBuilder.setAreaOfEffect("15 foot cone")//
				.setBaseDamage(0)//
				.setDamageDie(8)//
				.setTimesToThrowDamageDie(7)//
				.setDamageType(DamageType.FIRE)//
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
