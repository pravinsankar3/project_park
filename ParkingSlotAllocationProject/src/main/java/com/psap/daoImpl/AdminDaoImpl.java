//package com.psap.daoImpl;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import com.psap.dao.AdminDao;
//import com.psap.model.Login;
//import com.psap.model.ParkingFloor;
//import com.psap.model.ParkingPremise;
//import com.psap.model.User;
//
//public class AdminDaoImpl implements AdminDao{
//	
//	EntityManager em;
//
//	public AdminDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA-PU");
//		em= emf.createEntityManager();
//	}
//
//	@Override
//	public boolean login(Login login) throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean blockUser(User user) throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean createParkingPremise(ParkingPremise parkingPremise) throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public ParkingPremise readParkingPremiseById(long parkingPremiseId) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<ParkingPremise> readParkingPremiseByName(String premiseName) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<ParkingPremise> readAllParkingPremises() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ParkingPremise updateParkingPremise(ParkingPremise parkingPremise) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean deleteParkingPremise(int parkingPremiseId) throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean createParkingFloor(ParkingFloor parkingFloor) throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public ParkingFloor readParkingFloorById(long parkingFloorId) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<ParkingFloor> readParkingFloorByNumber(long parkingPremiseId, String floorNumber) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<ParkingFloor> readAllParkingFloors(long parkingPremiseId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ParkingFloor updateParkingCapacity(ParkingFloor parkingFloor) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean deleteParkingFloor(long parkingFloorId) throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//}
