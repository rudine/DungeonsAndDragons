package basic.attack.types.builders;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;

public class MeleeAttackBuilder {
	
	private MeleeAttack attack;
	
	public MeleeAttackBuilder() {
		this.attack = new MeleeAttack();
	}
	
	/**
	 * Is by default 5ft., so if the reach is 5ft., there is no need to set it
	 */
	public MeleeAttackBuilder setReach(int reach) {
		attack.setReach(reach);
		return this;
	}
	
	public MeleeAttackBuilder setToHit(int toHit) {
		attack.setToHit(toHit);
		return this;
	}
	
	/**
	 * Is by default 1, so if the attack is only meant for 1 creature, there is no need to set it
	 */
	public MeleeAttackBuilder setNumberOfTargets(int numberOfTargets) {
		attack.setNumberOfTargets(numberOfTargets);
		return this;
	}

	public MeleeAttackBuilder addDamageComponent(DamageComponent component) {
		attack.addToComponents(component);
		return this;
	}
	
	public MeleeAttackBuilder setWeaponName(String weaponName) {
		attack.setWeaponName(weaponName);
		return this;
	}
	
	public MeleeAttackBuilder setDescription(String description) {
		attack.setDescription(description);
		return this;
	}
	
	public MeleeAttackBuilder setUsesOnMultiAttack(int times) {
		attack.setNumberOfUsesOnMultiAttack(times);
		return this;
	}
	
	public MeleeAttack build() {
		return attack;
	}
}
