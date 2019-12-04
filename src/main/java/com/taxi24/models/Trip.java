/**
 * 
 */
package com.taxi24.models;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author niyomwungeri
 *
 */
@Entity
@Table(name = "trips")
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trip_id")
	private UUID tripId;
	
	@Column(nullable = false)
	private String departure;
	
	@Column(nullable = false)
	private String destination;
	
	@Column(nullable = false)
	private double cost;
	
	@Column(name = "is_complete")
	private Boolean isComplete = false;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rider_Id")
	private Rider rider;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "driver_Id")
	private Driver driver;
	
	@OneToOne(mappedBy = "trip")
	private Invoice invoice;

	public UUID getTripId() {
		return tripId;
	}

	public void setTripId(UUID tripId) {
		this.tripId = tripId;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}

	public Rider getRider() {
		return rider;
	}

	public void setRider(Rider rider) {
		this.rider = rider;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
