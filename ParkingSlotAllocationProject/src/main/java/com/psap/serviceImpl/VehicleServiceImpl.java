package com.psap.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psap.exceptions.DuplicateVehicleException;
import com.psap.exceptions.NoSuchVehicleException;
import com.psap.model.User;
import com.psap.model.Vehicle;
import com.psap.repository.VehicleRepository;
import com.psap.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	VehicleRepository dao;
	
	
	@Override
	public boolean addUsersVehicle(Vehicle vehicle) throws DuplicateVehicleException {
		// TODO Auto-generated method stub
		System.out.println(vehicle.getOwner());
		dao.save(vehicle);
		return true;
	}

	@Override
	public Vehicle findVehicleByVehicleNumber(String vehicleNumber, int userId) throws NoSuchVehicleException {
		// TODO Auto-generated method stub
		Vehicle v= new Vehicle();
		v.setVehicleNumber(vehicleNumber);
		User u=new User();
		u.setUserId(userId);
		v.setOwner(u);
//		Vehicle userVehicle = dao.findOne(Example.of(v));
		Vehicle userVehicle = dao.findByVehicleNumberAndOwnerUserId(vehicleNumber, userId);
		return userVehicle;
	}

	@Override
	public List<Vehicle> findAllVehiclesByUserId(int ownerId) {
		// TODO Auto-generated method stub
		Vehicle v= new Vehicle();
		User u=new User();
		u.setUserId(ownerId);
		v.setOwner(u);
		List<Vehicle> vehiclesList = dao.findByOwner(u);

		return vehiclesList;
	}

	@Override
	public boolean removeVehicleByVehicleNumber(String vehicleNumber, int userId) throws NoSuchVehicleException {
		// TODO Auto-generated method stub
		Vehicle v= new Vehicle();
		v.setVehicleNumber(vehicleNumber);
		User u=new User();
		u.setUserId(userId);
		v.setOwner(u);
		dao.delete(v);
		return true;
	}

	@Override
	public Vehicle modifyVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		Vehicle vehicleRef = dao.getOne(vehicle.getVehicleId());
		if(vehicle.getOwner() != null) {
			vehicleRef.setOwner(vehicle.getOwner());
		}
		if(vehicle.getVehicleCompany() != null) {
			vehicleRef.setVehicleCompany(vehicle.getVehicleCompany());
		}
		vehicleRef.setVehicleModel(vehicle.getVehicleModel());
		vehicleRef.setVehicleNumber(vehicle.getVehicleNumber());
		vehicleRef.setVehicleType(vehicle.getVehicleType());
		dao.save(vehicleRef);
		return vehicleRef;
	}

}
