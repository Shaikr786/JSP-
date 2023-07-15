package Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Book extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reshma","root","Reshma@123");
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery("select * from cart");
			out.println("<center> <table border=1>");
			out.println("<thead><th>Book Name</th><th>Price</th><th>Quantity</th><th>Amount</th></thead>");
			while(r.next())
			{
				out.println("<tr><td>"+r.getString(1)+"</td>");
				out.println("<td>"+r.getString(2)+"</td>");
				out.println("<td>"+r.getString(3)+"</td>");
				out.println("<td>"+r.getString(4)+"</td></tr>");
			}
			out.println("</table></center>");
			con.close();
		}
		catch(SQLException sq)
		{
		out.println("sql exception"+sq);
		}
catch(ClassNotFoundException cl) {
			out.println("Class not found"+cl);
			
		}
		
		
	}

}
