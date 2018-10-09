package basic.monsters.specialabilities;

public enum SpecialAbility {
	
	Brave("Brave", "Has advantage on saving throws against being frightened."),
	FalseAppearance("False appearance", "While the enemy remains motionless, it is indistinguishable from an inanimate statue."),
	FearOfFire("Fear of fire", "If the enemy takes fire damage, it has disadvantage on attack rolls and ability checks until the end of its next turn"),
	KeenSmell("Keen Smell", "Has advantage on Wisdom (Perception) checks that rely on smell."),
	PackTactics("Pack Tactics", "Has advantage on an attack roll against a creature if at least one of the lion’s allies is within 5 feet of the creature and the ally isn’t incapacitated."),
	Pounce("Pounce", "If this enemy moves at least 20 feet straight toward a creature and then hits it with a claw attack on the same turn, that target must succeed on a DC 13 Strength saving throw or be knocked prone. If the target is prone, the enemy can make one bite attack against it as a bonus action."),
	Rampage("Rampage", "If this enemy reduces a creature to 0 hitpoints with a melee attack on its turn, the enemy can take a bonus attack to move up to half its speed and make a bite attack"),
	RunningLeap("Running Leap", "With a 10-foot running start, the enemy can long jump up to 25 feet."),
	SnowCamouflage("Snow Camouflage", "Has advantage on Dexterity(Stealth) checks made to hide in snowy terrain.");
	
	private String name;
	
	private String description;
	
	private SpecialAbility(String name, String description) {
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
