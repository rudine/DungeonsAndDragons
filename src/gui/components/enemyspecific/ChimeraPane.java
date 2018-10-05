package gui.components.enemyspecific;

import java.util.List;

import basic.attacktypes.Attack;
import basic.monsters.Chimera;
import gui.components.EnemyPane;
import javafx.scene.text.Text;

public class ChimeraPane extends EnemyPane<Chimera> {

	public ChimeraPane(Chimera enemy) {
		super(enemy);
	}

	@Override
	protected void getAttackText(List<Text> texts) {
		for (Attack a : enemy.getAvailableAttacks()) {
			addAttackText(texts, a);
		}
		texts.forEach(t -> t.setWrappingWidth(580));
		attackPane.setMinHeight(3 * 30);
	}
}
