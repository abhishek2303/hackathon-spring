package com.stackroute.hackathon.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.hackathon.HackathonApplication;
import com.stackroute.hackathon.dao.UserServiceImpl;
import com.stackroute.hackathon.domains.User;
import com.stackroute.hackathon.repositorycontracts.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HackathonApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceImplMockTest {
	private UserServiceImpl userServiceImpl;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private User user;
	
	@Before
	public void setupMockito() {
		MockitoAnnotations.initMocks(this);
        userServiceImpl = new UserServiceImpl();
        
        userServiceImpl.setUserRepository(userRepository);
	}
	
	@After
	public void teardownMockito() {
		
	}
	
	@Test
	public void addUser() {
//		user = new User();
//		user.setId((long) 22201);
//		user.setName("Abhishek");
//		//Arrange
//		when(userRepository.findOne((long) 22201)).thenReturn(user);
//		//Act
//		User retrievedUser = userServiceImpl.(long) 22201);
//		//Assert
//		assertEquals("Checking ", retrievedUser.getUsername(), "abhishek23");
	}
}
