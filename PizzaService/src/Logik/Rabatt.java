package Logik;

import java.util.Calendar;
import java.util.Date;

public class Rabatt {
	private Pizza einePizza;
	private double rabatt = 10.0; 
	private String nummer;
	
	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	
	public Rabatt() {
		
	}
	
	public double getRabatt() {
		
		return rabatt;
		
	}
	
	public void setRabatt(double rabatt) {
		this.rabatt = rabatt;
	}
	
	public Pizza GetEinePizza() {
		return einePizza;
	}
	
	public void setEinePizza (Pizza einePizza) {
		this.einePizza = einePizza;
	}
	
	
	
	
}
