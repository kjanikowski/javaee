package app.service;

import java.util.ArrayList;
import java.util.List;

import app.domain.Newsletter;


public class NewsManager {

	
	private List<Newsletter> list = new ArrayList<Newsletter>();

	private int number = 0; 
	
	
	public void addNews(Newsletter news) {
		news.setId(number);
		list.add(news);
		number++;
	}
}
