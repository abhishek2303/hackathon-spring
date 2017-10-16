package com.stackroute.hackathon.servicecontracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.hackathon.domains.User;

@Service
public interface UserService {
	public User addUser(User user) throws Exception;
	public User update(User user) throws Exception;
	public User retrieveUserById(long id) throws Exception;
	public List<User> retrieveAllUsers() throws Exception;
	public User deleteUserById(long id) throws Exception;
}
