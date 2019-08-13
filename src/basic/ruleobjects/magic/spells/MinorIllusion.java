package basic.ruleobjects.magic.spells;

import basic.ruleobjects.magic.CastingTime;
import basic.ruleobjects.magic.SchoolOfMagic;
import basic.ruleobjects.magic.Spell;
import basic.ruleobjects.magic.SpellComponentService;

public class MinorIllusion extends Spell {
	
	public MinorIllusion() {
		setCastingTime(CastingTime.ACTION);
		setName("Minor Illusion");
		setDescription(createDescription());
		setRange("30 ft. 6v");
		setLevel(0);
		setDurationRounds(10);
		setSpellComponents(SpellComponentService.getSomaticMaterial());
		setSchool(SchoolOfMagic.Illusion);
	}

	@Override
	protected String createDescription() {
		return "You create a sound or an image of an object within range that lasts for the duration. "
				+ "The illusion also ends if you dismiss it as an action or cast this spell again.\r\n" + 
				"If you create a sound, its volume can range from a whisper to a scream. It can be your voice,"
				+ " someone else’s voice, a lion’s roar, a beating of drums, or any other sound you choose."
				+ " The sound continues unabated throughout the duration, or you can make discrete sounds at"
				+ " different times before the spell ends.\r\n If you create an image of an object—such as a "
				+ "chair, muddy footprints, or a small chest—it must be no larger than a 5-foot cube. The image"
				+ " can’t create sound, light, smell, or any other sensory effect. Physical interaction with"
				+ " the image reveals it to be an illusion, because things can pass through it.\r\n" 
				+ "If a creature uses its action to examine the sound or image, the creature can determine that"
				+ " it is an illusion with a successful Intelligence (Investigation) check against your spell "
				+ "save DC. If a creature discerns the illusion for what it is, the illusion becomes faint to the creature.";
	}
}
