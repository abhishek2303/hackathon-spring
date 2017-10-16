package com.stackroute.hackathon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.hackathon.domains.User;
import com.stackroute.hackathon.servicecontracts.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1.0/api/rest-user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ApiOperation(value = "Add a new User")
	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		try {
	          userService.addUser(user);
	          return new ResponseEntity<User>(user,HttpStatus.CREATED);
	      }
	      catch(Exception e) { 
	    	  e.printStackTrace();	    	  
	          return new ResponseEntity<String>("{\"msg\": \"User already exists\"}",HttpStatus.CONFLICT);
	      }
	}
	
	@ApiOperation(value = "Update an existing User")
	@PutMapping(value="/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		 try {
	       		userService.update(user);
	            return new ResponseEntity<User>(user,HttpStatus.OK);
	       }
	        catch(Exception e) {
	            return new ResponseEntity<String>("{\"msg\": \"User doesn't exist\"}",HttpStatus.NO_CONTENT);
	        }
	}
	
	@ApiOperation(value = "Retrieve a User by ID")
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id) {
    	try {
    		return new ResponseEntity<User>(userService.retrieveUserById(id),HttpStatus.OK);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<String>("{\"msg\": \"No User exists by this ID\"}",HttpStatus.NO_CONTENT);
    	}
    }
	
	@ApiOperation(value = "Retrive all Users", response = Iterable.class)
	@GetMapping("/user")
	public ResponseEntity<?> getAllUsers() {
		try {
    		return new ResponseEntity<List>(userService.retrieveAllUsers(),HttpStatus.OK);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<String>("{\"msg\": \"No Users exist\"}",HttpStatus.NO_CONTENT);
    	}
	}
	
	@ApiOperation(value = "Delete a User by ID")
	@DeleteMapping("/user/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {
		if(id <= 0) {
			return new ResponseEntity<String>("{\"msg\": \"Enter a valid id\"}",HttpStatus.NO_CONTENT);
		}
		try {
			User deletedUser = userService.deleteUserById(id);
            return new ResponseEntity<User>(deletedUser, HttpStatus.OK);
        }
        catch(Exception e) {
        	System.out.println("delete not possbile for id " + id);
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NO_CONTENT);
        }
	}
}

