package gui.ddex.earthspur;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import basic.monsters.AbstractEnemy;
import basic.monsters.Gargoyle;
import basic.monsters.Medusa;
import basic.monsters.NightMare;
import basic.services.StandardRulesService;
import gui.components.EnemyPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FallingStoneMineFights extends Application{
	private ScrollPane scrollpane;
	private List<Gargoyle> gargoyles;
	private GridPane basePane;
	private int dmInitiative;
	private List<EnemyPane<Gargoyle>> gargoylePanes;
	private EnemyPane<Medusa> medusaPane;
	private EnemyPane<NightMare> nightmarePane;
	private String fightTitle = "Earthspur Mine fights";
	private int numberOfGargoyles = 4;
	private boolean includeMedusaAndNightmare = false;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.basePane = new GridPane();
		basePane.setPrefSize(1850, 1000);
		this.scrollpane = new ScrollPane(basePane);

		gargoyles = new ArrayList<>();
		gargoylePanes = new ArrayList<>();
		
		for(int i = 0; i < numberOfGargoyles; i++) {
			Gargoyle gargoyle = new Gargoyle();
			gargoyles.add(gargoyle);
			EnemyPane<Gargoyle> gargoylePane = new EnemyPane<>(gargoyle);
			gargoylePanes.add(gargoylePane);
			int location = includeMedusaAndNightmare ? i + 2 : i;
			basePane.add(gargoylePane, location, 1);
		}
		
		if(includeMedusaAndNightmare) {
			medusaPane = new EnemyPane<Medusa>(new Medusa());
			basePane.add(medusaPane, 0, 1);
			
			nightmarePane = new EnemyPane<NightMare>(new NightMare());
			basePane.add(nightmarePane, 1, 1);
		}

		determineDMInitiative();
		initializeTopButtons();
		setStage(primaryStage);
	}

	private void determineDMInitiative() {
		List<Integer> dextMods = gargoyles.stream().map(h -> h.getAbilityScores().getDexterityModifier()).collect(Collectors.toList());
		dextMods.add(new Medusa().getAbilityScores().getDexterityModifier());
		dextMods.add(new NightMare().getAbilityScores().getDexterityModifier());
		dmInitiative = StandardRulesService.determineDMInitiative(dextMods);
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
		for(EnemyPane<Gargoyle> gargoylePane: gargoylePanes) {
			nextTurnActions(gargoylePane);
		}
		nextTurnActions(medusaPane);
		nextTurnActions(nightmarePane);
	}

	private <T extends AbstractEnemy> void nextTurnActions(EnemyPane<T> gargoylePane) {
		gargoylePane.refreshAttackPanes(false);
		gargoylePane.refreshHeader();
		gargoylePane.refreshCheckBoxes();
	}
	
	private void setStage(Stage primaryStage) {
		Scene scene = new Scene(scrollpane);
		primaryStage.setTitle(fightTitle);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
