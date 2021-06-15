package com.psap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psap.model.ParkingFloor;

@Repository
public interface ParkingFloorRepository extends JpaRepository<ParkingFloor, Integer> {

}
