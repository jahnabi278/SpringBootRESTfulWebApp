package com.synchrony.synchronyapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.synchrony.synchronyapp.logger.Logger;
import com.synchrony.synchronyapp.model.SynchronyUser;
import com.synchrony.synchronyapp.model.UserCredential;
import com.synchrony.synchronyapp.repo.SynchronyRepository;

@Service
public class SynchronyService {

	@Autowired
	SynchronyRepository synRepo;

	public ResponseEntity<String> create(SynchronyUser synUser) {
		synRepo.save(synUser);
		Logger.info("User created successsfullly ....");
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<String> validate(UserCredential userCred) {

		SynchronyUser user = synRepo.findById(userCred.getUserName()).get();
		if (user.getPassWord().equals(userCred.getPassWord())) {
			Logger.info("Login successful.");
			return new ResponseEntity<>("Login SuccesssFul", HttpStatus.OK);
		}
		Logger.error("Invalid User");
		return new ResponseEntity<>("User invalid", HttpStatus.OK);
	}

	public ResponseEntity<SynchronyUser> getUser(String userName) {
		SynchronyUser user = synRepo.findById(userName).orElse(new SynchronyUser());
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	public ResponseEntity<List<SynchronyUser>> getAllUsers() {
		try {
			return new ResponseEntity<>(synRepo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			Logger.info("Failed to retrieve user.", e);
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

}
