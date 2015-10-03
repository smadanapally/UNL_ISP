package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import utilities.DbConnection;

public class AccountsDao
{

	public boolean validateAccount(int accntno,int rtngno,double amount)
	{
		boolean flag=false;
		Connection connection = null;
		try {
			connection = DbConnection.getInstance().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String query = "select balance from vsivadas.accounts where account_id=? AND routing_number=?";
		java.sql.PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			ps=connection.prepareStatement(query);
			ps.setInt(1, accntno);
			ps.setInt(2, rtngno);
			rs=ps.executeQuery();
			
			
			while (rs.next())
			{
			if(rs.getDouble("balance")<amount)
			{
				flag=false;
			}
			else{
				flag=false;
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return flag;
		
}
}