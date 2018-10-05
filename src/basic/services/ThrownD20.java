package basic.services;

public class ThrownD20 {
	
	private int result;
	private boolean critical;
	
	public ThrownD20(int result, boolean critical) {
		this.result = result;
		this.critical = critical;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public boolean isCritical() {
		return critical;
	}

	public void setCritical(boolean critical) {
		this.critical = critical;
	}
}
