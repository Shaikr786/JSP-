package Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("username");
		out.println("Welcome"+" "+n);
		out.println("<form action='SecondServlet' method=post>");
		out.println("<input type='hidden' name='uname' value='"+n+"'>");
		out.println("<input type=submit value=submit>");
		out.println("</form>");
		out.close();
	}
}
