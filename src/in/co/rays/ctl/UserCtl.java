package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String id = req.getParameter("id");
		UserBean bean = new UserBean();
		if(id!=null) {
			try {
				UserModel model = new UserModel();
				bean = model.findByPk(Long.parseLong(id));
				if(bean!=null) {
					req.setAttribute("bean", bean);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd =  req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		UserModel model = new UserModel();
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");

		String op = req.getParameter("operation");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setLoginId(loginId);
		bean.setPassword(password);
		try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setAddress(address);
		
		
		try {
			
			if(operation.equalsIgnoreCase("save")) {
				try {
					model.add(bean);
					req.setAttribute("bean", bean);
					req.setAttribute("success", "User Added Successfully..!!");
				} catch (Exception e) {
					req.setAttribute("bean", bean);
					req.setAttribute("error", "Login id Already Exist...!!!");
					e.printStackTrace();
				}
				
			}
			
			if(operation.equalsIgnoreCase("update")) {
				bean.setId(Long.parseLong(req.getParameter("id")));
				try {
					model.update(bean);
					req.setAttribute("bean", bean);
					bean = model.findByPk(bean.getId());
					req.setAttribute("bean", bean);
					req.setAttribute("success", "User Updated Successfully..!!");
				} catch (Exception e) {
					req.setAttribute("bean", bean);
					req.setAttribute("error", "Login id Already Exist...!!!");
					e.printStackTrace();
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		RequestDispatcher rd =  req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);
	}
}
