package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationBox {
	boolean answer;

	public boolean display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		Label label = new Label();
		label.setText(message);

		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");

		yesButton.setOnAction(_ -> {
			answer = true;
			window.close();
		});
		noButton.setOnAction(_ -> {
			answer = false;
			window.close();
		});

		HBox horizontalLayout = new HBox(20);
		horizontalLayout.getChildren().addAll(yesButton, noButton);
		horizontalLayout.setAlignment(Pos.CENTER);
		horizontalLayout.setPadding(new Insets(20));

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, horizontalLayout);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();

		return answer;
	}
}
