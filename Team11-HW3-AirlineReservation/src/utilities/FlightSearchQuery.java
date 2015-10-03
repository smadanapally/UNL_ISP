package utilities;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FlightsDao;
import beans.Flight;
import beans.FlightSearch;

/**
 * Servlet implementation class FlightSearch
 */
public class FlightSearchQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlightSearchQuery() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Flight> flightobj=new ArrayList<Flight>();
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String comfort=request.getParameter("class");
		String dum=request.getParameter("doj");
		SimpleDateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
		Date doj=null;
		Date journey=null;
		try {
			doj=dtf.parse(dum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FlightSearch fs=new FlightSearch(source,destination,comfort,doj);
		FlightsDao fd=new FlightsDao();
		flightobj=fd.findFlights(fs);


		HttpSession flightsession=request.getSession();
		flightsession.setAttribute("flightdetails", flightobj);

		//RequestDispatcher rd = request.getRequestDispatcher("flightsearchresult.jsp");
		//rd.forward(request, response);
		String encodedURL = response.encodeRedirectURL("flightsearchresult.jsp");
		response.sendRedirect(encodedURL);
	}

}
