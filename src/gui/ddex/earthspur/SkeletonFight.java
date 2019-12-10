package gui.ddex.earthspur;

import java.util.ArrayList;

import basic.monsters.Skeleton;
import basic.monsters.Thug;
import basic.services.DiceService;
import gui.components.EnemyPane;
import gui.components.Statblock;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SkeletonFight extends Application{
	
	private ArrayList<Skeleton> skeletons;
	private GridPane basePane;
	private int dmInitiative;
	private ArrayList<EnemyPane<Skeleton>> skeletonPanes;
	private final int numberOfSkeletons = 2;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.basePane = new GridPane();
		dmInitiative = 3 + DiceService.throwD20(1);
		
		initializeTopButtons();
		skeletons = new ArrayList<>();
		skeletonPanes = new ArrayList<>();
		
		for(int i = 0; i < numberOfSkeletons; i++) {
			Skeleton skeleton = new Skeleton();
			skeletons.add(skeleton);
			EnemyPane<Skeleton> skeletonPane = new EnemyPane<>(skeleton);
			skeletonPanes.add(skeletonPane);
			if(i < 3) {
				basePane.add(skeletonPane, 0, i+1);
			}
			else {
				basePane.add(skeletonPane, 1, i-2);
			}
		}
		basePane.add(new Statblock<Thug>(new Thug()), 0, 4);
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
		for(EnemyPane<Skeleton> p: skeletonPanes) {
			p.refreshAttackPanes(false);
			p.refreshHeader();
		}
	}
	
	private void setStage(Stage primaryStage) {
		Scene scene = new Scene(basePane);
		primaryStage.setTitle("Skeletons fight");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
