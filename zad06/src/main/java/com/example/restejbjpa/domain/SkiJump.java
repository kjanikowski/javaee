package com.example.restejbjpa.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@NamedQueries({
	@NamedQuery(name = "skiJump.getAll", query = "SELECT s FROM SkiJump s"),
	@NamedQuery(name = "skiJump.getByName", query = "SELECT s FROM SkiJump s WHERE s.name = :name"),
	@NamedQuery(name = "skiJump.getAllByType", query = "SELECT s FROM SkiJump s JOIN s.competition c WHERE c.competitionName = :competitionName"),
	@NamedQuery(name = "skiJump.getByCity", query = "SELECT s FROM SkiJump s JOIN s.city c WHERE c.name = :name")
})
@Entity
@XmlRootElement
public class SkiJump {
	
	private long id;
	private String name;
	private int size;
	private Date doc;
	private boolean hasRecord;
	
	
	private City city;
	
	private List<Competition> competition;
	
	private SkiType skiType;
	
	
	public SkiJump() {
		super();
	}
		public SkiJump(String name, int size, Date doc, boolean hasRecord, City city, SkiType skiType) {
		super();
		this.name = name;
		this.size = size;
		this.doc = doc;
		this.hasRecord = hasRecord;
		this.city = city;
		this. skiType = skiType;
		//this.competition = competioion;
		
	}
	
	public String toString() {
		return name;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Date getDoc() {
		return doc;
	}
	public void setDoc(Date doc) {
		this.doc = doc;
	}
	public boolean isHasRecord() {
		return hasRecord;
	}
	public void setHasRecord(boolean hasRecord) {
		this.hasRecord = hasRecord;
	}

	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	@JsonBackReference
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	public List<Competition> getCompetition() {
		return competition;
	}

	public void setCompetition(List<Competition> competition) {
		this.competition = competition;
	}

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public SkiType getSkiType() {
		return skiType;
	}

	public void setSkiType(SkiType skiType) {
		this.skiType = skiType;
	}

}
