package gui.components.enemyspecific;

import basic.monsters.earthspur.GargoylePriest;
import basic.ruleobjects.magic.Spell;
import gui.components.EnemyPane;
import gui.components.SpellPane;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class GargoylePriestPane extends EnemyPane<GargoylePriest> {

	private ComboBox<Spell> spellDropdown;
	private SpellPane<Spell> spellPane;
	private HBox dropdownButton;

	public GargoylePriestPane(GargoylePriest priest) {
		super(priest);
		dropdownButton = new HBox(10);
		dropdownButton.setPadding(new Insets(10, 10, 10, 10));

		spellDropdown = new ComboBox<>();
		spellDropdown.getItems().addAll(priest.getSpellList());

		Button useSpell = new Button("Use spell");
		useSpell.setOnAction(e -> actionsOnSpellUsed(spellDropdown.getValue()));
		dropdownButton.getChildren().addAll(spellDropdown, useSpell);
		add(dropdownButton, 0, 8);
	}

	private void actionsOnSpellUsed(Spell spell) {
		spellPane = new SpellPane<Spell>(spell);
		setPadding(new Insets(10, 10, 10, 10));
		add(spellPane, 0, 9);
	}
	
	public void clearSpellPane() {
		getChildren().remove(spellPane);
	}

	// --------------------- --------------------
	// | spell dropdown ^| | use spell button |
	// --------------------- --------------------
	//
	// Bij het klikken op de knop worden de volgende acties getriggerd:
	// 1. De spell wordt weergegeven in een spellpane
	// 2. het aantal spells dat beschikbaar is voor de level van de spell wordt
	// verminderd, als deze 0 bereikt worden alle spells van die level
	// uit de lijst van de Combobox gehaald (IDEE spells available weergeven)
	// 3. In de additional text pane wordt weergegeven welke spell al gebruikt is en
	// hoe lang deze actief is (turn aangezwengeld en tot turn beschikbaar)
	// 4. Nice to have: toon de damage bij damaging spells en toon healing bij
	// healing spells
}
