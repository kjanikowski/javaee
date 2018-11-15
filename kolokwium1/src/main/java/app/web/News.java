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
import javax.servlet.http.HttpSession;

import app.domain.Newsletter;
import app.service.NewsManager;
@WebServlet("/newsletter")
public class News extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		if (session.getAttribute("news") == null)
			session.setAttribute("news", new NewsManager());
		
		NewsManager man = (NewsManager) session.getAttribute("news");
		int j =0;
		
		
		PrintWriter out = response.getWriter();
		
		
		out.print("<h3> Ustawienia: </h3>");
		
		while(man.getList().size()>j) {
			out.print("Imie " + man.getList().get(j).getImie() + " subskrypcja od "
					+ man.getList().get(j).getDateF() + " do: "
					+ man.getList().get(j).getDateT() +" czestosc= "
					+ man.getList().get(j).getCzest() + " zainteresowania: " + man.getList().get(j).getTemat() );

			j++;
		}
		
		out.println("<html><body><h2>Newsletter</h2>" +
				"<form action=\"news\" method=\"post\">" +
				"Name: <input type='text' name='name' /> <br />" +
				"From: <input type='date' name='from' /> <br />" +
				"From: <input type='date' name='to' /> <br />" +
				"<input type='radio' name='czest' value='codziennie'>Dziennie<br />" +
				"<input type='radio' name='czest' value='tygodniowo'>Tygodniowo<br />" +
				"<input type='radio' name='czest' value='miesiecznie'>Miesiecznie<br />" +
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
		HttpSession session = request.getSession();
		
		NewsManager man = (NewsManager) session.getAttribute("news");
		
		session.setAttribute("news",new NewsManager());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date, dateTo;
		
		date = sdf.parse(request.getParameter("from"));
		dateTo = sdf.parse(request.getParameter("to"));
		long millis = date.getTime();
		long millisTo = dateTo.getTime();
		Date dateF = new Date(millis);
		Date dateFTo = new Date(millisTo);
		String[] results = request.getParameterValues("hobby");
		String result = "";
		for (int i = 0; i < results.length; i++) {
		    System.out.println(results[i]); 
		    result = result +", "+ results[i];
		}

		
		
		man.addNews(new Newsletter( request.getParameter("name"), dateF, dateFTo, request.getParameter("czest"), result));
		session.setAttribute("news", man);
		
		out.println("<br><br><a href=\"http://localhost:8080/kolo/newsletter\">Wroc do newslettera</a><br><br>");

		
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
