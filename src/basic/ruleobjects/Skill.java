package basic.ruleobjects;

import static basic.ruleobjects.AbilityTypes.*;

public enum Skill {

    Acrobatics("Acrobatics", DEX),
    AnimalHandling("Animal handling", CHA),
    Arcana("Arcana", INT),
    Athletics("Athletics", STR),
    Deception("Deception", CHA),
    History("History", INT),
    Insight("Insight", WIS),
    Intimidation("Intimidation", CHA),
    Investigation("Investigation", INT),
    Medicine("Medicine", WIS),
    Nature("Nature", INT),
    Perception("Perception", WIS),
    Performance("Performance", CHA),
    Persuasion("Persuasion", CHA),
    Religion("Religion", INT),
    SleightOfHand("Sleight of hand", DEX),
    Stealth("Stealth", DEX),
    Survival("Survival", WIS);

    private String name;

    private AbilityTypes abilityType;

    Skill(String name, AbilityTypes abilityType){}

    public String getName() { return name;}

    public AbilityTypes getAbilityType() { return abilityType;}
}
