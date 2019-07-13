package Logik;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Warenkorb dient zu Verwaltung von Pizza Objekten in einer Liste
 * 
 * @author Marcel Rademacher und Lukas Niemeyer
 *
 */

public class Warenkorb extends Observable implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Pizza> warenkorb;

	public Warenkorb() {
		warenkorb = new ArrayList<Pizza>();
	}
	/**
	 * Fügt der Liste ein Pizza Object hinzu
	 * @param pizza
	 */
	public void add(Pizza pizza) {
		warenkorb.add(pizza);
		setChanged();
		notifyObservers(pizza);
	}
	
	public List<Pizza> getWarenkorb() {
		return warenkorb;
	}

	public void setWarenkorb(List<Pizza> liste) {
		this.warenkorb = liste;
	}

	/**
	 * Berechnert den Gesamtpreus der Pizza Objecte in der Liste
	 * @param list
	 * @return double
	 */
	public double preis(List<Pizza> list) {
		double i = 0;
		for (Pizza einePizza : list) {
			i = i + einePizza.getPrice();
		}
		return i;
	}

}
