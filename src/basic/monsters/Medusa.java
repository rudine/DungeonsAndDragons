package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.RangedAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.attack.types.builders.RangedAttackBuilder;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.AbilityTypes;
import basic.ruleobjects.Alignment;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.MonsterType;
import basic.ruleobjects.Size;
import basic.ruleobjects.Skill;
import basic.ruleobjects.modifiers.SkillModifier;

public class Medusa extends AbstractEnemy{

	public Medusa() {
		setAC(15);
		setHitpoints(127);
		setSpeed("30 ft. 6 vakjes");
		setAbilityScores(new AbilityScores(10, 15, 16, 12, 13, 15));
		addToSkills(new SkillModifier(5, Skill.Deception, AbilityTypes.CHA));
		addToSkills(new SkillModifier(4, Skill.Insight, AbilityTypes.WIS));
		addToSkills(new SkillModifier(4, Skill.Perception, AbilityTypes.WIS));
		addToSkills(new SkillModifier(5, Skill.Stealth, AbilityTypes.DEX));
		setAttacks();
		setAttacksOnAttackAction(3);
		setSpecialAttacks();
		setSpecialAttacksOnAction(1);
		setMonsterType(MonsterType.monstrosity);
		setSize(Size.Medium);
		setAlignment(Alignment.LawfulEvil);
	}
	
	private void setAttacks() {
		MeleeAttack shortsword = new MeleeAttackBuilder()//
				.setWeaponName("shortsword")//
				.setToHit(5)
				.addDamageComponent(new DamageComponent(1, 6, 2, DamageType.PIERCING))//
				.build();
		addToAvailableAttacks(shortsword);
		
		MeleeAttack snakeHair = new MeleeAttackBuilder()//
				.setWeaponName("snake hair")//
				.setToHit(5)
				.addDamageComponent(new DamageComponent(1, 4, 2, DamageType.PIERCING))//
				.addDamageComponent(new DamageComponent(4, 6, 0, DamageType.POISON))//
				.build();
		addToAvailableAttacks(snakeHair);
		
		RangedAttack longbow = new RangedAttackBuilder()//
				.setToHit(5)
				.setWeaponName("longbow")//
				.addDamageComponent(new DamageComponent(1, 8, 2, DamageType.PIERCING))//
				.addDamageComponent(new DamageComponent(2, 6, 0, DamageType.POISON))//
				.build();
		addToAvailableAttacks(longbow);
	}
	
	private void setSpecialAttacks() {
		
	}
}
