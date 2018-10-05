package gui.ddex.earthspur;

import java.util.ArrayList;
import java.util.stream.Collectors;

import basic.monsters.Gnoll;
import basic.monsters.GnollFangOfYeenoghu;
import basic.monsters.GnollPackLord;
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

public class RandomEncounterGnolls extends Application {
	private ArrayList<Gnoll> gnolls;
	private GridPane basePane;
	private ScrollPane scrollpane;
	private int dmInitiative;
	private ArrayList<EnemyPane<? extends Gnoll>> gnollPanes;
	private int numberOfGnolls = 7;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initializeGlobalVariables();
		addPackLord();
		addFangOfYeenoghu();
		addNormalGnolls();
		determineInitiative();
		initializeTopButtons();
		setStage(primaryStage);
	}

	protected void initializeGlobalVariables() {
		this.basePane = new GridPane();
		this.scrollpane = new ScrollPane(basePane);
		gnolls = new ArrayList<>();
		gnollPanes = new ArrayList<>();
	}

	protected void determineInitiative() {
		dmInitiative = StandardRulesService.determineDMInitiative(gnolls.stream().map(h -> h.getAbilityScores().getDexterityModifier()).collect(Collectors.toList()));
	}

	protected void addNormalGnolls() {
		for(int i = 0; i < numberOfGnolls; i++) {
			Gnoll gnoll = new Gnoll();
			gnolls.add(gnoll);
			EnemyPane<Gnoll> gnollPane = new EnemyPane<>(gnoll);
			gnollPanes.add(gnollPane);
			if(i < 3) {
				basePane.add(gnollPane, 0, i+1);
			}
			else if(i > 2 && i < 6){
				basePane.add(gnollPane, 1, i-2);
			}
			else {
				basePane.add(gnollPane, 2, i-5);
			}
		}
	}

	protected void addFangOfYeenoghu() {
		GnollFangOfYeenoghu fang = new GnollFangOfYeenoghu();
		gnolls.add(fang);
		EnemyPane<GnollFangOfYeenoghu> fangPane = new EnemyPane<>(fang);
		gnollPanes.add(fangPane);
		basePane.add(fangPane, 2, 3);
	}

	protected void addPackLord() {
		GnollPackLord packLord = new GnollPackLord();
		gnolls.add(packLord);
		EnemyPane<GnollPackLord> packLordPane = new EnemyPane<>(packLord);
		gnollPanes.add(packLordPane);
		basePane.add(packLordPane, 2, 2);
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
		for(EnemyPane<? extends Gnoll> p: gnollPanes) {
			p.refreshAttackPanes(false);
			p.refreshHeader();
		}
	}
	
	private void setStage(Stage primaryStage) {
		Scene scene = new Scene(scrollpane);
		primaryStage.setTitle("Random Encounter: Gnolls");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
