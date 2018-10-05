package basic.ruleobjects.modifiers;

import basic.ruleobjects.AbilityTypes;
import basic.ruleobjects.Skill;

public class SkillModifier {
	
	private int toAddToD20;
	private Skill skill;
	private AbilityTypes abilityModifier;
	
	public SkillModifier(int toAddToD20, Skill skill, AbilityTypes abilityModifier) {
		this.toAddToD20 = toAddToD20;
		this.skill = skill;
		this.abilityModifier = abilityModifier;
	}

	public AbilityTypes getAbilityModifier() {
		return abilityModifier;
	}

	public void setAbilityModifier(AbilityTypes abilityModifier) {
		this.abilityModifier = abilityModifier;
	}

	public int getToAddToD20() {
		return toAddToD20;
	}

	public void setToAddToD20(int toAddToD20) {
		this.toAddToD20 = toAddToD20;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	@Override
	public String toString() {
		return skill.name() + " " + toAddToD20;
	}
}
