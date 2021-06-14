package com.psap.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle")
public class Vehicle {
	// should be auto-generated
	@Id
	private long vehicleId;
	@Enumerated(EnumType.ORDINAL)
	private VehicleType vehicleType;
	private String vehicleNumber;
	private String vehicleCompany;
	private String vehicleModel;
	@OneToOne
	private User owner;
	
	// Constructors, Getter & Setter method
	public Vehicle() {
		super();
	}
	
	public Vehicle(long vehicleId, VehicleType vehicleType, String vehicleNumber, String vehicleCompany,
			String vehicleModel, User owner) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.vehicleCompany = vehicleCompany;
		this.vehicleModel = vehicleModel;
		this.owner = owner;
	}

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleCompany() {
		return vehicleCompany;
	}

	public void setVehicleCompany(String vehicleCompany) {
		this.vehicleCompany = vehicleCompany;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleType=" + vehicleType + ", vehicleNumber=" + vehicleNumber
				+ ", vehicleCompany=" + vehicleCompany + ", vehicleModel=" + vehicleModel + ", owner=" + owner + "]";
	}
	
	
}
