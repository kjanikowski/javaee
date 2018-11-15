package app.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.service.NewsManager;
import app.service.SkiJumpManager;
@WebServlet("/news")
public class News extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		if (getServletContext().getAttribute("news") == null)
			getServletContext().setAttribute("news", new NewsManager());
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Dodaj skocznie</h2>" +
				"<form action=\"add\" method=\"post\">" +
				"Name: <input type='text' name='name' /> <br />" +
				"From: <input type='date' name='from' /> <br />" +
				"From: <input type='date' name='to' /> <br />" +
				"<input type='radio' name='czest' value='dzien'>Dziennie<br />" +
				"<input type='radio' name='czest' value='tyg'>Tygodniowo<br />" +
				"<input type='radio' name='czest' value='mies'>Miesiecznie<br />" +
				"<input type='checkbox' name='hobby' value='skocznie'>Interesuje sie skoczniami<br />" +
				"<input type='checkbox' name='hobby' value='skoczkowie'>Interesuje sie skoczkami<br />" +
				"<input type='checkbox' name='hobby' value='narty'>Interesuje sie nartami<br />" +
				"<input type='submit' value=' OK ' />" +
				"</form>" +
				"</body></html>");
		out.close();
		
		
		
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();

		
		response.setContentType("text/html");
		
		NewsManager man = (NewsManager) getServletContext().getAttribute("news");
		
		
		
	}
	

}
