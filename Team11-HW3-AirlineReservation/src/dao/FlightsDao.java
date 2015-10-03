/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import utilities.DbConnection;
import beans.Flight;
import beans.FlightSearch;

/**
 * @author Admin
 *
 */
public class FlightsDao {

	public Flight getFlightDetails(int flightId) {
		return null;
	}

	public ArrayList<Flight> findFlights(FlightSearch fs) {
		ArrayList<Flight> fl = new ArrayList<Flight>();
		Connection connection = null;
		try {
			connection = DbConnection.getInstance().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String query = "select * from cse464.flights where source=? AND destination=? AND departure LIKE ?";
		java.sql.PreparedStatement ps = null;
		ResultSet rs;

		try {
			java.sql.Date jsd = new java.sql.Date(fs.getDoj().getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String datestring = sdf.format(fs.getDoj());
			java.util.Date jf;
			java.util.Date jr;
			ps = connection.prepareStatement(query);
			ps.setString(1, fs.getSource());
			ps.setString(2, fs.getDestination());
			ps.setString(3, datestring + "%");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				jf=new java.util.Date(rs.getTimestamp("departure").getTime());
				jr=new java.util.Date(rs.getTimestamp("arrival").getTime());
			
				Flight flight = new Flight(rs.getInt("id"),rs.getInt("plane"), rs.getString("operator"), rs.getString("source"),
						rs.getString("destination"), rs.getInt("first_class_reserved"), rs.getInt("business_reserved"),
						rs.getInt("economy_reserved"), jf, jr);
				fl.add(flight);
			}

		} catch (SQLException e) {
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
		return fl;
	}
	
	public boolean viewFlights(int seats,String source,String dest,int flightno) throws SQLException 
	{
		boolean flag=false;
		Connection connection = null;
		try {
			connection = DbConnection.getInstance().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String query = "select p.economy_capacity as pe,f.economy_reserved as fe from cse464.flights f join cse464.planes p on f.plane=p.id where source=? AND destination=? AND plane=? limit 1";
		java.sql.PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			ps=connection.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ps.setString(1, source);
		
		ps.setString(2, dest);
		ps.setInt(3, flightno);
		rs=ps.executeQuery();
		while(rs.next())
		{
		if((rs.getInt("pe") - rs.getInt("fe"))>=seats)
		{
			flag= true;
		}
		else
		{
			flag=false;
		}
	
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			ps.close();
			connection.close();
		}

	return flag;
	}
}
