package DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum DaoManager {

	INSTANCE;
	
	protected Connection connection;

	public Connection getConnection() {
		
//		String url = "jdbc:mysql://localhost:3306/bibliothek?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//		String dbName = "bibliothek";
//		String userName = "root";
//		String password = "root";

		try {
			InputStream in = this.getClass().getResourceAsStream("/dbSettings.proberties");
			Properties proberties = new Properties();
			proberties.load(in);
			in.close();
			
			String dbHost = proberties.getProperty("db.host");
			String dbPort = proberties.getProperty("db.Port");
			String dbName = proberties.getProperty("db.name");
			String dbUser = proberties.getProperty("db.user");
			String dbPassword = proberties.getProperty("db.password");
			
			String url = "jdbc:mysql://"+dbHost+ ":" + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = (Connection) DriverManager.getConnection(url, dbUser, "" );
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
	
	public DaoKontakte getDao(DbTable table) {
		
		DaoKontakte dao = null;
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
