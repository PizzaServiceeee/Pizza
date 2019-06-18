package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

	public Connection connection;

	public Connection getConnection() {
		
		String url = "jdbc:mysql://localhost:3306/bibliothek?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//		String dbName = "bibliothek";
		String userName = "root";
		String password = "root";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url, userName, "" );
			System.out.println("Datenbankverbindung wird aufgebaut");
		} catch (Exception e) {
			System.out.println("Keine Verbindung möglich");
			e.printStackTrace();
		} 
		return connection;
	}

}
