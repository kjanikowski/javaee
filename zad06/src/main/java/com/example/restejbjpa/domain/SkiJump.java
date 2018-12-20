package com.example.restejbjpa.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({
		@NamedQuery(name = "skijump.all", query = "Select s from SkiJump s"),
		@NamedQuery(name = "skijump.delete.all", query = "Delete from SkiJump ")
})
public class SkiJump {

	private long id;
	private String nazwa;
	private double rekord;
	private City city;
	
	public SkiJump(long id, String nazwa, double rekord, City city) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.rekord = rekord;
		this.city = city;
	}
	public SkiJump(String nazwa, double rekord) {
		super();
		this.nazwa = nazwa;
		this.rekord = rekord;
	}
	public SkiJump() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public double getRekord() {
		return rekord;
	}
	public void setRekord(double rekord) {
		this.rekord = rekord;
	}
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return nazwa + rekord + city.name;
		
	}
	
	
}
