package com.example.restejbjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	long id;
	String nazwa;
	double rekord;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	
}
