package com.example.restejbjpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class City {
	
	String name; 
	long id; 
	
	public City(String name) {
		super();
		this.name = name;
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
