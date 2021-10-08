package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
@Entity
@Table(name = "dealer")
public class Dealership {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="Name")
	private String dealerName;
	/**
	 * @param id
	 * @param dealerName
	 */
	public Dealership(int id, String dealerName) {
		this.id = id;
		this.dealerName = dealerName;
	}
	/**
	 * @param dealerName
	 */
	public Dealership(String dealerName) {
		this.dealerName = dealerName;
	}
	/**
	 * 
	 */
	public Dealership() {
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
	 * @return the dealerName
	 */
	public String getDealerName() {
		return dealerName;
	}
	/**
	 * @param dealerName the dealerName to set
	 */
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	@Override
	public String toString() {
		return "Dealership [id=" + id + ", dealerName=" + dealerName + "]";
	}
	

}
