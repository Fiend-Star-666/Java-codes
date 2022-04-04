package com.intern.carRental;

import java.util.*;
import com.intern.status.VehicleLogType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleLog {
	private String id;
	private VehicleLogType type;
	private String descriptoin;
	private Date creationDate;
	
	
	
	
	public ArrayList<VehicleLogType> searchByLogtype(){
		//TODO searchByLogType
		return null;
	}

}
