package application;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewLayout {
	public void display() {
		Stage window = new Stage();

		window.setTitle("List View Layout");
		Button button = new Button("Submit");

		ListView<String> listView = new ListView<>();
		listView.getItems().addAll("Iron Man", "Titanic", "Contact", "Surrogates");

		// This allows the user to select multiple items at once
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		// Set the button action
		button.setOnAction(e -> buttonClicked(listView));

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(listView, button);

		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}

	private void buttonClicked(ListView<String> listView) {
		String message = "";
		ObservableList<String> movies;

		// Get all selected items
		movies = listView.getSelectionModel().getSelectedItems();

		// Loop through and print each one
		for (String m : movies) {
			message += m + "\n";
		}

		System.out.println(message);
	}
}
