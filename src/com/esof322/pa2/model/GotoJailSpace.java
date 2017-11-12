package com.esof322.pa2.model;


/**
* @generated
*/
public class GotoJailSpace extends Space {
    
	public GotoJailSpace(String name) {
		super(name);
    	setName(name);
    }
	
	public String getNameSpace() {
		return getName();
	}
	
	@Override
	public void takeAction(Player callingPlayer) {
		callingPlayer.toJail();	
	}
    
    
}
