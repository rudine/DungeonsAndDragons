package basic.ruleobjects.magic;

import java.util.HashSet;
import java.util.Set;

public class SpellComponentService {

	public static Set<SpellComponent> getAllSpellComponents(){
		Set<SpellComponent> spellComponents = new HashSet<>();
		spellComponents.add(SpellComponent.M);
		spellComponents.add(SpellComponent.S);
		spellComponents.add(SpellComponent.V);
		return spellComponents;
	}
	
	public static Set<SpellComponent> getVerbal(){
		Set<SpellComponent> spellComponents = new HashSet<>();
		spellComponents.add(SpellComponent.V);
		return spellComponents;
	}
	
	public static Set<SpellComponent> getSomatic(){
		Set<SpellComponent> spellComponents = new HashSet<>();
		spellComponents.add(SpellComponent.S);
		return spellComponents;
	}
	
	public static Set<SpellComponent> getMaterial(){
		Set<SpellComponent> spellComponents = new HashSet<>();
		spellComponents.add(SpellComponent.M);
		return spellComponents;
	}
	
	public static Set<SpellComponent> getVerbalSomatic(){
		Set<SpellComponent> spellComponents = new HashSet<>();
		spellComponents.add(SpellComponent.S);
		spellComponents.add(SpellComponent.V);
		return spellComponents;
	}
	
	public static Set<SpellComponent> getVerbalMaterial(){
		Set<SpellComponent> spellComponents = new HashSet<>();
		spellComponents.add(SpellComponent.M);
		spellComponents.add(SpellComponent.V);
		return spellComponents;
	}
	
	public static Set<SpellComponent> getSomaticMaterial(){
		Set<SpellComponent> spellComponents = new HashSet<>();
		spellComponents.add(SpellComponent.S);
		spellComponents.add(SpellComponent.M);
		return spellComponents;
	}
}
