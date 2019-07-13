package GUI;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

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
	protected ResourceBundle languageBundle = null;
	protected int resNumber;
	protected int id = 0;
//	ConnectionClass dbcc = new ConnectionClass();
//	Connection con = dbcc.getConnection();
//	Statement st;

	public void start(Stage primaryStage) {
		
		final Stage fenster = primaryStage;
		gp = new GridPane();
		scene1 = new Scene(gp, 600, 500);
		gp.setAlignment(Pos.CENTER);

		final ObservableList<Pizza> warenkorbListe = FXCollections.<Pizza>observableArrayList();
		warenkorbListe.addAll(warenkorb.getWarenkorb());
		final ListView<Pizza> warenkorbObservList = new ListView<Pizza>((ObservableList<Pizza>) warenkorbListe);

		warenkorbObservList.setPrefSize(250, 100);
		gp.add(warenkorbObservList, 3, 7);

		final TextField tfVorname = new TextField(languageBundle.getString("KontaktGUI.0")); //$NON-NLS-1$
		Label lblVorname = new Label(languageBundle.getString("KontaktGUI.1")); //$NON-NLS-1$
		final TextField tfNachname = new TextField(languageBundle.getString("KontaktGUI.2")); //$NON-NLS-1$
		Label lblNachname = new Label(languageBundle.getString("KontaktGUI.3")); //$NON-NLS-1$
		final TextField tfPlz = new TextField(languageBundle.getString("KontaktGUI.4")); //$NON-NLS-1$
		Label lblPlz = new Label(languageBundle.getString("KontaktGUI.5")); //$NON-NLS-1$
		final TextField tfStraﬂe = new TextField(languageBundle.getString("KontaktGUI.6")); //$NON-NLS-1$
		Label lblStraﬂe = new Label(languageBundle.getString("KontaktGUI.7")); //$NON-NLS-1$
		final TextField tfOrt = new TextField(languageBundle.getString("KontaktGUI.8")); //$NON-NLS-1$
		Label lblOrt = new Label(languageBundle.getString("KontaktGUI.9")); //$NON-NLS-1$
		final TextField tfTelefon = new TextField(languageBundle.getString("KontaktGUI.10")); //$NON-NLS-1$
		Label lblTelefon = new Label(languageBundle.getString("KontaktGUI.11")); //$NON-NLS-1$
		final TextField tfEmail = new TextField(languageBundle.getString("KontaktGUI.12")); //$NON-NLS-1$
		Label lblEmail = new Label(languageBundle.getString("KontaktGUI.13")); //$NON-NLS-1$
		Button liefern = new Button(languageBundle.getString("KontaktGUI.14")); //$NON-NLS-1$
		Button btnZurueck = new Button(languageBundle.getString("KontaktGUI.15")); //$NON-NLS-1$
		Label warenkorbList = new Label(languageBundle.getString("KontaktGUI.16")); //$NON-NLS-1$
		final TextField Gesamtpreiss = new TextField();
		Gesamtpreiss.setDisable(true);
		final Button btnGutschein = new Button(languageBundle.getString("KontaktGUI.17")); //$NON-NLS-1$
		Label warenkorbPreis = new Label(languageBundle.getString("KontaktGUI.18")); //$NON-NLS-1$
		Button btnladen = new Button(languageBundle.getString("KontaktGUI.19")); //$NON-NLS-1$

		double j = warenkorb.preis(warenkorb.getWarenkorb());
		final String sString = (new Double(j).toString());
		Gesamtpreiss.setText(sString + "Ä"); //$NON-NLS-1$

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
		gp.add(warenkorbPreis, 3, 10);
		gp.add(btnGutschein, 3, 11);
		gp.add(Gesamtpreiss, 4, 10);
		gp.add(btnladen, 2, 11);
		gp.add(liefern, 4, 13);

		gp.add(btnZurueck, 4, 11);

		liefern.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Stage rGUI = new Stage();
				RechnungsGUI rechnungsGUI = new RechnungsGUI();
				Kontaktverwaltung moin = new Kontaktverwaltung();
				if(resNumber == 2) {
					rechnungsGUI.languageBundle = ResourceBundle.getBundle("Properties.RechnungGUI_en");
					rechnungsGUI.resNumber = resNumber;
				}else if(resNumber ==1) {
					rechnungsGUI.languageBundle = ResourceBundle.getBundle("Properties.RechnungGUI_de");
					rechnungsGUI.resNumber = resNumber;
				}
				Kontakt neuerKontakt = new Kontakt(tfVorname.getText(), tfNachname.getText(), tfPlz.getText(),
						tfStraﬂe.getText(), tfOrt.getText(), tfTelefon.getText(), tfEmail.getText());
				moin.hinzufuegen(neuerKontakt);
				rechnungsGUI.warenkorb = warenkorb;
				rechnungsGUI.einKontakt = neuerKontakt;
				rechnungsGUI.einKontaktverwaltung = moin;
				String TFdataVorname = tfVorname.getText();
				String TFdataNachname = tfNachname.getText();
				String TFdataPlz = tfPlz.getText();
				String TFdataStraﬂe = tfStraﬂe.getText();
				String TFdataWohnort = tfOrt.getText();
				String TFdataEmail = tfEmail.getText();
				String TFdataTelefonnummer = tfTelefon.getText();
				
				try {
					DaoManager daoManager = DaoManager.INSTANCE;
					DaoKontakte daoKontakt = (DaoKontakte) daoManager.getDao(DbTable.USER);
					daoKontakt.insertKontakt(TFdataVorname, TFdataNachname, TFdataPlz, TFdataStraﬂe, TFdataWohnort,
							TFdataEmail, TFdataTelefonnummer);
					id = id + 1;
					System.out.println(id);
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

		btnladen.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				DaoManager daoManager = DaoManager.INSTANCE;
				DaoKontakte daoKontakt = (DaoKontakte) daoManager.getDao(DbTable.USER);
				Kontakt kontakt = daoKontakt.findKontakt();
				tfVorname.setText(kontakt.getVorname());
				tfNachname.setText(kontakt.getNachname());
				tfPlz.setText(kontakt.getPlz());
				tfStraﬂe.setText(kontakt.getStraﬂe());
				tfOrt.setText(kontakt.getWohnort());
				tfEmail.setText(kontakt.getEmail());
				tfTelefon.setText(kontakt.getTelefonnummer());
			}
		});

		btnZurueck.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {

				Stage oGUI = new Stage();
				OrderGUI orderGUI = new OrderGUI();
				orderGUI.warenkorb = warenkorb;
				if(resNumber == 2) {
					orderGUI.languageBundle = ResourceBundle.getBundle("Properties.OrderGUI_en");
					orderGUI.resNumber = 2;
				}else if(resNumber == 1) {
					orderGUI.languageBundle = ResourceBundle.getBundle("Properties.OrderGUI_de");
					orderGUI.resNumber = 1;
				}
				
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
				Gesamtpreiss.setText(sString + "Ä"); //$NON-NLS-1$
				warenkorbObservList.refresh();

			}
		});

		fenster.setScene(scene1);
		fenster.setTitle(languageBundle.getString("KontaktGUI.22")); //$NON-NLS-1$
		primaryStage.show();

	}
}
