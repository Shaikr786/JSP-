package Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		request.getRequestDispatcher("link.html").include(request,response);
		Cookie ck = new Cookie("a","");
		ck.setMaxAge(0);
		response.addCookie(ck);
		out.println("<h1>You are successfully Loggedd Out..!</h1>");
		
		
	}

}
