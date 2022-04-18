package com.intern.primary.addonServices;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import com.intern.carRental.primary.abstrct.Payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name="id")
public class CheckTransaction extends Payment{
	

	
	private String bankName;
	private String checkNumber;
	
	@Override
	public boolean initiateTransaction() {
		// TODO Auto-generated method stub
		return false;
	}

}
