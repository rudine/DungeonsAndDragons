package gui.ddex.earthspur;

import java.util.ArrayList;
import java.util.stream.Collectors;

import basic.monsters.earthspur.DarmovGuard;
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

public class MagicDetectedFight extends Application{

	private ArrayList<DarmovGuard> guards;
	private GridPane basePane;
	private int dmInitiative;
	private ArrayList<EnemyPane<DarmovGuard>> guardPanes;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.basePane = new GridPane();
		basePane.setPrefHeight(980);
		
		guards = new ArrayList<>();
		guardPanes = new ArrayList<>();
		
		for(int i = 0; i < 6; i++) {
			DarmovGuard guard = new DarmovGuard();
			guards.add(guard);
			EnemyPane<DarmovGuard> guardPane = new EnemyPane<>(guard);
			guardPanes.add(guardPane);
			if(i < 3) {
				basePane.add(guardPane, 0, i+1);
			}
			else {
				basePane.add(guardPane, 1, i-2);
			}
		}
		
		dmInitiative = StandardRulesService.determineDMInitiative(guards.stream().map(f -> f.getAbilityScores().getDexterityModifier()).collect(Collectors.toList()));
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
		for(EnemyPane<DarmovGuard> p: guardPanes) {
			p.refreshAttackPanes(false);
			p.refreshHeader();
		}
	}
	
	private void setStage(Stage primaryStage) {
		Scene scene = new Scene(basePane);
		primaryStage.setTitle("Magic detected fight");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
