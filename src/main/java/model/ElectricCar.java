package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Sep 15, 2021
 */
@Entity
@Table(name="items")
public class ElectricCar {
	@Id
	@GeneratedValue
	
	@Column(name="ID")
	private int id;
	
	//This little bug with the reserved word took me 4 hours to find
	@Column(name="`RANGE`")
	private String range;
	
	@Column(name="MAKE")
	private String make;
	
	@Column(name="MODEL")
	private String model;
	
	@Column(name="PRICE")
	private String price;
	
	/**
	 * 
	 */
	public ElectricCar() {
	}
	/**
	 * @param range
	 * @param make
	 * @param model
	 * @param price
	 */
	public ElectricCar(String range, String make, String model, String price) {
		super();
		this.range = range;
		this.make = make;
		this.model = model;
		this.price = price;
	}
	
	/**
	 * @return the range
	 */
	public String getRange() {
		return range;
	}
	/**
	 * @param range the range to set
	 */
	public void setRange(String range) {
		this.range = range;
	}
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return
	 */
	public String returnItemDetails( ) {
		 return this.range + ": " + this.make + ": " + this.model + ": " + this.price;
		}
	@Override
	public String toString() {
		return "ElectricCar [id=" + id + ", range=" + range + ", make=" + make + ", model=" + model + ", price=" + price
				+ "]";
	}
	

}
