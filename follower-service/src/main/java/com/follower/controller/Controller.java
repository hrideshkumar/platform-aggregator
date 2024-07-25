package com.follower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.follower.service.FollowerService;

@RestController
@RequestMapping("/follow")
public class Controller {

	@Autowired
	private FollowerService service;

	@PutMapping("/{userId}/{influncerId}")
	public ResponseEntity<String> follow(@PathVariable String influncerId, @PathVariable int userId) {
		boolean result = service.followInfluncer(userId, influncerId);
		if (result)
			return new ResponseEntity<String>("SUCESS", HttpStatus.OK);

		return new ResponseEntity<String>("FAILED", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/{userId}/{influncerId}")
	public ResponseEntity<Boolean> isFollowed(@PathVariable String influncerId, @PathVariable int userId) {
		List<String> influncerList = service.getFollowedInfluncerList(userId);

		return new ResponseEntity<Boolean>(influncerList.contains(influncerId), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
