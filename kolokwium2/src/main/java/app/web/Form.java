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

import app.domain.Monitor;
import app.service.MonitorManager;

@WebServlet("/add")
public class Form extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Dodaj Monitor</h2>" +
				"<form action=\"add\" method=\"post\">" +
				"Ski jump name: <input type='text' name='name' /> <br />" +
				"Lenght: <input type='text' name='dlug' /> <br />" +
				"Date of competition: <input type='date' name='doc' /> <br />" +
				"<input type='radio' name='marka' value='Samsung'>Samsung<br />" +
				"<input type='radio' name='marka' value='LG'>LG<br />" +
				"<input type='checkbox' name='cechy' value='HD'>Interesuje sie skoczniami<br />" +
				"<input type='checkbox' name='cechy' value='HDR'>Interesuje sie skoczkami<br />" +
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
		MonitorManager manager = (MonitorManager) getServletContext().getAttribute("monitor");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(request.getParameter("doc"));
		long millis = date.getTime();
		double lenght = Double.parseDouble(request.getParameter("dlug"));
		String marka = request.getParameter("marka");
		Date date2 = new Date(millis);
		String[] results = request.getParameterValues("cechy");
		String result = "";
		for (int i = 0; i < results.length; i++) {
		    System.out.println(results[i]); 
		    result = result +", "+ results[i];
		}
		
		
		manager.addMonitor(new Monitor(request.getParameter("name"), lenght , date2, marka, result ));
		getServletContext().setAttribute("monitor", manager);
			
			
		 out.println("<br><br><br><a href=\"http://localhost:8080/servletjspdemo/shop\">Wroc do sklepu</a><br>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print("Niepoprawne badz niekompletne dane!");
			 out.println("<br><br><br><a href=\"http://localhost:8080/servletjspdemo/add\">Wroc do dodawania skoczni</a><br>");

		}
		out.close();

		
	}
	
	
	

}
