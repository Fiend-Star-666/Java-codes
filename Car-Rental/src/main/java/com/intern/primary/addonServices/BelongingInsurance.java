package com.intern.primary.addonServices;

import javax.persistence.PrimaryKeyJoinColumn;

import com.intern.carRental.primary.abstrct.RentalInsurance;

@PrimaryKeyJoinColumn(name="id")
public class BelongingInsurance extends RentalInsurance{

	@Override
	public Boolean addInsurance() {
		// TODO Auto-generated method stub
		return null;
	}

}
