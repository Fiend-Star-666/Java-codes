package com.intern.carRental;

import java.util.*;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.sql.Timestamp;

import com.intern.simpledata.Person;
import com.intern.status.ReservationStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VehicleReservation {
	@Id
	private String reservationNumber;
	private Date creationDate;
	private ReservationStatus status;
	private Timestamp dueDate;
	private Timestamp returnDate;
	private String pickupLocationName;
	private String returnLocationName;
	
	
	@OneToMany(mappedBy = "vehicleReservation")
	private List<AdditionalDriver> additionaldriver;

	public VehicleReservation fetchDetails() {
		// TODO fetchDetails
		return null;
	}
}
