package com.example.restejbjpa.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.SkiJump;

@Singleton
public class SkiJumpManager {
	
	@PersistenceContext
	EntityManager em;
	
	
	public void addSkiJump(SkiJump skiJump) {
		em.persist(skiJump);
	}
	
//	public void removeSkiJump(long id) {
//		em.remove(entity);
//	}
	
	public SkiJump getSkiJump(long id) {
		return em.find(SkiJump.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<SkiJump> getAllSkiJumps(){
		return em.createNamedQuery("skijump.all").getResultList();
	}
//	
	public void deleteAll() {
	em.createNamedQuery("skijump.delete.all").executeUpdate();
	}

}
