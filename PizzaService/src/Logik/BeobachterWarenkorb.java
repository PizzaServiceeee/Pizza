package Logik;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
import java.util.Date;

/**
 * BeobachterWarenkob observt den Warenkorb und erstellt eine Log datei sobald
 * ein Pizza Object erstellt wurde.
 * 
 * @author Marcel Rademacher und Lukas Niemeyer
 *
 */
public class BeobachterWarenkorb implements Observer {
	Date date = new Date();

	public BeobachterWarenkorb() {

	}
	
	/**Observer update() Methode
	 * Erstellt beim aufrufen ein Log File
	 * 
	 * @param o, arg
	 */
	@Override
	public void update(Observable o, Object arg) {
//		Properties pizza = new Properties();
//		
//		try {
//			FileOutputStream fos = new FileOutputStream("logging.cfg");
//			pizza.storeToXML(fos, "kein Kommentar");
//			
//		}catch(FileNotFoundException e){
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		try (FileWriter fw = new FileWriter("log.txt", true); BufferedWriter bw = new BufferedWriter(fw)) {
			bw.write("[" + date.toString() + "]" + ((Pizza) arg).getName() + ", " + ((Pizza) arg).getPrice() + ", "
					+ ", " + ((Pizza) arg).getCrust() + ", " + ((Pizza) arg).getSize());
			bw.newLine();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
