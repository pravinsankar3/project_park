package com.psap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psap.model.ParkingFloor;

@Repository
public interface ParkingFloorRepository extends JpaRepository<ParkingFloor, Integer> {
	ParkingFloor getOne(int parkingFloorId);
	List<ParkingFloor> findByFloorNo(String floorNumber);
	
}
