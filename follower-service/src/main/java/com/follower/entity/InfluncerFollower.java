package com.follower.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfluncerFollower {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int userId;
	private List<String> influncerId;
}
