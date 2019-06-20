package Logik;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Kontakt implements Drucker
{
	private int id =0;
	private int number =0;
	private String vorname;
	private String nachname;
	private String plz;
	private String straﬂe;
	private String wohnort;
	private String email;
	private String telefonnummer;
	private List<Pizza> warenkorb;
	protected Warenkorb warenkorbb = new Warenkorb();
	
	
	public Kontakt()
	{ 
		
	}
	
	public Kontakt(String vorname, String nachname, String plz, String straﬂe, String wohnort, String email,
			String telefonnummer)
	{
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.plz = plz;
		this.straﬂe = straﬂe;
		this.wohnort = wohnort;
		this.email = email;
		this.telefonnummer = telefonnummer;
		this.warenkorb = warenkorb;
	}


	
	
	
	public String getVorname()
	{
		return vorname;
	}
	
	public void setVorname(String vorname)
	{
		this.vorname = vorname;
	}
	
	public String getNachname()
	{
		return nachname;
	}
	
	public void setNachname(String nachname)
	{
		this.nachname = nachname;
	}
	
	public String getPlz()
	{
		return plz;
	}
	
	public void setPlz(String plz)
	{
		this.plz = plz;
	}
	
	public String getStraﬂe()
	{
		return straﬂe;
	}
	
	public void setStraﬂe(String straﬂe)
	{
		this.straﬂe = straﬂe;
	}
	
	public String getWohnort()
	{
		return wohnort;
	}
	
	public void setWohnort(String wohnort)
	{
		this.wohnort = wohnort;
	}


	@Override
	public void drucken()
	{
		System.out.println(this.toString());
	}
	
	public void bestellt(ObservableList<Pizza> warenkorbb)
	{
		warenkorbb = FXCollections.<Pizza>observableArrayList();
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getTelefonnummer()
	{
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer)
	{
		this.telefonnummer = telefonnummer;
	}
	
	public long emailwert()
	{
		 long o=0;
		 String g= "Abcdef@googlemail.com".toLowerCase();
		 String dd="abcdefghijklmnopqrstuvwxyz@.";
		 for(int i=0; i < g.length(); i++){
		    o =o+(dd.indexOf(g.charAt(i))+1);
		 }
		 return o;
	}


	public String exportiereAlsCsv()
	{
		return this.toString();
	}

	@Override
	public String toString()
	{
		return vorname +  ";" + nachname + ";" + plz + ";" + straﬂe
				+ ";" + wohnort + ";" + telefonnummer + ";" + email +  ";" + warenkorb+";" +warenkorbb.preis(warenkorb);
			
	}
	

	
}
