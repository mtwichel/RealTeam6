package com.esof322.pa2.model;

import java.util.ArrayList;
import java.util.List;

public class Trade {

	class PropertyBundle{
		private int offer;
		private List<PropertySpace> property;
		private PropertyBundle want;
		
		public PropertyBundle(int offer) {
			this.offer = offer;
			property = new ArrayList();
		}
		
		public void add(PropertySpace ps) {
			property.add(ps);
		}
		
		public PropertySpace get(int i) {
			return property.get(i);
		}
		
		public void setBundle(PropertyBundle pb) {
			want = pb;
		}
		
		public PropertyBundle getWant() {
			return want;
		}
		
		//returns amount of money the player is offering in addition to the Properties.
		public int getOffer() {
			return offer;
		}
		
		public int getlength() {
			return property.size();
		}
		
		//Checks if player has the wanted PropertyBundle in question
		public boolean hasWant(Player p) {
			List<PropertySpace> compare = p.getOwnedProperties();
			if(compare.contains(want)&&p.getBalance()>offer) {
				return true;
			}
			return false;
		}
		
		public void remove(int i) {
			property.remove(i);
		}
		
		//Checks if the player is the owner of the bundle
		public boolean isOwner(Player p) {
			List<PropertySpace> compare = p.getOwnedProperties();
			if(compare.contains(property)) {
				return true;
			}
			return false;
		}
		
		public List<PropertySpace> getPropertyList() {
			return property;
		}
	}
	
	private PropertyBundle offer;
	private PropertyBundle desire;
	
	private Player p1, p2;
	
	public Trade(Player p1,Player p2) {
		this.p1 = p1;//Offerer
		this.p2 = p2;
	}
	
	/*public void addBundle(int money, List properties) {
		//Money and properties are chosen via graphic.
	}*/
	
	public void setOffer(PropertyBundle pb) {
		offer = pb;
	}
	
	public void setDesire(PropertyBundle pb) {
		desire = pb;
	}
	
	public void Swap(boolean accept) {
		
		if(accept) {
		//Change to while !dire.isEmpty?
		for(int i = 0; i < desire.getlength();i++) {
			p1.aquireProperty(desire.get(0));
			p2.getOwnedProperties().remove(desire.get(0));
			desire.remove(i);
		}
		
		for(int i = 0; i < offer.getlength();i++) {
			p2.aquireProperty(offer.get(0));
			p1.getOwnedProperties().remove(offer.get(0));
			offer.remove(i);
		}
		
		if(offer.getOffer()>desire.getOffer()) {
			p2.addMoney(offer.getOffer()-desire.getOffer());
		}else {
			p1.addMoney(desire.getOffer()-offer.getOffer());
		}
		}else {
			//Nothing changes.
		}
		
	}
}
