package com.example.restejbjpa.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restejbjpa.domain.Competition;
import com.example.restejbjpa.domain.SkiJump;
import com.example.restejbjpa.service.CompetitionManager;
import com.example.restejbjpa.service.SkiJumpManagerInterface;

@Path(value = "competition")
public class CompetitionRest {
	
	@EJB
	CompetitionManager manager;
	
	@GET
	@Path(value = "/{compID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Competition getCompetition(@PathParam("compID") int id) {
		Competition comp = manager.findCompetition(id);
		return comp;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Competition> getAll(){
		return manager.getAllCompetition();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCompetition(Competition comp) {
		manager.addCompetition(comp);
		return Response.status(201).entity("Competition").build();
	}
	
	@DELETE
	@Path(value = "/{compID}")
	public Response deleteSkiJump(@PathParam("compID") int id) {
		manager.removeCompetition(id);
		return Response.status(200).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(value = "/{compID}/{SkiJumpID}")
	public Response addCompetition(@PathParam("compID") int compID, @PathParam("SkiJumpID") int skiJumpID) {
		manager.addSkiJump(compID, skiJumpID);
		return Response.status(201).entity("Competition").build();
	}
}
