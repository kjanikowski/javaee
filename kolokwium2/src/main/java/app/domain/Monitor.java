package app.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Monitor {
	
	private String name;
	private double lenght; 
	private Date productionDate;
	String marka;
	String cechy;
	
	private int id=0;
	
	
	public Monitor(String name, double lenght, Date doc,String marka, String cechy ) {
		this.name=name;
		this.lenght=lenght;
		this.productionDate = doc;
		this.marka = marka;
		this.cechy = cechy;
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
		return dateFormat.format(productionDate).toString();
		
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
		return productionDate;
	}
	public void setDoc(Date doc) {
		this.productionDate = doc;
	}


	public String getMarka() {
		return marka;
	}


	public void setMarka(String marka) {
		this.marka = marka;
	}


	public String getCechy() {
		return cechy;
	}


	public void setCechy(String cechy) {
		this.cechy = cechy;
	}


}