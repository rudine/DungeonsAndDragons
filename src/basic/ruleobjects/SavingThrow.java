package basic.ruleobjects;

public class SavingThrow {
	private int DC;
	private AbilityTypes modifier;
	
	public SavingThrow(int DC, AbilityTypes modifier) {
		this.DC = DC;
		this.modifier = modifier;
	}

	public int getDC() {
		return DC;
	}

	public void setDC(int dC) {
		DC = dC;
	}

	public AbilityTypes getModifier() {
		return modifier;
	}

	public void setModifier(AbilityTypes modifier) {
		this.modifier = modifier;
	}
	
	public String toString() {
		return "Save: " + modifier.toString() + " DC " + DC;
	}
}
