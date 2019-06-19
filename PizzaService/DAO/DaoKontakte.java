package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

import Logik.Kontakt;

public class DaoKontakte extends DaoGeneric<Kontakt> {

	private final static String TABLENAME = DbTable.USER.toString();
	private int ID = 0;
	private final String vorname = "vorname";
	private final String nachname = "nachname";
	private final String plz = "plz";
	private final String straﬂe = "straﬂe";
	private final String wohnort = "wohnort";
	private final String email = "email";
	private final String telefonnummer = "telefonnummer";

	public DaoKontakte(Connection con) {
		super(con, TABLENAME);

	}

	public void speichern(String vorname, String nachname, String plz, String straﬂe, String wohnort, String email,
			String telefonnummer) {
		
		String sql = "INSERT INTO user (ID, vorname, nachname, plz, straﬂe, wohnort, email, telefonnummer) "
				+ "VALUES('" + ID + "','" + vorname + "','" + nachname + "','" + plz + "','" + straﬂe + "','" + wohnort + "','" + email + "','"
				+ telefonnummer + "')";
		Statement st;
		try {
			st = this.con.createStatement();
			st.executeUpdate(sql);
			this.ID++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int count() {
		String query = "SELECT COUNT(*) as count FROM" + TABLENAME;
		PreparedStatement prepStateCounter;
		int recordCount = 0;

		try {
			prepStateCounter = this.con.prepareStatement(query);
			ResultSet res = prepStateCounter.executeQuery();
			if (res.next()) {
				recordCount = res.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			recordCount = -1;
		}
		return recordCount;
	}

	@Override
	public Kontakt getRecord(int id) {
		ResultSet res = null;
		Kontakt selectedRecord = null;

		String query = "SELECT " + id + ", " + vorname + ", " + nachname + ", " + plz + ", " + straﬂe + ", " + wohnort
				+ ", " + email + ", " + telefonnummer + ", " + " FROM " + TABLENAME + " WHERE " + id + "= ?";

		try {
			PreparedStatement prepStatement = this.con.prepareStatement(query);
			prepStatement.setInt(1, id);
			res = prepStatement.executeQuery();
			if (res.next()) {
				selectedRecord = new Kontakt(res.getString(vorname), res.getString(nachname), res.getString(plz),
						res.getString(straﬂe), res.getString(wohnort), res.getString(email),
						res.getString(telefonnummer));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return selectedRecord;
	}

}
