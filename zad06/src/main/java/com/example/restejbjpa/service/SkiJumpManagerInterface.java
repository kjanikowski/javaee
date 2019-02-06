package com.example.restejbjpa.service;

import java.util.List;

import com.example.restejbjpa.domain.SkiJump;


public interface SkiJumpManagerInterface {
	
	void addSkiJump(SkiJump skiJump);
	List<SkiJump> getAllSkiJumps();
	SkiJump getByName(String name);
	void removeSkiJump(long id);
	SkiJump getSkiJump(long id);
	List<SkiJump> getAllByCompetition(String type);
	SkiJump getByCity(String city);
}
