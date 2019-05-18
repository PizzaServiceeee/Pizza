package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import Logik.Kontakt;
import Logik.Kontaktverwaltung;
import Logik.Pizza;
import Logik.Warenkorb;
import javafx.application.Application;
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
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RechnungsGUI
{
	GridPane gp;
	Scene scene1;
	protected TextField textField;
	protected Label label;
	protected Button button;
	protected Warenkorb warenkorb = new Warenkorb();
	protected Kontakt einKontakt = new Kontakt();
	protected Kontaktverwaltung einKontaktverwaltung = new Kontaktverwaltung();
	
	public RechnungsGUI() 
	{
		
	}
	
		public void start(Stage primaryStage) {
		
		final Stage fenster = primaryStage;
		gp = new GridPane();
		scene1 = new Scene(gp,500,500);
		gp.setAlignment(Pos.CENTER);
		final TextField vorname = new TextField("Vorname");
		vorname.setText(einKontakt.getVorname());
		vorname.setDisable(true);
		Label vornamee = new Label("Vorname");
		final TextField nachname = new TextField("Nachname");
		nachname.setText(einKontakt.getNachname());
		nachname.setDisable(true);
		Label nachnamee = new Label("Nachnamee");
		final TextField plz = new TextField("PLZ");
		Label plzz = new Label("PLZ");
		plz.setText(einKontakt.getPlz());
		plz.setDisable(true);
		final TextField straﬂe = new TextField("Straﬂe");
		Label straﬂee = new Label("Straﬂe");
		straﬂe.setText(einKontakt.getStraﬂe());
		straﬂe.setDisable(true);
		final TextField ort = new TextField("Ort");
		Label ortt = new Label("Ort");
		ort.setText(einKontakt.getWohnort());
		ort.setDisable(true);
		final TextField telefon = new TextField("Telefonnummer");
		Label telefonn = new Label("Telefonnummer");
		telefon.setText(einKontakt.getTelefonnummer());
		telefon.setDisable(true);
		final TextField email = new TextField("Email");
		Label emaill = new Label("Email");
		email.setText(einKontakt.getEmail());
		email.setDisable(true);
		Button drucken = new Button("Rechnung drucken");
		Label warenkorbList = new Label("Warenkorb: ");
		TextField Gesamtpreiss = new TextField();
		Gesamtpreiss.setDisable(true);
		Label warenkorbPreis = new Label("Gesamtpreis: ");
		double i= warenkorb.preis(warenkorb.getWarenkorb());
		String sString = (new Double(i).toString());
		Gesamtpreiss.setText(sString+"Ä");
		gp.add(vorname, 3, 0);
		gp.add(vornamee, 2, 0);
		gp.add(nachname, 3, 1);
		gp.add(nachnamee, 2, 1);
		gp.add(plz, 3,2);
		gp.add(plzz, 2,2);
		gp.add(straﬂe, 3,3);
		gp.add(straﬂee, 2,3);
		gp.add(ort, 3,4);
		gp.add(ortt, 2,4);
		gp.add(telefonn, 2, 5);
		gp.add(telefon, 3, 5);
		gp.add(emaill, 2, 6);
		gp.add(email, 3, 6);
		gp.add(warenkorbPreis, 3,9);
		gp.add(Gesamtpreiss, 4,9);
		gp.add(drucken, 3, 10);
		
	
		drucken.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try
				{
					einKontaktverwaltung.exportiereEintraegeAlsCsv(new File("Datei"+".csv"));
				} catch (FileNotFoundException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		

		Button btnZurueck = new Button("Zur¸ck");
		Label warenkorbList = new Label("Warenkorb: ");
		TextField Gesamtpreiss = new TextField();
		Gesamtpreiss.setDisable(true);
		Label warenkorbPreis = new Label("Gesamtpreis: ");
		double i= warenkorb.preis(warenkorb.getWarenkorb());
		String sString = (new Double(i).toString());
		Gesamtpreiss.setText(sString+"Ä");
		gp.add(vorname, 3, 0);
		gp.add(vornamee, 2, 0);
		gp.add(nachname, 3, 1);
		gp.add(nachnamee, 2, 1);
		gp.add(plz, 3,2);
		gp.add(plzz, 2,2);
		gp.add(straﬂe, 3,3);
		gp.add(straﬂee, 2,3);
		gp.add(ort, 3,4);
		gp.add(ortt, 2,4);
		gp.add(telefonn, 2, 5);
		gp.add(telefon, 3, 5);
		gp.add(emaill, 2, 6);
		gp.add(email, 3, 6);
		gp.add(warenkorbPreis, 3,9);
		gp.add(Gesamtpreiss, 4,9);
		gp.add(drucken, 3, 10);
		gp.add(btnZurueck, 4, 10);
		
	
		drucken.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try
				{
					einKontaktverwaltung.exportiereEintraegeAlsCsv(new File("Datei"+".csv"));
				} catch (FileNotFoundException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1)
				{
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
	
		ListView<Pizza> warenkorbObservList = new ListView<Pizza>((ObservableList<Pizza>) warenkorb.getWarenkorb());
		warenkorbObservList.setPrefSize(200, 100);
		gp.add(warenkorbObservList,3, 7);
		
		fenster.setScene(scene1);
		fenster.setTitle("Rechnung");
		fenster.show();
	
	
}
}
