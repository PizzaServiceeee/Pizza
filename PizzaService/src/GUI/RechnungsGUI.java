package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

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

public class RechnungsGUI {
	GridPane gp;
	Scene scene1;
	protected TextField textField;
	protected Label label;
	protected Button button;
	protected Warenkorb warenkorb = new Warenkorb();
	protected Kontakt einKontakt = new Kontakt();
	protected Kontaktverwaltung einKontaktverwaltung = new Kontaktverwaltung();
	protected ResourceBundle languageBundle;
	protected int resNumber;
	public RechnungsGUI() {

	}

	public void start(Stage primaryStage) {

		final ObservableList<Pizza> warenkorbListe = FXCollections.<Pizza>observableArrayList();
		warenkorbListe.addAll(warenkorb.getWarenkorb());
		final ListView<Pizza> warenkorbObservList = new ListView<Pizza>((ObservableList<Pizza>) warenkorbListe);
		warenkorbObservList.setPrefSize(200, 100);

		final Stage fenster = primaryStage;
		gp = new GridPane();
		scene1 = new Scene(gp, 500, 500);
		gp.setAlignment(Pos.CENTER);
		final TextField vorname = new TextField(languageBundle.getString("RechnungsGUI.0")); //$NON-NLS-1$
		vorname.setText(einKontakt.getVorname());
		vorname.setDisable(true);
		Label vornamee = new Label(languageBundle.getString("RechnungsGUI.1")); //$NON-NLS-1$
		final TextField nachname = new TextField(languageBundle.getString("RechnungsGUI.2")); //$NON-NLS-1$
		nachname.setText(einKontakt.getNachname());
		nachname.setDisable(true);
		Label nachnamee = new Label(languageBundle.getString("RechnungsGUI.3")); //$NON-NLS-1$
		final TextField plz = new TextField(languageBundle.getString("RechnungsGUI.4")); //$NON-NLS-1$
		Label plzz = new Label(languageBundle.getString("RechnungsGUI.5")); //$NON-NLS-1$
		plz.setText(einKontakt.getPlz());
		plz.setDisable(true);
		final TextField straﬂe = new TextField(languageBundle.getString("RechnungsGUI.6")); //$NON-NLS-1$
		Label straﬂee = new Label(languageBundle.getString("RechnungsGUI.7")); //$NON-NLS-1$
		straﬂe.setText(einKontakt.getStraﬂe());
		straﬂe.setDisable(true);
		final TextField ort = new TextField(languageBundle.getString("RechnungsGUI.8")); //$NON-NLS-1$
		Label ortt = new Label(languageBundle.getString("RechnungsGUI.9")); //$NON-NLS-1$
		ort.setText(einKontakt.getWohnort());
		ort.setDisable(true);
		final TextField telefon = new TextField(languageBundle.getString("RechnungsGUI.10")); //$NON-NLS-1$
		Label telefonn = new Label(languageBundle.getString("RechnungsGUI.11")); //$NON-NLS-1$
		telefon.setText(einKontakt.getTelefonnummer());
		telefon.setDisable(true);
		final TextField email = new TextField(languageBundle.getString("RechnungsGUI.12")); //$NON-NLS-1$
		Label emaill = new Label(languageBundle.getString("RechnungsGUI.13")); //$NON-NLS-1$
		email.setText(einKontakt.getEmail());
		email.setDisable(true);
		Button drucken = new Button(languageBundle.getString("RechnungsGUI.14")); //$NON-NLS-1$
		Label warenkorbList = new Label(languageBundle.getString("RechnungsGUI.15")); //$NON-NLS-1$
		TextField Gesamtpreiss = new TextField();
		Gesamtpreiss.setDisable(true);
		Label warenkorbPreis = new Label(languageBundle.getString("RechnungsGUI.16")); //$NON-NLS-1$
		
		double i = warenkorb.preis(warenkorb.getWarenkorb());
		String sString = (new Double(i).toString());

	
		gp.add(vorname, 3, 0);
		gp.add(vornamee, 2, 0);
		gp.add(nachname, 3, 1);
		gp.add(nachnamee, 2, 1);
		gp.add(plz, 3, 2);
		gp.add(plzz, 2, 2);
		gp.add(straﬂe, 3, 3);
		gp.add(straﬂee, 2, 3);
		gp.add(ort, 3, 4);
		gp.add(ortt, 2, 4);
		gp.add(telefonn, 2, 5);
		gp.add(telefon, 3, 5);
		gp.add(emaill, 2, 6);
		gp.add(email, 3, 6);
		gp.add(warenkorbPreis, 3, 9);
		gp.add(Gesamtpreiss, 4, 9);
		gp.add(drucken, 3, 10);

		drucken.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					einKontaktverwaltung.exportiereEintraegeAlsCsv(new File(languageBundle.getString("RechnungsGUI.17") + ".csv")); //$NON-NLS-1$ //$NON-NLS-2$
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		Button btnZurueck = new Button(languageBundle.getString("RechnungsGUI.19")); //$NON-NLS-1$
		btnZurueck.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Stage oGUI = new Stage();
				OrderGUI orderGUI = new OrderGUI();
				orderGUI.warenkorb = warenkorb;
				try {
					orderGUI.start(oGUI);
					fenster.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		gp.add(warenkorbObservList, 3, 7, 3, 3);

		fenster.setScene(scene1);
		fenster.setTitle(languageBundle.getString("RechnungsGUI.20")); //$NON-NLS-1$
		fenster.show();

	}
}
