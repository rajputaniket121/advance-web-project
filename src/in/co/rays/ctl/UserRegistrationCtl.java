package in.co.rays.ctl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

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
		String createdBy = req.getParameter("createdBy");
		String modifiedBy = req.getParameter("modifiedBy");
		
		System.out.println("First Name : "+firstName);
		System.out.println("last Name : "+lastName);
		System.out.println("Login Id : "+loginId);
		System.out.println("Password : "+password);
		System.out.println("Date of Birth : "+dob);
		System.out.println("Mobile No : "+mobileNo);
		System.out.println("Role Id : "+roleId);
		System.out.println("Gender : "+gender);
		System.out.println("Modified By : "+createdBy);
		System.out.println("Created By : "+modifiedBy);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserBean bean = new UserBean();
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setLogin(loginId);
		bean.setPassword(password);
		try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setMobileNo(mobileNo);
		bean.setRoleId(Long.parseLong(roleId));
		bean.setGender(gender);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		
		UserModel model = new UserModel();
		try {
			model.add(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("UserRegistrationView.jsp");
	}
}
