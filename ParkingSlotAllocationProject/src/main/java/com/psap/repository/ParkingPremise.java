package com.psap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingPremiseRepository extends JpaRepository <ParkingPremise, Integer> {

}
