package gui.ddex.earthspur;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import basic.monsters.FleshGolem;
import basic.services.StandardRulesService;
import gui.components.AbstractFight;
import gui.components.EnemyPane;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FleshGolemFight extends AbstractFight {

	private List<FleshGolem> golems;
	private List<EnemyPane<FleshGolem>> golemPanes;
	private int numberOfEnemies = 2;
	private Font emphasisFont = Font.font("Verdana", FontWeight.BOLD, 12);

	@Override
	protected String setFightTitle() {
		return "Flesh golem fight";
	}

	@Override
	protected void initializeEnemiesAndEnemyPanes() {
		golems = new ArrayList<>();
		golemPanes = new ArrayList<>();

		for (int i = 0; i < numberOfEnemies; i++) {
			FleshGolem golem = new FleshGolem();
			golems.add(golem);
			EnemyPane<FleshGolem> golemPane = new EnemyPane<>(golem, "");
			golemPanes.add(golemPane);
			basePane.add(golemPane, i, 1);
		}
	}

	@Override
	protected void determineDMInitiative() {
		dmInitiative = StandardRulesService.determineDMInitiative(
				golems.stream().map(h -> h.getAbilityScores().getDexterityModifier()).collect(Collectors.toList()));
	}

	@Override
	protected void nextTurn() {
		golems.forEach(g -> g.prepareForNextTurn());
		for (EnemyPane<FleshGolem> g : golemPanes) {
			g.refreshAttackPanes(false);
			g.refreshHeader();
			g.refreshCheckBoxes();
			manageBeserkText(g);
		}
	}

	private void manageBeserkText(EnemyPane<FleshGolem> g) {
		FleshGolem golem = (FleshGolem) (g.getEnemy());
		ObservableList<Node> additionalTextPaneNodes = g.getAdditionalTextPane().getChildren();
		if (golem.isBeserk() && additionalTextPaneNodes.isEmpty()) {
			additionalTextPaneNodes.add(getBeserkText());
		} else if (!golem.isBeserk() && !additionalTextPaneNodes.isEmpty()) {
			additionalTextPaneNodes.clear();
		}
	}

	private Text getBeserkText() {
		Text beserk = new Text("BESERK!!");
		beserk.setFont(emphasisFont);
		beserk.setFill(Color.RED);
		return beserk;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
