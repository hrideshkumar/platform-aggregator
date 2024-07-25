package com.profile.repo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.profile.dto.SearchProfile;
import com.profile.dto.UserProfile;

import jakarta.annotation.PostConstruct;

@Component
public class ProfileRepo {

	Map<String, List<UserProfile>> profiles = new HashMap<String, List<UserProfile>>();
	
	@PostConstruct
	private void init() {
		// facebook influencer profile
		UserProfile fb = new UserProfile(1, "Jhon", "Chir", 32, List.of("Song"));
		profiles.put("facebook", List.of(fb));
		
		// insta influencer profile
		UserProfile insta = new UserProfile(1, "Jhon", "Chir", 32, List.of("Song"));
		profiles.put("insta", List.of(insta));
		
		
		// linkedin influencer profile
		UserProfile linkedin = new UserProfile(1, "Jhon", "Chir", 32, List.of("Song"));
		profiles.put("linkedin", List.of(linkedin));
	}
	
	
	
	
	
	
	public List<SearchProfile> findProfileList(String tenant){
		List<UserProfile> list = Optional.of(profiles).get().get(tenant);
		if(list == null)
			return Collections.emptyList();
		
		return list.stream().map(p -> new SearchProfile(p.getId(), p.getFirstName(), p.getLastName())).collect(Collectors.toList());
	}

	public UserProfile save(UserProfile profile, String tenant) {
		Optional<List<UserProfile>> prof = Optional.ofNullable(profiles.get(tenant));
		if(prof.isPresent()) {
			List<UserProfile> newPro = prof.orElse(List.of());
			newPro.add(profile);
			profiles.put(tenant, newPro);
		}else {
			List<UserProfile> newPro = List.of(profile);
			profiles.put(tenant, newPro);
		}
		return profile;
	}

	public UserProfile findById(int id, String tenant) {
		Optional<List<UserProfile>> list = Optional.of(profiles.get(tenant));
		if(list.isEmpty())
			return null;
		Optional<UserProfile> matchedP = list.get().stream().filter(p -> p.getId() == id).findFirst();
		return matchedP.orElse(null);
	}

}
