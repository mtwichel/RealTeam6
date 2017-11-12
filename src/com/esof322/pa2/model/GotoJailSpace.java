package com.esof322.pa2.model;


/**
* @generated
*/
public class GotoJailSpace extends Space {
    
	public GotoJailSpace(String name) {
    	setName(name);
    }
	
	public String getNameSpace() {
		return getName();
	}
	
	@Override
	void takeAction(Player callingPlayer) {
		callingPlayer.toJail();
		// TODO Auto-generated method stub
		
	}
    
    
}
