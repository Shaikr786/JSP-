package Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Profile extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		
		Cookie ck[] = request.getCookies();
		if (ck != null){
			String name = ck[0].getValue();
			if(!name.equals("")||name!=null) {
				out.println("<h1><b>Welcome to Profile page </b></h1>");
				out.println("<b>Welcome "+""+name+"</b>");
				
			}
			
		}
		else {
			out.println("<h1>Please first Login..!");
			request.getRequestDispatcher("login.html").include(request, response);
			
		}
		out.close();
		
	}

}
