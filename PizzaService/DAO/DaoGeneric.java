package DAO;

import java.sql.Connection;

public abstract class DaoGeneric<T> {

	protected final String tableName;
	protected Connection con;

	protected DaoGeneric(Connection con, String tableName) {
		this.con = con;
		this.tableName = tableName;
	}

	public abstract void speichern(String vorname, String nachname, String plz, String straﬂe, String wohnort,
			String email, String telefonnummer);

	public abstract int count();

	public abstract T getRecord(int id);

}
