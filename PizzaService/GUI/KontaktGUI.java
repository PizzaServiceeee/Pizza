package GUI;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.DaoKontakte;
import DAO.DaoManager;
import DAO.DbTable;
import Logik.Gutschein;
import Logik.Kontakt;
import Logik.Kontaktverwaltung;
import Logik.Pizza;
import Logik.Warenkorb;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
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

public class KontaktGUI {

	GridPane gp;
	Scene scene1;
	protected TextField textField;
	protected Label label;
	protected Button button;
	protected Warenkorb warenkorb = new Warenkorb();
	protected Pizza pizza;
	protected Gutschein gutschein = new Gutschein(false);
//	ConnectionClass dbcc = new ConnectionClass();
//	Connection con = dbcc.getConnection();
//	Statement st;

	public void start(Stage primaryStage) {

		final Stage fenster = primaryStage;
		gp = new GridPane();
		scene1 = new Scene(gp, 500, 500);
		gp.setAlignment(Pos.CENTER);

		final ObservableList<Pizza> warenkorbListe = FXCollections.<Pizza>observableArrayList();
		warenkorbListe.addAll(warenkorb.getWarenkorb());
		final ListView<Pizza> warenkorbObservList = new ListView<Pizza>((ObservableList<Pizza>) warenkorbListe);

		warenkorbObservList.setPrefSize(50, 50);
		gp.add(warenkorbObservList, 3, 7);

		final TextField vorname = new TextField("Vorname");
		Label vornamee = new Label("Vorname");
		final TextField nachname = new TextField("Nachname");
		Label nachnamee = new Label("Nachnamee");
		final TextField plz = new TextField("PLZ");
		Label plzz = new Label("PLZ");
		final TextField straﬂe = new TextField("Straﬂe");
		Label straﬂee = new Label("Straﬂe");
		final TextField ort = new TextField("Ort");
		Label ortt = new Label("Ort");
		final TextField telefon = new TextField("Telefonnummer");
		Label telefonn = new Label("Telefonnummer");
		final TextField email = new TextField("Email");
		Label emaill = new Label("Email");
		Button liefern = new Button("liefern");
		Button btnZurueck = new Button("Zur¸ck");
		Label warenkorbList = new Label("Warenkorb: ");
		final TextField Gesamtpreiss = new TextField();
		Gesamtpreiss.setDisable(true);
		final Button btnGutschein = new Button("Gutschein auf alles");
		Label warenkorbPreis = new Label("Gesamtpreis: ");

		double j = warenkorb.preis(warenkorbListe);
		final String sString = (new Double(j).toString());
		Gesamtpreiss.setText(sString + "Ä");
		
		final String TFdataVorname = vorname.getText();
		final String TFdataNachname = nachname.getText();
		final String TFdataPlz = plz.getText();
		final String TFdataStraﬂe = straﬂe.getText();
		final String TFdataWohnort = ort.getText();
		final String TFdataEmail = email.getText();
		final String TFdataTelefonnummer = telefon.getText();

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
		gp.add(btnGutschein, 3, 11);
		gp.add(Gesamtpreiss, 4, 10);
		gp.add(liefern, 2, 11);

		gp.add(btnZurueck, 4, 11);

//		liefern.setOnAction(new EventHandler<ActionEvent>() {
//			public void handle(ActionEvent e) {
//				Stage rGUI = new Stage();
//				RechnungsGUI rechnungsGUI = new RechnungsGUI();
//				Kontaktverwaltung moin = new Kontaktverwaltung();
//				Kontakt neuerKontakt = new Kontakt(vorname.getText(), nachname.getText(), plz.getText(),
//						straﬂe.getText(), ort.getText(), telefon.getText(), email.getText());
//				moin.hinzufuegen(neuerKontakt);
//				rechnungsGUI.warenkorb = warenkorb;
//				rechnungsGUI.einKontakt = neuerKontakt;
//				rechnungsGUI.einKontaktverwaltung = moin;
//				
//				DaoManager daoManager = DaoManager.INSTANCE;
//				DaoKontakte daoKontakt = (DaoKontakte) daoManager.getDao(DbTable.USER);
//				int gameCount = daoKontakt.count();
//				System.out.println("Anzahl Datens‰tze in der Tabelle" + DbTable.USER.toString() + " i " + gameCount );
//				
//				int id = 2;
//				Kontakt kontakt = daoKontakt.getRecord(id);
//				System.out.println("Der user mit der id " +id+ " ist " + kontakt.getNachname() + ", " + kontakt.getVorname());
//				try {
//				rechnungsGUI.start(rGUI);
//					fenster.close();
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//			}
//
//		});
		
		liefern.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Stage rGUI = new Stage();
				RechnungsGUI rechnungsGUI = new RechnungsGUI();
				Kontaktverwaltung moin = new Kontaktverwaltung();
				Kontakt neuerKontakt = new Kontakt(vorname.getText(), nachname.getText(), plz.getText(),
						straﬂe.getText(), ort.getText(), telefon.getText(), email.getText());
				moin.hinzufuegen(neuerKontakt);
				rechnungsGUI.warenkorb = warenkorb;
				rechnungsGUI.einKontakt = neuerKontakt;
				rechnungsGUI.einKontaktverwaltung = moin;
				try {
					DaoManager daoManager = DaoManager.INSTANCE;
					DaoKontakte daoKontakt = (DaoKontakte) daoManager.getDao(DbTable.USER);
					daoKontakt.speichern(TFdataVorname, TFdataNachname, TFdataPlz, TFdataStraﬂe, TFdataWohnort, TFdataEmail, TFdataTelefonnummer);

				} catch (Exception p) {
					p.printStackTrace();

				}
				try {
					rechnungsGUI.start(rGUI);
					fenster.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});

		btnZurueck.setOnAction(new EventHandler<ActionEvent>() {

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

		btnGutschein.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				for (int i = 0; i < warenkorbListe.size(); i++) {
					if (warenkorbListe.get(i).isGutschein() == false)
						warenkorbListe.get(i).setPrice(gutschein.getNewPrice(warenkorbListe.get(i).getPrice()));
					warenkorbListe.get(i).setGutschein(true);
				}
				double j = warenkorb.preis(warenkorbListe);
				final String sString = (new Double(j).toString());
				Gesamtpreiss.setText(sString + "Ä");
				warenkorbObservList.refresh();

			}
		});

		fenster.setScene(scene1);
		fenster.setTitle("Kontaktdaten");
		primaryStage.show();

	}
}
