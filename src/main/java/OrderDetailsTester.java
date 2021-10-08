import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.OrderDetailsHelper;
import model.OrderDetails;
import model.ElectricCar;
import model.Dealership;

/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
public class OrderDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dealership bobsDealer = new Dealership("Bob's Dealership");
		OrderDetailsHelper odh = new OrderDetailsHelper();
		ElectricCar tesla = new ElectricCar("294", "Tesla", "Model S", "32,000");
		ElectricCar toyota = new ElectricCar("180", "Toyota", "Bolt", "30,000");
		List<ElectricCar> bobsCar = new ArrayList<ElectricCar>();
		bobsCar.add(tesla);
		bobsCar.add(toyota);
		OrderDetails bobsList = new OrderDetails("Bob's OrderList", LocalDate.now(), bobsDealer);
		bobsList.setListOfItems(bobsCar);
		odh.insertNewOrderDetails(bobsList);
		List<OrderDetails> allLists = odh.getLists();
		for (OrderDetails a : allLists) {
			System.out.println(a.toString());
		}
	}

}
