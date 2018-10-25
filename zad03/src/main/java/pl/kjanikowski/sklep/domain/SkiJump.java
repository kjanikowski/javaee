package pl.kjanikowski.sklep.domain;

import java.util.Date;

public class SkiJump {
	
	private String name;
	private double lenght; 
	private Date doc;
	private boolean hasRecord;
	
	private int amount;
	
	
	public SkiJump(String name, double lenght, Date doc, boolean hasRecord) {
		this.name=name;
		this.lenght=lenght;
		this.doc = doc;
		this.hasRecord = hasRecord; 
	}
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void add() {
		this.amount++;
	}
	
	public void bought() {
		this.amount--;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLenght() {
		return lenght;
	}
	public void setLenght(double lenght) {
		this.lenght = lenght;
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

}
