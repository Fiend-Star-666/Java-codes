package com.intern.carRental.primary;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.*;

@Getter
@Setter
@Entity
public class CarRentalSystem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	private String name;
	
	@OneToMany(mappedBy="carRentalSystem")
	private List<CarRentalLocation> carRentalLocation ;

	public boolean addNewLocation() {
		//TODO addNewLocation
		return false;

	}

	@Override
	public String toString() {
		return "CarRentalSystem [id=" + id + ", name=" + name+ "]";
	}
}
