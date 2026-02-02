package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DropdownListView {
	public void display() {
		Stage window = new Stage();

		window.setTitle("ChoiceBox Demo");
		Button button = new Button("Click me");

		ChoiceBox<String> choiceBox = new ChoiceBox<>();

		// getItems returns the ObservableList object which you can add items to
		choiceBox.getItems().add("Apples");
		choiceBox.getItems().add("Bananas");
		choiceBox.getItems().addAll("Bacon", "Ham", "Meatballs");

		// Set a default value
		choiceBox.setValue("Apples");

		// Listen for selection changes (Optional: instant action without button)
		choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {

			System.out.println("old value ::" + oldValue);
			System.out.println("new value ::" + newValue);
		});

		// Button Action
		button.setOnAction(e -> getChoice(choiceBox));

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(choiceBox, button);

		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}

	private void getChoice(ChoiceBox<String> choiceBox) {
		String food = choiceBox.getValue();
		System.out.println(food);
	}
}
