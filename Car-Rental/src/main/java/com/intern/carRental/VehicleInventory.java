package com.intern.carRental;
import java.util.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VehicleInventory {
	
	private List<Vehicle> vehicleTypeIndex;
	private List<Vehicle> vehicleModelIndex;
	private Date creationDate;
	
}
