package gui.components;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class AbstractFight extends Application {
	
	private ScrollPane scrollPane;
	protected GridPane basePane;
	protected int dmInitiative;
	private String fightTitle;
	private HBox topPane;
	private Text turnText;
	private int turn;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.fightTitle = setFightTitle();
		initializeBaseAndScrollPane();
		initializeEnemiesAndEnemyPanes();
		determineDMInitiative();
		initializeTopButtons();
		setStage(primaryStage);
	}
	
	private void initializeBaseAndScrollPane() {
		this.basePane = new GridPane();
		basePane.setPrefSize(1850, 1000);
		this.scrollPane = new ScrollPane(basePane);
	}
	
	private void initializeTopButtons() {
		topPane = new HBox();
		topPane.setPadding(new Insets(10, 10, 10, 10));
		topPane.setSpacing(10);

		Button turnButton = new Button("Next turn");
		turnButton.setOnAction(e -> onNextTurn());
		turnText = new Text("Turn number: " + turn);
		topPane.getChildren().addAll(turnButton, new Text("DM initiative: " + dmInitiative), turnText);

		basePane.add(topPane, 0, 0);
	}
	
	private void onNextTurn() {
		turnText.setText("Turn number: " + ++turn);
		nextTurn();
	}
	
	protected abstract String setFightTitle();
	
	protected abstract void nextTurn();
	
	protected abstract void determineDMInitiative();
	
	protected abstract void initializeEnemiesAndEnemyPanes();
	
	private void setStage(Stage primaryStage) {
		Scene scene = new Scene(scrollPane);
		primaryStage.setTitle(fightTitle);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public int getTurn() {
		return turn;
	}
}
