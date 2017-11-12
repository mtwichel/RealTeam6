package com.esof322.pa2.model;

public class TaxSpace extends Space {
    
	private String name;
	private boolean taxType;
	
	public TaxSpace(String name,boolean b) {
		super(name);
    	setName(name);
    	taxType = b;
    }
	
	public String getNameSpace() {
		return getName();
	}
	
	@Override
	public void takeAction(Player callingPlayer) {
		
		if(taxType) { //true is luxury tax//
			callingPlayer.charge(null,75);
		}else if(callingPlayer.getBalance() < 2000) {//false is income tax
			callingPlayer.charge(null,(int)(callingPlayer.getBalance()*.1));
		}else {
			callingPlayer.charge(null,200);
		}
		
	}
    
    
}
