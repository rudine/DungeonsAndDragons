package gui.components;

import static gui.LayoutService.getDefaultPadding;
import static gui.LayoutService.getTitleFont;

import java.util.ArrayList;
import java.util.List;

import basic.action.Action;
import basic.attack.Attack;
import basic.attack.types.SpecialAttack;
import basic.monsters.AbstractEnemy;
import basic.monsters.interfaces.DamageTypeCausesDisadvantage;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.DamageType;
import basic.services.DamageService;
import gui.LayoutService;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class NewEnemyPane<T extends AbstractEnemy> extends GridPane {

	protected T enemy;
	private ComboBox<DamageType> damageTypesBox;
	private TextField inputField;
	private Statblock<T> statblock;
	protected VBox attackPane;
	private VBox specialAttackPane;
	private CheckBox disadvantageBox;
	private CheckBox advantageBox;
	private VBox checkboxes;
	private VBox additionalTextPane;

	public NewEnemyPane(T enemy) {
		this.enemy = enemy;
		add(new TitleBlock<T>(enemy), 0, 0);
		addDamagePane(); // 0, 1
		addStatBlock(); // 0, 2
		refreshAttackPanes(true); // attackPane 0, 4 & specialAttackpane 0, 5
		addOtherActionsPane(); // 0, 5
		addAdvantageCheckBoxes(); // 0, 6
		addSpecialAbilitiesPane(); // 0, 7
	}

	public NewEnemyPane(T enemy, String additionalText) {
		this(enemy);
		addAdditonalTextPane(additionalText); // 0, 8
	}

	private void addDamagePane() {
		HBox damagePane = new HBox(10);
		damagePane.setPadding(getDefaultPadding());

		Button addDamage = new Button("Add damage");
		addDamage.setOnAction(e -> onDamageAdded());

		damageTypesBox = new ComboBox<>();
		damageTypesBox.getItems().addAll(DamageType.values());

		inputField = new TextField();
		damagePane.getChildren().addAll(inputField, damageTypesBox, addDamage);

		add(damagePane, 0, 1);
	}

	private void onDamageAdded() {
		String inputText = inputField.getText();
		int damage = inputText.isEmpty() ? 0 : Integer.parseInt(inputText);
		enemy.doDamage(damage, damageTypesBox.getValue());
		statblock.updateHitpointsText();

		if (enemy instanceof DamageTypeCausesDisadvantage
				&& ((DamageTypeCausesDisadvantage) enemy).getRoundsAffected() > 0) {
			disadvantageBox.setSelected(enemy.isDisadvantageOnAttacks());
		}

		inputField.clear();
		damageTypesBox.setValue(null);
	}

	private void addStatBlock() {
		statblock = new Statblock<T>(enemy);
		add(statblock, 0, 2);
	}

	public void refreshAttackPanes(boolean start) {
		if (this.getChildren().contains(attackPane)) {
			this.getChildren().remove(attackPane);
		}
		if (this.getChildren().contains(specialAttackPane) && !enemy.getSpecialAttacks().isEmpty()) {
			this.getChildren().remove(specialAttackPane);
		}
		updateAttackPane(start);
		updateSpecialAttackPane(start);
	}

	private void updateAttackPane(boolean start) {
		attackPane = new VBox(10);
		attackPane.setPadding(getDefaultPadding());
		attackPane.setMinHeight(enemy.getAvailableAttacks().size() * enemy.getAttacksOnAttackAction() * 30);
		attackPane.setMinWidth(600);

		List<Text> texts = new ArrayList<>();
		Text title = new Text("Attacks: (" + enemy.getAttacksOnAttackAction() + ")");
		title.setFont(getTitleFont());
		texts.add(title);
		if (!start && enemy.isAlive()) {
			getAttackText(texts);
		}
		attackPane.getChildren().addAll(texts);
		add(attackPane, 0, 3);
	}

	protected void getAttackText(List<Text> texts) {
		if (heeftScheveVerdelingAttacksByMultiAttack()) {
			for (Attack a : enemy.getAvailableAttacks()) {
				for (int i = 0; i < a.getNumberOfUsesOnMultiAttack(); i++) {
					addAttackText(texts, a);
				}
			}
		} else {
			for (int i = 0; i < enemy.getAttacksOnAttackAction(); i++) {
				for (Attack a : enemy.getAvailableAttacks()) {
					addAttackText(texts, a);
				}
			}
		}
		texts.forEach(t -> t.setWrappingWidth(580));
	}

	protected boolean heeftScheveVerdelingAttacksByMultiAttack() {
		// of het getal is 0 --> niet ingesteld, toon available attacks zo vaak als er
		// attacks on attack action zijn
		// of het getal is gelijk aan attacks on attack action --> toon alle attacks zo
		// vaak als ze uses hebben
		// of het getal is kleiner dan attacks on attack action --> er is iets fout,
		// IllegalArgumentException
		// of het getal is groter dan attacks on attack action --> zoals bij 0
		int totalAttacksFromUses = enemy.getAvailableAttacks()//
				.stream()//
				.mapToInt(a -> a.getNumberOfUsesOnMultiAttack())//
				.sum();
		int attacksOnAttackAction = enemy.getAttacksOnAttackAction();
		// TODO dit klopt niet helemaal zoals bij de medusa het geval is. Die heeft 3
		// soorten aanvallen. Ze kan 3 melee of 2 ranged in een beurt

		if (totalAttacksFromUses == 0 || (totalAttacksFromUses > attacksOnAttackAction))
			return false;

		if (totalAttacksFromUses == attacksOnAttackAction)
			return true;

		if (totalAttacksFromUses < attacksOnAttackAction)
			throw new IllegalArgumentException("De som van de uses van attacks on attack"
					+ " action is kleiner dan attacks on attack action, er is ergens iets niet goed ingevuld");
		return false;
	}

	protected void addAttackText(List<Text> texts, Attack a) {
		AttackText text = DamageService.getAttackText(a, enemy.isAdvantageOnAttacks(), enemy.isDisadvantageOnAttacks());
		Text attackText = new Text(text.getText());
		if (text.isCritical()) {
			attackText.setFill(LayoutService.getCritical());
		}
		texts.add(attackText);
	}

	private void updateSpecialAttackPane(boolean start) {
		specialAttackPane = new VBox(10);
		specialAttackPane.setPadding(getDefaultPadding());
		specialAttackPane.setMinHeight(150);
		specialAttackPane.setMinWidth(500);

		if (!enemy.getSpecialAttacks().isEmpty()) {
			Text title = new Text("Special Attacks: ");
			title.setFont(getTitleFont());
			specialAttackPane.getChildren().add(title);
			if (!start && enemy.isAlive()) {
				List<Pane> sAIP = new ArrayList<>();
				for (SpecialAttack attack : enemy.getSpecialAttacks()) {
					VBox sAP = new VBox(10);
					sAP.setPadding(getDefaultPadding());

					List<Text> texts = new ArrayList<>();
					if (attack.isAvailable()) {
						texts.add(new Text(DamageService.getSpecialAttackText(attack)));
						texts.add(new Text("Description: "));
						texts.add(new Text(attack.getDescription()));
						texts.forEach(t -> t.setWrappingWidth(550));
					} else {
						texts.add(new Text(attack.getWeaponName() + " is not available"));
					}
					sAP.getChildren().addAll(texts);

					if (attack.isAvailable() && attack.hasRecharge()) {
						Button useButton = new Button("Use " + attack.getWeaponName());
						useButton.setOnAction(e -> attack.useAttack());
						sAP.getChildren().add(useButton);
					}
					sAIP.add(sAP);
				}
				specialAttackPane.getChildren().addAll(sAIP);
			}
			add(specialAttackPane, 0, 4);
		}
	}

	private void addOtherActionsPane() {
		if (!enemy.getActions().isEmpty()) {
			VBox actionsPane = new VBox(10);
			actionsPane.setPadding(getDefaultPadding());

			List<Text> texts = new ArrayList<>();
			for (Action a : enemy.getActions()) {
				Text title = new Text("Other Actions: ");
				title.setFont(getTitleFont());
				texts.add(title);
				texts.add(new Text(a.toString()));
			}
			texts.forEach(t -> t.setWrappingWidth(580));
			actionsPane.getChildren().addAll(texts);
			add(actionsPane, 0, 5);
		}
	}

	private void addAdvantageCheckBoxes() {
		checkboxes = new VBox(10);
		checkboxes.setPadding(getDefaultPadding());

		advantageBox = new CheckBox("Has advantage on attacks");
		advantageBox.setOnAction(e -> enemy.setAdvantageOnAttacks(!enemy.isAdvantageOnAttacks()));

		disadvantageBox = new CheckBox("Has disadvantage on attacks");
		disadvantageBox.setOnAction(e -> enemy.setDisadvantageOnAttacks(!enemy.isDisadvantageOnAttacks()));

		Button rerollAttacks = new Button("Reroll attacks");
		rerollAttacks.setOnAction(e -> refreshAttackPanes(false));

		checkboxes.getChildren().addAll(advantageBox, disadvantageBox, rerollAttacks);
		add(checkboxes, 0, 6);
	}

	private void addSpecialAbilitiesPane() {
		if (!enemy.getSpecialAbilities().isEmpty()) {
			VBox specAbPane = new VBox(10);
			specAbPane.setPadding(getDefaultPadding());

			List<Text> texts = new ArrayList<>();
			for (SpecialAbility s : enemy.getSpecialAbilities()) {
				Text title = new Text(s.getName());
				title.setFont(getTitleFont());
				texts.add(title);
				texts.add(new Text(s.getDescription()));
			}
			texts.forEach(t -> t.setWrappingWidth(580));
			specAbPane.getChildren().addAll(texts);
			add(specAbPane, 0, 7);
		}
	}
	
	public void refreshCheckBoxes() {
		disadvantageBox.setSelected(enemy.isDisadvantageOnAttacks());
		advantageBox.setSelected(enemy.isAdvantageOnAttacks());
	}
	
	private void addAdditonalTextPane(String additionalText) {

		if (additionalText != null) {
			additionalTextPane = new VBox(10);
			additionalTextPane.setPadding(getDefaultPadding());
			if (!additionalText.isEmpty()) {
				additionalTextPane.getChildren().add(new Text(additionalText));
			}
			add(additionalTextPane, 0, 8);
		}
	}

	public VBox getAdditionalTextPane() {
		return additionalTextPane;
	}

	public AbstractEnemy getEnemy() {
		return enemy;
	}
}
