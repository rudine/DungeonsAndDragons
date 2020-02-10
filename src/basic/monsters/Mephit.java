package basic.monsters;

import basic.monsters.interfaces.PreparesForNextTurn;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.Alignment;
import basic.ruleobjects.Range;
import basic.ruleobjects.Size;

public abstract class Mephit extends AbstractEnemy implements PreparesForNextTurn {

    protected int breathWeaponRechargeOn = 6;
    protected Range succesRange = new Range(6,6);
    protected abstract String getDeathBurstDescription();
    protected abstract String getInnateSpellcastingSpell();
    protected abstract String getBreathWeaponTitle();
    protected abstract String getBreathWeaponDescription();

    protected Mephit(){
        setAlignment(Alignment.NeutralEvil);
        setSize(Size.Small);
        setAttacksOnAttackAction(1);
        setSpecialAttacksOnAction(1);
        addToSpecialAbilities(getDeathBurst(), getInnateSpellcasting(), SpecialAbility.FalseAppearance);
    }

    protected SpecialAbility getDeathBurst(){
        SpecialAbility deathBurst = SpecialAbility.DeathBurst;
        deathBurst.setDescription(getDeathBurstDescription());
        return deathBurst;
    }

    protected SpecialAbility getInnateSpellcasting(){
        SpecialAbility innateSpellcasting = SpecialAbility.InnateSpellcasting;
        innateSpellcasting.setDescription(getInnateSpellcastingDescription());
        return innateSpellcasting;
    }

    private String getInnateSpellcastingDescription() {
        return "(1 / day). The mephit can innately cast " + getInnateSpellcastingSpell()
                + ", requiring no material components. Its innate spellcasting ability is" +
                " Charisma.";
    }

    @Override
    public void prepareForNextTurn() {
        specialAttacks.stream().filter(attack -> attack.hasRecharge()).forEach(attack -> attack.recharge());
    }
}
