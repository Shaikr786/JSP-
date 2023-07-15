package Test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitialParameters extends HttpServlet{
	ServletConfig cfg;

	public void init(ServletConfig config) throws ServletException {
		cfg = config;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String un = request.getParameter("txtuser");
		String pw = request.getParameter("txtpass");
		boolean flag = false;
		Enumeration<String> initparams = cfg.getInitParameterNames();
		while (initparams.hasMoreElements()) {
			String name = initparams.nextElement();
			String pass = cfg.getInitParameter(name);
			if (un.equals(name) && pw.equals(pass)) {
				flag = true;
			}
		}
		if (flag) {
			out.print("<h1>Valid user!</h1>");

		} else {
			out.print("<h1>Invalid user!</h1>");

		}

	}


}
