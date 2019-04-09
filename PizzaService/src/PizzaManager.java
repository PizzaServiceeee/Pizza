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
	private ObservableList<Pizza> warenkorb;
	
	public PizzaManager() {
		warenkorb = FXCollections.<Pizza>observableArrayList();
		
	}
	
	public void add(Pizza pizza) {
		warenkorb.add(pizza);
	}
	
	public void delete() {
		for(int i = 0; i < warenkorb.size(); i++) {
			if( warenkorb.get(i).getName() == "Salami") {
			warenkorb.remove(i);
			}else if(warenkorb.get(i).getName() == "Tonno") {
				warenkorb.remove(i);
			}
		};
	}
	
	public ObservableList getWarenkorb() {
		return warenkorb;
	}
	
	
	
}
