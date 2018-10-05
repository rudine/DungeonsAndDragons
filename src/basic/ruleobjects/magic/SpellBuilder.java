package basic.ruleobjects.magic;

public class SpellBuilder {
	
	private Spell spell;
	
	public SpellBuilder() {
		spell = new Spell();
	}
	
	public SpellBuilder setCastingTime(CastingTime castingTime) {
		spell.setCastingTime(castingTime);
		return this;
	}
	
	public SpellBuilder setName(String name) {
		spell.setName(name);
		return this;
	}
	
	public SpellBuilder setDescription(String description) {
		spell.setDescription(description);
		return this;
	}
	
	public SpellBuilder setRange(int range) {
		spell.setRange(range);
		return this;
	}
	
	public SpellBuilder addToSpellComponents(SpellComponent component, String description)
	{
		spell.getSpellComponents().put(component, description);
		return this;
	}
	
	public SpellBuilder setConcentration(boolean concentration) {
		spell.setConcentration(concentration);
		return this;
	}
	
	public SpellBuilder setDurationRounds(int rounds) {
		spell.setDurationRounds(rounds);
		return this;
	}
	
	public SpellBuilder setLevel(int level) {
		spell.setLevel(level);
		return this;
	}
	
	public Spell build() {
		return spell;
	}
}
