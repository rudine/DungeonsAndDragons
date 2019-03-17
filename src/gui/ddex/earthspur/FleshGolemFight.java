package gui.ddex.earthspur;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import basic.monsters.FleshGolem;
import basic.services.StandardRulesService;
import gui.components.EnemyPane;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FleshGolemFight extends Application {
	private ScrollPane scrollpane;
	private List<FleshGolem> golems;
	private GridPane basePane;
	private int dmInitiative;
	private List<EnemyPane<FleshGolem>> golemPanes;
	private String fightTitle = "Flesh golem fight";
	private int numberOfEnemies = 2;
	private Font emphasisFont = Font.font("Verdana", FontWeight.BOLD, 12);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.basePane = new GridPane();
		basePane.setPrefSize(1850, 1000);
		this.scrollpane = new ScrollPane(basePane);

		golems = new ArrayList<>();
		golemPanes = new ArrayList<>();
		
		for(int i = 0; i < numberOfEnemies; i++) {
			FleshGolem golem = new FleshGolem();
			golems.add(golem);
			EnemyPane<FleshGolem> golemPane = new EnemyPane<>(golem, "");
			golemPanes.add(golemPane);
			basePane.add(golemPane, i, 1);
		}

		dmInitiative = StandardRulesService.determineDMInitiative(golems.stream().map(h -> h.getAbilityScores().getDexterityModifier()).collect(Collectors.toList()));
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
		golems.forEach(g -> g.prepareForNextTurn());
		for(EnemyPane<FleshGolem> g: golemPanes) {
			g.refreshAttackPanes(false);
			g.refreshHeader();
			g.refreshCheckBoxes();
			manageBeserkText(g);
		}
	}

	private void manageBeserkText(EnemyPane<FleshGolem> g) {
		FleshGolem golem = (FleshGolem)(g.getEnemy());
		ObservableList<Node> additionalTextPaneNodes = g.getAdditionalTextPane().getChildren();
		if(golem.isBeserk() && additionalTextPaneNodes.isEmpty()) {
			additionalTextPaneNodes.add(getBeserkText());
		}
		else if(!golem.isBeserk() && !additionalTextPaneNodes.isEmpty()) {
			additionalTextPaneNodes.clear();
		}
	}

	private Text getBeserkText() {
		Text beserk = new Text("BESERK!!");
		beserk.setFont(emphasisFont);
		beserk.setFill(Color.RED);
		return beserk;
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
