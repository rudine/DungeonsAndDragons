package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.RangedAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.attack.types.builders.RangedAttackBuilder;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.Skill;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.services.DiceService;

public class Spy extends AbstractEnemy {

    public Spy() {
        setArmorClass(12);
        setHitpointsOnCreation(DiceService.throwD8(6));
        setSpeed("30 feet, 6 vakjes");
        setAbilityScores(new AbilityScores(10, 15, 10, 12, 14, 16));
        setAttacks();
        setAttacksOnAttackAction(2);
        addToSkills(new SkillModifier(5, Skill.Deception), new SkillModifier(4, Skill.Investigation), new SkillModifier(5, Skill.Investigation), new SkillModifier(6, Skill.Perception), new SkillModifier(5, Skill.Persuasion), new SkillModifier(4, Skill.SleightOfHand), new SkillModifier(4, Skill.Stealth));
        addToSpecialAbilities(SpecialAbility.CunningAction, SpecialAbility.SneakAttack);
    }

    @Override
    protected void setAttacks() {
        addHandCrossbowAttack();
        addShortswordAttack();
    }

    private void addHandCrossbowAttack() {
        RangedAttackBuilder rangedBuilder = new RangedAttackBuilder();
        RangedAttack heavyCrossbow = rangedBuilder.setWeaponName("Hand Crossbow")//
                .setRange("30/120 ft.")//
                .setToHit(4)
                .addDamageComponent(new DamageComponent(1, 6, 2, DamageType.PIERCING))//
                .build();
        addToAvailableAttacks(heavyCrossbow);
    }

    private void addShortswordAttack() {
        MeleeAttackBuilder meleeBuilder = new MeleeAttackBuilder();
        MeleeAttack mace = meleeBuilder.setWeaponName("Shortsword") //
                .setToHit(4)//
                .addDamageComponent(new DamageComponent(1, 6, 2, DamageType.PIERCING))//
                .build();
        addToAvailableAttacks(mace);
    }
}
