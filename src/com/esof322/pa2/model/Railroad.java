package com.esof322.pa2.model;

public class Railroad extends Space {
    
    public Railroad(String name, Banker banker, int[] i) {
    	super(banker, name);
    }
  
    public String getNameSpace() {
		return getName();
	}
    
    public int calculateRent() {
		return 0;
    }
    
    
}
