package GUI;
import Logik.Gutschein;
import Logik.Kontakt;
import Logik.Kontaktverwaltung;
import Logik.Pizza;
import Logik.Warenkorb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class KontaktGUI
{
	
	GridPane gp;
	Scene scene1;
	protected TextField textField;
	protected Label label;
	protected Button button;
	protected Warenkorb warenkorb = new Warenkorb();
	protected Pizza pizza;
	protected Gutschein gutschein = new Gutschein(false);
	
	public KontaktGUI() 
	{
		
	} 

	public void start(Stage primaryStage) {
		
		final Stage fenster = primaryStage;
		gp = new GridPane();
		scene1 = new Scene(gp,500,500);
		gp.setAlignment(Pos.CENTER);

		final ObservableList<Pizza> warenkorbListe = FXCollections.<Pizza>observableArrayList();
		warenkorbListe.addAll(warenkorb.getWarenkorb());
		final ListView<Pizza> warenkorbObservList = new ListView<Pizza>((ObservableList<Pizza>) warenkorbListe);
		warenkorbObservList.setPrefSize(50,50);
		gp.add(warenkorbObservList, 3, 7);
		
		final TextField vorname = new TextField("Vorname");
		Label vornamee = new Label("Vorname");
		final TextField nachname = new TextField("Nachname");
		Label nachnamee = new Label("Nachnamee");
		final TextField plz = new TextField("PLZ");
		Label plzz = new Label("PLZ");
		final TextField stra�e = new TextField("Stra�e");
		Label stra�ee = new Label("Stra�e");
		final TextField ort = new TextField("Ort");
		Label ortt = new Label("Ort");
		final TextField telefon = new TextField("Telefonnummer");
		Label telefonn = new Label("Telefonnummer");
		final TextField email = new TextField("Email");
		Label emaill = new Label("Email");
		Button liefern = new Button("liefern");
		Button btnZurueck = new Button("Zur�ck");
		Label warenkorbList = new Label("Warenkorb: ");
		final TextField Gesamtpreiss = new TextField();
		Gesamtpreiss.setDisable(true);
		final Button btnGutschein = new Button("Gutschein auf alles");
		Label warenkorbPreis = new Label("Gesamtpreis: ");
		double i= warenkorb.preis(warenkorb.getWarenkorb());
		String sString = (new Double(i).toString());
		Gesamtpreiss.setText(sString+"�");
		gp.add(vorname, 3, 0);
		gp.add(vornamee, 2, 0);
		gp.add(nachname, 3, 1);
		gp.add(nachnamee, 2, 1);
		gp.add(plz, 3,2);
		gp.add(plzz, 2,2);
		gp.add(stra�e, 3,3);
		gp.add(stra�ee, 2,3);
		gp.add(ort, 3,4);
		gp.add(ortt, 2,4);
		gp.add(telefonn, 2, 5);
		gp.add(telefon, 3, 5);
		gp.add(emaill, 2, 6);
		gp.add(email, 3, 6);
		gp.add(warenkorbPreis, 3,9);
		gp.add(btnGutschein, 3, 11);
		gp.add(Gesamtpreiss, 4,10);
		gp.add(liefern, 2, 11);

		gp.add(btnZurueck, 4, 11);

		
		liefern.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Stage rGUI = new Stage();
				RechnungsGUI rechnungsGUI = new RechnungsGUI();
				Kontaktverwaltung moin = new Kontaktverwaltung();
				Kontakt neuerKontakt = new Kontakt(vorname.getText(),nachname.getText(),plz.getText(),stra�e.getText(),ort.getText(),telefon.getText(),email.getText(),warenkorb.getWarenkorb());
				moin.hinzufuegen(neuerKontakt);
				rechnungsGUI.warenkorb=warenkorb;
				rechnungsGUI.einKontakt=neuerKontakt;
				rechnungsGUI.einKontaktverwaltung=moin;
				try {
					rechnungsGUI.start(rGUI);
					fenster.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnZurueck.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Stage oGUI = new Stage();
				OrderGUI orderGUI = new OrderGUI();
				orderGUI.warenkorb = warenkorb;
				
				try {
					orderGUI.start(oGUI);
					fenster.close();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
				
			}
		});
		

		btnGutschein.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e) {
				for(int i = 0; i < warenkorbListe.size();i++) {
					if(pizza.isGutschein() == false)
					warenkorbListe.get(i).setPrice(gutschein.getNewPrice(pizza.getPrice()));
					warenkorbListe.get(i).setGutschein(true);
					warenkorbObservList.refresh();
				}

			}
		});
	
		
		fenster.setScene(scene1);
		fenster.setTitle("Kontaktdaten");
		primaryStage.show();
		
		
		
		
	}
	
	
}
