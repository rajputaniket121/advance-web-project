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

@WebServlet(urlPatterns = {"/LoginCtl","/LoginPage"})
public class LoginCtl extends HttpServlet {
	
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String loginId = req.getParameter("loginId");
//		String password = req.getParameter("password");
//		String validId = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
//		if(loginId!=null&&password!=null) {
//			if(loginId.equals(validId) && !loginId.isEmpty()&&!password.isEmpty()) {
//				req.setAttribute("notValid", "Invalid Format");
//				RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
//				rd.forward(req, resp);
//				
//			}
//			
//		}
//		super.service(req, resp);
//		
//	}

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
