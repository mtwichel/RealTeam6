package com.esof322.pa2.model;

public class Railroad extends Space {
    
    public Railroad(String name,int[] i) {
    	super(name);
    }
  
    public String getNameSpace() {
		return getName();
	}
    
    public int calculateRent() {
		return 0;
    }
    
    
}
