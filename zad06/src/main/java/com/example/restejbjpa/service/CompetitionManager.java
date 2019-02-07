package com.example.restejbjpa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Competition;
import com.example.restejbjpa.domain.SkiJump;

@Stateless
public class CompetitionManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void addCompetition(Competition comp) {
		em.persist(comp);
	}
	
	public void removeCompetition(int id) {
		Competition comp = findCompetition(id);
		em.remove(comp);
	}
	
	public Competition findCompetition(int id) {
		Competition comp = em.find(Competition.class, id);
		comp.getSkijumps().size();
		return comp;		
	}
	
	public void addSkiJump(int comp, long skiJumpID) {
		Competition competition = findCompetition(comp);
		SkiJump skiJump = em.find(SkiJump.class, skiJumpID);
		competition.getSkijumps().add(skiJump);
		skiJump.getCompetition().add(competition);
		em.persist(competition);
		em.persist(skiJump);
	}
	
	@SuppressWarnings("unchecked")
	public List<Competition> getAllCompetition() {
		List<Competition> list = em.createNamedQuery("competition.getAll").getResultList();
		for(Competition comp : list) {
			comp.getSkijumps().size();
		}
		return list;
	}

}
