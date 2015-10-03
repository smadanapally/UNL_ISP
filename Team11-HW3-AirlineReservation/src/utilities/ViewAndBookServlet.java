 package utilities;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FlightsDao;
import beans.Booking;
import beans.Flight;

import com.google.gson.Gson;


/**
 * Servlet implementation class ViewAndBookServlet
 */
public class ViewAndBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAndBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside View and book Servlet");
		ArrayList<Flight> temp=(ArrayList<Flight>)request.getSession().getAttribute("flightdetails");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		int index=(Integer)request.getSession().getAttribute("index");
	
		String source=temp.get(index).getSource();
		String destination=temp.get(index).getDestination();
		int flightno=temp.get(index).getFlightno();
		
		int notickets=Integer.parseInt(request.getParameter("number"));
		//int notickets=Integer.parseInt(request.getParameter("seat"));
		Flight f1=new Flight();
		f1=temp.get(index);
		f1.setFirst_class_reserved(notickets);
		
		
		//ArrayList<Flight> temp3=(ArrayList<Flight>)request.getSession().getAttribute("Shopping");
		//temp3.add(f1);
		
		Booking b1=new Booking();
		

        b1.setNumber_of_seats(notickets);
		request.getSession().setAttribute("Booking", b1);
		FlightsDao fd=new FlightsDao();
		try {
			
		if(	fd.viewFlights(notickets, source, destination,flightno))
		{
			System.out.println("Seats accepted");
			int sum=(Integer)(request.getSession().getAttribute("sum"));
			sum+=notickets*100;
			request.getSession().setAttribute("sum", sum);
			ArrayList<Flight> shpng=(ArrayList<Flight>) request.getSession().getAttribute("Shopping");
			shpng.add(f1);
			String strings="Seats are available";
			String json = new Gson().toJson(strings);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
			//RequestDispatcher rd = request.getRequestDispatcher("Shoppingcart.jsp");
			//rd.forward(request, response);
			
			
		}
		else{
			System.out.println("Seats not accepted");
			String message = "No of seats requested are not available Kindly renter the no of seats again";
			request.setAttribute("message", message);
			String strings="Seats are not accepted";
			 String json = new Gson().toJson(strings);
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
