package com.esof322.pa2.model;

public class TaxSpace extends Space {
    
	private String name;
	private boolean taxType;
	
	public TaxSpace(String name,boolean b) {
    	setName(name);
    	taxType = b;
    }
	
	public String getNameSpace() {
		return getName();
	}
	
	@Override
	void takeAction(Player callingPlayer) {
		
		if(taxType) { //true is luxury tax
			callingPlayer.charge(75);
		}else if(callingPlayer.getBalance() < 2000) {//false is income tax
			callingPlayer.charge((int)(callingPlayer.getBalance()*.1));
		}else {
			callingPlayer.charge(200);
		}
		
	}
    
    
}
