package com.stackroute.hackathon.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.stackroute.hackathon.domains.User;
import com.stackroute.hackathon.exceptions.InvalidUserEmailException;
import com.stackroute.hackathon.exceptions.InvalidUserIdException;

import java.util.regex.Matcher;

@Component
public class UserValidator {
	public void validateUserEmail(String email) throws InvalidUserEmailException{
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = p.matcher(email);
		if(!matcher.find())
				throw new InvalidUserEmailException("Invalid user email: " + email);
	}
	
	public boolean validateUserId(long id) throws InvalidUserIdException {
		if(id <= 0) {
			throw new InvalidUserIdException("Invalid user id: " + id);
		}
		return true;
	}
	
	public void validate(User user) throws InvalidUserIdException, InvalidUserEmailException {
		validateUserId(user.getId());
		validateUserEmail(user.getEmail());
	}
}
