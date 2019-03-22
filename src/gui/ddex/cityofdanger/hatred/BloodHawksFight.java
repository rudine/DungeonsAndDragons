package gui.ddex.cityofdanger.hatred;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import basic.monsters.AbstractEnemy;
import basic.monsters.BloodHawk;
import basic.monsters.Hippogriff;
import basic.services.StandardRulesService;
import gui.components.AbstractFight;
import gui.components.EnemyPane;
import javafx.application.Application;

public class BloodHawksFight extends AbstractFight {

	private List<BloodHawk> bloodHawks;
	private List<EnemyPane<BloodHawk>> bloodHawkPanes;
	private EnemyPane<Hippogriff> hippogriffPane;
	private int numberOfBloodhawks = 8;
	private boolean includeHippogriff = false;
	
	@Override
	protected String setFightTitle() {
		return "Fight on the top of the tower, near the shrine of Talos";
	}

	@Override
	protected void nextTurn() {
		for (EnemyPane<BloodHawk> bloodhawkPane : bloodHawkPanes) {
			nextTurnActions(bloodhawkPane);
		}
		nextTurnActions(hippogriffPane);
	}
	
	private <T extends AbstractEnemy> void nextTurnActions(EnemyPane<T> pane) {
		if (pane != null) {
			pane.refreshAttackPanes(false);
			pane.refreshHeader();
			pane.refreshCheckBoxes();
		}
	}

	@Override
	protected void determineDMInitiative() {
		List<Integer> dextMods = bloodHawks.stream().map(h -> h.getAbilityScores().getDexterityModifier())
				.collect(Collectors.toList());
		dextMods.add(new Hippogriff().getAbilityScores().getDexterityModifier());
		dmInitiative = StandardRulesService.determineDMInitiative(dextMods);
	}

	@Override
	protected void initializeEnemiesAndEnemyPanes() {
		bloodHawks = new ArrayList<>();
		bloodHawkPanes = new ArrayList<>();

		for (int i = 0; i < numberOfBloodhawks; i++) {
			BloodHawk bloodhawk = new BloodHawk();
			bloodHawks.add(bloodhawk);
			EnemyPane<BloodHawk> bloodhawkPane = new EnemyPane<>(bloodhawk);
			bloodHawkPanes.add(bloodhawkPane);
			int location = includeHippogriff ? i + 1 : i;
			basePane.add(bloodhawkPane, location, 1);
		}

		if (includeHippogriff) {
			hippogriffPane = new EnemyPane<Hippogriff>(new Hippogriff());
			basePane.add(hippogriffPane, 0, 1);
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
