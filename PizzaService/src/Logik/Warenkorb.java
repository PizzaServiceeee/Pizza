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

public class Warenkorb extends Observable implements Serializable,Persistenz  {

	private static final long serialVersionUID = 1L;
	private ObservableList<Pizza> warenkorb;
	private Persistenz per;
	
	
	public Warenkorb() {
		
		warenkorb = FXCollections.<Pizza>observableArrayList();

	}

	public void add(Pizza pizza) {
		warenkorb.add(pizza);
		setChanged();
		notifyObservers(pizza);
	}
	

	public void delete() {
		for (int i = 0; i < warenkorb.size(); i++) {
			if (warenkorb.get(i).getName() == "Salami") {
				warenkorb.remove(i);
			} else if (warenkorb.get(i).getName() == "Tonno") {
				warenkorb.remove(i);
			}
		}
		;
	}

	public double preis(ObservableList<Pizza> observableList) {
		double i = 0;
		for (Pizza einePizza : observableList) {
			i = i + einePizza.getPrice();
		}
		return i;
	}

	public void speichern() {
		
		try {
			FileOutputStream fos = new FileOutputStream("safe.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new ArrayList<Pizza>(getWarenkorb()));
			System.out.println("Speichern abgeschlossen");
		} catch (IOException e) {
			System.out.println("Speichern fehgeschlagen");
			e.printStackTrace();
		}
		
	}
	
	


	public void laden() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("safe.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Pizza> tmp = (ArrayList<Pizza>) ois.readObject();
		warenkorb= FXCollections.<Pizza>observableArrayList(tmp);
		System.out.println("LAden abgeschlossen");
		

	}

	public ObservableList<Pizza> getWarenkorb() {
		return warenkorb;
	}



	


}
