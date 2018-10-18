package basic.attack;

import java.util.ArrayList;
import java.util.List;

public abstract class Attack implements Comparable<Attack>{

	private int toHit;
	private int numberOfTargets = 1;
	private String weaponName;
	private String description = "";
	private int numberOfUsesOnMultiAttack;
	private List<DamageComponent> components; 

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

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
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

	public List<DamageComponent> getComponents() {
		return components;
	}

	public void addToComponents(DamageComponent component) {
		if(components == null) {
			components = new ArrayList<>();
		}
		components.add(component);
	}
}
