package com.follower.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.follower.entity.InfluncerFollower;

public interface FollowerRepo extends JpaRepository<InfluncerFollower, Integer>{

	public InfluncerFollower getByUserId(int userId);
}
