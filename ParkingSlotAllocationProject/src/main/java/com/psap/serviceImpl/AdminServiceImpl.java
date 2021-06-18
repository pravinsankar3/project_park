package com.psap.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.psap.exceptions.DuplicateParkingFloorException;
import com.psap.exceptions.DuplicateParkingPremiseException;
import com.psap.exceptions.InvalidLoginCredintialException;
import com.psap.exceptions.NoSuchParkingFloorException;
import com.psap.exceptions.NoSuchParkingPremiseException;
import com.psap.exceptions.NoSuchUserException;
import com.psap.model.Login;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.User;
import com.psap.repository.LoginRepository;
import com.psap.repository.ParkingFloorRepository;
import com.psap.repository.ParkingPremiseRepository;
import com.psap.repository.UserRepository;
import com.psap.service.AdminService;

public class AdminServiceImpl implements AdminService{
	
	@Autowired
	LoginRepository lr;
	@Autowired
	UserRepository ur;
	@Autowired
	ParkingPremiseRepository pp;
	@Autowired
	ParkingFloorRepository pf;

	@Override
	public boolean login(Login login) throws InvalidLoginCredintialException {
		Optional<Login> l = lr.findById(login.getLoginId());
		if(!login.getPassword().equals(l.get().getPassword()))
			throw new InvalidLoginCredintialException("User Id and Password not Matching");
		return true;
	}

	@Override
	public boolean blockUser(User user) throws NoSuchUserException {
		Optional<User> u = ur.findById(user.getUserId());
		if(!u.isPresent())
			throw new NoSuchUserException("User is not available to block");
		ur.delete(user);
		return true;
	}

	@Override
	public boolean addParkingPremise(ParkingPremise parkingPremise) throws DuplicateParkingPremiseException {
		Optional<ParkingPremise> p = pp.findById(parkingPremise.getParkingPremiseId());
		if(p.isPresent())
			throw new DuplicateParkingPremiseException("Parking Premise is already present");
		pp.save(parkingPremise);
		return true;
	}

	@Override
	public ParkingPremise getParkingPremiseById(long parkingPremiseId) throws NoSuchParkingPremiseException {
		Optional<ParkingPremise> p = pp.findById((int) parkingPremiseId);
		if(!p.isPresent())
			throw new NoSuchParkingPremiseException("No Parking Premise found for this ID");
		return p.get();
	}

	@Override
	public List<ParkingPremise> getParkingPremiseByName(String premiseName) throws NoSuchParkingPremiseException {
		List<ParkingPremise> p = (List<ParkingPremise>) pp.findByParkingPremiseName(premiseName);
		return p;
	}

	@Override
	public List<ParkingPremise> getAllParkingPremises() {
		return pp.findAll();
	}

	@Override
	public ParkingPremise modifyParkingPremise(ParkingPremise parkingPremise) {
		ParkingPremise pre = (ParkingPremise) pp.findByParkingPremiseId(parkingPremise.getParkingPremiseId());
		if(parkingPremise.getParkingPremiseName() == null) {
			
			pre.setParkingPremiseName(parkingPremise.getParkingPremiseName());
		}
		pre.setNumberOfParkingFloors(parkingPremise.getNumberOfParkingFloors());
		pre.setParkingPremiseId(parkingPremise.getParkingPremiseId());
		pre.setPremiseAddress(parkingPremise.getPremiseAddress());
		pp.save(pre);
		return pre;
	}

	@Override
	public boolean removeParkingPremise(int parkingPremiseId) throws NoSuchParkingPremiseException {
		Optional<ParkingPremise> p = pp.findById((int) parkingPremiseId);
		if(!p.isPresent())
			throw new NoSuchParkingPremiseException("No Parking Premise found for this ID");
		pp.deleteById(parkingPremiseId);
		return true;
	}

	@Override
	public boolean addParkingFloor(ParkingFloor parkingFloor) throws DuplicateParkingFloorException {
		Optional<ParkingFloor> p = pf.findById(parkingFloor.getParkingFloorId());
		if(p.isPresent())
			throw new DuplicateParkingFloorException("Parking Floor is already present");
		pf.save(parkingFloor);
		return true;
	}

	@Override
	public ParkingFloor getParkingFloorById(long parkingFloorId) throws NoSuchParkingFloorException {
		Optional<ParkingFloor> p = pf.findById((int) parkingFloorId);
		if(!p.isPresent())
			throw new NoSuchParkingFloorException("No Parking Floor found for this ID");
		return p.get();
	}

	@Override
	public List<ParkingFloor> getParkingFloorByNumber(long parkingPremiseId, String floorNumber)
			throws NoSuchParkingFloorException {
		List<ParkingFloor> li = (List<ParkingFloor>) pf.findByFloorNumber(floorNumber);
		return li;
	}

	@Override
	public List<ParkingFloor> getAllParkingFloors(long parkingPremiseId) {
		return pf.findAll();
	}

	@Override
	public ParkingFloor modifyParkingCapacity(ParkingFloor parkingFloor) {
		ParkingFloor pfe = (ParkingFloor) pf.findByParkingFloorId(parkingFloor.getParkingFloorId());
		if(parkingFloor.getParkingFloorId() != 0) {
			
			pfe.setParkingFloorId(parkingFloor.getParkingFloorId());
		}
		pfe.setFloorNumber(parkingFloor.getFloorNumber());
		pfe.setNumberOfParkingSlots(parkingFloor.getNumberOfParkingSlots());
		pfe.setParkingPremise(parkingFloor.getParkingPremise());
		pf.save(pfe);
		return pfe;
	}

	@Override
	public boolean removeParkingFloor(long parkingFloorId) throws NoSuchParkingPremiseException {
		Optional<ParkingFloor> p = pf.findById((int) parkingFloorId);
		if(!p.isPresent())
			throw new NoSuchParkingPremiseException("No Parking Floor found for this ID");
		pp.deleteById((int) parkingFloorId);
		return true;
	}

}
