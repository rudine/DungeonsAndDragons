package basic.ruleobjects.magic.spells;

import java.util.ArrayList;
import java.util.List;

import basic.ruleobjects.DamageType;
import basic.ruleobjects.magic.CastingTime;
import basic.ruleobjects.magic.Spell;
import basic.services.DiceService;

public class MagicMissile extends Spell implements DamagingSpell {

	public MagicMissile() {
		setCastingTime(CastingTime.ACTION);
		setName("Magic Missile");
		setDescription(createDescription());
		setRange("120 ft. 24v");
		setLevel(1);
		setDurationRounds(0);
		setSpellComponents(SpellComponentService.getVerbalSomatic());
		setDamageType(DamageType.FORCE);
	}

	@Override
	public int getDamage(int casterLevel) {
		return DiceService.throwD4(1) + 1;
	}
	
	public List<Integer> getDamageForSeperateMissiles(int spellSlotLevel){
		List<Integer> missiles = new ArrayList<>();

		if(spellSlotLevel < 1 || spellSlotLevel > 9)
			throw new IllegalArgumentException("The spellslot level cannot be smaller than 1 or bigger than 9");
			
		int numberOfMissiles = 3 + (spellSlotLevel - 1);
		for(int i = 0; i < numberOfMissiles; i++) 
			missiles.add(getDamage(0)); // casterlevel irrelevant at this point.
		
		return missiles;
	}

	@Override
	protected String createDescription() {
		return "You create three glowing darts of magical force. Each dart hits a creature of your choice that you can see within range. A dart deals 1d4 + 1 force damage to its target. The darts all strike simultaneously, and you can direct them to hit one creature or several.\r\n"
				+ "At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, the spell creates one more dart for each slot level above 1st.";
	}
}
