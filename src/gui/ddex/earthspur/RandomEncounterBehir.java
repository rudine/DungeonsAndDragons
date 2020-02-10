package gui.ddex.earthspur;

import java.util.ArrayList;

import basic.monsters.Behir;
import basic.services.StandardRulesService;
import gui.components.EnemyPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RandomEncounterBehir extends Application {

	private Behir behir;
	private GridPane basePane;
	private int dmInitiative;
	private EnemyPane<Behir> behirPane;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initBasePane();
		
		behir = new Behir();
		behirPane = new EnemyPane<>(behir);
		
		basePane.add(behirPane, 0, 1);
		
		dmInitiative = StandardRulesService.determineDMInitiative(new ArrayList<Integer>(behir.getAbilityScores().getDexterityModifier())); 
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
	
	protected void initBasePane() {
		this.basePane = new GridPane();
		basePane.setPrefHeight(950);
		basePane.setPrefWidth(1800);
	}

	private void nextTurn() {
		behirPane.refreshAttackPanes(false);
		behirPane.refreshHeader();
		behir.prepareForNextTurn();
	}

	private void setStage(Stage primaryStage) {
		Scene scene = new Scene(basePane);
		primaryStage.setTitle("Behir random encounter");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
