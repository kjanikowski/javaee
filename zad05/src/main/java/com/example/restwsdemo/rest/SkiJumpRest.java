package com.example.restwsdemo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.restwsdemo.domain.SkiJump;
import com.example.restwsdemo.service.SkiJumpManager;

@Path(value = "skijump")
@Stateless
public class SkiJumpRest {

	@Inject
	SkiJumpManager manager;
	
	@GET
	@Path(value = "/{personId}")
	@Produces(MediaType.APPLICATION_JSON)
	public SkiJump getPerson(@PathParam("personId") long id) {
		SkiJump ski = manager.getSkiJump(id);
		return ski;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SkiJump> getSkiJumps(){
		return manager.getAllSkiJumps();
	}
	
	
}
