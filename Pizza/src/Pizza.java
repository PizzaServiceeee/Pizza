
public class Pizza {
	private int id;
	private static int number = -1;
	private String name;
	private double price;
	
	public Pizza(String name, double price) {
		number++;
		id = number;
		this.name = name;
		this.price = price;
	}
	public String toString() {
		return name + " " + price + " €";
	}
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
	
	public int getId() {
		return id;
	}
	
	
}
