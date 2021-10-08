 package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderDetails;
import model.ElectricCar;
import model.Dealership;

/**
 * Servlet implementation class EditOrderDetailsServlet
 */
@WebServlet("/editOrderDetailsServlet")
public class EditOrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrderDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderDetailsHelper dao = new OrderDetailsHelper();
		ElectricCarController lih = new ElectricCarController();
		DealershipHelper sh = new DealershipHelper();
		
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		OrderDetails listToUpdate = dao.searchForOrderDetailsById(tempId);

		String newListName = request.getParameter("listName");

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String DealershipName = request.getParameter("dealerName");
		//find our add the new Dealership
		Dealership newDealership = sh.findDealership(DealershipName);

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		try {
			//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<ElectricCar> selectedItemsInList = new ArrayList<ElectricCar>();

			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ElectricCar c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);

			}
			listToUpdate.setListOfItems(selectedItemsInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<ElectricCar> selectedItemsInList = new ArrayList<ElectricCar>();
			listToUpdate.setListOfItems(selectedItemsInList);
		}

		listToUpdate.setListName(newListName);
		listToUpdate.setOrderDate(ld);
		listToUpdate.setDealership(newDealership);

		dao.updateList(listToUpdate);

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}