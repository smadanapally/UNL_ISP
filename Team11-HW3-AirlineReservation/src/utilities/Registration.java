package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import beans.Client;
import beans.Organization;
import beans.User;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		SimpleDateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
		Date dob=null;
		Date dobn=null;
		//System.out.println(request.getParameter("dob"));
		try {
			
			dob=dtf.parse(request.getParameter("dob"));
			//System.out.println(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		User user = new User(Integer.parseInt(request.getParameter("userId")), request.getParameter("password"),request.getParameter("emailadd"),dob,request.getParameter("uname"));
		String organs=request.getParameter("org");
		String addr=request.getParameter("addr");
		System.out.println(request.getParameter("org"));
		System.out.println(request.getParameter("addr"));
		Organization org=new Organization(organs,addr);
		Client cli=new Client(user,org);
		UserDao ud=new UserDao();
		System.out.println("Starting to add users");
		
		if (ud.addNewUser(cli)) {
			response.sendRedirect("Login.jsp");
		}
		System.out.println("Finished to add users");
		//		try {
//			if (user.addUser()) {
//				response.sendRedirect("Login.jsp");
//			} else {
//				response.sendRedirect("Registration.jsp");
//			}
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
