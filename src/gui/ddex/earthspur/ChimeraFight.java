package gui.ddex.earthspur;

import java.util.ArrayList;
import java.util.stream.Collectors;

import basic.monsters.AbstractEnemy;
import basic.monsters.Chimera;
import basic.monsters.Lion;
import basic.monsters.earthspur.AudriciaRoaringhorn;
import basic.monsters.earthspur.Bhun;
import basic.monsters.interfaces.PreparesForNextTurn;
import basic.services.StandardRulesService;
import gui.components.EnemyPane;
import gui.components.enemyspecific.ChimeraPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChimeraFight extends Application {
	
	private ArrayList<AbstractEnemy> fighters;
	private GridPane basePane;
	private int dmInitiative;
	private ArrayList<EnemyPane<? extends AbstractEnemy>> fighterPanes;

	@Override
	public void start(Stage primaryStage) throws Exception {
		initBasePane();

		fighters = new ArrayList<>();
		fighterPanes = new ArrayList<>();

		Bhun bhun = new Bhun();
		fighters.add(bhun);
		AudriciaRoaringhorn audricia = new AudriciaRoaringhorn();
		fighters.add(audricia);
		Lion lion1 = new Lion();
		fighters.add(lion1);
		Lion lion2 = new Lion();
		fighters.add(lion2);
		Chimera chimera = new Chimera();
		fighters.add(chimera);
		
		EnemyPane<AbstractEnemy> bhunPane = new EnemyPane<>(bhun);
		EnemyPane<AbstractEnemy> audriciaPane = new EnemyPane<>(audricia);
		EnemyPane<AbstractEnemy> lion1Pane = new EnemyPane<>(lion1);
		EnemyPane<AbstractEnemy> lion2Pane = new EnemyPane<>(lion2);
		ChimeraPane chimeraPane = new ChimeraPane(chimera);

		fighterPanes.add(bhunPane);
		fighterPanes.add(audriciaPane);
		fighterPanes.add(lion1Pane);
		fighterPanes.add(lion2Pane);
		fighterPanes.add(chimeraPane);

		basePane.add(bhunPane, 0, 1);
		basePane.add(lion2Pane, 0, 2);
		basePane.add(audriciaPane, 1, 2);
		basePane.add(lion1Pane, 1, 1);
		basePane.add(chimeraPane, 2, 1);

		dmInitiative = StandardRulesService.determineDMInitiative(
				fighters.stream().map(f -> f.getAbilityScores().getDexterityModifier()).collect(Collectors.toList()));
		initializeTopButtons();

		setStage(primaryStage);
	}

	protected void initBasePane() {
		this.basePane = new GridPane();
		basePane.setPrefHeight(950);
		basePane.setPrefWidth(1800);
	}

	private void initializeTopButtons() {
		HBox topPane = new HBox();
		topPane.setPadding(new Insets(10, 10, 10, 10));
		topPane.setSpacing(10);

		Button turnButton = new Button("Next turn");
		turnButton.setOnAction(e -> nextTurn());
		topPane.getChildren().addAll(turnButton, new Text("DM initiative: " + dmInitiative));

		basePane.add(topPane, 0, 0);
	}

	private void nextTurn() {
		for (EnemyPane<? extends AbstractEnemy> p : fighterPanes) {
			p.refreshAttackPanes(false);
			p.refreshHeader();
		}
		fighters.stream().filter(f -> (f instanceof PreparesForNextTurn))
				.forEach(f -> ((PreparesForNextTurn) f).prepareForNextTurn());
	}

	private void setStage(Stage primaryStage) {
		Scene scene = new Scene(basePane);
		primaryStage.setTitle("Boarpit Fight Stage 2");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
