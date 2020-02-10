package gui.ddex.earthspur;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import basic.monsters.Bulette;
import basic.services.StandardRulesService;
import gui.components.EnemyPane;
import gui.ddex.earthspur.components.MineCartsPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BulletteMineCartCase extends Application {
	private List<Bulette> bulettes;
	private GridPane basePane;
	private MineCartsPane cartsPane;
	private int dmInitiative;
	private List<EnemyPane<Bulette>> bulettePanes;
	private String fightTitle = "Bulette minecart chase";
	private int numberOfEnemies = 2;
	private int numberOfCarts = 3;
	private int numberOfTurns = 10;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.basePane = new GridPane();

		bulettes = new ArrayList<>();
		bulettePanes = new ArrayList<>();

		for (int i = 0; i < numberOfEnemies; i++) {
			Bulette bulette = new Bulette();
			bulettes.add(bulette);
			EnemyPane<Bulette> bulettePane = new EnemyPane<>(bulette);
			bulettePanes.add(bulettePane);
			basePane.add(bulettePane, i, 1);
		}

		dmInitiative = StandardRulesService.determineDMInitiative(
				bulettes.stream().map(h -> h.getAbilityScores().getDexterityModifier()).collect(Collectors.toList()));
		initializeTopButtons();
		cartsPane = new MineCartsPane(numberOfCarts);
		basePane.add(cartsPane, 2, 1);
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
		if (numberOfTurns > 0) {
			for (EnemyPane<Bulette> b : bulettePanes) {
				b.refreshAttackPanes(false);
				b.refreshHeader();
			}
			cartsPane.onNextTurn();
			numberOfTurns--;
		} else {
			basePane.getChildren().clear();
			HBox topPane = new HBox();
			topPane.setPadding(new Insets(10, 10, 10, 10));
			topPane.setSpacing(10);
			topPane.getChildren().add(new Text("Einde minecart chase"));
			basePane.add(topPane, 0, 0);
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
