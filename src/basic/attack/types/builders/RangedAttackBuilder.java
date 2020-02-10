package basic.attack.types.builders;

import basic.attack.DamageComponent;
import basic.attack.types.RangedAttack;

public class RangedAttackBuilder {

	private RangedAttack attack;
	
	public RangedAttackBuilder() {
		this.attack = new RangedAttack();
	}
	
	public RangedAttackBuilder setRange(String range) {
		attack.setRange(range);
		return this;
	}
	
	public RangedAttackBuilder setToHit(int toHit) {
		attack.setToHit(toHit);
		return this;
	}
	
	/**
	 * Is by default 1, so if the attack is only meant for 1 creature, there is no need to set it
	 */
	public RangedAttackBuilder setNumberOfTargets(int numberOfTargets) {
		attack.setNumberOfTargets(numberOfTargets);
		return this;
	}

	public RangedAttackBuilder addDamageComponent(DamageComponent component) {
		attack.addToComponents(component);
		return this;
	}
	
	public RangedAttackBuilder setWeaponName(String weaponName) {
		attack.setWeaponName(weaponName);
		return this;
	}
	
	public RangedAttackBuilder setDescription(String description) {
		attack.setDescription(description);
		return this;
	}
	
	public RangedAttack build() {
		return attack;
	}
}
