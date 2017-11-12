package com.esof322.pa2.model;

public class TaxSpace extends Space {
    
	private String name;
	
	public TaxSpace(String name) {
    	setName(name);
    }
	
	public String getNameSpace() {
		return getName();
	}
	
	@Override
	void takeAction(Player callingPlayer) {
		// TODO Auto-generated method stub
		
	}
    
    
}
