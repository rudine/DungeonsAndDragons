package gui.components;

public class AttackText {
	
	private String text;
	private boolean critical;
	
	public AttackText(String text, boolean critical) {
		this.text = text;
		this.critical = critical;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCritical() {
		return critical;
	}

	public void setCritical(boolean critical) {
		this.critical = critical;
	}
}
