package basic.monsters.earthspur;

import java.util.ArrayList;
import java.util.List;

import basic.monsters.Gargoyle;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.magic.Spell;
import basic.ruleobjects.magic.spells.Blink;
import basic.ruleobjects.magic.spells.Darkness;
import basic.ruleobjects.magic.spells.FalseLife;
import basic.ruleobjects.magic.spells.MagicMissile;
import basic.ruleobjects.magic.spells.MinorIllusion;
import basic.ruleobjects.magic.spells.MirrorImage;
import basic.ruleobjects.magic.spells.RayOfFrost;
import basic.ruleobjects.magic.spells.Shield;
import basic.ruleobjects.magic.spells.ShockingGrasp;
import basic.services.DiceService;

public class GargoylePriest extends Gargoyle {

	private int thirdLevelSpells = 1;

	private int secondLevelSpells = 2;

	private int firstLevelSpells = 3;

	private int cantrips = 3;

	private List<Spell> spellList = new ArrayList<>();

	public GargoylePriest() {
		setHitpointsOnCreation(DiceService.throwD8(7) + 7);
		fillSpellList();
	}

	@Override
	protected void setGargoyleAbilityScores() {
		setAbilityScores(new AbilityScores(11, 11, 12, 10, 16, 7));
	}

	@Override
	protected int getDamageDie() {
		return 4;
	}

	private void fillSpellList() {
		spellList.add(new RayOfFrost());
		spellList.add(new MinorIllusion());
		spellList.add(new ShockingGrasp());
		spellList.add(new Blink());
		spellList.add(new Darkness());
		spellList.add(new MirrorImage());
		spellList.add(new Shield());
		spellList.add(new FalseLife());
		spellList.add(new MagicMissile());
	}

	public List<Spell> getSpellList() {
		if (spellList.isEmpty())
			throw new RuntimeException("Spell list not initialized");
		return spellList;
	}

	public int getThirdLevelSpells() {
		return thirdLevelSpells;
	}

	public void setThirdLevelSpells(int thirdLevelSpells) {
		this.thirdLevelSpells = thirdLevelSpells;
	}

	public int getSecondLevelSpells() {
		return secondLevelSpells;
	}

	public void setSecondLevelSpells(int secondLevelSpells) {
		this.secondLevelSpells = secondLevelSpells;
	}

	public int getFirstLevelSpells() {
		return firstLevelSpells;
	}

	public void setFirstLevelSpells(int firstLevelSpells) {
		this.firstLevelSpells = firstLevelSpells;
	}

	public int getCantrips() {
		return cantrips;
	}

	public void setCantrips(int cantrips) {
		this.cantrips = cantrips;
	}

}
