package com.intern.carRental;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.intern.simpledata.Person;
import lombok.*;



@Getter
@Setter
@Entity
public class AdditionalDriver {

	@ManyToOne
	private VehicleReservation vehicleReservation;
	@Id
	private String driverID;
	//private Person person;

}
