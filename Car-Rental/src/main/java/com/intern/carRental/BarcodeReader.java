package com.intern.carRental;
import java.util.*;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class BarcodeReader {
	private String Id;
	private Date registeredAt;
	private Boolean active;
	
	public Boolean isActive() {
		//TODO isActive
		return null;
	}
}
