package app.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.domain.SkiJump;
import app.service.SkiJumpManager;

@WebServlet("/add")
public class Form extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Dodaj skocznie</h2>" +
				"<form action=\"add\" method=\"post\">" +
				"Ski jump name: <input type='text' name='name' /> <br />" +
				"Lenght: <input type='text' name='dlug' /> <br />" +
				"Date of competition: <input type='date' name='doc' /> <br />" +
				"<input type='radio' name='record' value='true'>Has record<br />" +
				"<input type='radio' name='record' value='false'>No record<br />" +
				"<input type='submit' value=' OK ' />" +
				"</form>" +
				"</body></html>");
		out.close();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();

		try {
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		SkiJumpManager manager = (SkiJumpManager) getServletContext().getAttribute("skijump");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(request.getParameter("doc"));
		long millis = date.getTime();
		double lenght = Double.parseDouble(request.getParameter("dlug"));
		boolean record = Boolean.parseBoolean(request.getParameter("record"));
		Date date2 = new Date(millis);
		manager.addSkiJump(new SkiJump(request.getParameter("name"), lenght , date2, record));
		getServletContext().setAttribute("skijump", manager);
			
			
		 out.println("<p><a href=\"http://localhost:8080/zad03/shop\">Wróæ do sklepu</a></p>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print("Niepoprawne badz niekompletne dane!");
			 out.println("<p><a href=\"http://localhost:8080/zad03/add\">Wróc do dodawania skoczni</a></p>");

		}
		out.close();

		
	}
	
	
	

}
