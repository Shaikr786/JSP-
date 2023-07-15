package Test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		request.getRequestDispatcher("link.html").include(request, response);
		String a = request.getParameter("username");
		String b = request.getParameter("password");
		if(b.equals("rrr"))
		{
			out.println("<h1>You are Successfully Logged in...!</h1>");
			out.println("Welcome "+" "+a);
			Cookie ck = new Cookie("a",a);
			response.addCookie(ck);
		}
		else {
			out.println("<h1>Sorry..! You your username via password is incorrect</h1>");
			request.getRequestDispatcher("login.html").include(request,response);
			
		}
		out.close();
		
	}

}
