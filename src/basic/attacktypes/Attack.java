package basic.attacktypes;

import basic.ruleobjects.DamageType;

public abstract class Attack implements Comparable<Attack>{

	private int toHit;
	private int numberOfTargets = 1;
	private int damageDie;
	private int timesToThrowDamageDie;
	private int baseDamage = 0;
	private String weaponName;
	private DamageType type;
	private String description = "";
	private int numberOfUsesOnMultiAttack;

	public int getToHit() {
		return toHit;
	}

	public void setToHit(int toHit) {
		this.toHit = toHit;
	}

	public int getNumberOfTargets() {
		return numberOfTargets;
	}

	public void setNumberOfTargets(int numberOfTargets) {
		this.numberOfTargets = numberOfTargets;
	}

	public int getDamageDie() {
		return damageDie;
	}

	public void setDamageDie(int damageDie) {
		this.damageDie = damageDie;
	}

	public int getTimesToThrowDamageDie() {
		return timesToThrowDamageDie;
	}

	public void setTimesToThrowDamageDie(int timesToThrowDamageDie) {
		this.timesToThrowDamageDie = timesToThrowDamageDie;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public DamageType getType() {
		return type;
	}

	public void setType(DamageType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getNumberOfUsesOnMultiAttack() {
		return numberOfUsesOnMultiAttack;
	}

	public void setNumberOfUsesOnMultiAttack(int numberOfUsesOnMultiAttack) {
		this.numberOfUsesOnMultiAttack = numberOfUsesOnMultiAttack;
	}

	@Override
	public int compareTo(Attack other) {
		return this.getWeaponName().compareTo(other.getWeaponName());
	}
}
