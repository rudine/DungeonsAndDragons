package basic.monsters.earthspur;

import basic.attacktypes.MeleeAttack;
import basic.attacktypes.MeleeAttackBuilder;
import basic.attacktypes.RangedAttack;
import basic.attacktypes.RangedAttackBuilder;
import basic.monsters.PreparesForNextTurn;
import basic.monsters.Thug;
import basic.ruleobjects.DamageType;

public class AudriciaRoaringhorn extends Thug implements PreparesForNextTurn{
	
	public AudriciaRoaringhorn() {
		super();
		setAC(getAC() + 2);
	}

	@Override
	protected void setAttacks() {
		MeleeAttackBuilder meleeBuilder = new MeleeAttackBuilder();
		MeleeAttack rapier = meleeBuilder.setWeaponName("Rapier") //
					.setBaseDamage(2)
					.setToHit(4)//
					.setDamageDie(8)//
					.setTimesToThrowDamageDie(1)//
					.setDamageType(DamageType.PIERCING)//
					.build();
		addToAvailableAttacks(rapier);
		RangedAttackBuilder rangedBuilder = new RangedAttackBuilder();
		RangedAttack shortbow = rangedBuilder.setWeaponName("Shortbow")//
				.setBaseDamage(0)//
				.setRange("80/320")//
				.setToHit(2)
				.setDamageDie(6)//
				.setTimesToThrowDamageDie(1)//
				.setDamageType(DamageType.PIERCING)//
				.build();
		addToAvailableAttacks(shortbow);
	}

	@Override
	public void prepareForNextTurn() {
		if(isAlive()) {
			setHitpoints(getHitpoints() - 4); 
			if(getHitpoints() <= 0) {
				setAlive(false);
			}
		}
	}
}
