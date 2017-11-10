package com.esof322.pa2;

import java.util.List;

public class Board {
	
	private Space[] spaces = new Space[40];
	
	public Board() {
		init();
	}
    
    protected Space getSpace(int pos) {
    		return spaces[pos];
    }
    
    private void init() {
    	BlankSpace blankSpace;
    	TaxSpace tax;
    	JailSpace jail;
    	PropertySpace prop;
    	Railroad rail;
    	Utility util;
    	spaces[0] = new BlankSpace("Go");
    }
    
}
