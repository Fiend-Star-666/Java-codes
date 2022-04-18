package com.intern.primary.addonServices;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import com.intern.carRental.primary.abstrct.Notification;
import com.intern.primary.simplePOJO.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PrimaryKeyJoinColumn(name="id")
@Entity
public class SMSNotification extends Notification{
	

	
	private String phonenum;
	private Location address;

	@Override
	public Boolean sendNotification() {
		// TODO Auto-generated method stub
		return null;
	}
}
