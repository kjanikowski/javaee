package app.service;

import java.util.ArrayList;
import java.util.List;

import app.domain.SkiJump;

public class SkiJumpManager {
	
	
	private List<SkiJump> list = new ArrayList<SkiJump>();
	private List<SkiJump> basketList = new ArrayList<SkiJump>();

	private int number = 0; 
	
	public void addSkiJump(SkiJump skiJump) {
		skiJump.setid(number);
		list.add(skiJump);
		number++;
	}
	
	public void addbasketList(SkiJump skiJump) {
		basketList.add(skiJump);
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
	
	
	
	
	
	

	public List<SkiJump> getList() {
		return list;
	}

	public void setList(List<SkiJump> list) {
		this.list = list;
	}

	public List<SkiJump> getBasketList() {
		return basketList;
	}

	public void setBasketList(List<SkiJump> basketList) {
		this.basketList = basketList;
	}

}
