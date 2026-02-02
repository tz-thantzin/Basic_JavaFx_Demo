package menu;

import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuBarView {
	public void display() {
		Stage window = new Stage();
		window.setTitle("JavaFX Menu Bar");

		// --- 1. File Menu ---
		Menu fileMenu = new Menu("_File"); // Use underscore for Alt + F shortcut

		// Menu Items
		MenuItem newFile = new MenuItem("New...");
		newFile.setOnAction(_ -> System.out.println("Create a new file...")); // Handling clicks

		fileMenu.getItems().add(newFile);
		fileMenu.getItems().add(new MenuItem("Open..."));
		fileMenu.getItems().add(new MenuItem("Save..."));
		fileMenu.getItems().add(new SeparatorMenuItem()); // Add a horizontal line
		fileMenu.getItems().add(new MenuItem("Settings..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Exit..."));

		// --- 2. Edit Menu ---
		Menu editMenu = new Menu("_Edit"); // Alt + E shortcut
		editMenu.getItems().add(new MenuItem("Cut"));
		editMenu.getItems().add(new MenuItem("Copy"));

		// Disabling a Menu Item
		MenuItem paste = new MenuItem("Paste");
		paste.setOnAction(_ -> System.out.println("Pasting some crap..."));
		paste.setDisable(true); // Grays out the option
		editMenu.getItems().add(paste);

		// --- 3. Help Menu (Example of toggling) ---
		Menu helpMenu = new Menu("Help");
		CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
		showLines.setOnAction(_ -> {
			if (showLines.isSelected())
				System.out.println("Program will now display line numbers");
			else
				System.out.println("Hiding line numbers");
		});
		helpMenu.getItems().add(showLines);

		// Main Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

		BorderPane layout = new BorderPane();
		layout.setTop(menuBar);

		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}
}
