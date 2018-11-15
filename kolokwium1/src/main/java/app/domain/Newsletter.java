package app.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Newsletter {
	
	public Newsletter( String imie, Date from, Date to, String czest, String temat) {
		super();
		this.imie = imie;
		this.from = from;
		this.to = to;
		this.czest = czest;
		this.temat = temat;
	}
	
	int id;
	String imie;
	Date from;
	Date to;
	String czest;
	String temat;
	
	public String getDateF() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(from).toString();
		
	}
	
	public String getDateT() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(to).toString();
		
	}
	
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public String getCzest() {
		return czest;
	}
	public void setCzest(String czest) {
		this.czest = czest;
	}
	public String getTemat() {
		return temat;
	}
	public void setTemat(String temat) {
		this.temat = temat;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
