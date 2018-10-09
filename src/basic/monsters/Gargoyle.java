package basic.monsters;

import basic.attacktypes.MeleeAttack;
import basic.attacktypes.MeleeAttackBuilder;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.services.DamageService;
import basic.services.DiceService;

public class Gargoyle extends AbstractEnemy {
	
	public Gargoyle() {
		setAC(15);
		setHitpoints(DiceService.throwD8(7) + 21);
		setSpeed("30 ft., fly 60 ft.");
		setAbilityScores(new AbilityScores(15, 11, 16, 6, 11, 7));
		setAttacksOnAttackAction(2);
		setAttacks();
		addToSpecialAbilities(SpecialAbility.FalseAppearance);
	}
	
	private void setAttacks() {
		MeleeAttackBuilder biteBuilder = new MeleeAttackBuilder();
		MeleeAttack bite = biteBuilder.setWeaponName("Bite")//
				.setToHit(4)//
				.setBaseDamage(2)//
				.setDamageDie(6)//
				.setTimesToThrowDamageDie(1)//
				.setDamageType(DamageType.PIERCING)//
				.build();
		addToAvailableAttacks(bite);
		MeleeAttackBuilder clawBuilder = new MeleeAttackBuilder();
		MeleeAttack claw = clawBuilder.setWeaponName("Claw")//
				.setToHit(4)//
				.setBaseDamage(2)//
				.setDamageDie(6)//
				.setTimesToThrowDamageDie(1)//
				.setDamageType(DamageType.SLASHING)//
				.build();
		addToAvailableAttacks(claw);
	}
	
	@Override
	public void doDamage(int damage, DamageType type) {
		switch(type) {
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
