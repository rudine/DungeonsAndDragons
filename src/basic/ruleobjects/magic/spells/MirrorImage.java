package basic.ruleobjects.magic.spells;

import basic.ruleobjects.magic.CastingTime;
import basic.ruleobjects.magic.SchoolOfMagic;
import basic.ruleobjects.magic.Spell;

public class MirrorImage extends Spell {

	public MirrorImage() {
		setCastingTime(CastingTime.ACTION);
		setName("Darkness");
		setDescription(createDescription());
		setRange("Self");
		setLevel(2);
		setDurationRounds(10);
		setSpellComponents(SpellComponentService.getVerbalSomatic());
		setSchool(SchoolOfMagic.Illusion);
	}
	
	@Override
	protected String createDescription() {
		return "Three illusory duplicates of yourself appear in your space. Until the spell ends,"
				+ " the duplicates move with you and mimic your actions, shifting position so it’s"
				+ " impossible to track which image is real. You can use your action to dismiss"
				+ " the illusory duplicates.\r\n" 
				+ "Each time a creature targets you with an attack during the spell’s duration,"
				+ " roll a d20 to determine whether the attack instead targets one of your duplicates.\r\n" 
				+ "If you have three duplicates, you must roll a 6 or higher to change the attack’s"
				+ " target to a duplicate. With two duplicates, you must roll an 8 or higher. With"
				+ " one duplicate, you must roll an 11 or higher.\r\n" 
				+ "A duplicate’s AC equals 10 + your Dexterity modifier. If an attack hits a duplicate,"
				+ " the duplicate is destroyed. A duplicate can be destroyed only by an attack that hits"
				+ " it. It ignores all other damage and effects. The spell ends when all three duplicates"
				+ " are destroyed.\r\n" 
				+ "A creature is unaffected by this spell if it can’t see, if it relies on senses other"
				+ " than sight, such as blindsight, or if it can perceive illusions as false, as with truesight.";
	}
}
