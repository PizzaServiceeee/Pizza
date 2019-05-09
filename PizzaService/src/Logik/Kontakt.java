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
	private ObservableList<Pizza> warenkorb;
	
	
	public Kontakt()
	{
		
	}
	
	public Kontakt(String vorname, String nachname, String plz, String stra�e, String wohnort)
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
	public String toString()
	{
		return "Kunde [vorname=" + vorname + ", nachname=" + nachname + ", plz=" + plz + ", stra�e=" + stra�e
				+ ", wohnort=" + wohnort + "]";
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
	
	
	
}
