package com.profile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profile.dto.SearchProfile;
import com.profile.dto.UserProfile;
import com.profile.repo.ProfileRepo;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepo repo;
	
	
	public UserProfile saveProfileRepo(UserProfile profile, String tenant) {
		return repo.save(profile, tenant);
	}
	
	public List<SearchProfile> getAllProfiles(String tenant){
		return repo.findProfileList(tenant);
	}
	
	public UserProfile getProfileById(int id, String tenant){
		return repo.findById(id, tenant);
	}

}
