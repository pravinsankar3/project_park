package com.psap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psap.model.ParkingSlots;

@Repository
public interface ParkingSlotsRepository extends JpaRepository <ParkingSlots, Long>{

}
