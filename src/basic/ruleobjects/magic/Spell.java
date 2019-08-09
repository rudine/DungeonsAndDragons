package basic.ruleobjects.magic;

import java.util.HashSet;
import java.util.Set;

import basic.ruleobjects.DamageType;

public abstract class Spell {
	
	private CastingTime castingTime;
	private String name;
	private String description;
	private String range;
	private Set<SpellComponent> spellComponents;
	private boolean concentration = false;
	private int durationRounds;
	private int level;
	private DamageType damageType;
	
	public Spell() {
		spellComponents = new HashSet<>();
	}
	
	public CastingTime getCastingTime() {
		return castingTime;
	}

	public void setCastingTime(CastingTime castingTime) {
		this.castingTime = castingTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	protected abstract String createDescription();

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public Set<SpellComponent> getSpellComponents() {
		return spellComponents;
	}

	public void setSpellComponents(Set<SpellComponent> spellComponents) {
		this.spellComponents = spellComponents;
	}
	
	public boolean isConcentration() {
		return concentration;
	}

	public void setConcentration(boolean concentration) {
		this.concentration = concentration;
	}

	public int getDurationRounds() {
		return durationRounds;
	}

	public void setDurationRounds(int durationRounds) {
		this.durationRounds = durationRounds;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public DamageType getDamageType() {
		return damageType;
	}

	public void setDamageType(DamageType damageType) {
		this.damageType = damageType;
	}

	@Override
	public String toString() {
		String level = this.level == 0 ? "cantrip" : "" + this.level;
		return "" + name + " - level: " + level + " CT: " + castingTime;
	}
}
