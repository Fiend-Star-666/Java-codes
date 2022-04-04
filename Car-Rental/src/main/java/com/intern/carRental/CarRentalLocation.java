package com.intern.carRental;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.intern.simpledata.Location;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CarRentalLocation {
	@Id
	private String name;
	//private Location address;
	@OneToMany(mappedBy="carRentalLocation")
	private List<Vehicle> vehicle;
	@ManyToOne
	private CarRentalSystem carRentalSystem;

	//public Location getLocation() {
		//return address;
		// TODO getLocation
	//}

}