package gui.ddex.earthspur;

import java.util.ArrayList;
import java.util.List;

import basic.monsters.earthspur.GargoylePriest;
import basic.services.StandardRulesService;
import gui.components.AbstractFight;
import gui.components.enemyspecific.GargoylePriestPane;
import javafx.application.Application;

public class GargoyleEndFight extends AbstractFight {
	List<GargoylePriest> priests;
	List<GargoylePriestPane> priestPanes;
	private int numberOfPriests = 2;

	@Override
	protected String setFightTitle() {
		return "Gargoyles end fight";
	}

	@Override
	protected void nextTurn() {
		priestPanes.forEach(p -> nextTurnActions(p));
	}
	
	private void nextTurnActions(GargoylePriestPane p) {
		p.refreshAttackPanes(false);
		p.refreshHeader();
		p.refreshCheckBoxes();
		p.clearSpellPane();
	}
	

	@Override
	protected void determineDMInitiative() {
		List<Integer> dexterities = new ArrayList<>();
		dexterities.add(new GargoylePriest().getAbilityScores().getDexterityModifier());
		dexterities.add(new GargoylePriest().getAbilityScores().getDexterityModifier());
		dmInitiative = StandardRulesService.determineDMInitiative(dexterities);
	}

	@Override
	protected void initializeEnemiesAndEnemyPanes() {
		priests = new ArrayList<>();
		priestPanes = new ArrayList<>();
		
		for (int i = 0 ; i < numberOfPriests; i++) {
			GargoylePriest priest = new GargoylePriest();
			priests.add(priest);
			GargoylePriestPane priestPane = new GargoylePriestPane(priest);
			priestPanes.add(priestPane);
			basePane.add(priestPane, i, 1);
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
