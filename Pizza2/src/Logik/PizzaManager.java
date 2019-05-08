package Logik;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class PizzaManager {
	
	//*** Assoziation zu "Pizza"-Klasse (0...*). PizzaManager kennt 0 bis unendliche viele Pizzen.
	//*** deswegen die Liste mit Pizzen die im Warenkorb verwaltet werden, wenn
	//*** sie durch den Nutzer hinzugefügt wurden.
	
	//*** Ich sehe gerade in der Pizza Klasse b muss ich noch "int ID" hinzufügen zur besseren
	//*** Verwaltung in der delete() - Methode. Sonst löscht der mehrere Pizzen mit gleichem Namen.
	//*** Aber zu spät jetzt, gehe pennen  ;)
	private ArrayList<Pizza> pizzaList;
	
	public PizzaManager() {
	
		pizzaList = new ArrayList<Pizza>();
		
	}
	
	public void add(Pizza pizza) {
		pizzaList.add(pizza);
	}
	
	public void delete() {
		for(int i = 0; i < pizzaList.size(); i++) {
			if( pizzaList.get(i).getName() == "Salami") {
				pizzaList.remove(i);
			}else if(pizzaList.get(i).getName() == "Tonno") {
				pizzaList.remove(i);
			}
		};
	}
	
	public ArrayList<Pizza> getPizzaList() {
		return pizzaList;
	}
	

	
	
	
}
