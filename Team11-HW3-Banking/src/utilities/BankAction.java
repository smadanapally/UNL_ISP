package utilities;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class BankAction
 */
public class BankAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankAction() {
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
		System.out.println("Im in");
		System.out.println(request.getParameter("acno"));
		System.out.println(request.getParameter("total"));
		int total=(Integer.parseInt(request.getParameter("total")));
		int account=(Integer.parseInt(request.getParameter("acno")));
		int routing=(Integer.parseInt(request.getParameter("routing")));
		int holder=(Integer.parseInt(request.getParameter("holder")));
		Transaction T1=new Transaction(account,holder,routing,total);
		BankingDao B=new BankingDao();
		if(B.validateAccount(T1))
			{
			int flag=1;
			String json = new Gson().toJson(flag);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
			}
		else
		{
			int flag=0;
			String json = new Gson().toJson(flag);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
		
		
	}

}
