package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DaoManager {

	INSTANCE;
	
	public Connection connection;

	public Connection getConnection() {
		
		String url = "jdbc:mysql://localhost:3306/bibliothek?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//		String dbName = "bibliothek";
		String userName = "root";
		String password = "root";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url, userName, "root" );
			System.out.println("Datenbankverbindung wird aufgebaut");
		} catch (Exception e) {
			System.out.println("Keine Verbindung möglich");
			e.printStackTrace();
		} 
		return connection;
	}
	
	public void open() {
		try {
			if(this.connection == null || this.connection.isClosed()){
				this.connection = getConnection();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(this.connection != null || !this.connection.isClosed()) {
				this.connection.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public DaoGeneric getDao(DbTable table) {
		
		DaoGeneric dao = null;
		try {
			if(this.connection == null || this.connection.isClosed()) {
				this.open();
			}
			switch(table) {
			case USER:
				dao = new DaoKontakte(this.connection);
				break;
			default:
				dao = null;
				break;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return dao;
		
	}
	
	
	
	
	
}
