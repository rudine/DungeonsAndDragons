package gui.components;

import basic.monsters.AbstractEnemy;
import basic.ruleobjects.AbilityTypes;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.services.StringUtil;
import gui.LayoutService;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Statblock<T extends AbstractEnemy> extends GridPane {

	private T enemy;

	public Statblock(T enemy) {
		this.enemy = enemy;
		this.add(getTitleText(), 0, 1);
		this.add(getSubTitleText(), 0, 2);
		this.add(getArmorClassText(), 0, 3);
		this.add(getHitpointsText(), 0, 4);
		this.add(getSpeedText(), 0, 5);
		this.add(getStatBlocks(), 0, 6);
		if (!enemy.getSkills().isEmpty()) {
			this.add(getSkills(), 0, 7);
		}
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

	private HBox getArmorClassText() {
		HBox pane = new HBox();
		pane.setPadding(new Insets(5, 10, 0, 10));

		Text armorClass = new Text("Armor Class ");
		armorClass.setFont(LayoutService.getBoldFont());
		Text AC = new Text("" + enemy.getAC());
		AC.setFont(LayoutService.getNormalFont());

		pane.getChildren().addAll(armorClass, AC);
		return pane;
	}

	private HBox getHitpointsText() {
		HBox pane = new HBox();
		pane.setPadding(new Insets(0, 10, 0, 10));

		Text hitpointsHeader = new Text("Hitpoints ");
		hitpointsHeader.setFont(LayoutService.getBoldFont());
		Text hitpoints = new Text("" + enemy.getHitpoints());
		hitpoints.setFont(LayoutService.getNormalFont());

		pane.getChildren().addAll(hitpointsHeader, hitpoints);
		return pane;
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

		pane.getChildren().add(new StatPane(AbilityTypes.STR, enemy.getAbilityScores().getStrength()));
		pane.getChildren().add(new StatPane(AbilityTypes.DEX, enemy.getAbilityScores().getDexterity()));
		pane.getChildren().add(new StatPane(AbilityTypes.CON, enemy.getAbilityScores().getConstitution()));
		pane.getChildren().add(new StatPane(AbilityTypes.INT, enemy.getAbilityScores().getIntelligence()));
		pane.getChildren().add(new StatPane(AbilityTypes.WIS, enemy.getAbilityScores().getWisdom()));
		pane.getChildren().add(new StatPane(AbilityTypes.CHA, enemy.getAbilityScores().getCharisma()));

		return pane;
	}

	private HBox getSkills() {

		HBox pane = new HBox();
		pane.setPadding(new Insets(0, 10, 0, 10));

		Text skillsHeader = new Text("Skills ");
		skillsHeader.setFont(LayoutService.getBoldFont());
		StringBuilder builder = new StringBuilder();
		for (SkillModifier sm : enemy.getSkills()) {
			builder.append(sm.toString());
			builder.append(",");
		}

		Text skills = new Text(builder.toString());
		skills.setFont(LayoutService.getNormalFont());

		pane.getChildren().addAll(skillsHeader, skills);
		return pane;
	}
}
