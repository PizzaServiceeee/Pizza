package GUI;

import java.awt.Checkbox;
import java.util.ArrayList;

import Logik.DialogUtil;
import Logik.Pizza;
import Logik.PizzaManager;
import Logik.Salami;
import Logik.Warenkorb;
import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.*;

public class OrderGUI extends Application {

	protected GridPane gpMain;
	protected GridPane gpWaren;
	protected MenuBar menubar;
	protected Scene scene1;
	protected Scene scene2;
	protected PizzaManager manager = new PizzaManager();
	protected Warenkorb warenkorb = new Warenkorb();
	protected Pizza pizza;
	protected ArrayList<String> toppings = new ArrayList<String>();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		final Stage fenster = primaryStage;

		gpMain = new GridPane();
		// gpWaren = new GridPane();

		scene1 = new Scene(gpMain, 600, 600);
		// scene2 = new Scene(gpWaren, 350, 350);

		// ***Gridlines ersmal angemacht um besser abschätzen zu können wo die Elemente
		// itzen
		// gpMain.setGridLinesVisible(true);
		// gpWaren.setGridLinesVisible(true);
		gpMain.setVgap(10.0);
		gpMain.setHgap(20.0);

		Label pizzaTitle = new Label("Pizza auswählen: ");
		Label size = new Label("Pizza Size");
		Label crust = new Label("Crust");
		Label topping = new Label("Extra Topping: ");
		Label toppingExtra = new Label("+ 0.50 cents each");
		Label yourPizza = new Label("Your Pizza: ");
		Label warenkorbList = new Label("Warenkorb: ");

		TextArea data = new TextArea();
		data.setPrefSize(200, 200);
		data.setWrapText(true);
		ToggleGroup sizeGroup = new ToggleGroup();
		ToggleGroup crustGroup = new ToggleGroup();
		ToggleGroup pizzaGroup = new ToggleGroup();

		RadioButton addSalami = new RadioButton("Salami");
		addSalami.setToggleGroup(pizzaGroup);
		addSalami.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				pizza = new Salami("Salami", 10.00, "", "");

				data.setText(pizza.getName());

			}
		});
		RadioButton addTonno = new RadioButton("Tonno");
		addTonno.setToggleGroup(pizzaGroup);
		addTonno.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				pizza = new Salami("Tonno", 10.00, "", "");

				data.setText(pizza.getName());

			}
		});
		RadioButton extralarge = new RadioButton("Extra-Large");
		extralarge.setToggleGroup(sizeGroup);
		extralarge.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				if (extralarge.isSelected()) {
					pizza.setSize("Extra-Large");
					data.setText(pizza.getName() + "\n" + pizza.getSize());
				} else if (extralarge.isSelected() == false) {
					data.setText(pizza.getName());
				}
			}
		});
		RadioButton large = new RadioButton("Large");
		large.setToggleGroup(sizeGroup);
		large.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// manager.getPizzaList().get(0).setSize("Large");
				if (large.isSelected()) {
					pizza.setSize("Large");
					data.setText(pizza.getName() + "\n" + pizza.getSize());
				} else if (large.isSelected() == false) {
					data.setText(pizza.getName());
				}
			}
		});
		RadioButton medium = new RadioButton("Medium");
		medium.setToggleGroup(sizeGroup);
		medium.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// manager.getPizzaList().get(0).setSize("Medium");
				if (medium.isSelected()) {
					pizza.setSize("Medium");
					data.setText(pizza.getName() + "\n" + pizza.getSize());
				} else if (medium.isSelected() == false) {
					data.setText(pizza.getName());
				}
			}
		});
		RadioButton small = new RadioButton("Small");
		small.setToggleGroup(sizeGroup);
		small.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (small.isSelected()) {
					pizza.setSize("Small");
					data.setText(pizza.getName() + "\n" + pizza.getSize());
				} else if (small.isSelected() == false) {
					data.setText(pizza.getName());
				}
			}
		});
		RadioButton cheeseCrust = new RadioButton("cheese-Crust");
		cheeseCrust.setToggleGroup(crustGroup);
		cheeseCrust.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				pizza.setCrust("Cheese-Crust");
				data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust());
			}
		});
		RadioButton toastetCrust = new RadioButton("toastet");
		toastetCrust.setToggleGroup(crustGroup);
		toastetCrust.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// manager.getPizzaList().get(0).setCrust("Toastet - Crust");
				pizza.setCrust("Toastet - Crust");
				data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust());
			}
		});

		RadioButton thinCrust = new RadioButton("thin");
		thinCrust.setToggleGroup(crustGroup);
		thinCrust.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// manager.getPizzaList().get(0).setCrust("Thin - Crust");
				pizza.setCrust("Thin - Crust");
				data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust());
			}
		});
		RadioButton butterCrust = new RadioButton("butter");
		butterCrust.setToggleGroup(crustGroup);
		butterCrust.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				pizza.setCrust("Butter - Crust");
				data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust());
			}
		});
		CheckBox cheeseTop = new CheckBox("cheese");

		cheeseTop.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				double price = pizza.getPrice();

				if (cheeseTop.isSelected()) {
					price = price + 0.50;
					pizza.setPrice(price);
					data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust() + "\n"
							+ pizza.getTopping(0));

				} else if (cheeseTop.isSelected() == false) {
					data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust() + "\n");
				}
			}
		});
		CheckBox hamTop = new CheckBox("ham");
		hamTop.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				if (cheeseTop.isSelected()) {

					data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust() + "\n"
							+ pizza.getTopping(1));

				} else if (cheeseTop.isSelected() == false) {
					data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust() + "\n");

				}
			}
		});
		CheckBox pepperoniTop = new CheckBox("pepperoni");
		pepperoniTop.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				if (pepperoniTop.isSelected()) {

					data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust() + "\n"
							+ pizza.getTopping(2));

				} else if (pepperoniTop.isSelected() == false) {
					data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust() + "\n");
					// for (int i = 0; i < toppings.size(); i++) {
					// if (toppings.get(i) == top) {
					// toppings.set(i, null);
					// }
					// }
				}
			}
		});
		CheckBox olivesTop = new CheckBox("oliven");
		olivesTop.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				if (pepperoniTop.isSelected()) {

					data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust() + "\n"
							+ pizza.getTopping(3));

				} else if (pepperoniTop.isSelected() == false) {
					data.setText(pizza.getName() + "\n" + pizza.getSize() + "\n" + pizza.getCrust() + "\n");

				}
			}
		});
		Button addWarenkorb = new Button("Warenkorb hinzufügen");
		Button btnSend = new Button("Absenden");
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

		gpMain.add(topping, 1, 14);
		gpMain.add(toppingExtra, 1, 15);
		gpMain.add(cheeseTop, 1, 16);
		gpMain.add(hamTop, 1, 17);
		gpMain.add(pepperoniTop, 1, 18);
		gpMain.add(olivesTop, 1, 19);

		gpMain.add(yourPizza, 6, 0);
		gpMain.add(warenkorbList, 6, 11);

		gpMain.add(data, 6, 1, 1, 10);
		gpMain.add(addWarenkorb, 1, 20);

		addWarenkorb.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				warenkorb.add(pizza);

			}

		});
		btnSend.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				DialogUtil.showMessageDialog("Gesesndet", "Ihre Bestellung wurde versesndet");
			}
		});

		ListView<Pizza> warenkorbObservList = new ListView<Pizza>((ObservableList<Pizza>) warenkorb.getWarenkorb());
		warenkorbList.setPrefSize(100, 50);

		gpMain.add(warenkorbObservList, 6, 12, 1, 10);

		primaryStage.setScene(scene1);
		primaryStage.setTitle("Pizza bestellen");
		primaryStage.show();

	}
}
