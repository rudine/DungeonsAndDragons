package basic.action;

import basic.ruleobjects.SavingThrow;

public class Action {

	private SavingThrow save;

	private String areaOfEffect;

	private String name;

	private String description;

	public SavingThrow getSave() {
		return save;
	}

	public void setSave(SavingThrow save) {
		this.save = save;
	}

	public String getAreaOfEffect() {
		return areaOfEffect;
	}

	public void setAreaOfEffect(String areaOfEffect) {
		this.areaOfEffect = areaOfEffect;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder textBuilder = new StringBuilder();
		textBuilder.append(getName() + " - ");
		if (save != null) {
			textBuilder.append(getSave().toString());
			textBuilder.append(". ");
		}
		textBuilder.append("Area of Effect: " + getAreaOfEffect());
		textBuilder.append(" " + getDescription());
		return textBuilder.toString();
	}
}
