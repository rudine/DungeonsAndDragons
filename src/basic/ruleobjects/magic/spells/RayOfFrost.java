package basic.ruleobjects.magic.spells;

import basic.ruleobjects.DamageType;
import basic.ruleobjects.magic.CastingTime;
import basic.ruleobjects.magic.SchoolOfMagic;
import basic.ruleobjects.magic.Spell;
import basic.services.DiceService;

public class RayOfFrost extends Spell implements DamagingSpell {

	public RayOfFrost() {
		setCastingTime(CastingTime.ACTION);
		setName("Ray of frost");
		setDescription(createDescription());
		setRange("60 ft. 12v");
		setLevel(0);
		setDurationRounds(0);
		setSpellComponents(SpellComponentService.getVerbalSomatic());
		setDamageType(DamageType.COLD);
		setSchool(SchoolOfMagic.Evocation);
	}

	@Override
	protected String createDescription() {
		return "A frigid beam of blue-white light streaks toward a creature within range. Make a ranged spell attack against the "
				+ "target. On a hit, it takes 1d8 cold damage, and its speed is reduced by 10 feet until the start of your next turn.\r\n" + 
				"\r\n The spell’s damage increases by 1d8 when you reach 5th level (2d8), 11th level (3d8), and 17th level (4d8).";
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
