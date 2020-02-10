package gui.components;

import java.util.stream.Collectors;

import basic.monsters.AbstractEnemy;
import basic.ruleobjects.AbilityTypes;
import gui.LayoutService;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Statblock<T extends AbstractEnemy> extends GridPane {

	private T enemy;
	private HBox hitpointsPane;
	private Text hitpoints;

	public Statblock(T enemy) {
		this.enemy = enemy;
		this.add(getArmorClassText(), 0, 1);
		loadHitpointsText(); // 0, 2
		this.add(getSpeedText(), 0, 3);
		this.add(getStatBlocks(), 0, 4);
		if (!enemy.getSkills().isEmpty()) {
			this.add(getSkills(), 0, 5);
		}
	}

	private HBox getArmorClassText() {
		HBox pane = new HBox();
		pane.setPadding(new Insets(5, 10, 0, 10));

		Text armorClass = new Text("Armor Class ");
		armorClass.setFont(LayoutService.getBoldFont());
		Text AC = new Text("" + enemy.getArmorClass());
		AC.setFont(LayoutService.getNormalFont());

		pane.getChildren().addAll(armorClass, AC);
		return pane;
	}

	private void loadHitpointsText() {
		hitpointsPane = new HBox();
		hitpointsPane.setPadding(new Insets(0, 10, 0, 10));

		Text hitpointsHeader = new Text("Hitpoints ");
		hitpointsHeader.setFont(LayoutService.getBoldFont());
		hitpoints = new Text(getHitpointText());
		hitpoints.setFont(LayoutService.getNormalFont());

		hitpointsPane.getChildren().addAll(hitpointsHeader, hitpoints);
		this.add(hitpointsPane, 0, 2);
	}
	
	public void updateHitpointsText() {
		if(hitpointsPane.getChildren().contains(hitpoints)) {
			hitpointsPane.getChildren().remove(hitpoints);
			hitpoints = new Text(getHitpointText());
			hitpointsPane.getChildren().add(hitpoints);
		}
		else {
			throw new RuntimeException("Could not update hitpoints, hitpoints pane does not contain text");
		}
	}
	
	protected String getHitpointText() {
		StringBuilder builder = new StringBuilder();
		builder.append(enemy.getHitpoints());
		builder.append(" (" + ((int) Math.ceil(enemy.getVitalityPercentage())) + "%) ");
		builder.append(enemy.getVitalityDescription());
		return builder.toString();
	}
	
	private HBox getSpeedText() {
		HBox pane = new HBox();
		pane.setPadding(new Insets(0, 10, 0, 10));

		Text speedHeader = new Text("Speed ");
		speedHeader.setFont(LayoutService.getBoldFont());
		Text speed = new Text("" + enemy.getSpeed());
		speed.setFont(LayoutService.getNormalFont());

		pane.getChildren().addAll(speedHeader, speed);
		return pane;
	}

	private HBox getStatBlocks() {
		HBox pane = new HBox();
		pane.setPadding(new Insets(5, 10, 5, 10));

		pane.getChildren().add(new AbilityScoreBlock(AbilityTypes.STR, enemy.getAbilityScores().getStrength()));
		pane.getChildren().add(new AbilityScoreBlock(AbilityTypes.DEX, enemy.getAbilityScores().getDexterity()));
		pane.getChildren().add(new AbilityScoreBlock(AbilityTypes.CON, enemy.getAbilityScores().getConstitution()));
		pane.getChildren().add(new AbilityScoreBlock(AbilityTypes.INT, enemy.getAbilityScores().getIntelligence()));
		pane.getChildren().add(new AbilityScoreBlock(AbilityTypes.WIS, enemy.getAbilityScores().getWisdom()));
		pane.getChildren().add(new AbilityScoreBlock(AbilityTypes.CHA, enemy.getAbilityScores().getCharisma()));

		return pane;
	}

	private HBox getSkills() {
		HBox pane = new HBox();
		pane.setPadding(new Insets(0, 10, 0, 10));

		Text skillsHeader = new Text("Skills ");
		skillsHeader.setFont(LayoutService.getBoldFont());
		
		String skillsText = enemy.getSkills()//
				.stream()//
				.map(s -> s.toString())//
				.collect(Collectors.joining(", "));

		Text skills = new Text(skillsText);
		skills.setFont(LayoutService.getNormalFont());

		pane.getChildren().addAll(skillsHeader, skills);
		return pane;
	}
}
