package basic.monsters.specialabilities;

public enum SpecialAbility {
	
	Amphibious("Amphibious", "Can breathe air and water"),
	Amorphous("Amorphous", "Can move through a space as narrow as 1 inch wide without squeezing."),
	Beserk("Beserk", "Whenever this enemy starts its turn with 40 hit points or fewer, roll a d6. On a 6, it goes berserk. On each of its turns while berserk, it attacks the nearest creature it can see. If no creature is near enough to move to and attack, the enemy attacks an object, with preference for an object smaller than itself. Once the enemy goes berserk, it continues to do so until it is destroyed or regains all its hit points. The enemies' creator, if within 60 ft. it, can try to calm it by speaking firmly and persuasively. The enemy must be able to hear its creator, who must take an action to make a DC 15 Charisma (Persuasion) check. If the check succeeds, it ceases being berserk. If it takes damage while still at 40 hit points or fewer, it might go berserk again."),
	Brave("Brave", "Has advantage on saving throws against being frightened."),
	ConferFireResistance("Confer fire resistance", "The enemy can grant resistance to fire damage to anyone riding it"),
	CorrosiveForm("Corrosive Form", "A creature that touches this enemy or hits it with a melee attack while within 5ft of it takes 4(1d8) ACID dmg. Any non magical weapon made of wood or metal that hits it corrodes. After dealing damage, the weapon takes a permanent and cumulative -1 penalty to damage rolls. "
			+ "If its penalty drops to -5 the weapon is destroyed. Nonmagical ammunition made of metal or wood that hits this enemy is destoryed after dealing damage. This enemy can eat through 2-inch-thick, nonmagical wood or metal in 1 round."),
	EarthGlide("Earth Glide", "This enemy can burrow through nonmagical, unworked earth and stone. While doing so it doesn't disturb the material it moves through."),
	FalseAppearance("False appearance", "While the enemy remains motionless, it is indistinguishable from items that look like it in it's surroundings (statues / boulders)"),
	FearOfFire("Fear of fire", "If the enemy takes fire damage, it has disadvantage on attack rolls and ability checks until the end of its next turn"),
	Illumination("Illumination", "The enemy sheds bright light in a 10ft. radius and dim light for an additional 10ft."),
	ImmutableForm("Immutable form", "The enemy is immune to any spell or effect that would alter its form."),
	KeenSight("Keen Sight", "The enemy has advantage on Wisdom (Perception) checks that rely on sight."),
	KeenSmell("Keen Smell", "Has advantage on Wisdom (Perception) checks that rely on smell."),
	LightningAbsorption("Lightning absorption", "Whenever this enemy receives lightning damage, it takes no damage and instead regains a number of hit points equal to the damage dealt."),
	MagicResistance("Magic resistance", "This enemy had advantage on svaing throuws against spells and other magical effects."),
	MagicWeapons("Magic weapons","The attacks of this enemy are magical"),
	PackTactics("Pack Tactics", "Has advantage on an attack roll against a creature if at least one of the allies of this enemy is within 5 feet of the creature and the ally isn’t incapacitated."),
	Pounce("Pounce", "If this enemy moves at least 20 feet straight toward a creature and then hits it with a claw attack on the same turn, that target must succeed on a DC 13 Strength saving throw or be knocked prone. If the target is prone, the enemy can make one bite attack against it as a bonus action."),
	Rampage("Rampage", "If this enemy reduces a creature to 0 hitpoints with a melee attack on its turn, the enemy can take a bonus attack to move up to half its speed and make a bite attack"),
	RollingCharge("Rolling Charge", "If this enemy rolls at least 20 ft straight toward a target and then hits it with a slam attack on the same turn, the target takes and extra 7 (2d6) bludgeoning damage. If the target is a creature, it must succeed on a DC 16 strength saving throuw or be knocked prone."),
	RunningLeap("Running Leap", "With a 10-foot running start, the enemy can long jump up to 25 feet."),
	SiegeMonster("Siege monster", "This enemy deals double damage to objects and structures."),
	SnowCamouflage("Snow Camouflage", "Has advantage on Dexterity(Stealth) checks made to hide in snowy terrain."),
	SpeakFrogToad("Speak with Frogs and Toads", "This enemy can communicate simple concepts to frogs and toads when in speaks in it's language"),
	SpiderClimb("Spider Climb", "Can climb difficult surfaces, including upside down on ceilings, without needing to make an ability check."),
	StandingLeapLong30High15("Standing Leap", "The enemy's long jump is up to 30ft. and its high jump is up to 15ft. with or without a running start"),
	StandingLeapLong20High10("Standing Leap", "The enemy's long jump is up to 20ft. and its high jump is up to 10ft. with or without a running start"),
	SwampCamouflage("Swamp Camouflage", "The enemy has advantage on Dexterity (Stealth) checks made to hide in swampy terrain");
	
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
