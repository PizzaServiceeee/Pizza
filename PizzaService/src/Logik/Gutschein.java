package Logik;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import sun.util.resources.cldr.aa.CalendarData_aa_ER;

public class Gutschein implements Serializable {
	
	private Pizza einePizza;
	private boolean gutschein;
	
	public Gutschein(boolean gutschein) {
		this.gutschein = gutschein;
	}
	
	public void setGutschein(boolean isGutschein) {
		this.gutschein = isGutschein;
	}
	
	public boolean isGutschein() {
		return gutschein;
	}
	 
	public double getNewPrice(double price) {
		
		double newPrice = (price / 100)*90;
		return newPrice;
		
	}
	
	public Pizza getEinePizza() {
		return einePizza;
	}
	
	public void setEinePizza (Pizza einePizza) {
		this.einePizza = einePizza;
	}
	
	
	
	

	
	
	
}


