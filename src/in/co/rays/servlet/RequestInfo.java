package in.co.rays.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestInfo")
public class RequestInfo extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out =  resp.getWriter();
		out.println("<H1>Request Information Example </H1>");
		out.println("<br>Methods : "+req.getMethod());
		out.println("<br>Parameters name  : "+req.getParameterNames());
		out.println("<br>Request Url : "+req.getRequestURI());
		out.println("<br>Protocol : "+req.getProtocol());
		out.println("<br>Remote Address : "+req.getRemoteAddr());
		out.println("<br>");
		out.println("<br><h1>Header Info </h1> ");
		Enumeration<String> headerName = req.getHeaderNames();
		while(headerName.hasMoreElements()) {
			String name = headerName.nextElement();
			String value = req.getHeader(name);
			out.println("<br>"+name+" = "+value);
		}
		out.println("<br>Remote Address : "+req.getRemoteAddr());
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
