package com.esof322.pa2.model;

public class BlankSpace extends Space {
    
	public BlankSpace(String name) {
		super(name);
		setName(name);
	}
	@Override
	public void takeAction(Player callingPlayer) {
		
	}
    
	public String getNameSpace() {
		return getName();
	}
    
}
