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

		
//		
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
		String action =request.getParameter("action");
		HttpSession session = request.getSession();

		if(action != null && action.equals("add")) {
			String item = request.getParameter("addItem");

			ArrayList<String> items	= (ArrayList<String>) session.getAttribute("addItems");
			items.add(item);
			session.setAttribute("addItem", items);
			//check if arraylist exists, if not - create one
//			if( items.isEmpty()) {  
//				session.setAttribute("addItem", item);
//			}

		} else {
			String userName = request.getParameter("userName");

			ArrayList<String> items = new ArrayList<>();
			
			session.setAttribute("userName", userName);
			session.setAttribute("addItem", items);			
		}
		getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);

	}
}
