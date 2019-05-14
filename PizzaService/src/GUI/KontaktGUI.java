package GUI;
import Logik.Pizza;
import Logik.Warenkorb;
import javafx.application.Application;
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
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class KontaktGUI
{
	
	GridPane gp;
	Scene scene1;
	protected TextField textField;
	protected Label label;
	protected Button button;
	protected Warenkorb warenkorb = new Warenkorb();
	
	public KontaktGUI() 
	{
		
	}
	
	
	public void start(Stage primaryStage) {

		final Stage fenster = primaryStage;
		gp = new GridPane();
		gp.setGridLinesVisible(true);
		scene1 = new Scene(gp,500,500);
		gp.setAlignment(Pos.CENTER);
		TextField vorname = new TextField("Vorname");
		Label vornamee = new Label("Vorname");
		TextField nachname = new TextField("Nachname");
		Label nachnamee = new Label("Nachnamee");
		TextField plz = new TextField("PLZ");
		Label plzz = new Label("PLZ");
		TextField straﬂe = new TextField("Straﬂe");
		Label straﬂee = new Label("Straﬂe");
		TextField ort = new TextField("Ort");
		Label ortt = new Label("Ort");
		Button liefern = new Button("liefern");
		Label warenkorbList = new Label("Warenkorb: ");
		TextField Gesamtpreiss = new TextField();
		Gesamtpreiss.setDisable(true);
		Label warenkorbPreis = new Label("Gesamtpreis: ");
		double i= warenkorb.preis(warenkorb.getWarenkorb());
		String sString = (new Double(i).toString());
		Gesamtpreiss.setText(sString+"Ä");
		gp.add(vorname, 3, 0);
		gp.add(vornamee, 2, 0);
		gp.add(nachname, 3, 1);
		gp.add(nachnamee, 2, 1);
		gp.add(plz, 3,2);
		gp.add(plzz, 2,2);
		gp.add(straﬂe, 3,3);
		gp.add(straﬂee, 2,3);
		gp.add(ort, 3,4);
		gp.add(ortt, 2,4);
		gp.add(liefern, 3, 5);
		gp.add(warenkorbPreis, 3,6);
		gp.add(Gesamtpreiss, 4,6);
		
		
		
		
		liefern.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Stage kGUI = new Stage();
				KontaktGUI kontaktGUI = new KontaktGUI();
				
				try {
					kontaktGUI.start(kGUI);
					fenster.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		ListView<Pizza> warenkorbObservList = new ListView<Pizza>((ObservableList<Pizza>) warenkorb.getWarenkorb());
		warenkorbObservList.setPrefSize(100, 50);
		gp.add(warenkorbObservList, 3, 7, 2, 3);
		
		fenster.setScene(scene1);
		fenster.setTitle("Kontaktdaten");
		fenster.show();
		
		
		
		
	}
	
	
}
