package basic.ruleobjects;

import basic.services.StandardRulesService;

public class AbilityScores {

	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;

	public AbilityScores(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
	}

	public int getStrength() {
		return strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public int getStrengthModifier() {
		return StandardRulesService.getAbilityModifier(strength);
	}

	public int getDexterityModifier() {
		return StandardRulesService.getAbilityModifier(dexterity);
	}

	public int getConstitutionModifier() {
		return StandardRulesService.getAbilityModifier(constitution);
	}

	public int getIntelligenceModifier() {
		return StandardRulesService.getAbilityModifier(intelligence);
	}

	public int getWisdomModifier() {
		return StandardRulesService.getAbilityModifier(wisdom);
	}

	public int getCharismaModifier() {
		return StandardRulesService.getAbilityModifier(charisma);
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
}
