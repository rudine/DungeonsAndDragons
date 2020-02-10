package basic.ruleobjects.magic.spells;

import basic.ruleobjects.magic.CastingTime;
import basic.ruleobjects.magic.SchoolOfMagic;
import basic.ruleobjects.magic.Spell;
import basic.ruleobjects.magic.SpellComponentService;
import basic.services.DiceService;

public class FalseLife extends Spell implements HealingSpell{

	public FalseLife() {
		setCastingTime(CastingTime.ACTION);
		setName("False life");
		setDescription(createDescription());
		setRange("Self");
		setLevel(1);
		setDurationRounds(1000);
		setSpellComponents(SpellComponentService.getAllSpellComponents());
		setSchool(SchoolOfMagic.Necromancy);
	}
	
	@Override
	protected String createDescription() {
		return "Bolstering yourself with a necromantic facsimile of life, you gain 1d4 + 4 temporary hit points for the duration.\r\n" + 
				"At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, you gain 5 additional temporary hit points for each slot level above 1st.";
	}

	@Override
	public int getHealedHitpoints(int casterLevel) {
		return DiceService.throwD4(1) + 4;
	}
}
