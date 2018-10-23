package basic.monsters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import basic.ruleobjects.modifiers.SaveModifier;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.action.Action;
import basic.attack.Attack;
import basic.attack.types.SpecialAttack;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.Alignment;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.MonsterType;
import basic.ruleobjects.Size;

public abstract class AbstractEnemy {

	private boolean advantageOnAttacks;
	private boolean disadvantageOnAttacks;
	private int hitpoints;
	private boolean alive = true;
	private int AC;
	private String speed;
	private AbilityScores abilityScores;
	private Set<SpecialAbility> specialAbilities = new HashSet<>();
	private Set<Attack> availableAttacks = new TreeSet<>();
	private int attacksOnAttackAction;
	protected Set<SpecialAttack> specialAttacks = new HashSet<>();
	private int specialAttacksOnAction;
	private Set<SkillModifier> skills = new HashSet<>();
	private Set<SaveModifier> saveModifiers = new HashSet<>();
	private Size size = Size.Medium;
	private MonsterType monsterType = MonsterType.humanoid;
	private Alignment alignment = Alignment.Neutral;
	private Set<Action> actions = new HashSet<>(); 
	
	public void doDamage(int damage, DamageType type) {
		setHitpoints(getHitpoints() - damage);
		
		if (getHitpoints() <= 0) {
			setAlive(false);
		}
	}
	
	public AbilityScores getAbilityScores() {
		return abilityScores;
	}

	public void setAbilityScores(AbilityScores abilityScores) {
		this.abilityScores = abilityScores;
	}

	public boolean isAdvantageOnAttacks() {
		return advantageOnAttacks;
	}

	public void setAdvantageOnAttacks(boolean advantageOnAttacks) {
		this.advantageOnAttacks = advantageOnAttacks;
	}

	public boolean isDisadvantageOnAttacks() {
		return disadvantageOnAttacks;
	}

	public void setDisadvantageOnAttacks(boolean disadvantageOnAttacks) {
		this.disadvantageOnAttacks = disadvantageOnAttacks;
	}

	public int getHitpoints() {
		return hitpoints;
	}

	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getAC() {
		return AC;
	}

	public void setAC(int aC) {
		AC = aC;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public Set<SpecialAbility> getSpecialAbilities() {
		return specialAbilities;
	}
	
	public void addToSpecialAbilities(SpecialAbility... skill) {
		specialAbilities.addAll(Arrays.asList(skill));
	}

	public Set<Attack> getAvailableAttacks()
	{	
		return availableAttacks;
	}

	public void addToAvailableAttacks(Attack... attack) {
		availableAttacks.addAll(Arrays.asList(attack));
	}

	public int getAttacksOnAttackAction() {
		return attacksOnAttackAction;
	}

	public void setAttacksOnAttackAction(int attacksOnAttackAction) {
		this.attacksOnAttackAction = attacksOnAttackAction;
	}

	public Set<SpecialAttack> getSpecialAttacks() {
		return specialAttacks;
	}

	public void addToSpecialAttacks(SpecialAttack... attack) {
		this.specialAttacks.addAll(Arrays.asList(attack));
	}

	public int getSpecialAttacksOnAction() {
		return specialAttacksOnAction;
	}

	public void setSpecialAttacksOnAction(int specialAttacksOnAction) {
		this.specialAttacksOnAction = specialAttacksOnAction;
	}

	public Set<SaveModifier> getSaveModifiers() {
		return saveModifiers;
	}

	public void addToSaveModifiers(SaveModifier... saveModifiers) {
		this.saveModifiers.addAll(Arrays.asList(saveModifiers));
	}

	public void addToSkills(SkillModifier... skills) {
		this.skills.addAll(Arrays.asList(skills));
	}

	public Set<SkillModifier> getSkills() {
		return skills;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public MonsterType getMonsterType() {
		return monsterType;
	}

	public void setMonsterType(MonsterType monsterType) {
		this.monsterType = monsterType;
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	public void addToActions(Action action) {
		this.actions.add(action);
	}
	
	public Set<Action> getActions() {
		return actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}
}
