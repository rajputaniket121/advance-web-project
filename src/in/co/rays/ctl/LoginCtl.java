package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

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
			UserModel model = new UserModel();
			 try {
				UserBean bean = model.findByLogin(loginId);
				if (bean!=null && bean.getLogin().equals(loginId)&& bean.getPassword().equals(password)) {
					req.setAttribute("user", bean);
					resp.sendRedirect("WelcomeCtl");
					return;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (operation.equalsIgnoreCase("signUp")) {
			System.out.println("singup clicked");
			resp.sendRedirect("UserRegistrationCtl");
			return;
		}
		
		resp.sendRedirect("LoginView.jsp");
	}

}
