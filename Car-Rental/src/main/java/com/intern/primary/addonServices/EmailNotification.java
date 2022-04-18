package com.intern.primary.addonServices;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import com.intern.carRental.primary.abstrct.Notification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PrimaryKeyJoinColumn(name="id")
@Entity
public class EmailNotification extends Notification{
	

	
	private String email;

	@Override
	public Boolean sendNotification() {
		// TODO Auto-generated method stub
		return null;
	}
}
