package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Logik.Kontakt;

public interface DaoInterface<T>{
	
	public abstract void insertKontakt( String vorname, String nachname, String plz, String straﬂe, String wohnort,
			String email, String telefonnummer);
	
	public abstract Kontakt findKontakt();
}
