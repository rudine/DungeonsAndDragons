package gui.ddex.earthspur;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import basic.monsters.Yeti;
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

public class YetiFight extends Application {
	private List<Yeti> yetis;
	private GridPane basePane;
	private int dmInitiative;
	private List<EnemyPane<Yeti>> yetiPanes;
	private String fightTitle = "Yeti fight";
	private int numberOfEnemies = 2;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.basePane = new GridPane();
		
		yetis = new ArrayList<>();
		yetiPanes = new ArrayList<>();
		
		for(int i = 0; i < numberOfEnemies; i++) {
			Yeti yeti = new Yeti();
			yetis.add(yeti);
			EnemyPane<Yeti> yetiPane = new EnemyPane<>(yeti);
			yetiPanes.add(yetiPane);
			basePane.add(yetiPane, i, 1);
		}

		dmInitiative = StandardRulesService.determineDMInitiative(yetis.stream().map(h -> h.getAbilityScores().getDexterityModifier()).collect(Collectors.toList()));
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
		yetis.stream().filter(y -> y.getRoundsAffected() > 0).forEach(y -> y.setRoundsAffected(y.getRoundsAffected() - 1));
		yetis.stream().filter(y -> y.getRoundsAffected() == 0).forEach(y -> y.setDisadvantageOnAttacks(false));
		for(EnemyPane<Yeti> y: yetiPanes) {
			y.refreshAttackPanes(false);
			y.refreshHeader();
			y.refreshCheckBoxes();
		}
	}
	
	private void setStage(Stage primaryStage) {
		Scene scene = new Scene(basePane);
		primaryStage.setTitle(fightTitle);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
