package com.intern.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.carRental.primary.VehicleReservation;

public interface VehicleReservationRepository extends JpaRepository<VehicleReservation, Integer>{

}
