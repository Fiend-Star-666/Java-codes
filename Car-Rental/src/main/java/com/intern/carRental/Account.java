package com.intern.carRental;

import javax.persistence.Entity;

import com.intern.simpledata.Person;
import com.intern.status.AccountStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
	private int id;
	private String password;
	private AccountStatus status;
	private Person person;
	
	public Boolean resetPassword() {
		//TODO resetpassword
		return null;
	}
}