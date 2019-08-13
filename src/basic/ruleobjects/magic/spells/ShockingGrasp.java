package basic.ruleobjects.magic.spells;

import basic.ruleobjects.DamageType;
import basic.ruleobjects.magic.CastingTime;
import basic.ruleobjects.magic.SchoolOfMagic;
import basic.ruleobjects.magic.Spell;
import basic.services.DiceService;

public class ShockingGrasp extends Spell implements DamagingSpell{

	public ShockingGrasp() {
		setCastingTime(CastingTime.ACTION);
		setName("Shocking grasp");
		setDescription(createDescription());
		setRange("touch");
		setLevel(0);
		setDurationRounds(0);
		setSpellComponents(SpellComponentService.getVerbalSomatic());
		setDamageType(DamageType.LIGHTNING);
		setSchool(SchoolOfMagic.Evocation);
	}
	
	@Override
	protected String createDescription() {
		return "Lightning springs from your hand to deliver a shock to a creature you try to touch."
				+ " Make a melee spell attack against the target. You have advantage on the attack"
				+ " roll if the target is wearing armor made of metal. On a hit, the target takes"
				+ " 1d8 lightning damage, and it can’t take reactions until the start of its next turn.";
	}

	@Override
	public int getDamage(int casterLevel) {
		if(casterLevel < 1 || casterLevel > 20)
			throw new IllegalArgumentException("Casterlevel can't be smaller than 1 or bigger than 20");
		
		if(casterLevel < 5)
			return DiceService.throwD8(1);
		else if(casterLevel >= 5 && casterLevel < 11)
			return DiceService.throwD8(2);
		else if(casterLevel >= 11 && casterLevel < 17)
			return DiceService.throwD8(3);
		else
			return DiceService.throwD8(4);
	}
}
