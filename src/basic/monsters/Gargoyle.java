package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.services.DamageService;
import basic.services.DiceService;

public class Gargoyle extends AbstractEnemy {

	public Gargoyle() {
		setAC(15);
		setHitpointsOnCreation(DiceService.throwD8(7) + 21);
		setSpeed("30 ft., fly 60 ft.");
		setGargoyleAbilityScores();
		setAttacksOnAttackAction(2);
		setAttacks();
		addToSpecialAbilities(SpecialAbility.FalseAppearance);
	}

	protected void setGargoyleAbilityScores() {
		setAbilityScores(new AbilityScores(15, 11, 16, 6, 11, 7));
	}

	@Override
	protected void setAttacks() {
		MeleeAttackBuilder biteBuilder = new MeleeAttackBuilder();
		int strengthModifier = getAbilityScores().getStrengthModifier();
		MeleeAttack bite = biteBuilder.setWeaponName("Bite")//
				.setToHit(2 + strengthModifier)//
				.addDamageComponent(new DamageComponent(1, getDamageDie(), strengthModifier, DamageType.PIERCING))//
				.build();
		addToAvailableAttacks(bite);
		MeleeAttackBuilder clawBuilder = new MeleeAttackBuilder();
		MeleeAttack claw = clawBuilder.setWeaponName("Claw")//
				.setToHit(2 + strengthModifier)//
				.addDamageComponent(new DamageComponent(1, getDamageDie(), strengthModifier, DamageType.SLASHING))//
				.build();
		addToAvailableAttacks(claw);
	}

	protected int getDamageDie() {
		return 6;
	}

	@Override
	public void doDamage(int damage, DamageType type) {
		switch (type) {
		case BLUDGEONING:
		case PIERCING:
		case SLASHING:
			setHitpoints(DamageService.subtractHalfDamageFromHitpoints(getHitpoints(), damage));
			break;
		case POISON:
			break;
		default:
			super.doDamage(damage, type);
		}
	}
}
