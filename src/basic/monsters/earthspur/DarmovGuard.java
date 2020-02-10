package basic.monsters.earthspur;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.monsters.Veteran;
import basic.ruleobjects.DamageType;

public class DarmovGuard extends Veteran {
	
	@Override
	protected void setAttacks() {
		MeleeAttackBuilder meleeBuilder = new MeleeAttackBuilder();
		MeleeAttack cudgel = meleeBuilder.setWeaponName("Cudgel") //
				.setToHit(5)//
				.addDamageComponent(new DamageComponent(1, 6, 3, DamageType.BLUDGEONING))//
				.build();
		addToAvailableAttacks(cudgel);
	}
}
