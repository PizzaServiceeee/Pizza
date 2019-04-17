package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WilkommenGUI extends Application {
	
	
	GridPane gp;
	Scene scene1;
	
	public WilkommenGUI() {
		
	}
	
	public static void main (String[]args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		 
		final Stage fenster = primaryStage;
		gp = new GridPane();
	
		
		scene1 = new Scene(gp,300,300);
//		gp.setGridLinesVisible(true);
		gp.setAlignment(Pos.CENTER);
		Text wilkommen = new Text("Wilkommen");
		Text pizzaservice = new Text("Pizza Service");
		Button bestellen = new Button("Pizza bestellen");
		
		gp.add(wilkommen, 3, 0);
		gp.add(pizzaservice, 3, 1);
		gp.add(bestellen, 3,2);

		gp.setVgap(20);
		bestellen.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Stage oGUI = new Stage();
				OrderGUI orderGUI = new OrderGUI();
				try {
					orderGUI.start(oGUI);
					fenster.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Wilkommen beim Pizza Service");
		primaryStage.show();
		
		
		
	}

}
