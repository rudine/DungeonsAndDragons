package basic.monsters;

import static basic.services.DamageService.subtractDoubleDamageFromHitpoints;
import static basic.services.DiceService.throwD8;

import basic.attacktypes.MeleeAttack;
import basic.attacktypes.MeleeAttackBuilder;
import basic.attacktypes.RangedAttack;
import basic.attacktypes.RangedAttackBuilder;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.Alignment;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.MonsterType;
import basic.ruleobjects.Size;

public class Skeleton extends AbstractEnemy {

	public Skeleton() {
		setAC(13);
		setAlive(true);
		setAbilityScores(new AbilityScores(10, 14, 15, 6, 8, 5));
		setHitpoints(throwD8(2) + 4);
		setAttacks();
		setAttacksOnAttackAction(1);
		setSize(Size.Medium);
		setMonsterType(MonsterType.undead);
		setAlignment(Alignment.LawfulEvil);
		setSpeed("30 ft. 6 vakjes");
	}

	private void setAttacks() {
		MeleeAttackBuilder meleeBuilder = new MeleeAttackBuilder();
		MeleeAttack shortsword = meleeBuilder.setWeaponName("Shortsword") //
				.setBaseDamage(2)//
				.setDamageDie(6)//
				.setTimesToThrowDamageDie(1)//
				.setToHit(5)//
				.setReach(5)//
				.setNumberOfTargets(1)
				.setDamageType(DamageType.PIERCING)//
				.build();
		RangedAttackBuilder rangedBuilder = new RangedAttackBuilder();
		RangedAttack shortbow = rangedBuilder.setWeaponName("Shortbow") //
				.setBaseDamage(2)//
				.setDamageDie(6)//
				.setTimesToThrowDamageDie(1)//
				.setToHit(5)//
				.setRange("80/320 ft.")//
				.setNumberOfTargets(1)
				.setDamageType(DamageType.PIERCING)//
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
