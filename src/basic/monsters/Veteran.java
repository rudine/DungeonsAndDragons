package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.RangedAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.attack.types.builders.RangedAttackBuilder;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.services.DiceService;

import static basic.ruleobjects.Skill.Athletics;
import static basic.ruleobjects.Skill.Perception;

public class Veteran extends AbstractEnemy {
	
	public Veteran() {
		setAlive(true);
		setArmorClass(17);
		setHitpointsOnCreation(DiceService.throwD8(9) + 18);
		setSpeed("30 feet, 6 vakjes");
		setAbilityScores(new AbilityScores(16, 13, 14, 10, 11, 10));
		setAttacks();
		setAttacksOnAttackAction(2);
		addToSkills(new SkillModifier(5, Athletics), new SkillModifier(2, Perception));
	}
	
	protected void setAttacks() {
		MeleeAttackBuilder ls2hBuilder = new MeleeAttackBuilder();
		MeleeAttack longsword2Hands = ls2hBuilder.setWeaponName("Longsword 2 Hands") //
					.setToHit(5)//
					.addDamageComponent(new DamageComponent(1, 10, 3, DamageType.SLASHING))//
					.build();
		addToAvailableAttacks(longsword2Hands);
		MeleeAttackBuilder ls1hBuilder = new MeleeAttackBuilder();
		MeleeAttack longsword1Hand = ls1hBuilder.setWeaponName("Longsword 1 Hand") //
					.setToHit(5)//
					.addDamageComponent(new DamageComponent(1, 8, 3, DamageType.SLASHING))//
					.build();
		addToAvailableAttacks(longsword1Hand);
		MeleeAttackBuilder shortswordBuilder = new MeleeAttackBuilder();
		MeleeAttack shortsword = shortswordBuilder.setWeaponName("Shortsword") //
					.setToHit(5)//
					.addDamageComponent(new DamageComponent(1, 6, 3, DamageType.PIERCING))//
					.build();
		addToAvailableAttacks(shortsword);
		RangedAttackBuilder rBuilder = new RangedAttackBuilder();
		RangedAttack heavyCrossbow = rBuilder.setWeaponName("Heavy Crossbow")//
				.setRange("100/400")//
				.setToHit(3)
				.addDamageComponent(new DamageComponent(1, 10, 0, DamageType.PIERCING))//
				.build();
		addToAvailableAttacks(heavyCrossbow);
	}
}
