package com.stackroute.hackathon.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.hackathon.domains.User;
import com.stackroute.hackathon.repositorycontracts.UserRepository;
import com.stackroute.hackathon.servicecontracts.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public User retrieveUserById(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> retrieveAllUsers() {
		Iterable<User> iterable = userRepository.findAll();
		List<User> users = new ArrayList<User>();
		for(User user:  iterable) {
			users.add(user);
		}
		return users;
	}

	@Override
	public User deleteUserById(long id) {
		User userToDelete = userRepository.findOne(id);
		userRepository.delete(id);
		return userToDelete;
	}

}
