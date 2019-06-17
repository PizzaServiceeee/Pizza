package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

	public Connection connection;

	public Connection getConnection() {

		String dbName = "bibliothek";
		String userName = "root";
		String password = " ";

		try {
			
			Class.forName("com.mysql.jdbc.Driver'");
			
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
		
		} catch (ClassNotFoundException e) {
		
		} catch (SQLException e) {
	
		}

		return connection;
	}

}
