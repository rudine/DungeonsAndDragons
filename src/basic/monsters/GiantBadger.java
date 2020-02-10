package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.services.DiceService;

public class GiantBadger extends AbstractEnemy {

	public GiantBadger() {
		setArmorClass(10);
		setHitpointsOnCreation(DiceService.throwD8(2) + 4);
		setSpeed("30 ft. , burrow 10 ft.");
		setAbilityScores(new AbilityScores(13, 10, 15, 2, 12, 5));
		setAttacksOnAttackAction(2);
		setAttacks();
		addToSpecialAbilities(SpecialAbility.KeenSmell);
		
	}
	
	@Override
	protected void setAttacks() {
		MeleeAttack bite = new MeleeAttackBuilder()//
				.setWeaponName("Bite")//
				.setToHit(3)//
				.addDamageComponent(new DamageComponent(1, 6, 1, DamageType.PIERCING))//
				.build();
		addToAvailableAttacks(bite);
		MeleeAttack claws = new MeleeAttackBuilder()//
				.setWeaponName("Claws")//
				.setToHit(3)//
				.addDamageComponent(new DamageComponent(2, 4, 1, DamageType.SLASHING))//
				.build();
		addToAvailableAttacks(claws);
	}
	
}
