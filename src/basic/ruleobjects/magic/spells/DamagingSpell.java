package basic.ruleobjects.magic.spells;

import basic.ruleobjects.DamageType;

public interface DamagingSpell {
	
	public abstract int getDamage(int casterLevel);
	
	public abstract DamageType getDamageType();
	
	public abstract void setDamageType(DamageType damageType);
}
