package com.esof322.pa2.model;

public class BlankSpace extends Space {
    
	public BlankSpace(String name) {
		setName(name);
	}
	@Override
	void takeAction(Player callingPlayer) {
		
	}
    
	public String getNameSpace() {
		return getName();
	}
    
}
