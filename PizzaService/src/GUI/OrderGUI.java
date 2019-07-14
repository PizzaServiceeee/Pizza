package GUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import Logik.BeobachterWarenkorb;

import Logik.DialogUtil;
import Logik.Gutschein;
import Logik.Pizza;
import Logik.Salami;
import Logik.Tonno;
import Logik.Warenkorb;
import Strings.OrderGUI_en_Strings;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.*;

public class OrderGUI extends Application {

	protected GridPane gpMain;
	protected GridPane gpWaren;
	protected MenuBar menubar;
	protected Scene scene1;
	protected Scene scene2;
	protected String name;
	protected String size2;
	protected String crust2;
	protected String top;
	protected double price;
	protected Warenkorb warenkorb = new Warenkorb();
	protected Pizza pizza;
	protected Gutschein gutschein = new Gutschein(false);
	protected BeobachterWarenkorb beobachter = new BeobachterWarenkorb();
	protected ResourceBundle languageBundle = null;
	protected int resNumber;

	public static void main(String[] args) {

		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		final Stage fenster = primaryStage;

		warenkorb.addObserver(beobachter);
		gpMain = new GridPane();
		scene1 = new Scene(gpMain, 650, 600);

		gpMain.setVgap(10.0);
		gpMain.setHgap(20.0);

		final ObservableList<Pizza> warenkorbListe = FXCollections.<Pizza>observableArrayList();
		warenkorbListe.addAll(warenkorb.getWarenkorb());
		final ListView<Pizza> warenkorbObservList = new ListView<Pizza>((ObservableList<Pizza>) warenkorbListe);

		final Label pizzaTitle = new Label(languageBundle.getString("OrderGUI.1")); //$NON-NLS-1$
		final Label size = new Label(languageBundle.getString("OrderGUI.2")); //$NON-NLS-1$
		final Label crust = new Label(languageBundle.getString("OrderGUI.3")); //$NON-NLS-1$
		final Label yourPizza = new Label(languageBundle.getString("OrderGUI.5")); //$NON-NLS-1$
		final Label warenkorbList = new Label(languageBundle.getString("OrderGUI.6")); //$NON-NLS-1$
		final Label warenkorbPreis = new Label(languageBundle.getString("OrderGUI.7")); //$NON-NLS-1$
		final TextField Gesamtpreiss = new TextField();
		Gesamtpreiss.setDisable(true);

		final RadioButton large = new RadioButton(languageBundle.getString("OrderGUI.9")); //$NON-NLS-1$
		final RadioButton extralarge = new RadioButton(languageBundle.getString("OrderGUI.10")); //$NON-NLS-1$
		final RadioButton medium = new RadioButton(languageBundle.getString("OrderGUI.11")); //$NON-NLS-1$
		final RadioButton small = new RadioButton(languageBundle.getString("OrderGUI.12")); //$NON-NLS-1$
		RadioButton cheeseCrust = new RadioButton(languageBundle.getString("OrderGUI.13")); //$NON-NLS-1$
		RadioButton toastetCrust = new RadioButton(languageBundle.getString("OrderGUI.14")); //$NON-NLS-1$
		RadioButton thinCrust = new RadioButton(languageBundle.getString("OrderGUI.15")); //$NON-NLS-1$
		RadioButton butterCrust = new RadioButton(languageBundle.getString("OrderGUI.16")); //$NON-NLS-1$

		final TextArea data = new TextArea();
		data.setPrefSize(200, 200);
		data.setWrapText(true);

		ToggleGroup sizeGroup = new ToggleGroup();
		ToggleGroup crustGroup = new ToggleGroup();
		ToggleGroup pizzaGroup = new ToggleGroup();

		final RadioButton addSalami = new RadioButton(languageBundle.getString("OrderGUI.18")); //$NON-NLS-1$
		addSalami.setToggleGroup(pizzaGroup);
		addSalami.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				name = "Salami"; //$NON-NLS-1$
				data.setText(name);
			}
		});
		RadioButton addTonno = new RadioButton(languageBundle.getString("OrderGUI.20")); //$NON-NLS-1$
		addTonno.setToggleGroup(pizzaGroup);
		addTonno.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				name = "Tonno"; //$NON-NLS-1$
				data.setText(name);

			}
		});

		extralarge.setDisable(false);
		extralarge.setToggleGroup(sizeGroup);
		extralarge.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (extralarge.isSelected()) {
					size2 = languageBundle.getString("OrderGUI.22"); //$NON-NLS-1$
					data.setText(name + "\n" + size2); //$NON-NLS-1$
				} else if (extralarge.isSelected() == false) {
					data.setText(name);
				}
			}
		});

		large.setToggleGroup(sizeGroup);
		large.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				if (large.isSelected()) {
					size2 = languageBundle.getString("OrderGUI.24"); //$NON-NLS-1$
					data.setText(name + "\n" + size2); //$NON-NLS-1$
				} else if (large.isSelected() == false) {
					data.setText(name);
				}
			}
		});
		medium.setToggleGroup(sizeGroup);
		medium.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				size2 = languageBundle.getString("OrderGUI.26"); //$NON-NLS-1$
				if (medium.isSelected()) {
					size2 = languageBundle.getString("OrderGUI.27"); //$NON-NLS-1$
					data.setText(name + "\n" + size2); //$NON-NLS-1$
				} else if (medium.isSelected() == false) {
					data.setText(name);
				}
			}
		});

		small.setToggleGroup(sizeGroup);
		small.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				if (small.isSelected()) {
					size2 = languageBundle.getString("OrderGUI.29"); //$NON-NLS-1$
					data.setText(name + "\n" + size2); //$NON-NLS-1$
				} else if (small.isSelected() == false) {
					data.setText(name);
				}
			}
		});

		cheeseCrust.setToggleGroup(crustGroup);
		cheeseCrust.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				crust2 = languageBundle.getString("OrderGUI.31"); //$NON-NLS-1$

				data.setText(name + "\n" + size2 //$NON-NLS-1$
						+ "\n" + crust2); //$NON-NLS-1$
			}
		});

		toastetCrust.setToggleGroup(crustGroup);
		toastetCrust.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				crust2 = languageBundle.getString("OrderGUI.34"); //$NON-NLS-1$

				data.setText(name + "\n" + size2 //$NON-NLS-1$
						+ "\n" + crust2); //$NON-NLS-1$
			}
		});

		thinCrust.setToggleGroup(crustGroup);
		thinCrust.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				crust2 = OrderGUI_en_Strings.getString("OrderGUI.37"); //$NON-NLS-1$

				data.setText(name + "\n" + size2 //$NON-NLS-1$
						+ "\n" + crust2); //$NON-NLS-1$
			}
		});

		butterCrust.setToggleGroup(crustGroup);
		butterCrust.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				crust2 = OrderGUI_en_Strings.getString("OrderGUI.40"); //$NON-NLS-1$

				data.setText(name + "\n" + size2 //$NON-NLS-1$
						+ "\n" + crust2); //$NON-NLS-1$
			}
		});

		Button addWarenkorb = new Button(languageBundle.getString("OrderGUI.43")); //$NON-NLS-1$
		Button bestellen = new Button(languageBundle.getString("OrderGUI.44")); //$NON-NLS-1$

		bestellen.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				Stage kGUI = new Stage();
				KontaktGUI kontaktGUI = new KontaktGUI();
				kontaktGUI.warenkorb = warenkorb;
				if (resNumber == 2) {
					kontaktGUI.languageBundle = ResourceBundle.getBundle("Properties.KontaktGUI_en");
					kontaktGUI.resNumber = resNumber;
				} else if (resNumber == 1) {
					kontaktGUI.languageBundle = ResourceBundle.getBundle("Properties.KontaktGUI_de");
				}
				kontaktGUI.resNumber = resNumber;
				try {
					warenkorb.setWarenkorb(warenkorbListe);
					kontaktGUI.start(kGUI);
					fenster.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		addWarenkorb.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				if (name == "Salami") { //$NON-NLS-1$
					pizza = Pizza.getInstance(name, 10.0, size2, crust2);
				} else if (name == "Tonno") { //$NON-NLS-1$
					pizza = Pizza.getInstance(name, 8.0, size2, crust2);
				}
				warenkorbListe.add(pizza);
				warenkorb.add(pizza);
				warenkorbObservList.refresh();

				double i = warenkorb.preis(warenkorbListe);
				String sString = (new Double(i).toString());
				Gesamtpreiss.setText(sString + languageBundle.getString("OrderGUI.48")); //$NON-NLS-1$
			}

		});

		gpMain.add(pizzaTitle, 1, 0);
		gpMain.add(addSalami, 1, 1);
		gpMain.add(addTonno, 1, 2);

		gpMain.add(size, 1, 4);
		gpMain.add(extralarge, 1, 5);
		gpMain.add(large, 1, 6);
		gpMain.add(medium, 1, 7);
		gpMain.add(small, 1, 8);

		gpMain.add(crust, 1, 9);
		gpMain.add(cheeseCrust, 1, 10);
		gpMain.add(toastetCrust, 1, 11);
		gpMain.add(thinCrust, 1, 12);
		gpMain.add(butterCrust, 1, 13);

		gpMain.add(yourPizza, 6, 0);
		gpMain.add(warenkorbList, 6, 11);

		gpMain.add(data, 6, 1, 1, 10);
		gpMain.add(addWarenkorb, 1, 20);

		gpMain.add(bestellen, 1, 21);
		gpMain.add(warenkorbPreis, 1, 22);
		gpMain.add(Gesamtpreiss, 2, 22);

		warenkorbObservList.setPrefSize(100, 50);
		gpMain.add(warenkorbObservList, 6, 12, 1, 10);

		primaryStage.setScene(scene1);
		primaryStage.setTitle(languageBundle.getString("OrderGUI.52")); //$NON-NLS-1$
		primaryStage.show();

	}
}
