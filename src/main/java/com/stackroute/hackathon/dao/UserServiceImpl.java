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
	public User addUser(User user) throws Exception{
		User u = userRepository.findOne(user.getId());
		if(u==null)
			return userRepository.save(user);
		else
			throw new Exception();
	}

	@Override
	public User update(User user) throws Exception{
		User u = userRepository.findOne(user.getId());
		if(u==null)
			throw new Exception();
		else
			return userRepository.save(user);
	}

	@Override
	public User retrieveUserById(long id) throws Exception {
		User u = userRepository.findOne(id);
		if(u==null)
			throw new Exception();
		else
			return userRepository.findOne(id);
	}

	@Override
	public List<User> retrieveAllUsers() throws Exception{
		Iterable<User> iterable = userRepository.findAll();
		List<User> users = new ArrayList<User>();
		for(User user:  iterable) {
			users.add(user);
		}
		if (users == null)
			throw new Exception();
		else
			return users;
	}

	@Override
	public User deleteUserById(long id) throws Exception{
		User userToDelete = userRepository.findOne(id);
		if(userToDelete==null)
			throw new Exception();
		else {
		userRepository.delete(id);
		return userToDelete;
		}
	}

}
