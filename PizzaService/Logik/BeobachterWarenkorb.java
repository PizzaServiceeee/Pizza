package Logik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Date;

public class BeobachterWarenkorb implements Observer {
	Date date = new Date();

	public BeobachterWarenkorb() {

	}

	@Override
	public void update(Observable o, Object arg) {
		
		
		try (FileWriter fw = new FileWriter("log.txt", true); BufferedWriter bw = new BufferedWriter(fw)) {
			bw.write("[" + date.toString() + "]" + ((Pizza) arg).getName() + ", " + ((Pizza) arg).getPrice() + ", "
					+ ", " + ((Pizza) arg).getCrust() + ", " + ((Pizza) arg).getSize());
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
