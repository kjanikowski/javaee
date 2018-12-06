package com.example.restwsdemo.rest;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restwsdemo.domain.SkiJump;
import com.example.restwsdemo.service.SkiJumpManager;

@Path(value = "skijump")
@Stateless
public class SkiJumpRest {

	@Inject
	SkiJumpManager manager;
	
	@GET
	@Path(value = "/{SkiJumpID}")
	@Produces(MediaType.APPLICATION_JSON)
	public SkiJump getSkiJump(@PathParam("SkiJumpID") long id) {
		SkiJump ski = manager.getSkiJump(id);
		return ski;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<Long,SkiJump> getSkiJumps(){
		return manager.getAllSkiJumps();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSkiJump(SkiJump skiJump) {
		manager.addSkiJump(skiJump);
		
		return Response.status(201).entity("SkiJump").build();
	}
	
	@DELETE
	public Response deleteSkiJump() {
		manager.deleteAll();
		return Response.status(200).build();
	}
	
	
}
