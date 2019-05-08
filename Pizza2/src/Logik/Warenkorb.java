package Logik;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Warenkorb{
	

	private ObservableList<Pizza> warenkorb;
	
	public Warenkorb() {
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
	
	public ObservableList<Pizza> getWarenkorb() {
		return warenkorb;
	}

	
	
	
}
