package gui.ddex.earthspur.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MineCartsPane extends VBox {
	
	public MineCartsPane(int numberOfCarts) {
		setPadding(new Insets(10, 10, 10, 10));
		addCartButton();
		for (int i = 0 ; i < numberOfCarts; i++) {
			getChildren().add(getMineCartPane());
		}
	}
	
	public void removeFromCarts(MineCartPane pane) {
		getChildren().removeAll(pane);
	}
	
	private void addCartButton() {
		Button addCart = new Button("Add minecart");
		addCart.setOnAction(e -> getChildren().add(getMineCartPane()));
		getChildren().add(addCart);
	}
	
	private MineCartPane getMineCartPane() {
		return new MineCartPane(this, new MineCart(true, 50));
	}
	
	public void onNextTurn() {
		getChildren().stream().filter(o -> o instanceof MineCartPane).forEach(o -> ((MineCartPane)o).addOrRefreshRandomText());
	}
}
