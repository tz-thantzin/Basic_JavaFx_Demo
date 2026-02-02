package menu;

import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CheckMenuItemView {
	public void display() {
		Stage window = new Stage();
		window.setTitle("JavaFX - CheckMenuItem Tutorial");

		// --- File Menu ---
		Menu fileMenu = new Menu("File");
		fileMenu.getItems().add(new MenuItem("New..."));
		fileMenu.getItems().add(new MenuItem("Open..."));
		fileMenu.getItems().add(new MenuItem("Save..."));

		// --- Help Menu (The focus of this lesson) ---
		Menu helpMenu = new Menu("Help");

		// 1. Create CheckMenuItems [00:01:21]
		CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
		CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");

		// 2. Set default state [00:06:01]
		// You can make an item checked by default when the program starts
		autoSave.setSelected(true);

		// 3. Handle the logic (Check if it's selected) [00:02:41]
		showLines.setOnAction(_ -> {
			if (showLines.isSelected()) {
				System.out.println("Program will now display line numbers");
			} else {
				System.out.println("Hiding line numbers");
			}
		});

		// Add items to the Help menu
		helpMenu.getItems().addAll(showLines, autoSave);

		// Main Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		BorderPane layout = new BorderPane();
		layout.setTop(menuBar);

		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}
}
