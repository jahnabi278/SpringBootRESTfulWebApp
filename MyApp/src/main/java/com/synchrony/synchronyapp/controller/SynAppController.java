package com.synchrony.synchronyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synchrony.synchronyapp.model.SynchronyUser;
import com.synchrony.synchronyapp.model.UserCredential;

import com.synchrony.synchronyapp.service.SynchronyService;

@RestController
@RequestMapping("/app")
public class SynAppController {

	@Autowired
	SynchronyService synService;

	@PostMapping("/signup")
	public ResponseEntity<String> ceate(@RequestBody SynchronyUser synUser) {
		return synService.create(synUser);
	}

	@PostMapping("/signin")
	public ResponseEntity<String> validate(@RequestBody UserCredential userCred) {
		return synService.validate(userCred);
	}

	@GetMapping("/allusers")
	public ResponseEntity<List<SynchronyUser>> getAllUsers() {
		return synService.getAllUsers();

	}

	@GetMapping("/user/{userName}")
	public ResponseEntity<SynchronyUser> getUser(@PathVariable String userName) {
		return synService.getUser(userName);

	}

}
