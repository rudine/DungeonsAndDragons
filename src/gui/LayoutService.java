package gui;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LayoutService {
	
	private static final Font boldFont = Font.font("Scala Sans LF", FontWeight.BOLD, 14);
	private static final Font normalFont = Font.font("Scala Sans", 14);
	private static final Font subtitleFont = Font.font("Scala Sans LF", FontPosture.ITALIC, 12);
	private static final Font titleFont = Font.loadFont("file:resources/fonts/ScalaSans-Caps.otf", 18);
	private static final Font enemyNameFont = Font.loadFont("file:resources/fonts/MrsEavesSmallCaps SmallCaps Regular.otf", 24);

	public static Insets getDefaultPadding() {
		return new Insets(10, 10, 10, 10);
	}
	
	public static Font getTitleFont() {
		return titleFont;
	}
	
	public static Text setEnemyNameTextLayout(Text textToFormat) {
		textToFormat.setFont(enemyNameFont);
		textToFormat.setFill(getMaroon());
		return textToFormat;
	}
	
	public static Color getMaroon() {
		return Color.web("#58170D");
	}
	
	public static Color getCritical() {
		return Color.RED;
	}
	
	public static Font getNormalFont() {
		return normalFont;
	}
	
	public static Font getBoldFont() {
		return boldFont;
	}
	
	public static Font getSubtitleFont() {
		return subtitleFont;
	}
	
	public static Background getButtonBackground() {
		BackgroundImage button = new BackgroundImage(new Image("file:resources/images/button.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		return new Background(button);
	}
}
