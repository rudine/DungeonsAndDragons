package gui.ddex.earthspur;

import java.util.ArrayList;
import java.util.stream.Collectors;

import basic.monsters.Harpy;
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

public class RandomEncounterHarpies extends Application {
	private ScrollPane scrollpane;
	private ArrayList<Harpy> harpies;
	private GridPane basePane;
	private int dmInitiative;
	private ArrayList<EnemyPane<Harpy>> harpyPanes;
	private final String fightTitle = "Random encounter: Harpies";
	private final int numberOfEnemies = 9;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.basePane = new GridPane();
		this.scrollpane = new ScrollPane(basePane);
		
		harpies = new ArrayList<>();
		harpyPanes = new ArrayList<>();
		
		for(int i = 0; i < numberOfEnemies; i++) {
			Harpy harpy = new Harpy();
			harpies.add(harpy);
			EnemyPane<Harpy> harpyPane = new EnemyPane<>(harpy);
			harpyPanes.add(harpyPane);
			if(i < 3) {
				basePane.add(harpyPane, 0, i+1);
			}
			else if(i > 2 && i < 6){
				basePane.add(harpyPane, 1, i-2);
			}
			else {
				basePane.add(harpyPane, 2, i-5);
			}
		}

		dmInitiative = StandardRulesService.determineDMInitiative(harpies.stream().map(h -> h.getAbilityScores().getDexterityModifier()).collect(Collectors.toList()));
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
		for(EnemyPane<Harpy> p: harpyPanes) {
			p.refreshAttackPanes(false);
			p.refreshHeader();
		}
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

