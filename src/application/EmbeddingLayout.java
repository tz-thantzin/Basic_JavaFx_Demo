package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmbeddingLayout {
	public void display() {
		Stage window = new Stage();

		window.setTitle("thenewboston");

		HBox topMenu = new HBox();
		Button buttonA = new Button("File");
		Button buttonB = new Button("Edit");
		Button buttonC = new Button("View");
		topMenu.getChildren().addAll(buttonA, buttonB, buttonC);

		VBox leftMenu = new VBox();
		Button buttonD = new Button("D");
		Button buttonE = new Button("E");
		Button buttonF = new Button("F");
		leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);
		borderPane.setPadding(new Insets(20));

		Scene scene = new Scene(borderPane, 300, 250);
		window.setScene(scene);
		window.show();
	}
}
