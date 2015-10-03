package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private String driverName = "com.mysql.jdbc.Driver";

	private String dbUrl = "jdbc:mysql://cse.unl.edu:3306";

	private String userName = "vsivadas";

	private String password = "Uxy8ur";

	private static DbConnection dbConnection = null;

	private DbConnection() {
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
	
	public static DbConnection getInstance(){
		if(dbConnection == null){
			dbConnection  = new DbConnection();
		}
		return dbConnection;
	}
	
	
}