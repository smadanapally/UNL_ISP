package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private String driverName = "com.mysql.jdbc.Driver";

	private String dbUrl = "jdbc:mysql://cse.unl.edu:3306";

	private String userName = "vsivadas";

	private String password = "Uxy8ur";

	private static DBConnection dbConnection = null;

	private DBConnection() {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println();e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl, userName, password);
	}
	
	public static DBConnection getInstance(){
		if(dbConnection == null){
			dbConnection  = new DBConnection();
		}
		return dbConnection;
	}
	
	
}
