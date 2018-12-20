package app.service;

import java.util.ArrayList;
import java.util.List;

import app.domain.Monitor;

public class MonitorManager {
	
	
	private List<Monitor> list = new ArrayList<Monitor>();
	private List<Monitor> basketList = new ArrayList<Monitor>();

	private int number = 0; 
	
	public void addMonitor(Monitor monitor) {
		monitor.setid(number);
		list.add(monitor);
		number++;
	}
	
	public void addbasketList(Monitor monitor) {
		basketList.add(monitor);
	}
	
	public void addBasket(int id) {
		int i = 0;
		while (list.size() > i) {
			if (list.get(i).getid() == id) {
				basketList.add(list.get(i));
				list.remove(i);
				
			}
			i++;
		}
	}
	
	
	
	
	
	public void removeBasket(int id) {
		int i=0;
		while(basketList.size() > i) {
			if (basketList.get(i).getid() == id) {
				list.add(basketList.get(i));
				basketList.remove(i);
				
			}
			i++;
		}
	}
	
	public void remove(int id) {
		int i=0;
		while(list.size() > i) {
			if (list.get(i).getid() == id) {
				list.add(list.get(i));
				list.remove(i);
				
			}
			i++;
		}
	}
	
	public void clearBasket() {
		basketList.clear();
	}
	
	
	
	
	
	

	public List<Monitor> getList() {
		return list;
	}

	public void setList(List<Monitor> list) {
		this.list = list;
	}

	public List<Monitor> getBasketList() {
		return basketList;
	}

	public void setBasketList(List<Monitor> basketList) {
		this.basketList = basketList;
	}

}
