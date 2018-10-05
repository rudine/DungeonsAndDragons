package basic.monsters.earthspur;

import basic.attacktypes.MeleeAttack;
import basic.attacktypes.MeleeAttackBuilder;
import basic.monsters.Veteran;
import basic.ruleobjects.DamageType;

public class DarmovGuard extends Veteran {
	
	@Override
	protected void setAttacks() {
		MeleeAttackBuilder meleeBuilder = new MeleeAttackBuilder();
		MeleeAttack cudgel = meleeBuilder.setWeaponName("Cudgel") //
				.setBaseDamage(3)//
				.setDamageDie(6)//
				.setTimesToThrowDamageDie(1)//
				.setToHit(5)//
				.setDamageType(DamageType.BLUDGEONING)//
				.build();
		addToAvailableAttacks(cudgel);
	}
}
