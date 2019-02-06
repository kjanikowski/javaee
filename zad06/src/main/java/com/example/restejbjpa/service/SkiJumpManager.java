package com.example.restejbjpa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.SkiJump;
@Stateless
public class SkiJumpManager implements SkiJumpManagerInterface {

	@PersistenceContext
	EntityManager em;

	@Override
	public SkiJump getByName(String name) {
		return (SkiJump) em.createNamedQuery("skiJump.getByName").setParameter("name", name).getSingleResult();
	}

	@Override
	public void removeSkiJump(long id) {
		SkiJump skiJump = getSkiJump(id);
		em.remove(skiJump);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SkiJump> getAllByCompetition(String type) {
		List<SkiJump> list = em.createNamedQuery("skiJump.getAllByType").setParameter("competitionName", type).getResultList();
		for (SkiJump ski : list) {
			ski.getCompetition().size();
		}
		return list;
	}

	@Override
	public SkiJump getByCity(String city) {
		return (SkiJump) em.createNamedQuery("skiJump.getByName").setParameter("name", city).getSingleResult();
	}

	@Override
	public void addSkiJump(SkiJump skiJump) {
		em.persist(skiJump);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SkiJump> getAllSkiJumps() {
		return em.createNamedQuery("skiJump.getAll").getResultList();
	}

	@Override
	public SkiJump getSkiJump(long id) {
		return em.find(SkiJump.class, id);
	}

}
