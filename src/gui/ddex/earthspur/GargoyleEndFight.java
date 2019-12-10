package gui.ddex.earthspur;

import java.util.ArrayList;
import java.util.List;

import basic.monsters.EarthElemental;
import basic.monsters.Gargoyle;
import basic.monsters.earthspur.GargoylePriest;
import basic.services.StandardRulesService;
import gui.components.AbstractFight;
import gui.components.EnemyPane;
import gui.components.NewEnemyPane;
import gui.components.enemyspecific.GargoylePriestPane;
import javafx.application.Application;

public class GargoyleEndFight extends AbstractFight {
	List<GargoylePriest> priests;
	List<Gargoyle> gargoyles;
	List<EarthElemental> elementals;
	List<GargoylePriestPane> priestPanes;
	List<NewEnemyPane<Gargoyle>> gargoylePanes;
	List<EnemyPane<EarthElemental>> elementalPanes;
	
	private int numberOfPriests = 2;
	private int numberOfGargoyles = 4;
	private int numberOfElementals = 1;
//	private int numberOfGhalebs = 1;

	@Override
	protected String setFightTitle() {
		
		return "Gargoyles end fight";
	}

	@Override
	protected void nextTurn() {
		priestPanes.forEach(p -> nextTurnActionsPriest(p));
		gargoylePanes.forEach(p -> nextTurnActionsGargoyle(p));
		elementalPanes.forEach(p -> nextTurnActionsElemental(p));
	}
	
	private void nextTurnActionsPriest(GargoylePriestPane priestPane) {
		priestPane.setTurn(getTurn());
		priestPane.refreshAttackPanes(false);
		priestPane.refreshHeader();
		priestPane.refreshCheckBoxes();
		priestPane.clearSpellPane();
	}
	
	private void nextTurnActionsGargoyle(NewEnemyPane<Gargoyle> gargoylePane) {
		gargoylePane.refreshAttackPanes(false);
		gargoylePane.refreshCheckBoxes();
	}
	
	private void nextTurnActionsElemental(EnemyPane<EarthElemental> elementalPane) {
		elementalPane.refreshAttackPanes(false);
		elementalPane.refreshHeader();
		elementalPane.refreshCheckBoxes();
	}
	

	@Override
	protected void determineDMInitiative() {
		List<Integer> dexterities = new ArrayList<>();
		priests.forEach(p -> dexterities.add(p.getAbilityScores().getDexterityModifier()));
		gargoyles.forEach(g -> dexterities.add(g.getAbilityScores().getDexterityModifier()));
		dmInitiative = StandardRulesService.determineDMInitiative(dexterities);
	}

	@Override
	protected void initializeEnemiesAndEnemyPanes() {
		initializePriests();
		initializeGargoyles();
		initializeElementals();
	}

	private void initializeGargoyles() {
		gargoyles = new ArrayList<>();
		gargoylePanes = new ArrayList<>();
		for (int i = 0 ; i < numberOfGargoyles; i++) {
			Gargoyle gargoyle = new Gargoyle();
			gargoyles.add(gargoyle);
			NewEnemyPane<Gargoyle> gargoylePane = new NewEnemyPane<>(gargoyle);
			gargoylePanes.add(gargoylePane);
			basePane.add(gargoylePane, i + numberOfPriests, 1);
		}
	}

	private void initializePriests() {
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
	
	private void initializeElementals() {
		elementals = new ArrayList<>();
		elementalPanes = new ArrayList<>();
		for(int i = 0 ; i < numberOfElementals; i++) {
			EarthElemental elemental = new EarthElemental();
			elementals.add(elemental);
			EnemyPane<EarthElemental> elementalPane = new EnemyPane<>(elemental);
			elementalPanes.add(elementalPane);
			basePane.add(elementalPane, i + numberOfPriests + numberOfGargoyles, 1);
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
