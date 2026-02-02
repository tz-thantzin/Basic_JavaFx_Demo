package tableview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewLayout {
	private TableView<Product> table;
	private TextField nameInput, priceInput, quantityInput;

	public void display() {
		Stage window = new Stage();
		window.setTitle("JavaFX TableView - Adding and Deleting");

		// Columns
		TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

		TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(100);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		// Inputs
		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);

		priceInput = new TextField();
		priceInput.setPromptText("Price");

		quantityInput = new TextField();
		quantityInput.setPromptText("Quantity");

		// Buttons
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> addButtonClicked());

		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteButtonClicked());

		// HBox Layout
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

		// Table setup
		table = new TableView<>();
		table.setItems(getProduct());
		table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

		// VBox Layout
		VBox vBox = new VBox();
		vBox.getChildren().addAll(table, hBox);

		Scene scene = new Scene(vBox);
		window.setScene(scene);
		window.show();
	}

	// Add button clicked
	public void addButtonClicked() {
		Product product = new Product();
		product.setName(nameInput.getText());
		product.setPrice(Double.parseDouble(priceInput.getText()));
		product.setQuantity(Integer.parseInt(quantityInput.getText()));
		table.getItems().add(product);

		// Clear the fields
		nameInput.clear();
		priceInput.clear();
		quantityInput.clear();
	}

	// Delete button clicked
	public void deleteButtonClicked() {
		ObservableList<Product> productSelected, allProducts;
		allProducts = table.getItems();
		productSelected = table.getSelectionModel().getSelectedItems();

		productSelected.forEach(allProducts::remove);
	}

	public ObservableList<Product> getProduct() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("Laptop", 859.00, 20));
		products.add(new Product("Bouncy Ball", 2.49, 198));
		products.add(new Product("Toilet", 99.00, 74));
		products.add(new Product("The Notebook DVD", 19.99, 12));
		products.add(new Product("Corn", 1.49, 846));
		return products;
	}
}