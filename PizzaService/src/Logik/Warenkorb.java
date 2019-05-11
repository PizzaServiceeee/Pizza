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
	private ObservableList<Pizza> warenkorb;

	
	
	public Warenkorb() {

		warenkorb = FXCollections.<Pizza>observableArrayList();

	}

	public void add(Pizza pizza) {
		warenkorb.add(pizza);
		setChanged();
		notifyObservers(pizza);
	}
	
	public Gutschein getGutschein(Pizza pizza) {
		return pizza.getEinGutschein();
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

	public double preis(ObservableList<Pizza> warenkorb) {
		double i = 0;
		for (Pizza einePizza : warenkorb) {
			i = i + einePizza.getPrice();
		}
		return i;
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
			fis.close();
			ois.close();
			return warenkorb;
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return FXCollections.emptyObservableList();

	}

//	public void update(Observable o, Object arg) {
//		System.out.println(arg);
//		try (FileWriter fw = new FileWriter("log.txt", true); BufferedWriter bw = new BufferedWriter(fw)) {
//			bw.write(((Pizza) arg).getName() + ", " + ((Pizza) arg).getPrice() + ", " + ((Pizza) arg).getSize());
//			bw.newLine();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public ObservableList<Pizza> getWarenkorb() {
		return warenkorb;
	}
	


}
