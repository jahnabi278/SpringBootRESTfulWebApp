package com.synchrony.synchronyapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.synchrony.synchronyapp.model.SynchronyUser;
import com.synchrony.synchronyapp.repo.SynchoronyJSPRepository;

public class SynchronyJSPService {

	/**@Autowired
	SynchoronyJSPRepository synJspRepo;

	public void addSynUser(SynchronyUser user) {
		synJspRepo.save(user);
	}

	public void login(String userName, String password) {
		SynchronyUser user = synJspRepo.findById(userName).get();
		if (user.getPassWord().equals(password)) {

		}
	}**/
}
