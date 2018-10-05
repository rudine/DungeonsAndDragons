package gui.components;

import basic.ruleobjects.AbilityTypes;
import basic.services.StandardRulesService;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StatPane extends VBox {
	
	private Font boldFont = Font.font("Scala Sans LF", FontWeight.BOLD, 14);
	private Font normalFont = Font.font("Scala Sans", 14);
	
	public StatPane(AbilityTypes type, int score) {
		this.setPadding(new Insets(5, 10, 5, 10));
		Text typeText = new Text(type.name());
		typeText.setFont(boldFont);
		typeText.setFill(Color.MAROON);
		this.getChildren().add(typeText);
		Text scoreText = new Text("" + score + " (" + StandardRulesService.getAbilityModifier(score) + ")");
		scoreText.setFont(normalFont);
		this.getChildren().add(scoreText);
	}
}
