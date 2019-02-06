package com.example.restejbjpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class SkiType {
	
	private long id;
	private String type;
	
	public SkiType(String type) {
		super();
		this.type = type;
	}

	public SkiType() {
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
	@Column(unique = true)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


}
