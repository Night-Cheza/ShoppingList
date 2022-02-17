package ca.sait.shoppinglist.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Leila Nalivkina, Nick Hemnett
 */
public class ShoppingListServlet extends HttpServlet {
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");

		if(userName == null) {
			getServletContext().getRequestDispatcher("/WEB-INF/Registration.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
		}
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String action =request.getParameter("action");

		ArrayList<String> items = new ArrayList<>();
		
		if(action != null && action.equals("add")) {
			String item = request.getParameter("item");

			items	= (ArrayList<String>) session.getAttribute("items");			
			items.add(item);

			session.setAttribute("items", items);
		} else
			if(action != null && action.equals("delete")) {
				String item = request.getParameter("item");

				items	= (ArrayList<String>) session.getAttribute("items");			
				items.remove(item);

				session.setAttribute("items", items);
			} else {
				String userName = request.getParameter("userName");

				session.setAttribute("userName", userName);			
				session.setAttribute("items", items);
			}

		getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);

	}
}
