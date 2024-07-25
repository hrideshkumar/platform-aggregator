package com.profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profile.dto.SearchProfile;
import com.profile.dto.UserProfile;
import com.profile.service.ProfileService;

@RestController
@RequestMapping("/profile/{tenant}")
public class Controller {

	@Autowired
	private ProfileService service;
	
	@GetMapping
	public ResponseEntity<List<SearchProfile>> getAllProfileList(@PathVariable String tenant) {
		return new ResponseEntity<List<SearchProfile>>(service.getAllProfiles(tenant), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<UserProfile> saveProfile(@RequestBody UserProfile profile, @PathVariable String tenant) {
		return new ResponseEntity<UserProfile>(service.saveProfileRepo(profile, tenant), HttpStatus.OK);
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<UserProfile> saveProfile(@PathVariable String tenant, @PathVariable String id) {
		return new ResponseEntity<UserProfile>(service.getProfileById(Integer.valueOf(id), tenant), HttpStatus.OK);
	} 
}
