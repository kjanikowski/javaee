package app.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SkiJump {
	
	private String name;
	private double lenght; 
	private Date doc;
	private boolean hasRecord;
	
	private int id=0;
	
	
	public SkiJump(String name, double lenght, Date doc, boolean hasRecord) {
		this.name=name;
		this.lenght=lenght;
		this.doc = doc;
		this.hasRecord = hasRecord;
		id++;
	}
	
	
	public int getid() {
		return id;
	}
	public void setid(int amount) {
		this.id = amount;
	}

	
	
	public String getDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(doc).toString();
		
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