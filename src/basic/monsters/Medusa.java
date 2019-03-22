package basic.monsters;

import basic.action.Action;
import basic.action.ActionBuilder;
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
import basic.ruleobjects.SavingThrow;
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
		setAttacksOnAttackAction(5); // TODO 2 ranged or 3 melee, hack to make it work
		setActions();
		setMonsterType(MonsterType.monstrosity);
		setSize(Size.Medium);
		setAlignment(Alignment.LawfulEvil);
	}
	
	@Override
	protected void setAttacks() {
		MeleeAttack shortsword = new MeleeAttackBuilder()//
				.setWeaponName("shortsword")//
				.setToHit(5)
				.setUsesOnMultiAttack(2)
				.addDamageComponent(new DamageComponent(1, 6, 2, DamageType.PIERCING))//
				.build();
		addToAvailableAttacks(shortsword);
		
		MeleeAttack snakeHair = new MeleeAttackBuilder()//
				.setWeaponName("snake hair")//
				.setToHit(5)
				.setUsesOnMultiAttack(1)
				.addDamageComponent(new DamageComponent(1, 4, 2, DamageType.PIERCING))//
				.addDamageComponent(new DamageComponent(4, 6, 0, DamageType.POISON))//
				.build();
		addToAvailableAttacks(snakeHair);
		
		RangedAttack longbow = new RangedAttackBuilder()//
				.setToHit(5)
				.setWeaponName("longbow")//
				.addDamageComponent(new DamageComponent(1, 8, 2, DamageType.PIERCING))//
				.addDamageComponent(new DamageComponent(2, 6, 0, DamageType.POISON))//
				.setRange("150/600ft.")//
				.build();
		longbow.setNumberOfUsesOnMultiAttack(2);
		addToAvailableAttacks(longbow);
	}
	
	private void setActions() {
		Action petrifyingGaze = new ActionBuilder()//
				.setName("petrifying gaze")//
				.setArea("One creature that can see the medusa and starts its turn within 30ft of it\r\n\r\n")//
				.setSave(new SavingThrow(14, AbilityTypes.CON))//
				.setDescription(getPetrifyingGazeText())//
				.build();
		addToActions(petrifyingGaze);
	}
	
	private String getPetrifyingGazeText() {
		return "When a creature that can see the medusa’s eyes starts its turn within 30 feet\r\n"
				+ " of the medusa, the medusa can force it to make a DC 14 Constitution saving throw\r\n"
				+ " if the medusa isn’t incapacitated and can see the creature. If the saving throw\r\n"
				+ " fails by 5 or more, the creature is instantly petrified. Otherwise, a creature\r\n"
				+ " that fails the save begins to turn to stone and is restrained. The restrained creature\r\n"
				+ " must repeat the saving throw at the end of its next turn, becoming petrified on a\r\n"
				+ " failure or ending the effect on a success. The petrification lasts until the\r\n "
				+ " creature is freed by the greater restoration spell or other magic.\r\n"
				+ " Unless surprised, a creature can avert its eyes to avoid the saving throw at.\r\n"
				+ " the start of its turn. If the creature does so, it can’t see the medusa until.\r\n"
				+ " the start of its next turn, when it can avert its eyes again. If the creature.\r\n"
				+ " looks at the medusa in the meantime, it must immediately make the save. If the.\r\n"
				+ " medusa sees itself reflected on a polished surface within 30 feet of it and in.\r\n"
				+ " an area of bright light, the medusa is, due to its curse, affected by its own gaze.";
	}
}
