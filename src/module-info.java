module dungeonsAndDragons {
	requires javafx.base;
	requires javafx.controls;
	requires transitive javafx.graphics;

	exports gui.components to javafx.graphics;
	exports gui.components.enemyspecific to javafx.graphics;
	exports gui.ddex.earthspur to javafx.graphics;
	exports gui.ddex.cityofdanger.envy to javafx.graphics;
	exports gui.ddex.cityofdanger.love to javafx.graphics;
	exports gui.ddex.cityofdanger.hatred to javafx.graphics;
	exports gui.ddex.cityofdanger.greed to javafx.graphics;
	
	exports basic.ruleobjects to gui.components;
	exports basic.ruleobjects.modifiers to basic.monsters;
	exports basic.ruleobjects.magic to gui.components;
	exports basic.monsters to gui.components.enemyspecific;
	exports basic.monsters.earthspur to gui.components.enemyspecific;
	exports basic.monsters.specialabilities to basic.monsters;
	exports basic.attack.types to basic.monsters;
	exports basic.attack to basic.monsters;
	exports basic.action to basic.monsters;
}