/**
 * 
 */
package com.taxi24.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author niyomwungeri
 *
 */

@Entity
@Table(name="drivers")
public class Driver {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "driver_id")
    private UUID driveId;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "is_available", nullable = false)
	private Boolean isAvailable = false;
	
	@Column(nullable = false)
	private String location;
	
	@OneToMany(mappedBy = "driver")
	private Set<Trip> trips = new HashSet<>();
	
	public UUID getDriveId() {
		return driveId;
	}
	public void setDriveId(UUID driveId) {
		this.driveId = driveId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Set<Trip> getTrips() {
		return trips;
	}
	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}
}
