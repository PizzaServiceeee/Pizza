package Logik;

/**Kindsklasse von Pizza
 * 
 * @author Marcel Rademacher und Lukas Niemeyer
 *
 */

public class Tonno extends Pizza {
	private static final long serialVersionUID = 1L;
	private String name;


	public Tonno(String name, double price, String size, String crust) {
		super(name, price, size, crust);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
