package com.intern.DAO;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.intern.carRental.primary.abstrct.Vehicle;
import com.intern.carRental.primary.intrfces.AbstractVehicleRepository;

public interface VehicleRepository extends AbstractVehicleRepository<Vehicle>{
	Vehicle findByBarcode(String barcode);
	Vehicle deleteByBarcode(String barcode);
	ArrayList<Vehicle> findAllByModel(String model);
	//ArrayList<Vehicle> findAllByType(String type);
	
}
