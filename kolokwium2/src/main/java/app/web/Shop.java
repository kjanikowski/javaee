package app.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.domain.Monitor;
import app.service.MonitorManager;

@WebServlet("/shop")
public class Shop extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
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
					out.print("<form action=\"shop\" method=\"post\">" + "<input type=\"hidden\" name=\"id\" value=\""
					+ managerb.getList().get(j).getid() + "\">" + "<input type= \"hidden\" name =\"action\" value=\"removeFromBasket\">"	
					+ "<input type=\"submit\" value=\"Usun z koszyka\"></form><br>");
			j++;
		}

		int i = 0;
		out.println("<h3> Lista monitorow do kupienia: </h3>");
		while (manager.getList().size() > i) {
			out.print("Monitor " + manager.getList().get(i).getName() + " o dlugosci "
					+ manager.getList().get(i).getLenght() + " wyprodukowany dnia: "
					+ manager.getList().get(i).getDate() +" marka= "
					+ manager.getList().get(i).getMarka() + " cechy monitora= " + manager.getList().get(i).getCechy());
			out.print("<form action=\"shop\" method=\"post\">" + "<input type=\"hidden\" name=\"id\" value=\""
					+ manager.getList().get(i).getid() + "\">" + "<input type= \"hidden\" name =\"action\" value=\"addToBasket\">"	
					+ "<input type=\"submit\" value=\"Dodaj do koszyka\"></form><br>");
			i++;
		}
		out.println("<br><br><br><a href=\"http://localhost:8080/servletjspdemo/add\">Dodaj monitor</a><br>");
		out.println("<br><br><a href=\"http://localhost:8080/servletjspdemo/buy\">Realizacja zamowienia</a><br><br>");

		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		out.println("<html><body>");


		MonitorManager manager = (MonitorManager) getServletContext().getAttribute("monitor");
		MonitorManager managerb = (MonitorManager) session.getAttribute("basket");
		Monitor m = null;
		
		if(request.getParameter("action").equals("addToBasket"))
			if(session.getAttribute("basket") != null) {
			m = manager.getList().get(Integer.parseInt(request.getParameter("id")));
			managerb.addMonitor(m);
			manager.remove(Integer.parseInt(request.getParameter("id")));
			}
			
		if(request.getParameter("action").equals("removeFromBasket")) {
			m = managerb.getList().get(Integer.parseInt(request.getParameter("id")));
			manager.addMonitor(m);
			managerb.remove(Integer.parseInt(request.getParameter("id")));
		}
		
		getServletContext().setAttribute("monitor", manager);
		session.setAttribute("basket", managerb);


		out.println("<br><br><a href=\"http://localhost:8080/servletjspdemo/shop\">Wroc do sklepu</a><br><br>");

		out.println("Wykonano!</body></html>");
		out.close();


	}

}
