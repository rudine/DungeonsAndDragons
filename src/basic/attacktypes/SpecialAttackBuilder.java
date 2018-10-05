package basic.attacktypes;

import basic.ruleobjects.DamageType;
import basic.ruleobjects.Range;
import basic.ruleobjects.SavingThrow;

public class SpecialAttackBuilder {
	
	private SpecialAttack attack;
	
	public SpecialAttackBuilder() {
		this.attack = new SpecialAttack();
	}
	
	public SpecialAttackBuilder setAreaOfEffect(String areaOfEffect) {
		attack.setAreaOfEffect(areaOfEffect);
		return this;
	}
	
	public SpecialAttackBuilder setSavingThrow(SavingThrow save) {
		attack.setSave(save);
		return this;
	}
	
	public SpecialAttackBuilder setHalfDamageWhenSaved(boolean halfDamageWhenSaveMade) {
		attack.setHalfDamageWhenSaveMade(halfDamageWhenSaveMade);
		return this;
	}
	
	public SpecialAttackBuilder setDamageDie(int damageDie) {
		attack.setDamageDie(damageDie);
		return this;
	}
	
	public SpecialAttackBuilder setTimesToThrowDamageDie(int timesToThrowDamageDie) {
		attack.setTimesToThrowDamageDie(timesToThrowDamageDie);
		return this;
	}
	
	public SpecialAttackBuilder setBaseDamage(int baseDamage) {
		attack.setBaseDamage(baseDamage);
		return this;
	}
	
	public SpecialAttackBuilder setWeaponName(String weaponName) {
		attack.setWeaponName(weaponName);
		return this;
	}
	
	public SpecialAttackBuilder setDamageType(DamageType type) {
		attack.setType(type);
		return this;
	}
	
	public SpecialAttackBuilder setDescription(String description) {
		attack.setDescription(description);
		return this;
	}

	public SpecialAttackBuilder setRecharge(boolean recharge) {
		attack.setRecharge(recharge);
		return this;
	}
	
	public SpecialAttackBuilder setAvailable(boolean available) {
		attack.setAvailable(available);
		return this;
	}
	
	public SpecialAttackBuilder setAvailabilityDie(int sides) {
		attack.setAvailabilityDie(sides);
		return this;
	}
	
	public SpecialAttackBuilder setSuccesRange(Range succesRange) {
		attack.setSuccesRange(succesRange);
		return this;
	}
	
	public SpecialAttack build() {
		return attack;
	}
}
