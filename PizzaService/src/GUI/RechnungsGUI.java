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
		final TextField tfVorname = new TextField(languageBundle.getString("RechnungsGUI.0")); //$NON-NLS-1$
		tfVorname.setText(einKontakt.getVorname());
		tfVorname.setDisable(true);
		Label lblVorname = new Label(languageBundle.getString("RechnungsGUI.1")); //$NON-NLS-1$
		final TextField tfNachname = new TextField(languageBundle.getString("RechnungsGUI.2")); //$NON-NLS-1$
		tfNachname.setText(einKontakt.getNachname());
		tfNachname.setDisable(true);
		Label lblNachname = new Label(languageBundle.getString("RechnungsGUI.3")); //$NON-NLS-1$
		final TextField tfPlz = new TextField(languageBundle.getString("RechnungsGUI.4")); //$NON-NLS-1$
		Label lblPlz = new Label(languageBundle.getString("RechnungsGUI.5")); //$NON-NLS-1$
		tfPlz.setText(einKontakt.getPlz());
		tfPlz.setDisable(true);
		final TextField tfStraﬂe = new TextField(languageBundle.getString("RechnungsGUI.6")); //$NON-NLS-1$
		Label lblStraﬂe = new Label(languageBundle.getString("RechnungsGUI.7")); //$NON-NLS-1$
		tfStraﬂe.setText(einKontakt.getStraﬂe());
		tfStraﬂe.setDisable(true);
		final TextField tfOrt = new TextField(languageBundle.getString("RechnungsGUI.8")); //$NON-NLS-1$
		Label lblOrt = new Label(languageBundle.getString("RechnungsGUI.9")); //$NON-NLS-1$
		tfOrt.setText(einKontakt.getWohnort());
		tfOrt.setDisable(true);
		final TextField tfTelefon = new TextField(languageBundle.getString("RechnungsGUI.10")); //$NON-NLS-1$
		Label lblTelefon  = new Label(languageBundle.getString("RechnungsGUI.11")); //$NON-NLS-1$
		tfTelefon.setText(einKontakt.getTelefonnummer());
		tfTelefon.setDisable(true);
		final TextField tfEmail = new TextField(languageBundle.getString("RechnungsGUI.12")); //$NON-NLS-1$
		Label lblEmail = new Label(languageBundle.getString("RechnungsGUI.13")); //$NON-NLS-1$
		tfEmail.setText(einKontakt.getEmail());
		tfEmail.setDisable(true);
		Button drucken = new Button(languageBundle.getString("RechnungsGUI.14")); //$NON-NLS-1$
		Label warenkorbList = new Label(languageBundle.getString("RechnungsGUI.15")); //$NON-NLS-1$
		TextField Gesamtpreiss = new TextField();
		Gesamtpreiss.setDisable(true);
		Label warenkorbPreis = new Label(languageBundle.getString("RechnungsGUI.16")); //$NON-NLS-1$
		
		double i = warenkorb.preis(warenkorb.getWarenkorb());
		String sString = (new Double(i).toString());

	
		gp.add(tfVorname, 3, 0);
		gp.add(lblVorname, 2, 0);
		gp.add(tfNachname, 3, 1);
		gp.add(lblNachname, 2, 1);
		gp.add(tfPlz, 3, 2);
		gp.add(lblPlz, 2, 2);
		gp.add(tfStraﬂe, 3, 3);
		gp.add(lblStraﬂe, 2, 3);
		gp.add(tfOrt, 3, 4);
		gp.add(lblOrt, 2, 4);
		gp.add(lblTelefon, 2, 5);
		gp.add(tfTelefon, 3, 5);
		gp.add(lblEmail, 2, 6);
		gp.add(tfEmail, 3, 6);
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
