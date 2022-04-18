package com.intern.primary.addonServices;

import javax.persistence.PrimaryKeyJoinColumn;

import com.intern.carRental.primary.abstrct.Payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PrimaryKeyJoinColumn(name="id")  
public class CreditCardTransaction extends Payment{
	private String nameOnCard;

	@Override
	public boolean initiateTransaction() {
		// TODO Auto-generated method stub
		return false;
	}
}
