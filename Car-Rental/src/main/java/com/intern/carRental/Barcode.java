package com.intern.carRental;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.*;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Barcode {
	@Id
	private String barcode;
	
	private Date issuedAt;
	private boolean active;
	
	@OneToOne
	private Vehicle vehicle;
	
	
	
	public Boolean isActive(){
		//TODO isActive
		return null;
	}
}
