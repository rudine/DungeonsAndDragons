package gui.ddex.earthspur;

import java.util.ArrayList;
import java.util.stream.Collectors;

import basic.monsters.AbstractEnemy;
import basic.monsters.Thug;
import basic.monsters.Veteran;
import basic.monsters.earthspur.BPFDragonHead;
import basic.monsters.earthspur.BPFGoatHead;
import basic.monsters.earthspur.BPFLionHead;
import basic.monsters.interfaces.PreparesForNextTurn;
import basic.services.StandardRulesService;
import gui.components.EnemyPane;
import gui.components.enemyspecific.VeteranPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BoarPitFight extends Application {

	private ArrayList<AbstractEnemy> fighters;
	private GridPane basePane;
	private int dmInitiative;
	private ArrayList<EnemyPane<? extends AbstractEnemy>> fighterPanes;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.basePane = new GridPane();
		basePane.setPrefHeight(950);
		basePane.setPrefWidth(1800);
		
		fighters = new ArrayList<>();
		fighterPanes = new ArrayList<>();
		
		BPFDragonHead dragonHead = new BPFDragonHead();
		fighters.add(dragonHead);
		BPFGoatHead goatHead = new BPFGoatHead();
		fighters.add(goatHead);
		BPFLionHead lionHead = new BPFLionHead();
		fighters.add(lionHead);
		Veteran veteran = new Veteran();
		fighters.add(veteran);
		Thug rivalChallenger1 = new Thug();
		fighters.add(rivalChallenger1);
		Thug rivalChallenger2 = new Thug();
		fighters.add(rivalChallenger2);
		
		EnemyPane<AbstractEnemy> dragonHeadPane = new EnemyPane<>(dragonHead);
		EnemyPane<AbstractEnemy> goatHeadPane = new EnemyPane<>(goatHead);
		EnemyPane<AbstractEnemy> lionHeadPane = new EnemyPane<>(lionHead);
		EnemyPane<Veteran> veteranPane = new VeteranPane(veteran);
		EnemyPane<AbstractEnemy> thugPane1 = new EnemyPane<>(rivalChallenger1);
		EnemyPane<AbstractEnemy> thugPane2 = new EnemyPane<>(rivalChallenger2);
		
		fighterPanes.add(dragonHeadPane);
		fighterPanes.add(goatHeadPane);
		fighterPanes.add(lionHeadPane);
		fighterPanes.add(veteranPane);
		fighterPanes.add(thugPane1);
		fighterPanes.add(thugPane2);
		
		basePane.add(dragonHeadPane, 0, 1);
		basePane.add(thugPane1, 0, 2);
		basePane.add(goatHeadPane, 1, 2);
		basePane.add(lionHeadPane, 1, 1);
		basePane.add(veteranPane, 2, 1);
		basePane.add(thugPane2, 2, 2);
		 
		dmInitiative = StandardRulesService.determineDMInitiative(fighters.stream().map(f -> f.getAbilityScores().getDexterityModifier()).collect(Collectors.toList()));
		initializeTopButtons();
		
		setStage(primaryStage);
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
		fighters.stream()
				.filter(f -> (f instanceof PreparesForNextTurn))//
				.forEach(f -> ((PreparesForNextTurn)f)//
				.prepareForNextTurn());
	}

	private void setStage(Stage primaryStage) {
		Scene scene = new Scene(basePane);
		primaryStage.setTitle("Boarpit Fight Stage 1");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
