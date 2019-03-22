package gui.ddex.earthspur;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import basic.monsters.AbstractEnemy;
import basic.monsters.Gargoyle;
import basic.monsters.Medusa;
import basic.monsters.NightMare;
import basic.services.StandardRulesService;
import gui.components.AbstractFight;
import gui.components.EnemyPane;
import javafx.application.Application;

public class FallingStoneMineFights extends AbstractFight {
	private List<Gargoyle> gargoyles;
	private List<EnemyPane<Gargoyle>> gargoylePanes;
	private EnemyPane<Medusa> medusaPane;
	private EnemyPane<NightMare> nightmarePane;
	private int numberOfGargoyles = 4;
	private boolean includeMedusaAndNightmare = false;

	@Override
	protected String setFightTitle() {
		return "Earthspur Mine fights";
	}

	@Override
	protected void initializeEnemiesAndEnemyPanes() {
		gargoyles = new ArrayList<>();
		gargoylePanes = new ArrayList<>();

		for (int i = 0; i < numberOfGargoyles; i++) {
			Gargoyle gargoyle = new Gargoyle();
			gargoyles.add(gargoyle);
			EnemyPane<Gargoyle> gargoylePane = new EnemyPane<>(gargoyle);
			gargoylePanes.add(gargoylePane);
			int location = includeMedusaAndNightmare ? i + 2 : i;
			basePane.add(gargoylePane, location, 1);
		}

		if (includeMedusaAndNightmare) {
			medusaPane = new EnemyPane<Medusa>(new Medusa());
			basePane.add(medusaPane, 0, 1);

			nightmarePane = new EnemyPane<NightMare>(new NightMare());
			basePane.add(nightmarePane, 1, 1);
		}
	}

	@Override
	protected void determineDMInitiative() {
		List<Integer> dextMods = gargoyles.stream().map(h -> h.getAbilityScores().getDexterityModifier())
				.collect(Collectors.toList());
		dextMods.add(new Medusa().getAbilityScores().getDexterityModifier());
		dextMods.add(new NightMare().getAbilityScores().getDexterityModifier());
		dmInitiative = StandardRulesService.determineDMInitiative(dextMods);
	}

	@Override
	protected void nextTurn() {
		for (EnemyPane<Gargoyle> gargoylePane : gargoylePanes) {
			nextTurnActions(gargoylePane);
		}
		nextTurnActions(medusaPane);
		nextTurnActions(nightmarePane);
	}

	private <T extends AbstractEnemy> void nextTurnActions(EnemyPane<T> gargoylePane) {
		if (gargoylePane != null) {
			gargoylePane.refreshAttackPanes(false);
			gargoylePane.refreshHeader();
			gargoylePane.refreshCheckBoxes();
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
