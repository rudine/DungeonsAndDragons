package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
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
				.setToHit(strengthModifier + 2)//
				.addDamageComponent(new DamageComponent(1, 6, strengthModifier, DamageType.PIERCING))//
				.setDescription("DC12 CON save or take: " + DiceService.throwD6(2) + " poison dmg")//
				.setUsesOnMultiAttack(1)
				.build();
		addToAvailableAttacks(bite);
	}
	
	protected void addClawAttack(int strengthModifier) {
		MeleeAttackBuilder clawBuilder = new MeleeAttackBuilder();
		MeleeAttack claw = clawBuilder.setWeaponName("claw")//
				.setToHit(strengthModifier + 2)//
				.addDamageComponent(new DamageComponent(1, 8, strengthModifier, DamageType.SLASHING))//
				.setUsesOnMultiAttack(2)
				.build();
		addToAvailableAttacks(claw);
	}
}
