package Logik;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

/**
 * Pizza gibt die Attribute und Methoden vor die f�r eine Pizza Instanz ben�tigt
 * werden.
 * 
 * @author Marcel Rademacher und Lukas Niemeyer
 *
 */

public class Pizza extends Observable implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private static int number = -1;
	private String name;
	private double price;
	private String size;
	private String crust;
	private static Pizza diePizza;
	private String[] toppings = new String[] { "Cheese + 0,50", "Ham + 0,50", "Pepperoni + 0,50", "Oliven + 0,50" };
	private Gutschein gutschein = new Gutschein(false);

	public Pizza(String name, double price, String size, String crust) {
		number++;
		id = number;
		this.name = name;
		this.price = price;
		this.size = size;
		this.crust = crust;
	}

	/**
	 * Erstellt eine Instanz einer Pizza
	 * 
	 * @param name
	 * @param price
	 * @param size
	 * @param crust
	 * @return diePizza
	 */
	public static Pizza getInstance(String name, double price, String size, String crust) {
		if (diePizza == null) {
			diePizza = new Pizza(name, price, size, crust);
		} else if (diePizza != null) {
			diePizza = new Pizza(name, price, size, crust);
		}
		return diePizza;
	}

	public String toString() {
		return getId() + " " + getName() + " " + getPrice() + " � " + getSize() + " " + getCrust();
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

	public Gutschein getEinGutschein() {
		return gutschein;
	}

	public void setGutschein(boolean isGutschein) {
		gutschein.setGutschein(isGutschein);
	}

	public boolean isGutschein() {
		return gutschein.isGutschein();
	}

}
