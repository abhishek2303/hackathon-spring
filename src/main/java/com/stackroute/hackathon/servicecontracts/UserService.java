package com.stackroute.hackathon.servicecontracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.hackathon.domains.User;

@Service
public interface UserService {
	public User addUser(User user);
	public User update(User user);
	public User retrieveUserById(long id);
	public List<User> retrieveAllUsers();
	public User deleteUserById(long id);
}
