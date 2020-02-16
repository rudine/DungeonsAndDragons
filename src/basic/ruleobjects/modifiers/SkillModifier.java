package basic.ruleobjects.modifiers;

import basic.ruleobjects.Skill;

public class SkillModifier {
	
	private int toAddToD20;
	private Skill skill;

	public SkillModifier(int toAddToD20, Skill skill) {
		this.toAddToD20 = toAddToD20;
		this.skill = skill;
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
		return skill.getName() + " " + toAddToD20;
	}
}
