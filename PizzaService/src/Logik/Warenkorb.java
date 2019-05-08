package Logik;

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
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Warenkorb implements Serializable {

	private static final long serialVersionUID = 1L;
	private ObservableList<Pizza> warenkorb;

	public Warenkorb() {

		warenkorb = FXCollections.<Pizza>observableArrayList();

	}

	public void add(Pizza pizza) {
		warenkorb.add(pizza);

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
 
	public void speichern() throws IOException {
		FileOutputStream fos = new FileOutputStream("safe.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new ArrayList<Pizza>(warenkorb));
		oos.close();
		fos.close();
	}

	public ObservableList<Pizza> laden() {
		try {
			
			FileInputStream fis = new FileInputStream("safe.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Pizza> list = (ArrayList<Pizza>) ois.readObject();
			ObservableList<Pizza> list2 = FXCollections.<Pizza>observableList(list);
			warenkorb = list2;
			return FXCollections.<Pizza>observableList(list2);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return FXCollections.emptyObservableList();
		
	}

	public ObservableList<Pizza> getWarenkorb() {
		return warenkorb;
	}

}
