

import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.*;

public class OrderGUI extends Application {

	//*** Hi
	//*** GUI steht soweit und ein kleiner Teil Logik. Das hei� man kann mit dem momentanen Code im ersten Fenster
	//*** welches sich beim Ausf�hren �ffnet seine Pizza ausw�hlen und wie mit Lukas besprochen mit "+" und "-" 
	//*** dem Warenkorb hinzuf�gen. Der Warenkorb an sich �ffnet man mit dem Button "Warenkorb",
	//*** Dort habe ich eine ObservableList hinzugef�gt wo die Pizzen angezeigt werden�nachdem man "+"gedr�ckt hat.
	//*** Geht man zur�ck und dr�ckt "-" l�scht man den Eitnrag wieder. Da m�ssten wir uns vllt was besseres �berlegen,
	//*** das man direkt auf der Warenkorb Scene l�schen kann. Habe da noch keine Idee.
	protected GridPane gpMain;
	protected GridPane gpWaren;
	protected MenuBar menubar;
	protected Scene scene1;
	protected Scene scene2;
	protected PizzaManager manager = new PizzaManager();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		final Stage fenster = primaryStage;
		
		//*** Zwei GrudPanes
		//*** gpMain f�r die Hauptseite wo bestellt wird.
		//*** gpWaren f�r die Warenkorbseite.
		gpMain = new GridPane();
		gpWaren = new GridPane();

		
		//***Zwei Scenen 
		//*** Scene1 ist die "Bestell" Seite
		//*** Scene2 ist die Warenkorb Seite.
		scene1 = new Scene(gpMain, 200, 200);
		scene2 = new Scene(gpWaren, 200, 200);
		
		//***Gridlines ersmal angemacht um besser absch�tzen zu k�nnen wo die Elemente itzen
		gpMain.setGridLinesVisible(true);
		gpWaren.setGridLinesVisible(true);
		
		
		Label salami = new Label("Pizza Salami");
		Label tonno = new Label("Pizza Tonno");
		Button btnWaren = new Button("Warenkorb");
		Button btnPizza = new Button("Zur�ck zur Bestellung");
		Button addSalami = new Button("+");
		Button delSalami = new Button("-");
		Button addTonno = new Button("+");
		Button delTonno = new Button("-");
		gpMain.add(salami, 1, 1);
		gpMain.add(tonno, 1, 2);
		gpMain.add(addSalami, 2, 1);
		gpMain.add(delSalami, 3, 1);
		gpMain.add(addTonno, 2, 2);
		gpMain.add(delTonno, 3, 2);
		gpMain.add(btnWaren, 1, 3);
		
		addSalami.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				manager.add(new Salami("Salami", 8.00));
			}
		});
		
		delSalami.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				manager.delete();
			}
		});
		addTonno.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				manager.add(new Tonno("Tonno", 9.00));
			}
		});
		
		delTonno.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				manager.delete();
			}
		});
		
		//*** Scene2 der Warenkorb �ffnet sich nach d�cken des "Warenkorb" Button.
		btnWaren.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				fenster.setScene(scene2);
				fenster.show();
			}
		});
		
		//*** Scene1 die Standard Scene welches sich auch beim Ausf�hren als erstes �ffnet, 
		//*** kann im Warenkorb durch dr�cken des "Zur�ck zu Bestellung" Button wieder audgerufen werden.
		btnPizza.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				fenster.setScene(scene1);
				fenster.show();
			}
		});
		
		ListView<Pizza> warenkorbList = new ListView<Pizza>((ObservableList<Pizza>) manager.getWarenkorb());
		
		gpWaren.add(warenkorbList,1,2);		
		gpWaren.add(btnPizza, 1, 3);

		primaryStage.setScene(scene1);
		primaryStage.setTitle("Pizza bestellen");
		primaryStage.show();

	}
}
