package com.psap.ErrorHandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.psap.exceptions.NoSuchParkingSlotException;


@ControllerAdvice
public class ParkingException {
	@ExceptionHandler(NoSuchParkingSlotException.class)
	public ResponseEntity<?> handleEmployeeDataError(NoSuchParkingSlotException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","parking Slot Unavailable");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	
}
