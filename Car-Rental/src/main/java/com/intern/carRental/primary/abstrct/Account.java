package com.intern.carRental.primary.abstrct;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.intern.carRental.primary.VehicleReservation;
import com.intern.carRental.primary.intrfces.Search;
import com.intern.primary.enums.AccountStatus;
import com.intern.primary.simplePOJO.Person;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Inheritance(strategy=InheritanceType.JOINED)  
public abstract class Account implements Search{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private int id;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private AccountStatus ASstatus;

	@Embedded
	private Person person;

	@OneToOne(targetEntity = Vehicle.class)
	private Vehicle vehicle;
	
	public abstract Boolean resetPassword();
	
	@OneToMany(mappedBy = "account")
	private List<VehicleReservation> vehiclereservation;
}