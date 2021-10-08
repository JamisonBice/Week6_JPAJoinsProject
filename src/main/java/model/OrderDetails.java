package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
@Entity
public class OrderDetails {
	@Id
	@GeneratedValue
	private int id;
	private String orderName;
	private LocalDate orderDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Dealership Dealership;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ElectricCar> listOfECars;
	
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetails(int id, String orderName, LocalDate orderDate, Dealership Dealership, List<ElectricCar> listOfECars) {
		super();
		this.id = id;
		this.orderName = orderName;
		this.orderDate = orderDate;
		this.Dealership = Dealership;
		this.listOfECars = listOfECars;
	}
	public OrderDetails(String orderName, LocalDate orderDate, Dealership Dealership, List<ElectricCar> listOfECars) {
		super();
		this.orderName = orderName;
		this.orderDate = orderDate;
		this.Dealership = Dealership;
		this.listOfECars = listOfECars;
	}
	public OrderDetails(String orderName, LocalDate orderDate, Dealership Dealership) {
		super();
		this.orderName = orderName;
		this.orderDate = orderDate;
		this.Dealership = Dealership;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return orderName;
	}
	public void setListName(String orderName) {
		this.orderName = orderName;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public Dealership getDealership() {
		return Dealership;
	}
	public void setDealership(Dealership Dealership) {
		this.Dealership = Dealership;
	}
	public List<ElectricCar> getListOfItems() {
		return listOfECars;
	}
	public void setListOfItems(List<ElectricCar> listOfECars) {
		this.listOfECars = listOfECars;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", orderName=" + orderName + ", orderDate=" + orderDate + ", Dealership=" + Dealership
				+ ", listOfECars=" + listOfECars + "]";
	}

}
