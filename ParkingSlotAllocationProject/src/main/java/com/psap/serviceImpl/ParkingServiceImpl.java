package com.psap.serviceImpl;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.psap.exceptions.NoSuchParkingSlotException;
import com.psap.exceptions.ParkingSlotNotAvailableException;
import com.psap.model.Address;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.ParkingSlots;
import com.psap.repository.AddressRepository;
import com.psap.repository.ParkingFloorRepository;
import com.psap.repository.ParkingPremiseRepository;
import com.psap.repository.ParkingSlotsRepository;
import com.psap.service.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {
	
	@Autowired
	ParkingPremiseRepository parkPremiseRepo;
	@Autowired
	ParkingFloorRepository parkFloorRepo;
	@Autowired
	ParkingSlotsRepository parkSlotsRepo;
	@Autowired
	AddressRepository addressRepo; 

	@Override
	public boolean checkAvailability(Date date, String time) throws ParkingSlotNotAvailableException {
		ParkingSlots value = parkSlotsRepo.findByParkingDateAndParkingTime(new Date() , "12:00");
		if(value == null) {
		return true;
		}
		return false;
	}

	@Override
	public boolean bookParkingSlot(ParkingSlots slot) throws ParkingSlotNotAvailableException {
		Optional<ParkingSlots> p = parkSlotsRepo.findById(slot.getParkingSlotId());
		if(p.isPresent())
			throw new ParkingSlotNotAvailableException("Parking slot is occupied");
			parkSlotsRepo.save(slot);
			return true;
	}

	@Override
	public boolean cancelParkingSlotBooking(ParkingSlots slot) throws NoSuchParkingSlotException {
		Optional<ParkingSlots> p = parkSlotsRepo.findById(slot.getParkingSlotId());
		if(!p.isPresent())
			throw new NoSuchParkingSlotException("Parking slot is not available");
			parkSlotsRepo.delete(slot);
			return true;
	}

//	@Override
//	public Optional<ParkingPremise> getAllParkingSlotsByPremise(ParkingPremise parkingPremise) {
//		Optional<ParkingPremise> p = parkPremiseRepo.findById(parkingPremise.getParkingPremiseId());
//		return p;
//	}

	@Override
	public <ParkingFloor> getAllParkingSlotsByFloor(ParkingFloor parkingFloor) {
		Optional<ParkingFloor> p = parkFloorRepo.findById(parkingFloor.getNumberOfParkingSlots());
		return p;
	}

	@Override
	public Optional<ParkingSlots> getParkingSlotsById(long parkingSlotId) {
		
		Optional<ParkingSlots> slot = parkSlotsRepo.findById(parkingSlotId);
		if(!slot.isPresent())
			throw new NoSuchParkingSlotException("Slot With Id "+ parkingSlotId +" Not Found");
		return slot;
	}

	@Override
	public List<ParkingSlots> getAllParkingSlotsByPremise(ParkingPremise parkingPremise) {
		// TODO Auto-generated method stub
		return null;
	}

}
