package com.stackroute.hackathon.serviceimpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.hackathon.HackathonApplication;
import com.stackroute.hackathon.dao.UserServiceImpl;
import com.stackroute.hackathon.repositorycontracts.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HackathonApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class UserServiceImplTest {
	private UserServiceImpl userService;
	
	@Before
	public void setup() {
		
	}
	
	@After
	public void teardown() {
		
	}
	
	@Test
	public void testForInvalidId() {
		userService = new UserServiceImpl();
	}

}
