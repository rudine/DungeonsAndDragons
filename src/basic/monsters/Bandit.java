package basic.monsters;

import basic.attacktypes.MeleeAttack;
import basic.attacktypes.MeleeAttackBuilder;
import basic.attacktypes.RangedAttack;
import basic.attacktypes.RangedAttackBuilder;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.services.DiceService;

public class Bandit extends AbstractEnemy {

	public Bandit() {
		setAC(12);
		setHitpoints(DiceService.throwD8(2) + 2);
		setSpeed("30ft. 6 vakjes");
		setAbilityScores(new AbilityScores(11, 12, 12, 10, 10, 10));
		setAttacksOnAttackAction(1);
		setAttacks();
	}

	protected void setAttacks() {
		int dexModifier = this.getAbilityScores().getDexterityModifier();
		addScimitarAttack(dexModifier);
		addLightCrossbowAttack(dexModifier);
	}

	private void addScimitarAttack(int dexModifier) {
		MeleeAttack attack = new MeleeAttackBuilder()//
				.setWeaponName("Scimitar")//
				.setBaseDamage(dexModifier)//
				.setToHit(3)//
				.setDamageDie(6)//
				.setTimesToThrowDamageDie(1)//
				.setDamageType(DamageType.SLASHING)//
				.build();
		addToAvailableAttacks(attack);
	}

	private void addLightCrossbowAttack(int dexModifier) {
		RangedAttackBuilder builder = new RangedAttackBuilder();
		RangedAttack attack = builder.setWeaponName("Light crossbow")//
				.setBaseDamage(1)//
				.setToHit(3)//
				.setDamageDie(8)//
				.setTimesToThrowDamageDie(1)//
				.setRange("80/320 ft.")//
				.setDamageType(DamageType.PIERCING)//
				.build();
		addToAvailableAttacks(attack);
	}
}
