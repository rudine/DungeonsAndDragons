package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.RangedAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.attack.types.builders.RangedAttackBuilder;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.services.DiceService;

public class Bandit extends AbstractEnemy {

	public Bandit() {
		setAC(12);
		setHitpointsOnCreation(DiceService.throwD8(2) + 2);
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
				.setToHit(3)//
				.addDamageComponent(new DamageComponent(1, 6, dexModifier, DamageType.SLASHING)) //
				.build();
		addToAvailableAttacks(attack);
	}

	private void addLightCrossbowAttack(int dexModifier) {
		RangedAttackBuilder builder = new RangedAttackBuilder();
		RangedAttack attack = builder.setWeaponName("Light crossbow")//
				.setToHit(3)//
				.addDamageComponent(new DamageComponent(1, 8, 1, DamageType.PIERCING)) //
				.setRange("80/320 ft.")//
				.build();
		addToAvailableAttacks(attack);
	}
}
