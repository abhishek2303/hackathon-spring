package com.stackroute.hackathon.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.hackathon.HackathonApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HackathonApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

	@LocalServerPort
    private int port;
    
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    
    @Before
    public void setUp() throws Exception {  
        
    }
    
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testGetAllUsers() throws Exception {
    	
    }
    
    @Test
    public void testGetUserByExistingId() throws Exception {
    	
    }
    
    @Test
    public void testGetUserByNonExistingId() throws Exception {
    	
    }
    
    @Test
    public void testAddNewUser() throws Exception {
    	
    }
    
    @Test
    public void testAddExistingUser() throws Exception {
    	
    }
    
    @Test
    public void testUpdateExistingUser() throws Exception {
    	
    }
    
    @Test
    public void testUpdateNonExistingUser() throws Exception {
    	
    }
    
    @Test
    public void testDeleteExitingUser() throws Exception {
    	
    	
    }
    
    @Test
    public void testDeleteNonExitingUser() throws Exception {
    	
    	
    }
}
