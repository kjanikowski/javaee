package pl.kjanikowski.sklep.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.kjanikowski.sklep.domain.SkiJump;

@WebServlet(urlPatterns = "/dataT")
public class SkiDataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
//		String selectedHobby = "";
//		for (String hobby : request.getParameterValues("hobby")) {
//			selectedHobby += hobby + " ";
//		}
		
		SkiJump skiJump = new SkiJump(request.getParameterValues("name"), Double.parseDouble(request.getParameter("lenght")),request.getParameterValues("doc"),Boolean.getBoolean(request.getParameter("record")));
		
		
		
		
		out.println("<html><body><h2>Your data</h2>" +
				"<p>First name: " + request.getParameter("firstName") + "<br />" +
				"<p>Your hobby: " + selectedHobby + "<br />" +
				"</body></html>");
		out.close();
	}

}