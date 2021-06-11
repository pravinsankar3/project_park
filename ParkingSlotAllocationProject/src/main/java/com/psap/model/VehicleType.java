package com.psap.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "VehicleType")
public enum VehicleType {
	TwoWheeler, ThreeWheeler, FourWheeler
}
