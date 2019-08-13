package gui.components;

import java.util.stream.Collectors;

import basic.ruleobjects.magic.Spell;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SpellPane<S extends Spell> extends GridPane {
	
	private Spell spell;
	
	public SpellPane(S spell) {
		this.spell = spell;
		addTitleText();
		addSpellDescription();
		addCharacteristicsPane();
	}
	
	private void addTitleText() {
		Text spellNameAndSchool = new Text(spell.getName() + " (" + spell.getSchool() + ")");
		this.add(spellNameAndSchool, 0, 0);
	}
	
	private void addSpellDescription() {
		HBox descriptionPane = new HBox(10);
		descriptionPane.setPadding(new Insets(10, 10, 10, 10));
		Text spellDescription = new Text(spell.getDescription());
		spellDescription.setWrappingWidth(400);
		descriptionPane.getChildren().add(spellDescription);
		this.add(descriptionPane, 1, 1);
	}

	private void addCharacteristicsPane() {
		VBox characteristics = new VBox(10);
		characteristics.setPadding(new Insets(10, 10, 10, 10));
		Text castingTime = new Text("Casting Time: " + spell.getCastingTime());
		Text range = new Text("Range: " + spell.getRange());
		Text duration = new Text("Duration (rounds): " + spell.getDurationRounds());
		Text concentration = new Text("Concentration ? :" + (spell.isConcentration() ? " Yes" : " No"));
		Text spellComponents = new Text("Spellcomponents: " + spellComponents());
		characteristics.getChildren().addAll(castingTime, range, duration, concentration, spellComponents);
		this.add(characteristics, 0, 1);
	}
	
	private String spellComponents() {
		return spell.getSpellComponents()
				.stream()
				.map(c -> c.toString())
				.collect(Collectors.joining(","));
	}
}
