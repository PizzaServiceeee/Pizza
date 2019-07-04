package GUI;


import java.io.IOException;
import java.util.ArrayList;

import Logik.BeobachterWarenkorb;

import Logik.DialogUtil;
import Logik.Gutschein;
import Logik.Pizza;
import Logik.Salami;
import Logik.Tonno;
import Logik.Warenkorb;
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
	// protected PizzaManager manager = new PizzaManager();
	protected Warenkorb warenkorb = new Warenkorb();
	protected Pizza pizza;
	protected Gutschein gutschein = new Gutschein(false);
	protected BeobachterWarenkorb beobachter = new BeobachterWarenkorb();
//	protected ArrayList toppings = new ArrayList();
	
	public static void main(String[] args) {

		launch(args);
	} 

	public void start(Stage primaryStage) throws Exception {
		
		final Stage fenster = primaryStage;
		warenkorb.addObserver(beobachter);
	
		gpMain = new GridPane();
		scene1 = new Scene(gpMain, 650, 600);
//		gpMain.setGridLinesVisible(true);

		gpMain.setVgap(10.0);
		gpMain.setHgap(20.0);
		
		
		final ObservableList<Pizza> warenkorbListe = FXCollections.<Pizza>observableArrayList();
		warenkorbListe.addAll(warenkorb.getWarenkorb());
		final ListView<Pizza> warenkorbObservList = new ListView<Pizza>((ObservableList<Pizza>) warenkorbListe);

		final Label pizzaTitle = new Label(OrderGUI_de_Strings.getString("OrderGUI.0")); //$NON-NLS-1$
		final Label size = new Label(OrderGUI_de_Strings.getString("OrderGUI.1")); //$NON-NLS-1$
		final Label crust = new Label(OrderGUI_de_Strings.getString("OrderGUI.2")); //$NON-NLS-1$
		final Label topping = new Label(OrderGUI_de_Strings.getString("OrderGUI.3")); //$NON-NLS-1$
		final Label toppingExtra = new Label(OrderGUI_de_Strings.getString("OrderGUI.4")); //$NON-NLS-1$
		final Label yourPizza = new Label(OrderGUI_de_Strings.getString("OrderGUI.5")); //$NON-NLS-1$
		final Label warenkorbList = new Label(OrderGUI_de_Strings.getString("OrderGUI.6"));  //$NON-NLS-1$
		final Label warenkorbPreis = new Label(OrderGUI_de_Strings.getString("OrderGUI.7")); //$NON-NLS-1$
		final TextField Gesamtpreiss = new TextField();
		Gesamtpreiss.setDisable(true);
		double j= warenkorb.preis(warenkorb.getWarenkorb());
		String sString = (new Double(j).toString());
		Gesamtpreiss.setText(sString+OrderGUI_de_Strings.getString("OrderGUI.8"));	 //$NON-NLS-1$
	
		
		final RadioButton large = new RadioButton(OrderGUI_de_Strings.getString("OrderGUI.9")); //$NON-NLS-1$
		final RadioButton extralarge = new RadioButton(OrderGUI_de_Strings.getString("OrderGUI.10")); //$NON-NLS-1$
		final RadioButton medium = new RadioButton(OrderGUI_de_Strings.getString("OrderGUI.11")); //$NON-NLS-1$
		final RadioButton small = new RadioButton(OrderGUI_de_Strings.getString("OrderGUI.12")); //$NON-NLS-1$
		RadioButton cheeseCrust = new RadioButton(OrderGUI_de_Strings.getString("OrderGUI.13")); //$NON-NLS-1$
		RadioButton toastetCrust = new RadioButton(OrderGUI_de_Strings.getString("OrderGUI.14")); //$NON-NLS-1$
		RadioButton thinCrust = new RadioButton(OrderGUI_de_Strings.getString("OrderGUI.15")); //$NON-NLS-1$
		RadioButton butterCrust = new RadioButton(OrderGUI_de_Strings.getString("OrderGUI.16")); //$NON-NLS-1$
		final RadioButton rbBesteck = new RadioButton(OrderGUI_de_Strings.getString("OrderGUI.17")); //$NON-NLS-1$


		final TextArea data = new TextArea();
		data.setPrefSize(200, 200);
		data.setWrapText(true);

		ToggleGroup sizeGroup = new ToggleGroup();
		ToggleGroup crustGroup = new ToggleGroup();
		ToggleGroup pizzaGroup = new ToggleGroup();
		
		final RadioButton addSalami = new RadioButton(OrderGUI_de_Strings.getString("OrderGUI.18")); //$NON-NLS-1$
		addSalami.setToggleGroup(pizzaGroup);
		addSalami.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				name = OrderGUI_de_Strings.getString("OrderGUI.19"); //$NON-NLS-1$
				data.setText(name);

			}
		});
		RadioButton addTonno = new RadioButton(OrderGUI_de_Strings.getString("OrderGUI.20")); //$NON-NLS-1$
		addTonno.setToggleGroup(pizzaGroup);
		addTonno.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				name = OrderGUI_de_Strings.getString("OrderGUI.21"); //$NON-NLS-1$
				data.setText(name);

			}
		});

			extralarge.setDisable(false);
			extralarge.setToggleGroup(sizeGroup);
			extralarge.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					

					if (extralarge.isSelected()) {
						size2 = OrderGUI_de_Strings.getString("OrderGUI.22"); //$NON-NLS-1$
//						pizza.setSize("Extra-Large");
						data.setText(name + OrderGUI_de_Strings.getString("OrderGUI.23") +size2); //$NON-NLS-1$
					} else if (extralarge.isSelected() == false) {
						data.setText(name);
					}
				}
			});
			
			large.setToggleGroup(sizeGroup);
			large.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
				
					if (large.isSelected()) {
						size2 = OrderGUI_de_Strings.getString("OrderGUI.24"); //$NON-NLS-1$
//						pizza.setSize("Large");
						data.setText(name + OrderGUI_de_Strings.getString("OrderGUI.25") +size2); //$NON-NLS-1$
					} else if (large.isSelected() == false) {
						data.setText(name);
					}
				}
			});
			medium.setToggleGroup(sizeGroup);
			medium.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					size2 = OrderGUI_de_Strings.getString("OrderGUI.26"); //$NON-NLS-1$
					// manager.getPizzaList().get(0).setSize("Medium");
					if (medium.isSelected()) {
						size2 = OrderGUI_de_Strings.getString("OrderGUI.27"); //$NON-NLS-1$
						data.setText(name+ OrderGUI_de_Strings.getString("OrderGUI.28") + size2); //$NON-NLS-1$
					} else if (medium.isSelected() == false) {
						data.setText(name);
					}
				}
			});

			small.setToggleGroup(sizeGroup);
			small.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					
					// manager.getPizzaList().get(0).setSize("small");
					if (small.isSelected()) {
						size2 = OrderGUI_de_Strings.getString("OrderGUI.29"); //$NON-NLS-1$
						data.setText(name + OrderGUI_de_Strings.getString("OrderGUI.30") + size2); //$NON-NLS-1$
					} else if (small.isSelected() == false) {
						data.setText(name);
					}
				}
			});

			cheeseCrust.setToggleGroup(crustGroup);
			cheeseCrust.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					crust2 = OrderGUI_de_Strings.getString("OrderGUI.31"); //$NON-NLS-1$
//					pizza.setCrust("Cheese-Crust");
					data.setText(name + OrderGUI_de_Strings.getString("OrderGUI.32") + size2 + OrderGUI_de_Strings.getString("OrderGUI.33") + crust2); //$NON-NLS-1$ //$NON-NLS-2$
				}
			});

			toastetCrust.setToggleGroup(crustGroup);
			toastetCrust.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					crust2 = OrderGUI_de_Strings.getString("OrderGUI.34"); //$NON-NLS-1$
//					pizza.setCrust("Toastet - Crust");
					data.setText(name + OrderGUI_de_Strings.getString("OrderGUI.35") + size2 + OrderGUI_de_Strings.getString("OrderGUI.36") + crust2); //$NON-NLS-1$ //$NON-NLS-2$
				}
			});

			thinCrust.setToggleGroup(crustGroup);
			thinCrust.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					crust2 = OrderGUI_de_Strings.getString("OrderGUI.37"); //$NON-NLS-1$
					// manager.getPizzaList().get(0).setCrust("Thin - Crust");
				
					data.setText(name + OrderGUI_de_Strings.getString("OrderGUI.38") + size2 + OrderGUI_de_Strings.getString("OrderGUI.39") + crust2); //$NON-NLS-1$ //$NON-NLS-2$
				}
			});

			butterCrust.setToggleGroup(crustGroup);
			butterCrust.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					crust2 = OrderGUI_de_Strings.getString("OrderGUI.40"); //$NON-NLS-1$
					// manager.getPizzaList().get(0).setCrust("Butter - Crust");
			
					data.setText(name + OrderGUI_de_Strings.getString("OrderGUI.41") + size2 + OrderGUI_de_Strings.getString("OrderGUI.42") + crust2); //$NON-NLS-1$ //$NON-NLS-2$
				}
			});

		Button addWarenkorb = new Button(OrderGUI_de_Strings.getString("OrderGUI.43")); //$NON-NLS-1$
		Button bestellen = new Button(OrderGUI_de_Strings.getString("OrderGUI.44")); //$NON-NLS-1$
		Button btnSpeichern = new Button(OrderGUI_de_Strings.getString("OrderGUI.45")); //$NON-NLS-1$
		

		bestellen.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Stage kGUI = new Stage();
				KontaktGUI kontaktGUI = new KontaktGUI();
				kontaktGUI.warenkorb=warenkorb;
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
				
				if(name == OrderGUI_de_Strings.getString("OrderGUI.46")) { //$NON-NLS-1$
					pizza = Pizza.getInstance(name, 10.0, size2, crust2);
//					pizza = new Salami(name, 10.0, size2, crust2);
				}else if(name == OrderGUI_de_Strings.getString("OrderGUI.47")) { //$NON-NLS-1$
					pizza = Pizza.getInstance(name, 8.0, size2, crust2);
//					pizza = new Tonno(name, 8.0, size2, crust2);
				}
				warenkorbListe.add(pizza);
				warenkorbObservList.refresh();
				

				double i= warenkorb.preis(warenkorbListe);
				String sString = (new Double(i).toString());
				Gesamtpreiss.setText(sString+OrderGUI_de_Strings.getString("OrderGUI.48"));	 //$NON-NLS-1$
			}

		});
		Button btnSend = new Button(OrderGUI_de_Strings.getString("OrderGUI.49")); //$NON-NLS-1$
		btnSend.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				DialogUtil.showMessageDialog(OrderGUI_de_Strings.getString("OrderGUI.50"), OrderGUI_de_Strings.getString("OrderGUI.51")); //$NON-NLS-1$ //$NON-NLS-2$
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
		gpMain.add(btnSpeichern, 2, 2);


//		gpMain.add(btnGutschein, 2, 20);
//		gpMain.add(btnLog, 2, 4);

		gpMain.add(bestellen, 1,21);
		gpMain.add(warenkorbPreis, 1, 22);
		gpMain.add(Gesamtpreiss, 2, 22);
		

		warenkorbObservList.setPrefSize(100, 50);
		gpMain.add(warenkorbObservList, 6, 12, 1, 10);
		// gpWaren.add(btnPizza, 1, 3);
		// gpWaren.add(btnSend, 2, 3);
		
		primaryStage.setScene(scene1);
		primaryStage.setTitle(OrderGUI_de_Strings.getString("OrderGUI.52")); //$NON-NLS-1$
		primaryStage.show();

	}
}
