package utilities;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Booking;
import dao.BookingsDao;

/**
 * Servlet implementation class BookingHistory
 */
public class BookingHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		int user_id=Integer.parseInt((request.getSession().getAttribute("user").toString()));
		BookingsDao bad=new BookingsDao();
		//Booking book_history=new Booking();
		ArrayList<Booking> history=new ArrayList<Booking>();
		history=bad.getBookingHistory(user_id);
//		System.out.println("size of the history"+history.size());
//		for(Booking b:history)
//		{
//			System.out.println(b.getBooking_id());
//		}
	request.getSession().setAttribute("history", history);
	String encodedURL = response.encodeRedirectURL("BookingHistory.jsp");
	response.sendRedirect(encodedURL);
	
	// RequestDispatcher rd = request.getRequestDispatcher("BookingHistory.jsp");
		//rd.forward(request, response);

	}

}
