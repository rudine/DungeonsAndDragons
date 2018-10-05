package basic.monsters;

import basic.attacktypes.MeleeAttack;
import basic.attacktypes.MeleeAttackBuilder;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.services.DiceService;

public class GiantBadger extends AbstractEnemy {

	public GiantBadger() {
		setAC(10);
		setHitpoints(DiceService.throwD8(2) + 4);
		setSpeed("30 ft. , burrow 10 ft.");
		setAbilityScores(new AbilityScores(13, 10, 15, 2, 12, 5));
		setAttacksOnAttackAction(2);
		setAttacks();
		addToSpecialAbilities(SpecialAbility.KeenSmell);
		
	}
	
	private void setAttacks() {
		MeleeAttack bite = new MeleeAttackBuilder()//
				.setWeaponName("Bite")//
				.setBaseDamage(1)//
				.setToHit(3)//
				.setDamageDie(6)//
				.setTimesToThrowDamageDie(1)//
				.setDamageType(DamageType.PIERCING)//
				.build();
		addToAvailableAttacks(bite);
		MeleeAttack claws = new MeleeAttackBuilder()//
				.setWeaponName("Claws")//
				.setBaseDamage(1)//
				.setToHit(3)//
				.setDamageDie(4)//
				.setTimesToThrowDamageDie(2)//
				.setDamageType(DamageType.SLASHING)//
				.build();
		addToAvailableAttacks(claws);
	}
	
}
