module dungeonsAndDragons {
	requires javafx.base;
	requires javafx.controls;
	requires transitive javafx.graphics;

	exports gui.components to javafx.graphics;
	exports gui.components.enemyspecific to javafx.graphics;
	exports gui.ddex.earthspur to javafx.graphics;
	exports gui.ddex.cityofdanger.envy to javafx.graphics;
	exports gui.ddex.cityofdanger.love to javafx.graphics;
	
	exports basic.ruleobjects to gui.components;
	exports basic.ruleobjects.modifiers to basic.monsters;
	exports basic.monsters to gui.components.enemyspecific;
	exports basic.monsters.specialabilities to basic.monsters;
	exports basic.attacktypes to basic.monsters;
}