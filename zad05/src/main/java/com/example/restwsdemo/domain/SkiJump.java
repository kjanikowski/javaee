package com.example.restwsdemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SkiJump {

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
