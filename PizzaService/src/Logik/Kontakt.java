package Logik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Kontakt implements Drucker
{


	private String vorname;
	private String nachname;
	private String plz;
	private String stra�e;
	private String wohnort;
	private String email;
	private String telefonnummer;
	private ObservableList<Pizza> warenkorb;
	
	
	public Kontakt()
	{
		
	}
	
	public Kontakt(String vorname, String nachname, String plz, String stra�e, String wohnort, String email,
			String telefonnummer, ObservableList<Pizza> warenkorb)
	{
		this.vorname = vorname;
		this.nachname = nachname;
		this.plz = plz;
		this.stra�e = stra�e;
		this.wohnort = wohnort;
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
	
	public String getStra�e()
	{
		return stra�e;
	}
	
	public void setStra�e(String stra�e)
	{
		this.stra�e = stra�e;
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
		return "Kontakt [vorname=" + vorname + ", nachname=" + nachname + ", plz=" + plz + ", stra�e=" + stra�e
				+ ", wohnort=" + wohnort + ", email=" + email + ", telefonnummer=" + telefonnummer + ", warenkorb="
				+ warenkorb + "]";
	}
	
	
}
