package GUI;


import java.io.IOException;
import java.util.ArrayList;

import Logik.BeobachterWarenkorb;
import Logik.Besteck;
import Logik.DialogUtil;
import Logik.Gutschein;
import Logik.Persistenz;
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
		gpMain.setGridLinesVisible(true);

		gpMain.setVgap(10.0);
		gpMain.setHgap(20.0);
		
		
		final ObservableList<Pizza> warenkorbListe = FXCollections.<Pizza>observableArrayList();
		warenkorbListe.addAll(warenkorb.getWarenkorb());
		final ListView<Pizza> warenkorbObservList = new ListView<Pizza>((ObservableList<Pizza>) warenkorbListe);
		
		
		
		Label pizzaTitle = new Label("Pizza auswählen: ");
		Label size = new Label("Pizza Size");
		Label crust = new Label("Crust");
		Label topping = new Label("Extra Topping: ");
		Label toppingExtra = new Label("+ 0.50 cents each");
		Label yourPizza = new Label("Your Pizza: ");
		Label warenkorbList = new Label("Warenkorb: "); 
		Label warenkorbPreis = new Label("Gesamtpreis: ");
		final TextField Gesamtpreiss = new TextField();
		Gesamtpreiss.setDisable(true);
		double j= warenkorb.preis(warenkorb.getWarenkorb());
		String sString = (new Double(j).toString());
		Gesamtpreiss.setText(sString+"€");	
	
		
		final RadioButton large = new RadioButton("Large");
		final RadioButton extralarge = new RadioButton("Extra-Large");
		final RadioButton medium = new RadioButton("Medium");
		final RadioButton small = new RadioButton("Small");
		RadioButton cheeseCrust = new RadioButton("Cheese-Crust");
		RadioButton toastetCrust = new RadioButton("Toastet");
		RadioButton thinCrust = new RadioButton("Thin");
		RadioButton butterCrust = new RadioButton("Butter");
		final RadioButton rbBesteck = new RadioButton("Besteck?");
//		final CheckBox cheeseTop = new CheckBox("cheese");
//		final CheckBox hamTop = new CheckBox("ham");
//		final CheckBox pepperoniTop = new CheckBox("pepperoni");
//		final CheckBox olivesTop = new CheckBox("oliven");

		final TextArea data = new TextArea();
		data.setPrefSize(200, 200);
		data.setWrapText(true);

		ToggleGroup sizeGroup = new ToggleGroup();
		ToggleGroup crustGroup = new ToggleGroup();
		ToggleGroup pizzaGroup = new ToggleGroup();
		
		final RadioButton addSalami = new RadioButton("Salami");
		addSalami.setToggleGroup(pizzaGroup);
		addSalami.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				name = "Salami";
				data.setText(name);

			}
		});
		RadioButton addTonno = new RadioButton("Tonno");
		addTonno.setToggleGroup(pizzaGroup);
		addTonno.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				name = "Tonno";
				data.setText(name);

			}
		});

			extralarge.setDisable(false);
			extralarge.setToggleGroup(sizeGroup);
			extralarge.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					

					if (extralarge.isSelected()) {
						size2 = "Extra - Large";
//						pizza.setSize("Extra-Large");
						data.setText(name + "\n" +size2);
					} else if (extralarge.isSelected() == false) {
						data.setText(name);
					}
				}
			});
			
			large.setToggleGroup(sizeGroup);
			large.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
				
					if (large.isSelected()) {
						size2 = "Large";
//						pizza.setSize("Large");
						data.setText(name + "\n" +size2);
					} else if (large.isSelected() == false) {
						data.setText(name);
					}
				}
			});
			medium.setToggleGroup(sizeGroup);
			medium.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					size2 = "medium";
					// manager.getPizzaList().get(0).setSize("Medium");
					if (medium.isSelected()) {
						size2 = "medium";
						data.setText(name+ "\n" + size2);
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
						size2 = "medium";
						data.setText(name + "\n" + size2);
					} else if (small.isSelected() == false) {
						data.setText(name);
					}
				}
			});

			cheeseCrust.setToggleGroup(crustGroup);
			cheeseCrust.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					crust2 = "Cheese - Crust";
//					pizza.setCrust("Cheese-Crust");
					data.setText(name + "\n" + size2 + "\n" + crust2);
				}
			});

			toastetCrust.setToggleGroup(crustGroup);
			toastetCrust.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					crust2 = "Toastet - Crust";
//					pizza.setCrust("Toastet - Crust");
					data.setText(name + "\n" + size2 + "\n" + crust2);
				}
			});

			thinCrust.setToggleGroup(crustGroup);
			thinCrust.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					crust2 = "Thin - Crust";
					// manager.getPizzaList().get(0).setCrust("Thin - Crust");
				
					data.setText(name + "\n" + size2 + "\n" + crust2);
				}
			});

			butterCrust.setToggleGroup(crustGroup);
			butterCrust.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					crust2 = "Butter - Crust";
					// manager.getPizzaList().get(0).setCrust("Butter - Crust");
			
					data.setText(name + "\n" + size2 + "\n" + crust2);
				}
			});
			
			rbBesteck.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					Besteck besteck = Besteck.getInstance(); 
					if(rbBesteck.isSelected()) {
					besteck.setBesteck(true);
					}
					if(besteck.getBesteck() == true) {
					data.setText(name + "\n" + size2 + "\n" + crust2 + "Besteck");
					}
				}
			});
			
			

//			cheeseTop.setOnAction(new EventHandler<ActionEvent>() {
//				public void handle(ActionEvent e) {
//					
//				
//					if (cheeseTop.isSelected()) {
//
//						data.setText( name + "\n" + size2 + "\n" + crust2 + "\n"
//								+ "Cheese-Top");
//						
//					} else if (cheeseTop.isSelected() == false) {
//						data.setText(name + "\n" + size2+ "\n" + crust2 + "\n");
//						
//					}
//				}
//			});
//
//			hamTop.setOnAction(new EventHandler<ActionEvent>() {
//
//				public void handle(ActionEvent e) {
//					
//					
//					if (hamTop.isSelected()) {
//
//						data.setText( name + "\n" + size2 + "\n" + crust2 + "\n"
//								+ "Cheese-Top");
//
//					
//					} else if (hamTop.isSelected() == false) {
//						data.setText(name + "\n" + size2+ "\n" + crust2 + "\n");
//					
//					}
//				}
//			});

//			pepperoniTop.setOnAction(new EventHandler<ActionEvent>() {
//
//				public void handle(ActionEvent e) {
//
//					
//					
//					if (pepperoniTop.isSelected()) {
//
//						data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust() + "\n"
//								+ pizza.getTopping(2));
//					
//					} else if (pepperoniTop.isSelected() == false) {
//						data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust() + "\n");
//						
//					}
//				}
//			});
//
//			olivesTop.setOnAction(new EventHandler<ActionEvent>() {
//
//				public void handle(ActionEvent e) {
//					
//					if (olivesTop.isSelected()) {
//
//						data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust() + "\n"
//								+ pizza.getTopping(3));
//						pizza.setPrice(price1);
//					} else if (olivesTop.isSelected() == false) {
//						data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust() + "\n");
//						pizza.setPrice(price2);
//					}
//				}
//			});
//		}
		Button addWarenkorb = new Button("Warenkorb hinzufügen");
		Button bestellen = new Button("bestellen");
		Button btnSpeichern = new Button("Speichern");
		
		fenster.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent e) {
				warenkorb.speichern();
			}
		});
		
		
		Button btnLaden = new Button("Laden");
		btnLaden.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			
				try {
					warenkorb.laden();
					warenkorbListe.addAll(warenkorb.getWarenkorb());
					warenkorbObservList.setItems(warenkorbListe); 
					warenkorbObservList.refresh();
					
					double i= warenkorb.preis(warenkorbListe);
					String sString = (new Double(i).toString());
					Gesamtpreiss.setText(sString+"€");	
					
				} catch (ClassNotFoundException e1) {
				
					e1.printStackTrace();
				} catch (IOException e1) {
				
					e1.printStackTrace();
				}
				warenkorbObservList.setItems(warenkorbListe); 
				warenkorbObservList.refresh();
			}
		});
		
		bestellen.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Stage kGUI = new Stage();
				KontaktGUI kontaktGUI = new KontaktGUI();
				kontaktGUI.warenkorb=warenkorb;
				try {
					kontaktGUI.start(kGUI);
					fenster.close();
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
//		
//		final Button btnGutschein = new Button("Gutschein auf alles");
//		final SimpleBooleanProperty isDisabled = new SimpleBooleanProperty();
//		btnGutschein.disableProperty().bind(isDisabled);
//		btnGutschein.setOnAction(new EventHandler<ActionEvent>(){
//			public void handle(ActionEvent e) {
//				for(int i = 0; i < warenkorbListe.size();i++) {
//					if(pizza.isGutschein() == false)
//					warenkorbListe.get(i).setPrice(gutschein.getNewPrice(pizza.getPrice()));
//					warenkorbListe.get(i).setGutschein(true);
//					warenkorbObservList.refresh();
//				}
//				isDisabled.setValue(false);
//			}
//		});

		addWarenkorb.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				if(name == "Salami") {
					pizza = Pizza.getInstance(name, 10.0, size2, crust2);
//					pizza = new Salami(name, 10.0, size2, crust2);
				}else if(name == "Tonno") {
					pizza = Pizza.getInstance(name, 8.0, size2, crust2);
//					pizza = new Tonno(name, 8.0, size2, crust2);
				}
				warenkorbListe.add(pizza);
				warenkorbObservList.refresh();
				
				double i= warenkorb.preis(warenkorbListe);
				String sString = (new Double(i).toString());
				Gesamtpreiss.setText(sString+"€");	
			}

		});
		Button btnSend = new Button("Absenden");
		btnSend.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				DialogUtil.showMessageDialog("Gesesndet", "Ihre Bestellung wurde versesndet");
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

		gpMain.add(rbBesteck, 1, 15);
//		gpMain.add(topping, 1, 14);
//		gpMain.add(toppingExtra, 1, 15);
//		gpMain.add(cheeseTop, 1, 16);
//		gpMain.add(hamTop, 1, 17);
//		gpMain.add(pepperoniTop, 1, 18);
//		gpMain.add(olivesTop, 1, 19);

		gpMain.add(yourPizza, 6, 0);
		gpMain.add(warenkorbList, 6, 11);

		gpMain.add(data, 6, 1, 1, 10);
		gpMain.add(addWarenkorb, 1, 20);
		gpMain.add(btnSpeichern, 2, 2);
		gpMain.add(btnLaden, 2, 3);

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
		primaryStage.setTitle("Pizza bestellen");
		primaryStage.show();

	}
}
