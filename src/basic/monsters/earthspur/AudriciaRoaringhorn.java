package basic.monsters.earthspur;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.RangedAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.attack.types.builders.RangedAttackBuilder;
import basic.monsters.Thug;
import basic.monsters.interfaces.PreparesForNextTurn;
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
				.addDamageComponent(new DamageComponent(1, 8, 2, DamageType.PIERCING))//	
				.setToHit(4)//
				.build();
		addToAvailableAttacks(rapier);
		RangedAttackBuilder rangedBuilder = new RangedAttackBuilder();
		RangedAttack shortbow = rangedBuilder.setWeaponName("Shortbow")//
				.addDamageComponent(new DamageComponent(1, 6, 0, DamageType.PIERCING))//
				.setRange("80/320")//
				.setToHit(2)//
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
