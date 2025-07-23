package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do get");
		resp.sendRedirect("UserRegistrationView.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do Post");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String dob = req.getParameter("dob");
		String mobileNo = req.getParameter("mobileNo");
		String roleId = req.getParameter("roleId");
		String gender = req.getParameter("gender");
		
		System.out.println("First Name : "+firstName);
		System.out.println("last Name : "+lastName);
		System.out.println("Login Id : "+loginId);
		System.out.println("Password : "+password);
		System.out.println("Date of Birth : "+dob);
		System.out.println("Mobile No : "+mobileNo);
		System.out.println("Role Id : "+roleId);
		System.out.println("Gender : "+gender);
		
		resp.sendRedirect("UserRegistrationView.jsp");
	}
}
