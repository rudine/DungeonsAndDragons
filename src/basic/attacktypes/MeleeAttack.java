package basic.attacktypes;

public class MeleeAttack extends Attack {
	
	private int reach = 5;
	
	public MeleeAttack() {
	}

	public int getReach() {
		return reach;
	}

	public void setReach(int reach) {
		this.reach = reach;
	}
}
