package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxView {
	public void display() {
		Stage window = new Stage();

		window.setTitle("ComboBox Demo");
		Button button = new Button("Submit");

		ComboBox<String> comboBox = new ComboBox<>();
		comboBox.getItems().addAll("Good Will Hunting", "St. Vincent", "Blackhat");

		comboBox.setPromptText("What is your favorite movie?");

		// The line you were typing: allows the user to write their own input
		comboBox.setEditable(true);

		button.setOnAction(e -> printMovie(comboBox));

		// Optional: Print immediately when an item is selected from the list
		comboBox.setOnAction(e -> System.out.println("User selected: " + comboBox.getValue()));

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(comboBox, button);

		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}

	private void printMovie(ComboBox<String> comboBox) {
		System.out.println(comboBox.getValue());
	}
}
