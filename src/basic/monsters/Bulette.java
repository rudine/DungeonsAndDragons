package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.SpecialAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.attack.types.builders.SpecialAttackBuilder;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.AbilityTypes;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.SavingThrow;
import basic.services.DiceService;

public class Bulette extends AbstractEnemy {

	public Bulette() {
		setAC(17);
		setHitpointsOnCreation(DiceService.throwD10(9) + 45);
		setSpeed("40ft, burrow 40ft");
		setAbilityScores(new AbilityScores(19, 11, 21, 2, 10, 5));
		addToSpecialAbilities(SpecialAbility.StandingLeapLong30High15);
		setAttacksOnAttackAction(1);
		setAttacks();
		setSpecialAttacksOnAction(1);
		setSpecialAttack();
	}
	
	@Override
	protected void setAttacks() {
		MeleeAttackBuilder builder = new MeleeAttackBuilder();
		MeleeAttack bite = builder
				.setWeaponName("Bite")//
				.setToHit(7)//
				.addDamageComponent(new DamageComponent(4, 12, 4, DamageType.PIERCING))//
				.build();
		addToAvailableAttacks(bite);
	}
	
	private void setSpecialAttack() {
		SpecialAttackBuilder builder = new SpecialAttackBuilder();
		SpecialAttack deadlyLeap = builder.setWeaponName("Deadly leap")//
				.setAreaOfEffect("After jump of at least 15ft. land in space with other creatures")//
				.addDamageComponent(new DamageComponent(3, 6, 4, DamageType.BLUDGEONING))//
				.addDamageComponent(new DamageComponent(3, 6, 4, DamageType.SLASHING))//
				.setRecharge(false)//
				.setAvailable(true)//
				.setHalfDamageWhenSaved(true)//
				.setSavingThrow(new SavingThrow(16, AbilityTypes.DEX))//
				.setDescription(getDeadlyLeapDescription())//
				.build();
		addToSpecialAttacks(deadlyLeap);
	}
	
	private String getDeadlyLeapDescription() {
		return "If the bulette jumps at least 15ft. as part of its movement,"
				+ " it can then use this action to land on its feet in a"
				+ " space that contains >= 1 creatures. Each creature must succeed"
				+ " on a DC16 STR or DEX save or be knocked prone and take damage"
				+ " Damage is halved on succes, and the creature is not prone,"
				+ " but pushed 5ft out of the bulettes space to a free space."
				+ " If there is no free space within 5ft the creature falls prone"
				+ " in the bulette's space.";
	}
}
