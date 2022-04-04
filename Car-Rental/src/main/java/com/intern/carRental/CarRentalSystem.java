package com.intern.carRental;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.*;

@Getter
@Setter
@Entity
public class CarRentalSystem {
	@Id
	private String name;
	@OneToMany(mappedBy="carRentalSystem")
	private List<CarRentalLocation> carRentalLocation ;

	public boolean addNewLocation() {
  //TODO addNewLocation
		return false;

	}
}
