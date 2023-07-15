package Test;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
public class Login extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String un = request.getParameter("uname");
		String pw1 = request.getParameter("pword");
			if(pw1.equals("vvit") && un.equals("vvit"))
			{
				pw.println("<h1> Login Successful </h1>");
				request.getRequestDispatcher("Welcome").forward(request, response);
				
			}
			else {
				pw.println("<h2> Invalid Login </h2>");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				
			}
			
		
	}

}
