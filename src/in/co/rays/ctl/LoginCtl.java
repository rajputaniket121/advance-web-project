package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginCtl")
public class LoginCtl  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login get");
		resp.sendRedirect("LoginView.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login post");
		
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String operation = req.getParameter("operation");
		
		if(operation.equalsIgnoreCase("signIn")) {
			System.out.println("singin clicked");
		}else if (operation.equalsIgnoreCase("signUp")) {
			System.out.println("singup clicked");
			resp.sendRedirect("UserRegistrationCtl");
			return;
		}
		
		resp.sendRedirect("LoginView.jsp");
	}

}
