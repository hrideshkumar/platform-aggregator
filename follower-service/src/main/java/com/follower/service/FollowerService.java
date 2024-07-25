package com.follower.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.follower.entity.InfluncerFollower;
import com.follower.repo.FollowerRepo;

@Service
public class FollowerService {

	@Autowired
	private FollowerRepo repo;
	
	public List<String> getFollowedInfluncerList(int userId){
		Optional<InfluncerFollower> influncerFollower = Optional.ofNullable(repo.getByUserId(userId));
		if(influncerFollower.isPresent())
			return influncerFollower.get().getInfluncerId();
		else
			return List.of();
	}
	
	public boolean followInfluncer(int userId, String influncerId) {
		Optional<InfluncerFollower> influncerFollower = Optional.ofNullable(repo.getByUserId(userId));
		if(influncerFollower.isPresent()) {
			return influncerFollower.get().getInfluncerId().add(influncerId);
		}
		List<String> list = List.of(influncerId);
		InfluncerFollower follwer = new InfluncerFollower();
		follwer.setUserId(userId);
		follwer.setInfluncerId(list);
		repo.save(follwer);
		return true;
		
		
		
	}
}
