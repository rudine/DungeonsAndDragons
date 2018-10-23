package basic.action;

import basic.ruleobjects.SavingThrow;

public class ActionBuilder {

	private Action action;
	
	public ActionBuilder() {
		this.action = new Action();
	}
	
	public ActionBuilder setSave(SavingThrow save) {
		action.setSave(save);
		return this;
	}
	
	public ActionBuilder setArea(String areaOfEffect) {
		action.setAreaOfEffect(areaOfEffect);
		return this;
	}
	
	public ActionBuilder setName(String name) {
		action.setName(name);
		return this;
	}
	
	public ActionBuilder setDescription(String description) {
		action.setDescription(description);
		return this;
	}
	
	public Action build() {
		return action;
	}
}
