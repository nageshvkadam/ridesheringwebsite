package com.nagesh.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_trip")
public class UserTrip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long tripId;
	
	public Long getTripId() {
		return tripId;
	}
	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	public LocalDate getRideDate() {
		return rideDate;
	}
	public void setRideDate(LocalDate rideDate) {
		this.rideDate = rideDate;
	}
	public LocalTime getRideTime() {
		return rideTime;
	}
	public void setRideTime(LocalTime rideTime) {
		this.rideTime = rideTime;
	}
	public String getCabType() {
		return cabType;
	}
	public void setCabType(String cabType) {
		this.cabType = cabType;
	}
	public Integer getPassengers() {
		return passengers;
	}
	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	private String pickupLocation;
	private String dropLocation;
	private LocalDate rideDate;
	private LocalTime rideTime;
	
	
	private String cabType;
	private Integer passengers;
    private LocalDateTime createdAt = LocalDateTime.now();

	

}