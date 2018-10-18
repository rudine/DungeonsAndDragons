package basic.attack.types.builders;

import basic.attack.DamageComponent;
import basic.attack.types.SpecialAttack;
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
	
	public SpecialAttackBuilder addDamageComponent(DamageComponent component) {
		attack.addToComponents(component);
		return this;
	}
	
	public SpecialAttackBuilder setWeaponName(String weaponName) {
		attack.setWeaponName(weaponName);
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
