package basic.ruleobjects;

public enum ConditionType {
	
	BLINDED ("Blinded","A blinded creature can’t see and automatically fails any ability check that requires sight. Attack rolls against the creature have advantage, and the creature’s Attack rolls have disadvantage."),
	CHARMED("Charmed", "A charmed creature can’t Attack the charmer or target the charmer with harmful Abilities or magical effects. The charmer has advantage on any ability check to interact socially with the creature."),
	DEAFENED("Deafened", "A deafened creature can’t hear and automatically fails any ability check that requires hearing."),
	FRIGHTENED("Frightened", "A frightened creature has disadvantage on ability checks and attack rolls while the source of its fear is within line of sight. The creature can’t willingly move closer to the source of its fear."),
	GRAPPLED("Grappled", "A grappled creature’s speed becomes 0, and it can’t benefit from any bonus to its speed. The condition ends if the Grappler is incapacitated (see the condition). The condition also ends if an effect removes the grappled creature from the reach of the Grappler or Grappling effect, such as when a creature is hurled away by the Thunderwave spell."),
	INCAPACITATED("Incapacitated", "An incapacitated creature can’t take actions or reactions."),
	INVISIBLE("Invisible", "An invisible creature is impossible to see without the aid of magic or a Special sense. For the purpose of Hiding, the creature is heavily obscured. The creature’s location can be detected by any noise it makes or any tracks it leaves. Attack rolls against the creature have disadvantage, and the creature’s Attack rolls have advantage."),
	PARALYZED("Paralyzed", "A paralyzed creature is incapacitated (see the condition) and can’t move or speak. The creature automatically fails Strength and Dexterity saving throws. Attack rolls against the creature have advantage. Any Attack that hits the creature is a critical hit if the attacker is within 5 feet of the creature."),
	PETRIFIED("Petrified", "A petrified creature is transformed, along with any nonmagical object it is wearing or carrying, into a solid inanimate substance (usually stone). Its weight increases by a factor of ten, and it ceases aging. The creature is incapacitated (see the condition), can’t move or speak, and is unaware of its surroundings. Attack rolls against the creature have advantage. The creature automatically fails Strength and Dexterity saving throws. The creature has Resistance to all damage. The creature is immune to poison and disease, although a poison or disease already in its system is suspended, not neutralized."),
	POISONED("Poisoned", "A poisoned creature has disadvantage on Attack rolls and Ability Checks. The creature has disadvantage on Attack rolls. An Attack roll against the creature has advantage if the attacker is within 5 feet of the creature. Otherwise, the Attack roll has disadvantage."),
	PRONE("Prone", "A prone creature’s only Movement option is to crawl, unless it stands up and thereby ends the condition. "),
	RESTRAINED("Restrained", "A restrained creature’s speed becomes 0, and it can’t benefit from any bonus to its speed. Attack rolls against the creature have advantage, and the creature’s Attack rolls have disadvantage. The creature has disadvantage on Dexterity saving throws."),
	STUNNED("Stunned", "A stunned creature is incapacitated (see the condition), can’t move, and can speak only falteringly. The creature automatically fails Strength and Dexterity saving throws. Attack rolls against the creature have advantage."),
	UNCONCIOUS("Unconcious", "An unconscious creature is incapacitated (see the condition), can’t move or speak, and is unaware of its surroundings. The creature drops whatever it’s holding and falls prone. The creature automatically fails Strength and Dexterity saving throws. Attack rolls against the creature have advantage. Any Attack that hits the creature is a critical hit if the attacker is within 5 feet of the creature."),
	EXHAUSTED_1("Exhausted Level 1", "Disadvantage on ability checks"),
	EXHAUSTED_2("Exhausted Level 2", "Speed halved"),
	EXHAUSTED_3("Exhausted Level 3", "Disadvantage on attack rolls and saving throws"),
	EXHAUSTED_4("Exhausted Level 4", "Hitpoint maximum halved"),
	EXHAUSTED_5("Exhauseted Level 5", "Speed is reduced to 0"),
	EXHAUSTED_6("Exhausted Level 6", "Death"),
	ALTERNATE("", "");
	
	private String name;
	
	private String description;
	
	private ConditionType(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
