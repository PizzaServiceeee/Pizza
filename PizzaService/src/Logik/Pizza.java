package Logik;

import java.util.ArrayList;
import java.util.Arrays;

public class Pizza {
	private int id;
	private static int number = -1;
	private String name;
	private double price;
	private String size;
	private String crust;
	private String[] toppings = new String[] {"Cheese + 0,50", "Ham + 0,50", "Pepperoni + 0,50", "Oliven + 0,50"};

	public Pizza( String name, double price, String size, String crust) {
		number++;
		id = number;
		this.name = name;
		this.price = price;
		this.size = size;
		this.crust = crust;
		this.toppings = toppings;

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
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getCrust() {
		return crust;
	}
	public void setCrust(String crust) {
		this.crust = crust;
	}
	
	public String getTopping(int j) {
		for(int i = 0; i < toppings.length;i++) {
			if(i== j) {
				return toppings[i];
			}
		}return null;
	}

	
	
}
