package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserBean bean = null;
		int pageNo = 1;
		int pageSize = 5;
		UserModel model = new UserModel();
		try {
			List<UserBean> userList = model.search(bean, pageNo, pageSize);
			req.setAttribute("userList", userList);
			req.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = null;
		int pageNo = 1;
		int pageSize = 5;
		UserModel model = new UserModel();
		pageNo = Integer.parseInt(req.getParameter("pageNo"));
		String[] ids = req.getParameterValues("ids");
		try {
			if (op.equalsIgnoreCase("previous")) {
				pageNo--;
			} else if (op.equalsIgnoreCase("add")) {
				resp.sendRedirect("UserCtl");
				return;

			} else if (op.equalsIgnoreCase("delete")) {
				if (ids != null && ids.length > 0) {
					pageNo = 1;
					for (String id : ids) {
						model.delete(Long.parseLong(id));
					}
					req.setAttribute("success", "User deleted Successfully..!!!");
				}else {
					req.setAttribute("error", "Select Atlest one Checkbox..!!!");
				}

			} else if (op.equalsIgnoreCase("next")) {
				pageNo++;
			} else if (op.equalsIgnoreCase("search")) {
				pageNo = 1;
				bean = new UserBean();
				bean.setFirstName(req.getParameter("firstName"));
				String dob = req.getParameter("dob");
				if (dob != null && !dob.isEmpty()) {
					bean.setDob(sdf.parse(dob));
				}
			}
			List<UserBean> userList = model.search(bean, pageNo, pageSize);
			req.setAttribute("userList", userList);
			req.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
		rd.forward(req, resp);
	}

}
