package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ZutatenGUI extends Stage {
	GridPane gp;
	Scene scene;
	CheckBox gyros;
	CheckBox salami;
	CheckBox thunfisch;

	public ZutatenGUI(Stage primaryStage) {
		this.initOwner(primaryStage);
		this.initModality(Modality.WINDOW_MODAL);

	}

	public void showView() throws Exception {

		gp = new GridPane();
		scene = new Scene(gp, 200, 200);

		Label auswahl = new Label("Bitte wählen");

		gyros = new CheckBox("Gyros");
		salami = new CheckBox("Salami");
		thunfisch = new CheckBox("Thunfisch");
		Button ok = new Button("Ok");

		gp.add(auswahl, 1, 1);
		gp.add(gyros, 1, 3);
		gp.add(salami, 1, 4);
		gp.add(thunfisch, 1, 5);

		if (gyros.isSelected()) {

		}
	
		this.setScene(scene);
		this.show();
	}

}
