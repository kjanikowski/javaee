package com.example.restwsdemo.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;

import com.example.restwsdemo.domain.SkiJump;
@Singleton
public class SkiJumpManager {
	
	private Map<Long,SkiJump> map = Collections.synchronizedMap(new HashMap<Long,SkiJump>());
	long i = 0;

	
	
	public void addSkiJump(SkiJump skiJump) {
		map.put(i, skiJump);
		i++;
	}
	
	public void removeSkiJump(long id) {
		map.remove(id);
	}
	
	public SkiJump getSkiJump(long id) {
		return map.get(id);
	}
	
	public Map<Long,SkiJump> getAllSkiJumps(){
		return map;
	}
	
	public void deleteAll() {
		map.clear();
	}

}
