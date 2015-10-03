package utilities;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.AccountsDao;
import dao.BookingsDao;
import dao.TransactionsDao;
import beans.Booking;
import beans.Flight;

/**
 * Servlet implementation class TransactionConfirmation
 */
public class TransactionConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransactionConfirmation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
		System.out.println("In this servlet using ajax");
		int account_no=(Integer.parseInt(request.getParameter("acno")));
		ArrayList<Flight> temp = (ArrayList<Flight>) request.getSession().getAttribute("Shopping");
		System.out.println("in transaction confirmation servlet");
		//System.out.println(request.getParameter("acno"));
		//int account_no = Integer.parseInt(request.getParameter("acno"));
		for (int i = 0; i < temp.size(); i++) {
			System.out.println("IN THE FOR LOOP");
			Booking b2 = (Booking) (request.getSession().getAttribute("Booking"));
			double amount = temp.get(i).getFirst_class_reserved() * 100;

			b2.setNumber_of_seats(temp.get(i).getFirst_class_reserved());
			Random rand = new Random();
			rand.setSeed(System.currentTimeMillis());
			int booking_id = Math.abs(rand.nextInt());
			b2.setAccount_id(account_no);
			java.util.Date dateOfBooking = new java.util.Date(System.currentTimeMillis());
			b2.setDate_of_booking(dateOfBooking);
			b2.setBooking_id(booking_id);
			b2.setTotal_cost(amount);
			b2.setUser_id(Integer.parseInt((String) request.getSession().getAttribute("user")));

			request.getSession().setAttribute("Confirm", b2);

			BookingsDao bado = new BookingsDao();
			try {
				bado.addNewBooking(b2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ArrayList<Flight>
			// temp=(ArrayList<Flight>)request.getSession().getAttribute("flightdetails");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			// int index=(Integer)request.getSession().getAttribute("index");
			bado.addBookingFLights(booking_id, temp.get(i).getId());

		}
		System.out.println("DATA INSERTION IS OVER");
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		int order_id = Math.abs(rand.nextInt());
		String json = new Gson().toJson(order_id);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);

//		RequestDispatcher rd = request.getRequestDispatcher("TransactionConfirmation.jsp");
//		rd.forward(request, response);
	}

}
