package tableview;

public class Product {

	private String name;
	private double price;
	private int quantity;

	// Default Constructor
	public Product() {
		this.name = "";
		this.price = 0;
		this.quantity = 0;
	}

	// Overloaded Constructor
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	// Getters and Setters
	// NOTE: You MUST follow standard naming convention (getVariable, setVariable)
	// or the TableView will not be able to read the data.

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}