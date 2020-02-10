package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.RangedAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.attack.types.builders.RangedAttackBuilder;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.services.DiceService;

public class Gnoll extends AbstractEnemy {

	public Gnoll() {
		setArmorClass(15);
		setHitpointsOnCreation(DiceService.throwD8(5));
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
				.setToHit(4)//
				.addDamageComponent(new DamageComponent(1, 8, strengthModifier, DamageType.PIERCING))//
				.setRange("5ft. melee or 20/60 ft. ranged")//
				.build();
		addToAvailableAttacks(spear);
	}

	protected void addLongbowAttack(int dexModifier) {
		RangedAttackBuilder longbowBuilder = new RangedAttackBuilder();
		RangedAttack longbow = longbowBuilder.setWeaponName("longbow")//
				.setToHit(dexModifier + 2)//
				.addDamageComponent(new DamageComponent(1, 8, 1, DamageType.PIERCING))//
				.setRange("150/600 ft.")//
				.build();
		addToAvailableAttacks(longbow);
	}

	protected void addBiteAttack(int strengthModifier) {
		MeleeAttackBuilder biteBuilder = new MeleeAttackBuilder();
		MeleeAttack bite = biteBuilder.setWeaponName("bite")//
				.setToHit(strengthModifier + 2)//
				.addDamageComponent(new DamageComponent(1, 4, strengthModifier, DamageType.PIERCING))//
				.build();
		addToAvailableAttacks(bite);
	}
}
