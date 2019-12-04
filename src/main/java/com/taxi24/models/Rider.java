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

@Entity
@Table(name = "riders")
public class Rider {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rider_id")
    private UUID riderId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@OneToMany(mappedBy = "rider")
	private Set<Trip> trips = new HashSet<>();

	public UUID getRiderId() {
		return riderId;
	}

	public void setRiderId(UUID riderId) {
		this.riderId = riderId;
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

	public Set<Trip> getTrips() {
		return trips;
	}

	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}
	
}
