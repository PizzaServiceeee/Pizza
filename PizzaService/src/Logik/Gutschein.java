package Logik;

import java.util.Calendar;
import java.util.Date;

import sun.util.resources.cldr.aa.CalendarData_aa_ER;

public class Gutschein {
	
	private Pizza einePizza;

	private boolean use;
	public Gutschein() {
	
	}
	
	public boolean isGutschein() {
		return use;
	}
	
	public void setGutschein(boolean use) {
		this.use = use;
	}
	
	public double getNewPrice() {
		double price = einePizza.getPrice();
		double newPrice = (price / 100)*110;
		return newPrice;
	}
	
	public Pizza getEinePizza() {
		return einePizza;
	}
	
	public void setEinePizza (Pizza einePizza) {
		this.einePizza = einePizza;
	}
	
	
	
	

	
	
	
}


