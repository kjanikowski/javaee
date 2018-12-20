package app.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.service.MonitorManager;

@WebServlet("/shop")
public class Shop extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		if (getServletContext().getAttribute("monitor") == null)
			getServletContext().setAttribute("monitor", new MonitorManager());
		if (getServletContext().getAttribute("basket") == null)
			getServletContext().setAttribute("basket", new MonitorManager());

		MonitorManager manager = (MonitorManager) getServletContext().getAttribute("monitor");
		int j =0;
		out.println("<h3> Koszyk: </h3>");
		while (manager.getBasketList().size() > j) {
			out.print("Monitor " + manager.getBasketList().get(j).getName() + " o dlugosci "
					+ manager.getBasketList().get(j).getLenght() + " wyprodukowany dnia: "
					+ manager.getBasketList().get(j).getDate() +" marka= "
					+ manager.getBasketList().get(j).getMarka() + " cechy monitora= " + manager.getBasketList().get(j).getCechy());
					out.print("<form action=\"shop\" method=\"post\">" + "<input type=\"hidden\" name=\"id\" value=\""
					+ manager.getBasketList().get(j).getid() + "\">" + "<input type= \"hidden\" name =\"action\" value=\"removeFromBasket\">"	
					+ "<input type=\"submit\" value=\"Usun z koszyka\"></form><br>");
			j++;
		}

		int i = 0;
		out.println("<h3> Lista skoczni do kupienia: </h3>");
		while (manager.getList().size() > i) {
			out.print("Monitor " + manager.getBasketList().get(j).getName() + " o dlugosci "
					+ manager.getBasketList().get(j).getLenght() + " wyprodukowany dnia: "
					+ manager.getBasketList().get(j).getDate() +" marka= "
					+ manager.getBasketList().get(j).getMarka() + " cechy monitora= " + manager.getBasketList().get(j).getCechy());
			out.print("<form action=\"shop\" method=\"post\">" + "<input type=\"hidden\" name=\"id\" value=\""
					+ manager.getList().get(i).getid() + "\">" + "<input type= \"hidden\" name =\"action\" value=\"addToBasket\">"	
					+ "<input type=\"submit\" value=\"Dodaj do koszyka\"></form><br>");
			i++;
		}
		out.println("<br><br><br><a href=\"http://localhost:8080/servletjspdemo/add\">Dodaj skocznie</a><br>");

		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html><body>");


		MonitorManager manager = (MonitorManager) getServletContext().getAttribute("monitor");
		
		if(request.getParameter("action").equals("addToBasket"))
			manager.addBasket(Integer.parseInt(request.getParameter("id")));
			
		if(request.getParameter("action").equals("removeFromBasket"))
			manager.removeBasket(Integer.parseInt(request.getParameter("id")));


		out.println("<br><br><a href=\"http://localhost:8080/servletjspdemo/shop\">Wroc do sklepu</a><br><br>");

		out.println("Wykonano!</body></html>");
		out.close();


	}

}
