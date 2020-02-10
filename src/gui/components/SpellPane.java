package gui.components;

import java.util.stream.Collectors;

import basic.ruleobjects.magic.Spell;
import basic.ruleobjects.magic.spells.DamagingSpell;
import basic.ruleobjects.magic.spells.HealingSpell;
import basic.ruleobjects.magic.spells.MagicMissile;
import basic.ruleobjects.magic.spells.RequiresAttackRoll;
import gui.LayoutService;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SpellPane<S extends Spell> extends GridPane {

	private Spell spell;
	private int casterLevel;
	private int spellAttackModifier;

	public SpellPane(S spell, int casterLevel, int spellAttackModifier) {
		this.spell = spell;
		this.casterLevel = casterLevel;
		this.spellAttackModifier = spellAttackModifier;
		addTitleText();
		addSpellDescription();
		addCharacteristicsPane();
	}

	private void addTitleText() {
		Text spellNameAndSchool = new Text(spell.getName() + " (" + spell.getSchool() + ")");
		spellNameAndSchool.setFont(LayoutService.getTitleFont());
		this.add(spellNameAndSchool, 0, 0);
	}

	private void addSpellDescription() {
		HBox descriptionPane = new HBox(10);
		descriptionPane.setPadding(LayoutService.getDefaultPadding());
		Text spellDescription = new Text(spell.getDescription());
		spellDescription.setWrappingWidth(400);
		descriptionPane.getChildren().add(spellDescription);
		this.add(descriptionPane, 1, 1);
	}

	private void addCharacteristicsPane() {
		VBox characteristics = new VBox(10);
		characteristics.setPadding(LayoutService.getDefaultPadding());
		Text castingTime = new Text("Casting Time: " + spell.getCastingTime());
		Text range = new Text("Range: " + spell.getRange());
		Text duration = new Text("Duration (rounds): " + spell.getDurationRounds());
		Text concentration = new Text("Concentration ? :" + (spell.isConcentration() ? " Yes" : " No"));
		Text spellComponents = new Text("Spellcomponents: " + spellComponents());
		characteristics.getChildren().addAll(castingTime, range, duration, concentration, spellComponents);
		if(spell instanceof RequiresAttackRoll) {
			RequiresAttackRoll rollSpell = (RequiresAttackRoll) spell;
			int attackRoll = rollSpell.getToHit(spellAttackModifier);
			Text attackRollText = new Text("To hit: " + attackRoll);
			characteristics.getChildren().add(attackRollText);
		}
		if (spell instanceof DamagingSpell) {
			if (spell instanceof MagicMissile) {
				MagicMissile missile = (MagicMissile) spell;
				String damage = missile.getDamageForSeperateMissiles(1).stream().map(i -> i.toString()).collect(Collectors.joining(", "));
				Text damageText = new Text("Damage: " + damage + " " + missile.getDamageType());
				characteristics.getChildren().add(damageText);
			} else {
				DamagingSpell damSpell = (DamagingSpell) spell;
				int damage = damSpell.getDamage(casterLevel);
				Text damageText = new Text("Damage: " + damage + " " + damSpell.getDamageType());
				characteristics.getChildren().add(damageText);
			}
		}
		if (spell instanceof HealingSpell) {
			HealingSpell healSpell = (HealingSpell) spell;
			int healing = healSpell.getHealedHitpoints(1); // TODO placeholder voor de casterlevel van de enemy + echt
															// toevoegen aan enemy
			Text healText = new Text("Healed: " + healing);
			characteristics.getChildren().add(healText);
		}

		this.add(characteristics, 0, 1);
	}

	private String spellComponents() {
		return spell.getSpellComponents().stream().map(c -> c.toString()).collect(Collectors.joining(","));
	}
}
