package in.co.rays.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("Service called for LifeCycleServlet");
		super.service(arg0, arg1);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Do get called for LifeCycleServlet");
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Do Post called for LifeCycleServlet");
		super.doPost(req, resp);
	}

}
