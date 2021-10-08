package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ElectricCar;
 
/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String range = request.getParameter("range");
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String price = request.getParameter("price");
		if (range.isEmpty() || make.isEmpty() || model.isEmpty() || price.isEmpty() ||  range == null || make == null || model == null || price == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			ElectricCar ec = new ElectricCar(range,make,model,price);
			ElectricCarController ecc = new ElectricCarController();
			ecc.insertItem(ec);

			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}