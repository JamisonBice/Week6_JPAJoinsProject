import java.util.List;

import java.util.Scanner;

import controller.ElectricCarController;
import model.ElectricCar;

/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Sep 15, 2021
 */

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		 static ElectricCarController ecc = new ElectricCarController();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a range: ");
			String range = in.nextLine();
			System.out.print("Enter a manufacturer: ");
			String make = in.nextLine();
			System.out.print("Enter a model: ");
			String model = in.nextLine();
			System.out.print("Enter a price: ");
			String price = in.nextLine();
			ElectricCar toAdd = new ElectricCar(range, make, model, price);
			ecc.insertItem(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the range to delete: ");
			String range = in.nextLine();
			System.out.print("Enter the manufacturer to delete: ");
			String make = in.nextLine();
			System.out.print("Enter the model to delete: ");
			String model = in.nextLine();
			System.out.print("Enter the price to delete: ");
			String price = in.nextLine();
			ElectricCar toDelete = new ElectricCar(range, make, model, price);
			ecc.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Range");
			System.out.println("2 : Search by Manufacturer");
			System.out.println("3 : Search by Model");
			System.out.println("4 : Search by Price");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ElectricCar> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter a range name: ");
				String rangeName = in.nextLine();
				foundItems = ecc.searchForItemByRange(rangeName);
			} else if (searchBy == 2) {
				System.out.print("Enter a manufacturer name: ");
				String makeName = in.nextLine();
				foundItems = ecc.searchForItemByMake(makeName);
			} else if (searchBy == 3) {
				System.out.print("Enter a model name: ");
				String modelName = in.nextLine();
				foundItems = ecc.searchForItemByModel(modelName);
			}else {
				System.out.print("Enter a price name: ");
				String priceName = in.nextLine();
				foundItems = ecc.searchForItemByPrice(priceName);
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ElectricCar l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ElectricCar toEdit = ecc.searchForItemById(idToEdit);
				System.out.println("Retrieved the" + toEdit.getRange() + " and " + toEdit.getMake() + " and " + toEdit.getModel() + " and " + toEdit.getPrice());
				System.out.println("1 : Update Range");
				System.out.println("2 : Update Manufacturer");
				System.out.println("3 : Update Model");
				System.out.println("4 : Update Price");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Range: ");
					String newRange = in.nextLine();
					toEdit.setRange(newRange);
				} else if (update == 2) {
					System.out.print("New Manufacturer: ");
					String newMake = in.nextLine();
					toEdit.setMake(newMake);
				} else if (update == 3) {
					System.out.print("New Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
				} else if (update == 4) {
					System.out.print("New Price: ");
					String newPrice = in.nextLine();
					toEdit.setPrice(newPrice);
				}

				ecc.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the electric car database! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the electric program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					ecc.cleanUp();
					System.out.println("   Bye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ElectricCar> allItems = ecc.showAllItems();
			for(ElectricCar singleItem: allItems) {
				System.out.println(singleItem.returnItemDetails());
			}

		}

	} 