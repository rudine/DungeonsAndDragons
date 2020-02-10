package basic.ruleobjects.magic.spells;

import basic.ruleobjects.magic.CastingTime;
import basic.ruleobjects.magic.SchoolOfMagic;
import basic.ruleobjects.magic.Spell;
import basic.ruleobjects.magic.SpellComponentService;

public class Shield extends Spell {

	public Shield() {
		setCastingTime(CastingTime.REACTION);
		setName("Shield");
		setDescription(createDescription());
		setRange("Self");
		setLevel(1);
		setDurationRounds(1);
		setSpellComponents(SpellComponentService.getVerbalSomatic());
		setSchool(SchoolOfMagic.Abjuration);
	}
	
	@Override
	protected String createDescription() {
		return "An invisible barrier of magical force appears and protects you."
				+ " Until the start of your next turn, you have a +5 bonus to AC,"
				+ " including against the triggering attack, and you take no damage"
				+ " from magic missile.";
	}
}
