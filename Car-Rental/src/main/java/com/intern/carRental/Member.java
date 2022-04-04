package com.intern.carRental;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Member extends Account {
 	private String driverLicenseNumber;
 	private Date driverLicenseExpiry;
 	
 	public List<VehicleReservation> getReservations(){
		//TODO getreservation
 		return null;
 	}	
}