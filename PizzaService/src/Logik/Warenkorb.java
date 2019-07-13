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

public class Warenkorb extends Observable implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Pizza> warenkorb;

	public Warenkorb() {
		warenkorb = new ArrayList<Pizza>();
	}

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

	public void delete() {
		for (int i = 0; i < warenkorb.size(); i++) {
			if (warenkorb.get(i).getName() == "Salami") {
				warenkorb.remove(i);
			} else if (warenkorb.get(i).getName() == "Tonno") {
				warenkorb.remove(i);
			}
		};
	}

	public double preis(List<Pizza> list) {
		double i = 0;
		for (Pizza einePizza : list) {
			i = i + einePizza.getPrice();
		}
		return i;
	}

}
