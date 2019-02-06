package com.example.restejbjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQuery(name = "competition.getAll", query = "SELECT c FROM Competition c")
public class Competition {
	
	private int id;
	private String CompetitionName;
	public Competition(String competitionName) {
		super();
		CompetitionName = competitionName;
	}
	public Competition() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private List<SkiJump> skijumps = new ArrayList<SkiJump>();
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(unique = true)
	public String getCompetitionName() {
		return CompetitionName;
	}
	public void setCompetitionName(String competitionName) {
		CompetitionName = competitionName;
	}
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<SkiJump> getSkijumps() {
		return skijumps;
	}
	public void setSkijumps(List<SkiJump> skijumps) {
		this.skijumps = skijumps;
	}
}
