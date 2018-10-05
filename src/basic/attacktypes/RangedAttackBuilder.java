package basic.attacktypes;

import basic.ruleobjects.DamageType;

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
	
	public RangedAttackBuilder setNumberOfTargets(int numberOfTargets) {
		attack.setNumberOfTargets(numberOfTargets);
		return this;
	}

	public RangedAttackBuilder setDamageDie(int damageDie) {
		attack.setDamageDie(damageDie);
		return this;
	}
	
	public RangedAttackBuilder setTimesToThrowDamageDie(int timesToThrowDamageDie) {
		attack.setTimesToThrowDamageDie(timesToThrowDamageDie);
		return this;
	}
	
	public RangedAttackBuilder setBaseDamage(int baseDamage) {
		attack.setBaseDamage(baseDamage);
		return this;
	}
	
	public RangedAttackBuilder setWeaponName(String weaponName) {
		attack.setWeaponName(weaponName);
		return this;
	}
	
	public RangedAttackBuilder setDamageType(DamageType type) {
		attack.setType(type);
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
