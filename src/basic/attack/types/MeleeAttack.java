package basic.attack.types;

import basic.attack.Attack;

public class MeleeAttack extends Attack {
	
	private int reach = 5;
	
	public int getReach() {
		return reach;
	}

	public void setReach(int reach) {
		this.reach = reach;
	}
}
