package gui.components.enemyspecific;

import java.util.List;
import java.util.Optional;

import basic.attack.Attack;
import basic.monsters.Veteran;
import gui.components.EnemyPane;
import javafx.scene.text.Text;

public class VeteranPane extends EnemyPane<Veteran> {

	public VeteranPane(Veteran enemy) {
		super(enemy);
	}
	
	@Override
	protected void getAttackText(List<Text> texts) {
		Optional<Attack> optionalRanged = enemy.getAvailableAttacks().stream().filter(a -> a.getWeaponName().equals("Heavy Crossbow")).findFirst(); 
		Attack ranged = optionalRanged.orElseThrow(() -> new RuntimeException("Wapen bestaat niet bij deze vijand"));
		addAttackText(texts, ranged);

		texts.add(new Text("------------------------------------------------------------------------------------------"));
		Optional<Attack> optionalLS2H = enemy.getAvailableAttacks().stream().filter(a -> a.getWeaponName().equals("Longsword 2 Hands")).findFirst(); 
		Attack lS2H = optionalLS2H.orElseThrow(() -> new RuntimeException("Wapen bestaat niet bij deze vijand"));
		for(int i = 0; i < 2; i++) {
			addAttackText(texts, lS2H);
		}
		
		texts.add(new Text("------------------------------------------------------------------------------------------"));
		Optional<Attack> optionalLS1H = enemy.getAvailableAttacks().stream().filter(a -> a.getWeaponName().equals("Longsword 1 Hand")).findFirst(); 
		Attack lS1H = optionalLS1H.orElseThrow(() -> new RuntimeException("Wapen bestaat niet bij deze vijand"));
		for(int i = 0; i < 2; i++) {
			addAttackText(texts, lS1H);
		}
		Optional<Attack> optionalSS = enemy.getAvailableAttacks().stream().filter(a -> a.getWeaponName().equals("Shortsword")).findFirst(); 
		Attack shortsword = optionalSS.orElseThrow(() -> new RuntimeException("Wapen bestaat niet bij deze vijand"));
		addAttackText(texts, shortsword);
	}
}
