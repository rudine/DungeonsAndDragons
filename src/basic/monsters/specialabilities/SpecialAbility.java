package basic.monsters.specialabilities;

public enum SpecialAbility {
	
	Amorphous("Amorphous", "Can move through a space as narrow as 1 inch wide without squeezing."),
	Brave("Brave", "Has advantage on saving throws against being frightened."),
	ConferFireResistance("Confer fire resistance", "The enemy can grant resistance to fire damage to anyone riding it"),
	CorrosiveForm("Corrosive Form", "A creature that touches this enemy or hits it with a melee attack while within 5ft of it takes 4(1d8) ACID dmg. Any non magical weapon made of wood or metal that hits it corrodes. After dealing damage, the weapon takes a permanent and cumulative -1 penalty to damage rolls. "
			+ "If its penalty drops to -5 the weapon is destroyed. Nonmagical ammunition made of metal or wood that hits this enemy is destoryed after dealing damage. This enemy can eat through 2-inch-thick, nonmagical wood or metal in 1 round."),
	FalseAppearance("False appearance", "While the enemy remains motionless, it is indistinguishable from an inanimate statue."),
	FearOfFire("Fear of fire", "If the enemy takes fire damage, it has disadvantage on attack rolls and ability checks until the end of its next turn"),
	Illumination("Illumination", "The enemy sheds bright light in a 10ft. radius and dim light for an additional 10ft."),
	KeenSmell("Keen Smell", "Has advantage on Wisdom (Perception) checks that rely on smell."),
	PackTactics("Pack Tactics", "Has advantage on an attack roll against a creature if at least one of the lion’s allies is within 5 feet of the creature and the ally isn’t incapacitated."),
	Pounce("Pounce", "If this enemy moves at least 20 feet straight toward a creature and then hits it with a claw attack on the same turn, that target must succeed on a DC 13 Strength saving throw or be knocked prone. If the target is prone, the enemy can make one bite attack against it as a bonus action."),
	Rampage("Rampage", "If this enemy reduces a creature to 0 hitpoints with a melee attack on its turn, the enemy can take a bonus attack to move up to half its speed and make a bite attack"),
	RunningLeap("Running Leap", "With a 10-foot running start, the enemy can long jump up to 25 feet."),
	SnowCamouflage("Snow Camouflage", "Has advantage on Dexterity(Stealth) checks made to hide in snowy terrain."),
	SpiderClimb("Spider Climb", "Can climb difficult surfaces, including upside down on ceilings, without needing to make an ability check."),
	StandingLeap("Standing Leap", "The enemy's long jump is up to 30ft. and its high jump is up to 15ft. with or without a running start");
	
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
