package com.psap.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.checkerframework.checker.nullness.Opt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.psap.exceptions.DuplicateUserException;
import com.psap.exceptions.NoSuchUserException;
import com.psap.model.Login;
import com.psap.model.User;
import com.psap.repository.LoginRepository;
import com.psap.repository.UserRepository;
import com.psap.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	@Autowired
	UserRepository userrepo;
	@Autowired
	LoginRepository loginrepo;
	
												// Get Mapping //
	
	// Get all Users 
	
	@GetMapping("/allusers")   
	public List<User> getAllUsers(){
		List<User> list = (List<User>) userrepo.findAll();
		return list;
	}
	
	// User to login 
	
	@GetMapping("/login")     
	public ResponseEntity<?> loginUser(Login login) throws NoSuchUserException {
		
		if (!userrepo.equals(login))
			throw new NoSuchUserException("User id"+login.getLoginId() + "does not exists");
		
		return new ResponseEntity<String>("User Logged in Successfully", HttpStatus.CREATED);
	}
	
	// Find User by login Id
	
	@GetMapping("/finduser/{uid}")
	public ResponseEntity<?> getUserProfileById(@PathVariable("uid") long userId) throws NoSuchUserException{
		Optional<User> opt = userrepo.findById(userId);
		if (opt.isPresent())
			return new ResponseEntity<User>(opt.get(), HttpStatus.OK);
		throw new NoSuchUserException("User with Id " + userId + "Not Found");
	}
	
	
												// Post Mapping //
	
	// User to register
	
	@PostMapping("/register") 		
	public ResponseEntity<?> registerUser(User user) throws DuplicateUserException {
		Optional<User> opt = userrepo.findById(user.getUserId());
		if(opt.isPresent())
			throw new DuplicateUserException("User with Id " +user.getUserId()+ "Already exists");
		userrepo.save(user);
		return new ResponseEntity<String>("User Registered Sucessfully",HttpStatus.CREATED);
	}
											
												//Put Mapping //
	
	// User to update LoginId
	
	@PutMapping("/updatelogin")			
	public ResponseEntity<?> updateLoginId(@RequestBody Login login) throws DuplicateUserException {
			Optional<Login> upt = loginrepo.findById(login.getLoginId());
			if (!upt.isPresent())
				return new ResponseEntity<String>("User with Id" + login.getLoginId()+ "not exists", null);
			loginrepo.save(login);
			throw new DuplicateUserException("User with Id " +login.getLoginId()+ "Updated Login Id successfully");
	}
	
	// User to update password
	
	@PutMapping("/updatepass")			
	public ResponseEntity<?> updatePassword(@RequestBody Login login) throws DuplicateUserException {
			Optional<Login> upass = loginrepo.findById(login.getPassword());
			if (!upass.isPresent())
				return new ResponseEntity<String>("User with Id" + login.getLoginId()+ "not exists", null);
			loginrepo.save(login);
			throw new DuplicateUserException("User with Login Id " +login.getLoginId()+ "Updated  Password successfully");
	}
											
												// Delete Mapping //
	
	// User to delete
	
	@DeleteMapping("/delete")		
	public ResponseEntity<?> deleteUser(@RequestBody long userId )throws NoSuchUserException{
		Optional<User> opt = userrepo.findById(userId);
		if (opt.isPresent()) {
			userrepo.deleteById(userId);
			return new ResponseEntity<String>("User with Id"+userId+ "deleted succesfully",HttpStatus.OK);
		}else
			throw new NoSuchUserException("User with" +userId+ "not exists");
	}
	
	
	
}

