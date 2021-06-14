//package com.psap.serviceImpl;
//
//import java.util.List;
//
//import com.psap.dao.AdminDao;
//import com.psap.daoImpl.AdminDaoImpl;
//import com.psap.exceptions.DuplicateParkingFloorException;
//import com.psap.exceptions.DuplicateParkingPremiseException;
//import com.psap.exceptions.InvalidLoginCredintialException;
//import com.psap.exceptions.NoSuchParkingFloorException;
//import com.psap.exceptions.NoSuchParkingPremiseException;
//import com.psap.exceptions.NoSuchUserException;
//import com.psap.model.Login;
//import com.psap.model.ParkingFloor;
//import com.psap.model.ParkingPremise;
//import com.psap.model.User;
//import com.psap.service.AdminService;
//
//public class AdminServiceImpl implements AdminService{
//	
//	AdminDao ad = new AdminDaoImpl();
//	
//	
//
//	@Override
//	public boolean login(Login login) throws InvalidLoginCredintialException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean blockUser(User user) throws NoSuchUserException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean addParkingPremise(ParkingPremise parkingPremise) throws DuplicateParkingPremiseException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public ParkingPremise getParkingPremiseById(long parkingPremiseId) throws NoSuchParkingPremiseException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<ParkingPremise> getParkingPremiseByName(String premiseName) throws NoSuchParkingPremiseException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<ParkingPremise> getAllParkingPremises() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ParkingPremise modifyParkingPremise(ParkingPremise parkingPremise) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean removeParkingPremise(int parkingPremiseId) throws NoSuchParkingPremiseException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean addParkingFloor(ParkingFloor parkingFloor) throws DuplicateParkingFloorException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public ParkingFloor getParkingFloorById(long parkingFloorId) throws NoSuchParkingFloorException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<ParkingFloor> getParkingFloorByNumber(long parkingPremiseId, String floorNumber)
//			throws NoSuchParkingFloorException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<ParkingFloor> getAllParkingFloors(long parkingPremiseId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ParkingFloor modifyParkingCapacity(ParkingFloor parkingFloor) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean removeParkingFloor(long parkingFloorId) throws NoSuchParkingPremiseException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//}
