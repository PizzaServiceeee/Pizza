package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

import Logik.Kontakt;

public class DaoKontakte implements DaoInterface<Kontakt> {

	private final static String TABLENAME = DbTable.USER.toString();
	protected Connection con;

//	private final String vorname = "vorname";
//	private final String nachname = "nachname";
//	private final String plz = "plz";
//	private final String straﬂe = "straﬂe";
//	private final String wohnort = "wohnort";
//	private final String email = "email";
//	private final String telefonnummer = "telefonnummer";

	public DaoKontakte(Connection con) {
		this.con = con;
	}

	@Override
	public Kontakt findKontakt() {
		ResultSet res = null;
		Kontakt selectedRecord = null;
		Statement st = null;
		String query = "SELECT * FROM user ORDER BY id DESC;";

		try {
			st = con.createStatement();
			res = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			res.next();
			String vorname = res.getString(2);
			String nachname = res.getString(3);
			String plz = res.getString(4);
			String straﬂe = res.getString(5);
			String wohnort = res.getString(6);
			String email = res.getString(7);
			String telefonnummer = res.getString(8);
			selectedRecord = new Kontakt(vorname, nachname, plz, straﬂe, wohnort, email, telefonnummer);
			return selectedRecord;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public void insertKontakt(String vorname, String nachname, String plz, String straﬂe, String wohnort, String email,
			String telefonnummer) {

		String sql = "INSERT INTO user ( vorname, nachname, plz, straﬂe, wohnort, email, telefonnummer) " + "VALUES('"
				+ vorname + "','" + nachname + "','" + plz + "','" + straﬂe + "','" + wohnort + "','" + email + "','"
				+ telefonnummer + "')";
		Statement st;
		try {
			st = this.con.createStatement();
			st.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
