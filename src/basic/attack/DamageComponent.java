package basic.attack;

import basic.ruleobjects.DamageType;

public class DamageComponent {
	
	private int baseDamage;
	
	private int timesToThrowDie;
	
	private int damageDie;
	
	private DamageType type;
	
	/**
	 * Reads like the description in the monster statblocks.
	 * Example: Hit: 7(1d6 + 4) piercing damage
	 * would be a new DamageComponent(1, 6, 4, DamageType.PIERCING) 
	 */
	public DamageComponent(int times, int die, int base, DamageType type) {
		this.baseDamage = base;
		this.timesToThrowDie = times;
		this.damageDie = die;
		this.type = type;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}

	public int getTimesToThrowDie() {
		return timesToThrowDie;
	}

	public void setTimesToThrowDie(int timesToThrowDie) {
		this.timesToThrowDie = timesToThrowDie;
	}

	public int getDamageDie() {
		return damageDie;
	}

	public void setDamageDie(int damageDie) {
		this.damageDie = damageDie;
	}

	public DamageType getType() {
		return type;
	}

	public void setType(DamageType type) {
		this.type = type;
	}
}
