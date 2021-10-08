package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ElectricCar;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ElectricCarController ecc = new ElectricCarController();
		
		String range = request.getParameter("range");
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String price = request.getParameter("price");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		ElectricCar itemToUpdate = ecc.searchForItemById(tempId);
		itemToUpdate.setRange(range);
		itemToUpdate.setMake(make);
		itemToUpdate.setModel(model);
		itemToUpdate.setPrice(price);
				
		ecc.updateItem(itemToUpdate);

		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);


	}

}