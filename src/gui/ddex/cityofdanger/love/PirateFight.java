package gui.ddex.cityofdanger.love;

import java.util.ArrayList;
import java.util.stream.Collectors;

import basic.monsters.Bandit;
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

public class PirateFight extends Application {
	private ScrollPane scrollpane;
	private ArrayList<Bandit> bandits;
	private GridPane basePane;
	private int dmInitiative;
	private ArrayList<EnemyPane<Bandit>> banditPanes;
	private final String fightTitle = "Mixies friends: pirates!";
	private final int numberOfEnemies = 4;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.basePane = new GridPane();
		this.scrollpane = new ScrollPane(basePane);
		
		bandits = new ArrayList<>();
		banditPanes = new ArrayList<>();
		
		for(int i = 0; i < numberOfEnemies; i++) {
			Bandit pirate = new Bandit();
			bandits.add(pirate);
			EnemyPane<Bandit> banditPane = new EnemyPane<>(pirate);
			banditPanes.add(banditPane);
			if(i < 3) {
				basePane.add(banditPane, 0, i+1);
			}
			else if(i > 2 && i < 6){
				basePane.add(banditPane, 1, i-2);
			}
			else {
				basePane.add(banditPane, 2, i-5);
			}
		}

		dmInitiative = StandardRulesService.determineDMInitiative(bandits.stream().map(h -> h.getAbilityScores().getDexterityModifier()).collect(Collectors.toList()));
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
		for(EnemyPane<Bandit> p: banditPanes) {
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
