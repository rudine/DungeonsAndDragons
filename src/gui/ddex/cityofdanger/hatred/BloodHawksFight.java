package gui.ddex.cityofdanger.hatred;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import basic.monsters.AbstractEnemy;
import basic.monsters.BloodHawk;
import basic.monsters.Hippogriff;
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

public class BloodHawksFight extends Application {

	private ScrollPane scrollpane;
	private List<BloodHawk> bloodHawks;
	private GridPane basePane;
	private int dmInitiative;
	private List<EnemyPane<BloodHawk>> bloodHawkPanes;
	private EnemyPane<Hippogriff> hippogriffPane;
	private String fightTitle = "Fight on the top of the tower, near the shrine of Talos";
	private int numberOfBloodhawks = 8;
	private boolean includeHippogriff = true;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.basePane = new GridPane();
		basePane.setPrefSize(1850, 1000);
		this.scrollpane = new ScrollPane(basePane);

		bloodHawks = new ArrayList<>();
		bloodHawkPanes = new ArrayList<>();
		
		for(int i = 0; i < numberOfBloodhawks; i++) {
			BloodHawk bloodhawk = new BloodHawk();
			bloodHawks.add(bloodhawk);
			EnemyPane<BloodHawk> bloodhawkPane = new EnemyPane<>(bloodhawk);
			bloodHawkPanes.add(bloodhawkPane);
			int location = includeHippogriff ? i + 1 : i;
			basePane.add(bloodhawkPane, location, 1);
		}
		
		if(includeHippogriff) {
			hippogriffPane = new EnemyPane<Hippogriff>(new Hippogriff());
			basePane.add(hippogriffPane, 0, 1);
		}

		determineDMInitiative();
		initializeTopButtons();
		setStage(primaryStage);
	}

	private void determineDMInitiative() {
		List<Integer> dextMods = bloodHawks.stream().map(h -> h.getAbilityScores().getDexterityModifier()).collect(Collectors.toList());
		dextMods.add(new Hippogriff().getAbilityScores().getDexterityModifier());
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
		for(EnemyPane<BloodHawk> bloodhawkPane: bloodHawkPanes) {
			nextTurnActions(bloodhawkPane);
		}
		nextTurnActions(hippogriffPane);
	}

	private <T extends AbstractEnemy> void nextTurnActions(EnemyPane<T> bloodhawkPane) {
		bloodhawkPane.refreshAttackPanes(false);
		bloodhawkPane.refreshHeader();
		bloodhawkPane.refreshCheckBoxes();
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
