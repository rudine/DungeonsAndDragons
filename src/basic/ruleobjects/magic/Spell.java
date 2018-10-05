package basic.ruleobjects.magic;

import java.util.HashMap;
import java.util.Map;

public class Spell {
	
	private CastingTime castingTime;
	private String name;
	private String description;
	private int range;
	private Map<SpellComponent, String> spellComponents;
	private boolean concentration;
	private int activeRounds;
	private int durationRounds;
	private int level;
	
	public Spell() {
		spellComponents = new HashMap<>();
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

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public Map<SpellComponent, String> getSpellComponents() {
		return spellComponents;
	}

	public void setSpellComponents(Map<SpellComponent, String> spellComponents) {
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

	public int getActiveRounds() {
		return activeRounds;
	}

	public void setActiveRounds(int activeRounds) {
		this.activeRounds = activeRounds;
	}

	@Override
	public String toString() {
		return "" + name + " - level: " + level + " CT: " + castingTime;
	}
}
