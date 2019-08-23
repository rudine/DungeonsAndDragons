package gui.components.enemyspecific;

import java.util.List;
import java.util.stream.Collectors;

import basic.monsters.earthspur.GargoylePriest;
import basic.ruleobjects.magic.Spell;
import gui.LayoutService;
import gui.components.EnemyPane;
import gui.components.SpellPane;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class GargoylePriestPane extends EnemyPane<GargoylePriest> {

	private ComboBox<Spell> spellDropdown;
	private SpellPane<Spell> spellDescriptionPane;
	private HBox spellSelectionPane;
	private HBox spellAvailabilityPane;
	private int turn;

	public GargoylePriestPane(GargoylePriest priest) {
		super(priest, "");
		addSpellAvailabilityPane();
		addSpellSelectionPane();
	}

	private void addSpellAvailabilityPane() {
		spellAvailabilityPane = new HBox(10);
		spellAvailabilityPane.setPadding(LayoutService.getDefaultPadding());
		
		Text availablityTitle = new Text("Available spells: ");
		availablityTitle.setFont(LayoutService.getTitleFont());
		Text firstLevelSpells = new Text("First level: " + getPriest().getFirstLevelSpells());
		Text secondLevelSpells = new Text("Second level: " + getPriest().getSecondLevelSpells());
		Text thirdLevelSpells = new Text("Third level: " + getPriest().getThirdLevelSpells());
		
		spellAvailabilityPane.getChildren().addAll(availablityTitle, firstLevelSpells, secondLevelSpells, thirdLevelSpells);
		add(spellAvailabilityPane, 0, 9);
	}

	private void refreshSpellAvailabilityPane() {
		getChildren().remove(spellAvailabilityPane);
		addSpellAvailabilityPane();
	}

	private void addSpellSelectionPane() {
		spellSelectionPane = new HBox(10);
		spellSelectionPane.setPadding(LayoutService.getDefaultPadding());

		spellDropdown = new ComboBox<>();
		spellDropdown.getItems().addAll(getSpellList()); // FIXME sorteer op level, sorteer op alfabetische volgorde

		Button useSpell = new Button("Use spell");
		useSpell.setOnAction(e -> actionsOnSpellUsed(spellDropdown.getValue()));
		spellSelectionPane.getChildren().addAll(spellDropdown, useSpell);
		add(spellSelectionPane, 0, 10);
	}

	private void actionsOnSpellUsed(Spell spell) {
		removeSpellPane();
		addSpellPane(spell);
		updateAdditionalTextPane(spell);
		updateSpellAvailability(spell);
		refreshSpellAvailabilityPane();
	}

	private void updateAdditionalTextPane(Spell spell) {
		Text usedSpell = null;
		if(spell.getDurationRounds() != 0)
			usedSpell = new Text(spell.getName() + " active from round " + getTurn() + " until round " + (getTurn() + spell.getDurationRounds()) + ". Concentration ? " + (spell.isConcentration() ? "Yes" : "No"));
		else
			usedSpell = new Text(spell.getName() + " cast on round " + getTurn());
		getAdditionalTextPane().getChildren().add(usedSpell);
	}
	
	private void updateSpellAvailability(Spell spell) {
		switch (spell.getLevel()) {
		case 3:
			updateThirdLevelSpells();
			break;
		case 2:
			updateSecondLevelSpells();
			break;
		case 1:
			updateFirstLevelSpells();
			break;
		case 0:
			break;
		default:
			throw new IllegalArgumentException(
					"Gargoyle priest have no spells higher than 3rd level or lower than cantrips");
		}
	}

	private void addSpellPane(Spell spell) {
		spellDescriptionPane = new SpellPane<Spell>(spell, 2, getPriest().getAbilityScores().getWisdomModifier() + 2);
		setPadding(LayoutService.getDefaultPadding());
		add(spellDescriptionPane, 0, 11);
	}

	private void removeSpellPane() {
		if(spellDescriptionPane != null) {
			getChildren().remove(spellDescriptionPane);
		}
	}

	public void clearSpellPane() {
		getChildren().remove(spellDescriptionPane);
	}

	private void updateThirdLevelSpells() {
		if (getPriest().getThirdLevelSpells() > 0) {
			getPriest().setThirdLevelSpells(getPriest().getThirdLevelSpells() - 1);

			if (getPriest().getThirdLevelSpells() == 0) {
				List<Spell> spellsToRemove = getSpellList()
						.stream()
						.filter(s -> s.getLevel() == 3)
						.collect(Collectors.toList());
				getSpellList().removeAll(spellsToRemove);

				spellDropdown.getItems().clear();
				spellDropdown.getItems().addAll(getSpellList());
			}
		}
	}
	
	private void updateSecondLevelSpells() {
		if (getPriest().getSecondLevelSpells() > 0) {
			getPriest().setSecondLevelSpells(getPriest().getSecondLevelSpells() - 1);

			if (getPriest().getSecondLevelSpells() == 0) {
				List<Spell> spellsToRemove = getSpellList()
						.stream()
						.filter(s -> s.getLevel() == 2)
						.collect(Collectors.toList());
				getSpellList().removeAll(spellsToRemove);

				spellDropdown.getItems().clear();
				spellDropdown.getItems().addAll(getSpellList());
			}
		}
	}

	
	private void updateFirstLevelSpells() {
		if (getPriest().getFirstLevelSpells() > 0) {
			getPriest().setFirstLevelSpells(getPriest().getFirstLevelSpells() - 1);

			if (getPriest().getFirstLevelSpells() == 0) {
				List<Spell> spellsToRemove = getSpellList()
						.stream()
						.filter(s -> s.getLevel() == 3)
						.collect(Collectors.toList());
				getSpellList().removeAll(spellsToRemove);

				spellDropdown.getItems().clear();
				spellDropdown.getItems().addAll(getSpellList());
			}
		}
	}

	private GargoylePriest getPriest() {
		return (GargoylePriest) super.getEnemy();
	}

	private List<Spell> getSpellList() {
		return getPriest().getSpellList();
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getTurn() {
		return turn;
	}
	
	// --------------------- --------------------
	// | spell dropdown ^| | use spell button |
	// --------------------- --------------------
	//
	// Bij het klikken op de knop worden de volgende acties getriggerd:
	// 1. De spell wordt weergegeven in een spellpane
	// 2. het aantal spells dat beschikbaar is voor de level van de spell wordt
	// verminderd, als deze 0 bereikt worden alle spells van die level
	// uit de lijst van de Combobox gehaald
	// 3. In de additional text pane wordt weergegeven welke spell al gebruikt is en
	// hoe lang deze actief is (turn aangezwengeld en tot turn beschikbaar)
	// 4. Nice to have: toon de damage bij damaging spells en toon healing bij
	// healing spells en toon de to hit bij spells die een attackroll nodig hebben
	// 5. Spells available weergeven
}
