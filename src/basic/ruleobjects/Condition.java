package basic.ruleobjects;

public class Condition {
	
	private ConditionType type;
	private int turns;
	private String alternateCondition;
	private String alternateConditonDescription;
	
	public Condition(ConditionType type, int turns){
		this.type = type;
		this.turns = turns;
	}
	
	public Condition(String alternateCondition, String alternateConditionDescription, int turns) {
		this.alternateCondition = alternateCondition;
		this.alternateConditonDescription = alternateConditionDescription;
		this.turns = turns;
	}

	public ConditionType getType() {
		if (type != null)
			return type;
		return ConditionType.ALTERNATE;
	}

	public void setType(ConditionType type) {
		this.type = type;
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

	public String getAlternateCondition() {
		return alternateCondition;
	}

	public void setAlternateCondition(String alternateCondition) {
		this.alternateCondition = alternateCondition;
	}

	public String getAlternateConditonDescription() {
		return alternateConditonDescription;
	}

	public void setAlternateConditonDescription(String alternateConditonDescription) {
		this.alternateConditonDescription = alternateConditonDescription;
	}
}
