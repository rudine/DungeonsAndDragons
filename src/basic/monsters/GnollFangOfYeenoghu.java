package basic.monsters;

import basic.attacktypes.MeleeAttack;
import basic.attacktypes.MeleeAttackBuilder;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.services.DiceService;

public class GnollFangOfYeenoghu extends Gnoll {
	
	public GnollFangOfYeenoghu() {
		setHitpoints(DiceService.throwD8(10) + 20);
		setAbilityScores(new AbilityScores(17, 15, 15, 10, 11, 13));
		setAC(14);
		getAvailableAttacks().clear();
		setAttacks();
		setAttacksOnAttackAction(3);
	}
	
	@Override
	protected void setAttacks() {
		addBiteAttack(getAbilityScores().getStrengthModifier());
		addClawAttack(getAbilityScores().getStrengthModifier());
	}
	
	@Override
	protected void addBiteAttack(int strengthModifier) {
		MeleeAttackBuilder biteBuilder = new MeleeAttackBuilder();
		MeleeAttack bite = biteBuilder.setWeaponName("bite")//
				.setBaseDamage(strengthModifier)//
				.setToHit(strengthModifier + 2)//
				.setDamageDie(6)//
				.setTimesToThrowDamageDie(1)//
				.setDamageType(DamageType.PIERCING)//
				.setDescription("DC12 CON save or take: " + DiceService.throwD6(2) + " poison dmg")//
				.setUsesOnMultiAttack(1)
				.build();
		addToAvailableAttacks(bite);
	}
	
	protected void addClawAttack(int strengthModifier) {
		MeleeAttackBuilder clawBuilder = new MeleeAttackBuilder();
		MeleeAttack claw = clawBuilder.setWeaponName("claw")//
				.setBaseDamage(strengthModifier)//
				.setToHit(strengthModifier + 2)//
				.setDamageDie(8)//
				.setTimesToThrowDamageDie(1)//
				.setDamageType(DamageType.SLASHING)//
				.setUsesOnMultiAttack(2)
				.build();
		addToAvailableAttacks(claw);
	}
}
