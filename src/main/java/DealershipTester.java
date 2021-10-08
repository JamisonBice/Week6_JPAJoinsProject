import java.util.List;

import controller.DealershipHelper;
import model.Dealership;

/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
public class DealershipTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dealership joesDealer = new Dealership("Joe's Dealership");
		
		DealershipHelper de = new DealershipHelper();
		de.insertDealership(joesDealer);
		Dealership jimDealer = new Dealership("Jim's Dealership"); 
		de.insertDealership(jimDealer);
		List<Dealership> allDealers = de.showAllDealerships();
		for (Dealership a : allDealers) {
			System.out.println(a.toString());
		}
	}

}
