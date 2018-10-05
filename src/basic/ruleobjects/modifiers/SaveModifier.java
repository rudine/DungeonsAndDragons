package basic.ruleobjects.modifiers;

import basic.ruleobjects.AbilityTypes;

public class SaveModifier {

	private AbilityTypes abilityModifier;
	private int toAddToD20;

	public SaveModifier(AbilityTypes abilityModifier, int toAddToD20) {
		this.abilityModifier = abilityModifier;
		this.toAddToD20 = toAddToD20;
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
}
