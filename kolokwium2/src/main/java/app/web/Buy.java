package app.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.service.MonitorManager;
@WebServlet("/buy")
public class Buy extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		if (getServletContext().getAttribute("monitor") == null)
			getServletContext().setAttribute("monitor", new MonitorManager());
		if (session.getAttribute("basket") == null)
			session.setAttribute("basket", new MonitorManager());
		
		MonitorManager manager = (MonitorManager) getServletContext().getAttribute("monitor");
		MonitorManager managerb = (MonitorManager) session.getAttribute("basket");
		int j =0;
		out.println("<h3> Koszyk: </h3>");
		while (managerb.getList().size() > j) {
			out.print("Monitor " + managerb.getList().get(j).getName() + " o dlugosci "
					+ managerb.getList().get(j).getLenght() + " wyprodukowany dnia: "
					+ managerb.getList().get(j).getDate() +" marka= "
					+ managerb.getList().get(j).getMarka() + " cechy monitora= " + managerb.getList().get(j).getCechy());
			j++;
		}
		
		out.print("<form action=\"buy\" method=\"post\">" + "<input type=\"hidden\" name=\"id\" value=\""
				+ "\">" + "<input type= \"hidden\" name =\"action\" value=\"addToBasket\">"	
				+ "<input type=\"submit\" value=\"Kup\"></form><br>");
		
		
		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		HttpSession session = request.getSession();

		MonitorManager manager = (MonitorManager) getServletContext().getAttribute("basket");
		MonitorManager managerb = (MonitorManager) session.getAttribute("monitor");

		
		if(request.getParameter("action").equals("addToBasket"))
			if(session.getAttribute("basket") != null) {
			managerb.clear();
			}
			
		session.setAttribute("basket", manager);

		out.println("<br><br><a href=\"http://localhost:8080/servletjspdemo/shop\">Wroc do sklepu</a><br><br>");

		out.println("Wykonano!</body></html>");
		out.close();
		
		
		
	}
	
	
}
