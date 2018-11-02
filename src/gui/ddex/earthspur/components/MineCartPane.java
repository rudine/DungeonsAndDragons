package gui.ddex.earthspur.components;

import basic.services.DiceService;
import gui.ddex.earthspur.MineCartChaseEffect;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MineCartPane extends GridPane {
	private TextField notesField;
	private Text hitpointsText;
	private TextField damagePointsField;
	private final MineCartsPane parentPane;
	private Font titleFont = Font.font("Verdana", FontWeight.BOLD, 10);
	private MineCart minecart;
	private Text randomEffectTitle;
	private Text randomEffectText;

	public MineCartPane(MineCartsPane parentPane, MineCart minecart) {
		this.parentPane = parentPane;
		this.minecart = minecart;
		setPadding(new Insets(10, 10, 10, 10));
		setHgap(10);
		setVgap(10);
		addNotesField();
		addRemoveCartButton();
		addDamagePointsField();
		addDmgButton();
		addOrRefreshHitpointText();
		addOrRefreshRandomText();
	}

	private void addNotesField() {
		notesField = new TextField();
		notesField.setMaxWidth(300);
		add(notesField, 0, 0);
	}

	private void addOrRefreshHitpointText() {
		if (hitpointsText != null)
			getChildren().remove(hitpointsText);
		if (!minecart.isOnRails())
			hitpointsText = new Text("Minecart has derailed. ");
		else
			hitpointsText = new Text("Hitpoints: " + minecart.getHitPoints());
		add(hitpointsText, 1, 0);
	}

	private void addDamagePointsField() {
		damagePointsField = new TextField();
		damagePointsField.setMaxWidth(50);
		add(damagePointsField, 2, 0);
	}

	private void addDmgButton() {
		Button damageButton = new Button("Add damage");
		damageButton.setOnAction(e -> {
			minecart.setHitPoints(minecart.getHitPoints() - Integer.parseInt(damagePointsField.getText()));
			addOrRefreshHitpointText();
			damagePointsField.clear();
		});
		add(damageButton, 3, 0);
	}
	
	private void addRemoveCartButton() {
		Button removeButton = new Button("Remove cart");
		removeButton.setOnAction(e -> parentPane.removeFromCarts(this));
		add(removeButton, 4, 0);
	}
	
	public void addOrRefreshRandomText() {
		if(randomEffectText != null && randomEffectTitle != null) 
			getChildren().removeAll(randomEffectTitle, randomEffectText);
		
		MineCartChaseEffect effect = MineCartChaseEffect.getByDieResult(DiceService.throwD6(1));
		
		randomEffectTitle = new Text(effect.getTitle());
		randomEffectTitle.setFont(titleFont);
		add(randomEffectTitle, 0, 1);
		
		randomEffectText = new Text(effect.getEffect());
		randomEffectText.setWrappingWidth(300);
		add(randomEffectText, 0, 2);
	}
}
