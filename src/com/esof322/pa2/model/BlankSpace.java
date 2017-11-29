package com.esof322.pa2.model;

public class BlankSpace extends Space {
    
	public BlankSpace(String name) {
		super(name);
	}
	
	@Override
	public void takeAction(Player callingPlayer) {
		//Literally do nothing
	}
    
}
