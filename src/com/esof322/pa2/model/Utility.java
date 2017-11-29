package com.esof322.pa2.model;

public class Utility extends Space {
    
	public Utility(Banker banker, String name, int[] i) {
    	super(banker, name);
    }
    
	public String getNameSpace() {
		return getName();
	}
	
    public int calculateRent() {
		return 0;
        //TODO
    }

	@Override
	public void takeAction(Player callingPlayer) {
		// TODO Auto-generated method stub
		
	}
    
    
}
