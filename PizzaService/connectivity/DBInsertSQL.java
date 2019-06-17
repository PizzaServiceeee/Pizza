//package connectivity;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javafx.application.Application;
//import javafx.stage.Stage;
//
//import java.sql.DriverManager;
//
//public class DBInsertSQL extends Application {
//
//		
//	public int eintragenVorname(String vorname) {
//		
//		ConnectionClass dbcc = new ConnectionClass();
//		Connection con = dbcc.getConnection();
//		try {
//		String sql = "INSERT INTO 'user' VALUES('"+ vorname+"')";
//		if(con != null) {
//		Statement st = con.createStatement();
//		return st.executeUpdate(sql);
//		}
//		}catch(SQLException e) {
//			return 0;
//		}
//		System.out.println("Vorname gespeichert");
//		return 0;
//	}
//
//	@Override
//	public void start(Stage arg0) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//		
//	}
//}
