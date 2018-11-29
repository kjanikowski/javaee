package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;

import com.example.restwsdemo.domain.SkiJump;
@Singleton
public class SkiJumpManager {
	
	private List<SkiJump> list = Collections.synchronizedList(new ArrayList<SkiJump>());
	
	public void addSkiJump(SkiJump skiJump) {
		list.add(skiJump);
	}
	
	public void removeSkiJump(SkiJump skiJump) {
		list.remove(skiJump);
	}
	
	public SkiJump getSkiJump(long id) {
		return new SkiJump("Skocznia w Wisle", 138.5);
	}
	
	public List<SkiJump> getAllSkiJumps(){
		return list;
	}
	
	public void deleteAll() {
		list.clear();
	}

}
