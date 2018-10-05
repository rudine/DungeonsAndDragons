package gui.ddex.cityofdanger.envy;

import java.util.ArrayList;
import java.util.stream.Collectors;

import basic.monsters.GiantBadger;
import basic.services.StandardRulesService;
import gui.components.enemyspecific.GiantBadgerPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GiantBadgerFight extends Application{
	private ScrollPane scrollpane;
	private ArrayList<GiantBadger> badgers;
	private GridPane basePane;
	private int dmInitiative;
	private ArrayList<GiantBadgerPane> badgerPanes;
	private final String fightTitle = "Altered badgers with obsidian teeth";
	private final int numberOfEnemies = 3;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.basePane = new GridPane();
		this.scrollpane = new ScrollPane(basePane);
		
		badgers = new ArrayList<>();
		badgerPanes = new ArrayList<>();
		
		for(int i = 0; i < numberOfEnemies; i++) {
			GiantBadger badger = new GiantBadger();
			badgers.add(badger);
			GiantBadgerPane badgerPane = new GiantBadgerPane(badger);
			badgerPanes.add(badgerPane);
			if(i < 3) {
				basePane.add(badgerPane, 0, i+1);
			}
			else if(i > 2 && i < 6){
				basePane.add(badgerPane, 1, i-2);
			}
			else {
				basePane.add(badgerPane, 2, i-5);
			}
		}

		dmInitiative = StandardRulesService.determineDMInitiative(badgers.stream().map(h -> h.getAbilityScores().getDexterityModifier()).collect(Collectors.toList()));
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
		for(GiantBadgerPane p: badgerPanes) {
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
