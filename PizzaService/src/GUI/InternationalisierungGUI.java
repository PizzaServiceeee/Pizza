package GUI;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InternationalisierungGUI extends Application {

	protected Scene scene1;
	protected GridPane gp;
	protected ResourceBundle bundle = ResourceBundle.getBundle("Properties.OrderGUI_en");
	protected int resNumber;

	public InternationalisierungGUI() {
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {

		final Stage fenster = primaryStage;
		gp = new GridPane();
		scene1 = new Scene(gp, 200,200);

		Button btnUS = new Button("US");
		Button btnDE = new Button("DE");

		btnUS.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Stage oGUI = new Stage();
				OrderGUI orderGUI = new OrderGUI();
				bundle = ResourceBundle.getBundle("Properties.OrderGUI_en");
				resNumber = 2;
				orderGUI.languageBundle = bundle;
				orderGUI.resNumber = resNumber;
				try {
					orderGUI.start(oGUI);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				fenster.close();
			}
		});

		btnDE.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Stage oGUI = new Stage();
				OrderGUI orderGUI = new OrderGUI();
				bundle = ResourceBundle.getBundle("Properties.OrderGUI_de");
				resNumber = 1;
				orderGUI.languageBundle = bundle;
				orderGUI.resNumber = resNumber;
				try {
					orderGUI.start(oGUI);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				fenster.close();
			}
		});
		Label sprache = new Label("Bitte Wählen Sie Ihre Sprache aus");
		Label language = new Label("Please choose ur Language");
		gp.add(sprache, 0, 0);
		gp.add(language, 0, 1);
		gp.add(btnUS, 0, 3);
		gp.add(btnDE, 0, 4);

		fenster.setScene(scene1);
		fenster.setTitle("Internationalisierung");
		fenster.show();
	}

}
