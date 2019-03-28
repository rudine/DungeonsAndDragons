package gui.ddex.cityofdanger.greed;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import basic.monsters.AbstractEnemy;
import basic.monsters.Bullywug;
import basic.monsters.GiantFrog;
import basic.services.StandardRulesService;
import gui.components.AbstractFight;
import gui.components.EnemyPane;
import javafx.application.Application;

public class DeepGuardianFight extends AbstractFight {
	private List<AbstractEnemy> deepGuardians;
	private List<EnemyPane<AbstractEnemy>> enemyPanes;
	private int numberOfFrogs = 2;
	private int numberOfBullywugs = 4;
	
	
	@Override
	protected String setFightTitle() {
		return "Deep Guardians!";
	}

	@Override
	protected void nextTurn() {
		for (EnemyPane<AbstractEnemy> enemypane : enemyPanes) {
			enemypane.refreshAttackPanes(false);
			enemypane.refreshHeader();
			enemypane.refreshCheckBoxes();
		}
	}

	@Override
	protected void determineDMInitiative() {
		dmInitiative = StandardRulesService.determineDMInitiative(
				deepGuardians.stream()//
				.map(deepguardian -> deepguardian.getAbilityScores().getDexterityModifier())//
				.collect(Collectors.toList()));
	}

	@Override
	protected void initializeEnemiesAndEnemyPanes() {
		deepGuardians = new ArrayList<>();
		enemyPanes = new ArrayList<>();

		for(int i = 0; i < numberOfFrogs; i++) {
			GiantFrog frog = new GiantFrog();
			deepGuardians.add(frog);
			EnemyPane<AbstractEnemy> pane = new EnemyPane<AbstractEnemy>(frog);
			enemyPanes.add(pane);
			basePane.add(pane, i, 1);
		}

		for(int i = numberOfFrogs; i < numberOfBullywugs + numberOfFrogs; i++) {
			Bullywug wug = new Bullywug();
			deepGuardians.add(wug);
			EnemyPane<AbstractEnemy> pane = new EnemyPane<AbstractEnemy>(wug);
			enemyPanes.add(pane);
			basePane.add(pane, i, 1);
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
