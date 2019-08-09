package basic.monsters.earthspur;

import java.util.ArrayList;
import java.util.List;

import basic.monsters.Gargoyle;
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

public class GargoylePriest extends Gargoyle {
	
	private int thirdLevelSpells = 1;
	
	private int secondLevelSpells = 2;
	
	private int firstLevelSpells = 3;
	
	private int cantrips = 3;
	
	private List<Spell> spells = new ArrayList<>();

	public GargoylePriest() {
		fillSpellList();
	}
	
	private void fillSpellList() {
		spells.add(new RayOfFrost());
		spells.add(new MinorIllusion());
		spells.add(new ShockingGrasp());
		spells.add(new Blink());
		spells.add(new Darkness());
		spells.add(new MirrorImage());
		spells.add(new Shield());
		spells.add(new FalseLife());
		spells.add(new MagicMissile());
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
