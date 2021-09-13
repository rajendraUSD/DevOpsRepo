package com.usd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usd.entity.User;
import com.usd.exception.UserNotFoundException;
import com.usd.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepo;

	public User saveUser(User user) {

		return registrationRepo.save(user);
	}

	public User fetchUserByEmailId(String email) {
		return registrationRepo.findByEmailId(email);

	}

	public User fetchUserByEmailIdAndPassword(String emailId, String password) {
		return registrationRepo.findByEmailIdAndPassword(emailId, password);
	}

	public void updateResetPassword(String token, String email) throws UserNotFoundException {
		User user = registrationRepo.findByEmailId(email);
		if (user != null) {
			user.setResetPasswordToken(token);
			registrationRepo.save(user);
		} else {
			throw new UserNotFoundException("Could not found any email with" + email);
		}
	}

	public User getByResetPasswordToken(String resetPasswordToken) {
		return registrationRepo.findByResetPasswordToken(resetPasswordToken);

	}

	public void updatePassword(User user, String newPasssword) {
		user.setPassword(newPasssword);
		registrationRepo.save(user);
	}
}
