/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utilities.DbConnection;
import beans.Booking;
import beans.Flight;
import beans.User;


/**
 * @author Admin
 *
 */
public class BookingsDao {
	
	public boolean addBookingFLights( int id,int flight)
	{
		int flag=0;
		boolean bliss=false;
		Connection connection = null;
		try {
			connection = DbConnection.getInstance().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String query = "insert into vsivadas.booking_flights(booking_id,flight_id) values(?,?)";
		java.sql.PreparedStatement ps = null;
		ResultSet rs;
		try {
			
			
			ps = connection.prepareStatement(query);
	//		java.sql.Date date=new java.sql.Date(book.getDate_of_booking().getTime());
			ps.setInt(1,id);
			ps.setInt(2, flight);
			
			flag=ps.executeUpdate();
			if(flag>0)
				{
				
			bliss= true;
				
				}
			else
				bliss=false;
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return bliss;	
	}
	//one 
	public ArrayList<Booking> getBookingHistory(int id)
	{	
		
		ArrayList<Booking> listing = new ArrayList<Booking>();
		
		Connection connection = null;
		try {
			connection = DbConnection.getInstance().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//String query = "select * from vsivadas.bookings where user_id=?";
		String query ="select b.booking_id,b.date_of_booking,b.number_of_seats,b.account_id,b.user_id,b.total_cost,f.source,f.destination,f.departure from vsivadas.bookings b join vsivadas.booking_flights bf ON b.booking_id=bf.booking_id join cse464.flights f ON bf.flight_id=f.id where b.user_id=?";
		java.sql.PreparedStatement ps = null;
		ResultSet rs;
		try {
			
			
			ps = connection.prepareStatement(query);
			//java.sql.Date date=new java.sql.Date(current.getDate_of_birth().getTime());
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next())
				{
				Flight tempo=new Flight();
				Booking temp=new Booking();
				temp.setAccount_id(rs.getInt("account_id"));
				//System.out.println(rs.getInt("booking_id"));
				temp.setBooking_id(rs.getInt("booking_id"));
				temp.setDate_of_booking(rs.getDate("date_of_booking"));
				temp.setNumber_of_seats(rs.getInt("number_of_seats"));
				temp.setTotal_cost(rs.getDouble("total_cost"));
				temp.setUser_id(rs.getInt("user_id"));
				tempo.setDeparture(rs.getDate("departure"));
				tempo.setSource(rs.getString("source"));
				tempo.setDestination(rs.getString("destination"));
				temp.setWings(tempo);
				listing.add(temp);
				
				}
//			for(Booking b: listing)
//			{
//				System.out.println("In the list"+b.getBooking_id());
//			}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listing;
	}
	public boolean addNewBooking(Booking book) throws SQLException
	{
		int flag=0;
		boolean bliss=false;
		Connection connection = null;
		try {
			connection = DbConnection.getInstance().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String query = "insert into vsivadas.bookings(booking_id,date_of_booking,number_of_seats,account_id,user_id,total_cost) values(?,?,?,?,?,?)";
		java.sql.PreparedStatement ps = null;
		ResultSet rs;
		try {
			
			
			ps = connection.prepareStatement(query);
			java.sql.Date date=new java.sql.Date(book.getDate_of_booking().getTime());
			ps.setInt(1, book.getBooking_id());
			ps.setDate(2, date);
			ps.setInt(3, book.getNumber_of_seats());
			ps.setInt(4, book.getAccount_id());
			ps.setInt(5, book.getUser_id());
			ps.setDouble(6,book.getTotal_cost());
			flag=ps.executeUpdate();
			if(flag>0)
				{
				
			bliss= true;
				
				}
			else
				bliss=false;
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return bliss;
	}
}
