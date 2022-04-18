package com.intern.carRental.primary;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.intern.carRental.primary.abstrct.Account;
import com.intern.carRental.primary.abstrct.Equipment;
import com.intern.carRental.primary.abstrct.Notification;
import com.intern.carRental.primary.abstrct.RentalInsurance;
import com.intern.carRental.primary.abstrct.Service;
import com.intern.carRental.primary.abstrct.Vehicle;
import com.intern.primary.enums.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VehicleReservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String reservationNumber;
	private Date creationDate;
	
	@Enumerated(EnumType.STRING)
	private ReservationStatus RSstatus;
	
	private Date dueDate;
	private Date returnDate;
	private String pickupLocationName;
	private String returnLocationName;
	
	@ManyToOne
	private Account account;
	
	@OneToMany(mappedBy = "vehicleReservation")
	private List<AdditionalDriver> additionaldriver;

	@ManyToOne
	private Vehicle vehicle;
	
	@OneToOne
	private Bill bill;
	
	@OneToMany(mappedBy = "vehiclereservation") 
	private List<Notification> notification;
	
	@OneToMany(mappedBy = "vehiclereservation")
	private List<Service> service;
	
	@OneToMany(mappedBy = "vehiclereservation") 
	private List<RentalInsurance> rentalinsurance;
	
	@OneToMany(mappedBy= "vehiclereservation")
	private List<Equipment> equipment;
	
	public VehicleReservation fetchDetails() {
		// TODO fetchDetails
		return null;
	}
}