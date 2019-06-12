package connectivity;

import connectivity.ConnectionClass;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class dbMain {

	public static void main(String[] args) throws SQLException {
		ConnectionClass dbcc = new ConnectionClass();
		
		Connection connection = dbcc.getConnection();
		String sql = "INSERT INTO 'user' VALUES('bibliothek');";
		Statement st = connection.createStatement();
		st.executeUpdate(sql);

		System.out.println("data entered");

	}

}
