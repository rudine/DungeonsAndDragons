package basic.monsters;

import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.Skill;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.services.DiceService;

public class Spy extends AbstractEnemy{

    public Spy(){
        setArmorClass(12);
        setHitpointsOnCreation(DiceService.throwD8(6));
        setSpeed("30 feet, 6 vakjes");
        setAbilityScores(new AbilityScores(10, 15, 10, 12, 14, 16));
        setAttacks();
        setAttacksOnAttackAction(2);
        addToSkills(new SkillModifier(5, Skill.Deception));
    }

    @Override
    protected void setAttacks() {

    }
}
