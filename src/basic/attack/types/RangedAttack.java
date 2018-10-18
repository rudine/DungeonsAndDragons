package basic.attack.types;

import basic.attack.Attack;

public class RangedAttack extends Attack {

	private String range;

	public RangedAttack() {
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}
}
