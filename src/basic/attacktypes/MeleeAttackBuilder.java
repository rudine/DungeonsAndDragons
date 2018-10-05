package basic.attacktypes;

import basic.ruleobjects.DamageType;

public class MeleeAttackBuilder {
	
	private MeleeAttack attack;
	
	public MeleeAttackBuilder() {
		this.attack = new MeleeAttack();
	}
	
	public MeleeAttackBuilder setReach(int reach) {
		attack.setReach(reach);
		return this;
	}
	
	public MeleeAttackBuilder setToHit(int toHit) {
		attack.setToHit(toHit);
		return this;
	}
	
	public MeleeAttackBuilder setNumberOfTargets(int numberOfTargets) {
		attack.setNumberOfTargets(numberOfTargets);
		return this;
	}

	public MeleeAttackBuilder setDamageDie(int damageDie) {
		attack.setDamageDie(damageDie);
		return this;
	}
	
	public MeleeAttackBuilder setTimesToThrowDamageDie(int timesToThrowDamageDie) {
		attack.setTimesToThrowDamageDie(timesToThrowDamageDie);
		return this;
	}
	
	public MeleeAttackBuilder setBaseDamage(int baseDamage) {
		attack.setBaseDamage(baseDamage);
		return this;
	}
	
	public MeleeAttackBuilder setWeaponName(String weaponName) {
		attack.setWeaponName(weaponName);
		return this;
	}
	
	public MeleeAttackBuilder setDamageType(DamageType type) {
		attack.setType(type);
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
