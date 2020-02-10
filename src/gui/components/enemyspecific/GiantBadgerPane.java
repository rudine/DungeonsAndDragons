package gui.components.enemyspecific;

import java.util.List;

import basic.attack.Attack;
import basic.monsters.GiantBadger;
import gui.components.EnemyPane;
import javafx.scene.text.Text;

public class GiantBadgerPane extends EnemyPane<GiantBadger>{

	public GiantBadgerPane(GiantBadger enemy) {
		super(enemy);
	}
	
	@Override
	protected void getAttackText(List<Text> texts) {
		for (Attack attack : enemy.getAvailableAttacks()) {
			addAttackText(texts, attack);
		}
		texts.forEach(t -> t.setWrappingWidth(580));
		attackPane.setMinHeight(3 * 30);
	}
}
