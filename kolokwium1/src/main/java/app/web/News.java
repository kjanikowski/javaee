package app.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.domain.Newsletter;
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
				"<form action=\"news\" method=\"post\">" +
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

		try {
		response.setContentType("text/html");
		
		NewsManager man = (NewsManager) getServletContext().getAttribute("news");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date, dateTo;
		
		date = sdf.parse(request.getParameter("from"));
		dateTo = sdf.parse(request.getParameter("to"));
		long millis = date.getTime();
		long millisTo = dateTo.getTime();
		Date dateF = new Date(millis);
		Date dateFTo = new Date(millisTo);

		
		
		man.addNews(new Newsletter( request.getParameter("name"), dateF, dateFTo, request.getParameter("czest"), request.getParameter("czest")));
		getServletContext().setAttribute("news", man);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
