package basic.monsters;

import basic.attacktypes.MeleeAttack;
import basic.attacktypes.MeleeAttackBuilder;
import basic.attacktypes.RangedAttack;
import basic.attacktypes.RangedAttackBuilder;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.services.DiceService;

public class Gnoll extends AbstractEnemy {

	public Gnoll() {
		setAlive(true);
		setAC(15);
		setHitpoints(DiceService.throwD8(5));
		setSpeed("30 ft. 6 vakjes");
		setAbilityScores(new AbilityScores(14, 12, 11, 6, 10, 7));
		addToSpecialAbilities(SpecialAbility.Rampage);
		setAttacksOnAttackAction(1);
		setAttacks();
	}
	
	protected void setAttacks(){
		int strengthModifier = this.getAbilityScores().getStrengthModifier();
		int dexModifier = this.getAbilityScores().getDexterityModifier();
		addBiteAttack(strengthModifier);
		addSpearAttack(strengthModifier);
		addLongbowAttack(dexModifier);
	}

	protected void addSpearAttack(int strengthModifier) {
		RangedAttackBuilder spearBuilder = new RangedAttackBuilder();
		RangedAttack spear = spearBuilder.setWeaponName("spear")//
				.setBaseDamage(strengthModifier)//
				.setToHit(4)//
				.setDamageDie(8)//
				.setTimesToThrowDamageDie(1)//
				.setRange("5ft. melee or 20/60 ft. ranged")//
				.setDamageType(DamageType.PIERCING)//
				.build();
		addToAvailableAttacks(spear);
	}

	protected void addLongbowAttack(int dexModifier) {
		RangedAttackBuilder longbowBuilder = new RangedAttackBuilder();
		RangedAttack longbow = longbowBuilder.setWeaponName("longbow")//
				.setBaseDamage(1)//
				.setToHit(dexModifier + 2)//
				.setDamageDie(8)//
				.setTimesToThrowDamageDie(1)//
				.setRange("150/600 ft.")//
				.setDamageType(DamageType.PIERCING)//
				.build();
		addToAvailableAttacks(longbow);
	}

	protected void addBiteAttack(int strengthModifier) {
		MeleeAttackBuilder biteBuilder = new MeleeAttackBuilder();
		MeleeAttack bite = biteBuilder.setWeaponName("bite")//
				.setBaseDamage(strengthModifier)//
				.setToHit(strengthModifier + 2)//
				.setDamageDie(4)//
				.setTimesToThrowDamageDie(1)//
				.setDamageType(DamageType.PIERCING)//
				.build();
		addToAvailableAttacks(bite);
	}
}
