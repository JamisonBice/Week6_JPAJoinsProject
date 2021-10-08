package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Sep 15, 2021
 */
/**
 * Servlet implementation class AddItemsForListServlet
 */
@WebServlet("/addItemsForListServlet")
public class AddItemsForListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemsForListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ElectricCarController ecc = new ElectricCarController();
		
		request.setAttribute("allItems", ecc.showAllItems());
		
		if(ecc.showAllItems().isEmpty()) {
			request.setAttribute("allItems", "");
		}
		
		getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}