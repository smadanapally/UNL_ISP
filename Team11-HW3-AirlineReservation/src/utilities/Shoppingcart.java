package utilities;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Flight;

import com.google.gson.Gson;

/**
 * Servlet implementation class Shoppingcart
 */
public class Shoppingcart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Shoppingcart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Gson gson = new Gson();
		int sum = 0;
		System.out.println("Inside shopping cart servlet ");
		int index = Integer.parseInt(request.getParameter("element"));
		ArrayList<Flight> temp = (ArrayList<Flight>) request.getSession()
				.getAttribute("Shopping");
		sum=(Integer)request.getSession().getAttribute("sum");
		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).getFlightno() == index)
				System.out.println("Sum is :"+(temp.get(i).getFirst_class_reserved())*100);	
				sum-=temp.get(i).getFirst_class_reserved()*100;
				temp.remove(i);
		System.out.println("Sum is :"+sum);	
		}
		request.getSession().setAttribute("sum", sum);
		
		String json = new Gson().toJson(sum);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
