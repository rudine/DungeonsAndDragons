package basic.monsters;

import static basic.services.DamageService.subtractDoubleDamageFromHitpoints;
import static basic.services.DiceService.throwD8;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.RangedAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.attack.types.builders.RangedAttackBuilder;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.Alignment;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.MonsterType;
import basic.ruleobjects.Size;

public class Skeleton extends AbstractEnemy {

	public Skeleton() {
		setArmorClass(13);
		setAlive(true);
		setAbilityScores(new AbilityScores(10, 14, 15, 6, 8, 5));
		setHitpointsOnCreation(throwD8(2) + 4);
		setAttacks();
		setAttacksOnAttackAction(1);
		setSize(Size.Medium);
		setMonsterType(MonsterType.undead);
		setAlignment(Alignment.LawfulEvil);
		setSpeed("30 ft. 6 vakjes");
	}

	@Override
	protected void setAttacks() {
		MeleeAttackBuilder meleeBuilder = new MeleeAttackBuilder();
		MeleeAttack shortsword = meleeBuilder.setWeaponName("Shortsword") //
				.setToHit(5)//
				.addDamageComponent(new DamageComponent(1, 6, 2, DamageType.PIERCING))//
				.build();
		RangedAttackBuilder rangedBuilder = new RangedAttackBuilder();
		RangedAttack shortbow = rangedBuilder.setWeaponName("Shortbow") //
				.setToHit(5)//
				.addDamageComponent(new DamageComponent(1, 6, 2, DamageType.PIERCING))//
				.setRange("80/320 ft.")//
				.build();
		addToAvailableAttacks(shortbow, shortsword);
	}

	@Override
	public void doDamage(int damage, DamageType type) {
		switch (type) {
		case BLUDGEONING:
			setHitpoints(subtractDoubleDamageFromHitpoints(getHitpoints(), damage));
			break;
		case POISON:
			break;
		default:
			setHitpoints(getHitpoints() - damage);
			break;
		}

		if (getHitpoints() <= 0) {
			setAlive(false);
			return;
		}
	}
}
