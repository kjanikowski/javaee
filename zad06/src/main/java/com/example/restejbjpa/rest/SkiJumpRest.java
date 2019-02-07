package com.example.restejbjpa.rest;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restejbjpa.domain.SkiJump;
import com.example.restejbjpa.service.SkiJumpManager;
import com.example.restejbjpa.service.SkiJumpManagerInterface;



@Path(value = "skijump")
public class SkiJumpRest {

	@EJB
	SkiJumpManagerInterface manager;
	
	@GET
	@Path(value = "/{SkiJumpID}")
	@Produces(MediaType.APPLICATION_JSON)
	public SkiJump getSkiJump(@PathParam("SkiJumpID") long id) {
		SkiJump ski = manager.getSkiJump(id);
		return ski;
	}
	
	@GET
	@Path(value = "/{CompName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SkiJump> getSkiJumpByComp(@PathParam("CompName") String name) {
		return manager.getAllByCompetition(name);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SkiJump> getSkiJumps(){
		return manager.getAllSkiJumps();
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public String test(){
		return "REST SkiJump Service is running now!";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSkiJump(SkiJump skiJump) {
		manager.addSkiJump(skiJump);
		return Response.status(201).entity("SkiJump").build();
	}
	
	@DELETE
	@Path(value = "/{SkiJumpID}")
	public Response deleteSkiJump(@PathParam("SkiJumpID") long id) {
		manager.removeSkiJump(id);
		return Response.status(200).build();
	}
	
	
}
