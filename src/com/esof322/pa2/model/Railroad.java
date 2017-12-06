package com.esof322.pa2.model;

public class Railroad extends Space {
    
    public Railroad(Banker banker, String name) {
    	super(banker, name);
    }
  
    public String getNameSpace() {
		return getName();
	}
    
    public int calculateRent() {
		return 0;
    }

	@Override
	public void takeAction(Player callingPlayer) {
		// TODO Auto-generated method stub
		
	}
    
    
}
