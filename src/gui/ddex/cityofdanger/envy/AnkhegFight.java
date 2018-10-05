package gui.ddex.cityofdanger.envy;

import java.util.ArrayList;

import basic.monsters.Ankheg;
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

public class AnkhegFight extends Application{

	private Ankheg ankheg;
	private GridPane basePane;
	private int dmInitiative;
	private EnemyPane<Ankheg> ankhegPane;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initBasePane();
		
		ankheg = new Ankheg();
		ankhegPane = new EnemyPane<>(ankheg);
		
		basePane.add(ankhegPane, 0, 1);
		
		dmInitiative = StandardRulesService.determineDMInitiative(new ArrayList<Integer>(ankheg.getAbilityScores().getDexterityModifier())); 
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
			ankhegPane.refreshAttackPanes(false);
			ankhegPane.refreshHeader();
				ankheg.prepareForNextTurn();
	}

	private void setStage(Stage primaryStage) {
		Scene scene = new Scene(basePane);
		primaryStage.setTitle("Ankheg has little gnome!!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
