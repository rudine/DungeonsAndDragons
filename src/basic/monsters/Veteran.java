package basic.monsters;

import static basic.ruleobjects.AbilityTypes.STR;
import static basic.ruleobjects.AbilityTypes.WIS;
import static basic.ruleobjects.Skill.Athletics;
import static basic.ruleobjects.Skill.Perception;

import basic.attacktypes.MeleeAttack;
import basic.attacktypes.MeleeAttackBuilder;
import basic.attacktypes.RangedAttack;
import basic.attacktypes.RangedAttackBuilder;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.services.DiceService;

public class Veteran extends AbstractEnemy {
	
	public Veteran() {
		setAlive(true);
		setAC(17);
		setHitpoints(DiceService.throwD8(9) + 18);
		setSpeed("30 feet, 6 vakjes");
		setAbilityScores(new AbilityScores(16, 13, 14, 10, 11, 10));
		setAttacks();
		setAttacksOnAttackAction(2);
		addToSkills(new SkillModifier(5, Athletics, STR), new SkillModifier(2, Perception, WIS));
	}
	
	protected void setAttacks() {
		MeleeAttackBuilder ls2hBuilder = new MeleeAttackBuilder();
		MeleeAttack longsword2Hands = ls2hBuilder.setWeaponName("Longsword 2 Hands") //
					.setBaseDamage(3)
					.setToHit(5)//
					.setDamageDie(10)//
					.setTimesToThrowDamageDie(1)//
					.setDamageType(DamageType.SLASHING)//
					.build();
		addToAvailableAttacks(longsword2Hands);
		MeleeAttackBuilder ls1hBuilder = new MeleeAttackBuilder();
		MeleeAttack longsword1Hand = ls1hBuilder.setWeaponName("Longsword 1 Hand") //
					.setBaseDamage(3)
					.setToHit(5)//
					.setDamageDie(8)//
					.setTimesToThrowDamageDie(1)//
					.setDamageType(DamageType.SLASHING)//
					.build();
		addToAvailableAttacks(longsword1Hand);
		MeleeAttackBuilder shortswordBuilder = new MeleeAttackBuilder();
		MeleeAttack shortsword = shortswordBuilder.setWeaponName("Shortsword") //
					.setBaseDamage(3)
					.setToHit(5)//
					.setDamageDie(6)//
					.setTimesToThrowDamageDie(1)//
					.setDamageType(DamageType.PIERCING)//
					.build();
		addToAvailableAttacks(shortsword);
		RangedAttackBuilder rBuilder = new RangedAttackBuilder();
		RangedAttack heavyCrossbow = rBuilder.setWeaponName("Heavy Crossbow")//
				.setBaseDamage(0)//
				.setRange("100/400")//
				.setToHit(3)
				.setDamageDie(10)//
				.setTimesToThrowDamageDie(1)//
				.setDamageType(DamageType.PIERCING)//
				.build();
		addToAvailableAttacks(heavyCrossbow);
	}

}
