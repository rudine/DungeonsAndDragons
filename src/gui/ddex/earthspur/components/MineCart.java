package gui.ddex.earthspur.components;

public class MineCart {
	
	private boolean onRails;
	
	private int hitPoints;
	
	public MineCart(boolean onRails, int hitPoints) {
		this.onRails = onRails;
		this.hitPoints = hitPoints;
	}

	public boolean isOnRails() {
		return onRails;
	}

	public void setOnRails(boolean onRails) {
		this.onRails = onRails;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
		if(hitPoints <= 0)
			setOnRails(false);
	}
}
