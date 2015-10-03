package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import beans.Client;
import beans.Flight;
import beans.User;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		String path = this.getServletContext().getRealPath("/");
		path += "\\WEB-INF\\classes\\users.properties";
		String usr=request.getParameter("userid");
		int sum=0;
		//	User us = new User(request.getParameter("usrname"), request.getParameter("passwd"), path);
		Boolean active = Boolean.valueOf(request.getParameter("remember"));
		boolean activated = active.booleanValue();
		if(activated){

			Cookie username = new Cookie("User_name",
					request.getParameter("usrname"));
			username.setMaxAge(60*60*24*365);
			username.setPath("/");
			response.addCookie(username);
		}
		UserDao usd=new UserDao();
		//request.getSession().invalidate();
		if(usd.userValidation(Integer.parseInt(usr), request.getParameter("passwd")))
		{ 
			Client cld=new Client();
			cld=usd.getUserDetails(Integer.parseInt(usr));
			System.out.println(cld.user.getUsername());
			System.out.println(cld.org.getOrganization());
			HttpSession session = request.getSession();
			session.setAttribute("username",cld.user.getUsername());
			session.setAttribute("organization", cld.org.getOrganization());
			session.setAttribute("user", usr);
			session.setMaxInactiveInterval(5*60);
			ArrayList<Flight> shopping=new ArrayList<Flight>();
			request.getSession().setAttribute("Shopping", shopping);
			request.getSession().setAttribute("sum", sum);
			//response.sendRedirect("https://www.google.com/?gws_rd=ssl");
			//RequestDispatcher rd=(RequestDispatcher)request.getRequestDispatcher("./flightsearchquery.jsp");
			//rd.forward(request, response);
		String encodedURL = response.encodeRedirectURL("./flightsearchquery.jsp");
		response.sendRedirect(encodedURL);
//			return;
		}
		else
		{
			response.sendRedirect("Login.jsp");

		}


	}

}
