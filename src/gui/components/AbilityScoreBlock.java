package gui.components;

import basic.ruleobjects.AbilityTypes;
import basic.services.StandardRulesService;
import gui.LayoutService;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class AbilityScoreBlock extends VBox {
	
	private Font boldFont = Font.font("Scala Sans LF", FontWeight.BOLD, 14);
	private Font normalFont = Font.font("Scala Sans", 14);
	
	public AbilityScoreBlock(AbilityTypes type, int score) {
		this.setPadding(new Insets(5, 10, 5, 10));
		Text typeText = new Text(type.name());
		typeText.setFont(boldFont);
		typeText.setFill(LayoutService.getMaroon());
		this.getChildren().add(typeText);
		Text scoreText = new Text("" + score + " (" + getAbilityModifierString(StandardRulesService.getAbilityModifier(score)) + ")");
		scoreText.setFont(normalFont);
		this.getChildren().add(scoreText);
	}
	
	private String getAbilityModifierString(int modifier) {
		if(modifier > 0)
			return "+" + modifier;
		else if(modifier == 0)
			return "" + modifier;
		return "-" + modifier;
	}
}
