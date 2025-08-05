package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String opValue = req.getParameter("operation");
		if(opValue!=null && opValue.equalsIgnoreCase("Logout")) {
			HttpSession session =  req.getSession();
			session.invalidate();
			req.setAttribute("success", "User logout Successfully..!!");
		}
		RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login post");

		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String operation = req.getParameter("operation");
		String uri = req.getParameter("uri");
		if (operation.equalsIgnoreCase("signIn")) {
			System.out.println("singin clicked");
			UserModel model = new UserModel();
			try {
				UserBean bean = model.authenticate(loginId, password);
				if (bean != null) {
					HttpSession session =  req.getSession();
					session.setAttribute("user", bean);
					if(uri.equalsIgnoreCase("null")) {
						resp.sendRedirect("WelcomeView.jsp");
						return;
					}else {
						resp.sendRedirect(uri);
						return;
					}
				} else {
					req.setAttribute("error", "Login & Password is Incorrect");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (operation.equalsIgnoreCase("signUp")) {
			System.out.println("singup clicked");
			resp.sendRedirect("UserRegistrationCtl");
			return;
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
		rd.forward(req, resp);
	}

}
