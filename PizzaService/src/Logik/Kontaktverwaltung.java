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

/**
 * Kontaktverwaltung dient zu Verwaltung von Kontakt Objekten
 *  
 * @author Marcel Rademacher und Lukas Niemeyer
 *
 */

public class Kontaktverwaltung
{
	ObservableList<Kontakt> Kontaktliste;
	
	
	public Kontaktverwaltung()
	{
		Kontaktliste = FXCollections.<Kontakt> observableArrayList();
	} 
	
	/**
	 * Adds a Contact to List.
	 * @param einVerKontakt
	 */
	public void hinzufuegen(Kontakt einVerKontakt) 
	{
				for (Kontakt einEintrag : Kontaktliste)
				if (einEintrag.getEmail().equals(einVerKontakt.getEmail()))
					return;	
				Kontaktliste.add(einVerKontakt);		
	}
	
	/**
	 * Exports the whole Contact List as CSV
	 * @param datei
	 * @throws FileNotFoundException, IOException
	 */
	public void exportiereEintraegeAlsCsv(File datei) throws FileNotFoundException, IOException
	{
		try (OutputStream os = new FileOutputStream(datei))
		{
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
