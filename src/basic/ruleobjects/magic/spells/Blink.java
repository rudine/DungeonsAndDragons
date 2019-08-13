package basic.ruleobjects.magic.spells;

import basic.ruleobjects.magic.CastingTime;
import basic.ruleobjects.magic.SchoolOfMagic;
import basic.ruleobjects.magic.Spell;

public class Blink extends Spell {

	public Blink() {
		setCastingTime(CastingTime.ACTION);
		setName("Blink");
		setDescription(createDescription());
		setRange("Self");
		setLevel(3);
		setDurationRounds(10);
		setSpellComponents(SpellComponentService.getVerbalSomatic());
		setSchool(SchoolOfMagic.Transmutation);
	}

	@Override
	protected String createDescription() {
		return "Roll a d20 at the end of each of your turns for the duration of the spell."
				+ " On a roll of 11 or higher, you vanish from your current plane of"
				+ " existence and appear in the Ethereal Plane (the spell fails and the"
				+ " casting is wasted if you were already on that plane). At the start of"
				+ " your next turn, and when the spell ends if you are on the Ethereal"
				+ " Plane, you return to an unoccupied space of your choice that you can"
				+ " see within 10 feet of the space you vanished from. If no unoccupied space"
				+ " is available within that range, you appear in the nearest unoccupied"
				+ " space (chosen at random if more than one space is equally near). You"
				+ " can dismiss this spell as an action.\r\n" 
				+ "While on the Ethereal Plane, you can see and hear the plane you originated"
				+ " from, which is cast in shades of gray, and you can�t see anything there"
				+ " more than 60 feet away. You can only affect and be affected by other"
				+ " creatures on the Ethereal Plane. Creatures that aren�t there can�t"
				+ " perceive you or interact with you, unless they have the ability to do so.";
	}
}
