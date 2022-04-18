package com.intern.primary.addonServices;

import javax.persistence.PrimaryKeyJoinColumn;

import com.intern.carRental.primary.abstrct.Payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PrimaryKeyJoinColumn(name="id")
public class CashTransaction extends Payment{
	
	private double cashTendered;

	@Override
	public boolean initiateTransaction() {
		// TODO Auto-generated method stub
		return false;
	}

}
