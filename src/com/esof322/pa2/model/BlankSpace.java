package com.esof322.pa2.model;

public class BlankSpace extends Space {
    
	public BlankSpace(Banker banker, String name) {
		super(banker, name);
	}
	
	@Override
	public void takeAction(Player callingPlayer) {
		//Literally do nothing
	}
    
}
