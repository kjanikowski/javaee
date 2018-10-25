package pl.kjanikowski.sklep.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/formT")
public class ListServlet extends HttpServlet {
	
	

		private static final long serialVersionUID = 1L;
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.println("<html><body><h2>Simple form servlet</h2>" +
					"<form action='dataT'>" +
					"Ski jump name: <input type='text' name='name' /> <br />" +
					"Lenght: <input type='text' name='lenght' /> <br />" +
					"Date of competition: <input type='text' name='doc' /> <br />" +
					"First name: <input type='text' name='firstName' /> <br />" +
					"<input type='radio' name='record' value='yes'>Has record<br />" +
					"<input type='radio' name='record' value='no'>No record<br />" +
					"<input type='submit' value=' OK ' />" +
					"</form>" +
					"</body></html>");
			out.close();
		}

	
}
