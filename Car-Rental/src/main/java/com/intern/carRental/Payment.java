package com.intern.carRental;

import java.util.*;

import com.intern.status.PaymentStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
	private Date creationDate;
	private double amount;
	private PaymentStatus status;

	public boolean initiateTransaction() {
		// TODO iniateTransaction
		return false;
	}

}
