package com.psap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psap.model.ParkingPremise;

@Repository
public interface ParkingPremiseRepository extends JpaRepository <ParkingPremise, Integer> {
	List<ParkingPremise> findByParkingPremiseName(String parkingPremiseName);

}
