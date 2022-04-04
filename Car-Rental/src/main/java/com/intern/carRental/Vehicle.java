package com.intern.carRental;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import com.intern.status.VehicleStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vehicle {
	@Id
	private String licenseNumber;
	private String stockNumber;
	private int passengerCapacity;
	//private String barcode;
	private Boolean hasSunroof;
	private String Model;	
	@Enumerated(EnumType.STRING)
	private VehicleStatus status;
	private String make;
	private int manufacturingYear;
	private int mileage; 
	
	@ManyToOne
	private CarRentalLocation carRentalLocation;
	
	
	private String barcode;
	
	
	public Boolean reserveVehicle(){
		//TODO reserveVehicle
		return null;
	}
	public Boolean returnVehicle(){
		//TODO returnVehicle
		return null;
	}
}
