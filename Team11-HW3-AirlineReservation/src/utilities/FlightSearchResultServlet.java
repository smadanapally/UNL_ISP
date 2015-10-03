package utilities;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FlightSearchResultServlet
 */
public class FlightSearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightSearchResultServlet() {
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
//int i=request.getParameter(arg0)
		int index=Integer.parseInt(request.getParameter("flight"));
		request.getSession().setAttribute("index", index);
		String encodedURL = response.encodeRedirectURL("viewandbook.jsp");
		response.sendRedirect(encodedURL);
	
//		RequestDispatcher rd = (RequestDispatcher)request.getRequestDispatcher("viewandbook.jsp");
//		rd.forward(request, response);
		// TODO Auto-generated method stub
	}

}
