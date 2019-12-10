package gui.components;

import basic.monsters.AbstractEnemy;
import basic.services.StringUtil;
import gui.LayoutService;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class TitleBlock<T extends AbstractEnemy> extends GridPane{

	private T enemy;
	
	public TitleBlock(T enemy){
		this.enemy = enemy;
		this.add(getTitleText(), 0, 1);
		this.add(getSubTitleText(), 0, 2);
	}
	
	private HBox getTitleText() {
		HBox pane = new HBox();
		pane.setPadding(new Insets(10, 10, 1, 10));

		Text enemyNameText = new Text(StringUtil.convertCamelCase(enemy.getClass().getSimpleName()));
		enemyNameText = LayoutService.setEnemyNameTextLayout(enemyNameText);

		pane.getChildren().add(enemyNameText);
		return pane;
	}

	private HBox getSubTitleText() {
		HBox pane = new HBox();
		pane.setPadding(new Insets(0, 10, 5, 10));

		Text text = new Text(enemy.getSize() + " " + enemy.getMonsterType() + ", " + enemy.getAlignment());
		text.setFont(LayoutService.getSubtitleFont());

		pane.getChildren().add(text);
		return pane;
	}
}
