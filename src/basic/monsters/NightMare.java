package basic.monsters;

import basic.attacktypes.MeleeAttack;
import basic.attacktypes.MeleeAttackBuilder;
import basic.attacktypes.SpecialAttack;
import basic.attacktypes.SpecialAttackBuilder;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;

public class NightMare extends AbstractEnemy {
	
	public NightMare() {
		setAC(13);
		setHitpoints(68);
		setSpeed("60 ft. 12v, fly 90ft. 18v");
		setAbilityScores(new AbilityScores(18, 15, 16, 10, 13, 15));
		setAttacksOnAttackAction(1);
		setAttacks();
		addToSpecialAbilities(SpecialAbility.ConferFireResistance, SpecialAbility.Illumination);
		// special action Etherial Stride <-- add to Enemy and create special actions verwerk in gui
	}

	private void setAttacks() {
		MeleeAttackBuilder builder = new MeleeAttackBuilder();
		MeleeAttack hooves = builder.setWeaponName("Hooves")//
				.setToHit(6)//
				.setBaseDamage(4 + 7)// FIXME plus 7 fire damage
				.setDamageDie(8)//
				.setTimesToThrowDamageDie(2)//
				.setDamageType(DamageType.BLUDGEONING)//
				.build();
		addToAvailableAttacks(hooves);
	}
	
	
	@Override
	public void doDamage(int damage, DamageType type) {
		if(type == DamageType.FIRE)
			damage = 0;
		super.doDamage(damage, type);
	}
}
