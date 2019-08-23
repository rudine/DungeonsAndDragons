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

	public static Insets getDefaultPadding() {
		return new Insets(10, 10, 10, 10);
	}
	
	public static Font getTitleFont() {
		return Font.font("Verdana", FontWeight.BOLD, 12);
	}
	
	public static Font getTitleFontNew() {
		return Font.font("Scala Sans LF", FontWeight.BOLD, FontPosture.ITALIC, 20);
	}
	
	private static Font getMrsEavesSmallCaps() {
		return Font.loadFont("file:resources/fonts/MrsEavesSmallCaps SmallCaps Regular.otf", 24);
	}
	
	public static Text setEnemyNameTextLayout(Text textToFormat) {
		textToFormat.setFont(getMrsEavesSmallCaps());
		textToFormat.setFill(Color.MAROON);
		return textToFormat;
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
