package gui.ddex.earthspur;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import basic.monsters.Yeti;
import basic.services.StandardRulesService;
import gui.components.AbstractFight;
import gui.components.EnemyPane;
import javafx.application.Application;

public class YetiFight extends AbstractFight {
	private List<Yeti> yetis;
	private List<EnemyPane<Yeti>> yetiPanes;
	private int numberOfEnemies = 7;

	protected void initializeEnemiesAndEnemyPanes() {
		yetis = new ArrayList<>();
		yetiPanes = new ArrayList<>();

		for (int i = 0; i < numberOfEnemies; i++) {
			Yeti yeti = new Yeti();
			yetis.add(yeti);
			EnemyPane<Yeti> yetiPane = new EnemyPane<>(yeti);
			yetiPanes.add(yetiPane);
			basePane.add(yetiPane, i, 1);
		}
	}

	protected void determineDMInitiative() {
		dmInitiative = StandardRulesService.determineDMInitiative(
				yetis.stream().map(h -> h.getAbilityScores().getDexterityModifier()).collect(Collectors.toList()));
	}

	@Override
	protected void nextTurn() {
		yetis.forEach(y -> y.prepareForNextTurn());
		for (EnemyPane<Yeti> y : yetiPanes) {
			y.refreshAttackPanes(false);
			y.refreshHeader();
			y.refreshCheckBoxes();
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	protected String setFightTitle() {
		return "Yeti fight";
	}
}
