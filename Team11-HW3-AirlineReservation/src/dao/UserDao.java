package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import utilities.DbConnection;
import beans.Client;
import beans.Organization;
import beans.User;

public class UserDao {
	
	public Client getUserDetails(int userId)
	{
		Connection connection=null;
		
		User user=new User();
		Organization org=new Organization();
		
		try {
			connection = DbConnection.getInstance().getConnection();
					} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
					}
			String query="select * from vsivadas.users where user_id=?";
			java.sql.PreparedStatement ps;
			ResultSet rs;

			try {
				ps = connection.prepareStatement(query);
				ps.setInt(1, userId);
				rs=ps.executeQuery();
				if(rs.next())
				{
					user.setUserId(rs.getInt("user_id"));
					user.setEmailaddress(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					org.setOrganization(rs.getString("organization"));
					org.setAddress(rs.getString("address"));
					user.setUsername(rs.getString("user_name"));
					user.setDate_of_birth(rs.getDate("date_of_birth"));
						
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Client client=new Client(user,org);
		return client;
	}
	public boolean userValidation(int userid,String passwd)
	{
		boolean flag=false;
		Connection connection=null;
		try {
			connection = DbConnection.getInstance().getConnection();
					} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
					}
			String query="select * from vsivadas.users where user_id=? AND password=?";
			java.sql.PreparedStatement ps;
			ResultSet rs;

			try {
				ps = connection.prepareStatement(query);
				ps.setInt(1, userid);
				ps.setString(2,passwd);
				rs=ps.executeQuery();
				if(rs.next())
				{
					flag=true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		return flag;
	
	}
	public boolean addNewUser(Client cli)
	
	{
		//User usr=new User();
		int flag=0;
		Connection connection=null;
		try {
			connection = DbConnection.getInstance().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String query="insert into vsivadas.users(user_id,password,email,date_of_birth,organization,address,user_name) values(?,?,?,?,?,?,?)";
		try {
			System.out.println(cli.org.getOrganization());
			System.out.println(cli.org.getAddress());
			java.sql.Date jsd=new java.sql.Date(cli.user.getDate_of_birth().getTime());
			java.sql.PreparedStatement ps= connection.prepareStatement(query);
			ps.setInt(1, cli.user.getUserId());
			ps.setString(2, cli.user.getPassword());
			ps.setString(3, cli.user.getEmailaddress());
			ps.setDate(4, jsd);
			ps.setString(5, cli.org.getOrganization());
			ps.setString(6,cli.org.getAddress());
			ps.setString(7,cli.user.getUsername());
			flag=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			
		}
		if(flag>0)
		{
	return true;
		}
		else{
			return false;
		}
	}
}
