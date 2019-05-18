package Logik;

public class Salami extends Pizza {

	private static final long serialVersionUID = 1L;
	String name;
	public Salami(String name, double price, String size, String crust) {
		super(name,price,size,crust);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
 
}
