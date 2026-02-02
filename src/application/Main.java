package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import menu.CheckMenuItemView;
import menu.MenuBarView;
import tableview.TableViewLayout;

public class Main extends Application {

	private Stage window;

	@Override
	public void start(Stage primaryStage) {
	    window = primaryStage;

	    TreeView<String> navigationTree = createNavigationTree();
	    navigationTree.getSelectionModel().selectedItemProperty()
	            .addListener((obs, oldVal, newVal) -> handleSelection(newVal));

	    // Pass the tree directly as the root of the scene
	    Scene scene = new Scene(navigationTree, 300, 500); 

	    try {
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    } catch (Exception e) {
	        System.out.println("CSS not found.");
	    }

	    window.setTitle("JavaFX Component Explorer");
	    window.setScene(scene);
	    window.show();
	}

	private TreeView<String> createNavigationTree() {

		TreeItem<String> root = new TreeItem<>("Components");
		root.setExpanded(true);

		// ===== Scene Control =====
		TreeItem<String> sceneControl = new TreeItem<>("Scene Control");
		sceneControl.getChildren().addAll(new TreeItem<>("Alert"), new TreeItem<>("Confirmation"),
				new TreeItem<>("Close Window"));

		// ===== Scene Layout =====
		TreeItem<String> sceneLayout = new TreeItem<>("Scene Layout");
		sceneLayout.getChildren().addAll(new TreeItem<>("Embedded Layout"), new TreeItem<>("GridPane"),
				new TreeItem<>("Data Validation"));

		// ===== Controls =====
		TreeItem<String> controls = new TreeItem<>("Controls");
		controls.getChildren().addAll(new TreeItem<>("Checkbox"), new TreeItem<>("ChoiceBox"),
				new TreeItem<>("ComboBox"), new TreeItem<>("ListView"), new TreeItem<>("TreeView"));

		// ===== Data View =====
		TreeItem<String> dataView = new TreeItem<>("Data View");
		dataView.getChildren().add(new TreeItem<>("TableView"));

		// ===== Menu =====
		TreeItem<String> menu = new TreeItem<>("Menu");
		menu.getChildren().addAll(new TreeItem<>("MenuBar"), new TreeItem<>("CheckMenuItem"));

		root.getChildren().addAll(sceneControl, sceneLayout, controls, dataView, menu);

		return new TreeView<>(root);
	}

	private void handleSelection(TreeItem<String> item) {
		if (item == null || item.getChildren().size() > 0)
			return;

		switch (item.getValue()) {
		case "Alert" -> AlertBox.display("Title", "Text");
		case "Confirmation" -> {
			boolean result = new ConfirmationBox().display("Title", "Text");
			System.out.println(result);
		}
		case "Close Window" -> window.close();

		case "Embedded Layout" -> new EmbeddingLayout().display();
		case "GridPane" -> new GridPlane().display();
		case "Data Validation" -> new DataValidation().display();

		case "Checkbox" -> new CheckboxView().display();
		case "ChoiceBox" -> new DropdownListView().display();
		case "ComboBox" -> new ComboBoxView().display();
		case "ListView" -> new ListViewLayout().display();
		case "TreeView" -> new TreeViewLayout().display();

		case "TableView" -> new TableViewLayout().display();

		case "MenuBar" -> new MenuBarView().display();
		case "CheckMenuItem" -> new CheckMenuItemView().display();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
