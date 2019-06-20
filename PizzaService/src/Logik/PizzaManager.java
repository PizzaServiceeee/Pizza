package Logik;
//package Logik;
//
//import java.io.BufferedWriter;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Observable;
//import java.util.Observer;
//
//public class PizzaManager extends Observable implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//	private ArrayList<Pizza> pizzaList;
//
//	public PizzaManager() {
//
//		pizzaList = new ArrayList<Pizza>();
//
//	}
//
//	public void add(Pizza pizza) {
//		if(pizza != null) {
//		pizzaList.add(pizza);
//		setChanged();
//		notifyObservers(pizza);
//		}
//	}
//	 
//	
//
//
//	public void delete() {
//		for (int i = 0; i < pizzaList.size(); i++) {
//			if (pizzaList.get(i).getName() == "Salami") {
//				pizzaList.remove(i);
//			} else if (pizzaList.get(i).getName() == "Tonno") {
//				pizzaList.remove(i);
//			}
//		}
//		;
//	}
//
//	public ArrayList<Pizza> getPizzaList() {
//		return pizzaList;
//	}
//
//	public void speichern() throws IOException {
//		FileOutputStream fos = new FileOutputStream("safe.ser");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(this);
//	oos.close(); 
//	fos.close();
//	}
//
//	public static PizzaManager laden() throws FileNotFoundException, IOException, ClassNotFoundException {
//	FileInputStream fis = new FileInputStream("safe.ser");
//	ObjectInputStream ois = new ObjectInputStream(fis);
//	return (PizzaManager) ois.readObject();
//	}
//
//
//
//}
