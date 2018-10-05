module dungeonsAndDragons {
	requires javafx.base;
	requires javafx.controls;
	requires transitive javafx.graphics;

	exports gui to javafx.graphics;
	exports basic.ruleobjects to gui.components;
	exports basic.ruleobjects.modifiers to basic.monsters;
	exports basic.monsters to gui.components.enemyspecific;
	exports basic.monsters.specialabilities to basic.monsters;
	exports basic.attacktypes to basic.monsters;
}