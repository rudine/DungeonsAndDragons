package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.SpecialAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.attack.types.builders.SpecialAttackBuilder;
import basic.ruleobjects.*;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.services.DiceService;

public class SmokeMephit extends Mephit {

    public SmokeMephit() {
        setArmorClass(12);
        setHitpointsOnCreation(DiceService.throwD6(5) + 5);
        setSpeed("30ft., 30ft. fly (6 vakjes)");
        setAbilityScores(new AbilityScores(6, 14, 12, 10, 10, 11));
        setAttacks();
        setSpecialAttack();
        addToSkills(new SkillModifier(2, Skill.Perception), new SkillModifier(4, Skill.Stealth));
    }

    @Override
    protected String getDeathBurstDescription() {
        return "When the mephit dies, it leaves behind a cloud of smoke that fills a 5ft radius sphere centered" +
                " on its space. The sphere is heavily obscured. Wind disperses the cloud, which otherwise lasts for 1 minute" +
                " (10 rounds).";
    }

    @Override
    protected String getInnateSpellcastingSpell() {
        return "dancing lights";
    }

    @Override
    protected String getBreathWeaponTitle() {
        return "Cinder breath";
    }

    @Override
    protected String getBreathWeaponDescription() {
        return "The mephit exhales a 15ft cone of smoldering ash. Each creature in that area must succeed on a DC 10 " +
                "Dexterity saving throw or be blinded until the end of the mephit's next turn";
    }

    @Override
    protected void setAttacks() {
        MeleeAttackBuilder meleeBuilder = new MeleeAttackBuilder();
        MeleeAttack claws = meleeBuilder.setWeaponName("Claws")//
                .setToHit(4)//
                .addDamageComponent(new DamageComponent(1, 4, 2, DamageType.SLASHING))//
                .build();
        addToAvailableAttacks(claws);
    }

    private void setSpecialAttack() {
        SpecialAttackBuilder attackBuilder = new SpecialAttackBuilder();
        SpecialAttack cinderBreath = attackBuilder.setAreaOfEffect("15ft cone")//
                .setSavingThrow(new SavingThrow(10, AbilityTypes.DEX))//
                .setWeaponName(getBreathWeaponTitle())//
                .setDescription(getBreathWeaponDescription())//
                .setRecharge(true)//
                .setAvailable(true)//
                .setAvailabilityDie(breathWeaponRechargeOn)//
                .setSuccesRange(succesRange)//
                .build();
        addToSpecialAttacks(cinderBreath);
    }
}
