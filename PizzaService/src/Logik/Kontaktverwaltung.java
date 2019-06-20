package Logik;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Kontaktverwaltung
{
	ObservableList<Kontakt> Kontaktliste;
	
	
	public Kontaktverwaltung()
	{
		Kontaktliste = FXCollections.<Kontakt> observableArrayList();
	} 
	
	public void hinzufuegen(Kontakt einVerKontakt) 
	{
				for (Kontakt einEintrag : Kontaktliste)
				if (einEintrag.getEmail().equals(einVerKontakt.getEmail()))
					return;	
				Kontaktliste.add(einVerKontakt);		
	}
	

	public void exportiereEintraegeAlsCsv(File datei) throws FileNotFoundException, IOException
	{
		try (OutputStream os = new FileOutputStream(datei))
		{
			// STring auch mit get bytes dann geht auch outputstream
			String l = "Vorname" + ";" + "Nachname" + ";" + "PLZ" + ";" + "Straﬂe" + ";" + "Wohnort" + ";"
					+ "Email" + ";" + "Telefonnummer" + ";" + "Warenkorb" + ";" + "GesamtPreis" + "\n";
			l.getBytes();
			os.write(l.getBytes());
			for (Kontakt einEintrag : Kontaktliste)
			{
				os.write(einEintrag.exportiereAlsCsv().getBytes());
			}

		}
	}
	
}
