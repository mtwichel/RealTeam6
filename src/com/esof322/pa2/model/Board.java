package com.esof322.pa2.model;

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
    	GotoJailSpace goToJail;
    	PropertySpace prop;
    	Railroad rail;
    	Utility util;
    	spaces[0] = new BlankSpace("Go");
    	spaces[1] = new PropertySpace("Mediterranean Avenue");
    	spaces[2] = new BlankSpace("Community Chest");
    	spaces[3] = new PropertySpace("Baltic Avenue");
    	spaces[4] = new TaxSpace("Income Tax");
    	spaces[5] = new Railroad("Reading Railroad");		
    	spaces[6] = new PropertySpace("Oriental Avenue");
    	spaces[7] = new BlankSpace("Chance");
    	spaces[8] = new PropertySpace("Vermont Avenue");
    	spaces[9] = new PropertySpace("Connecticut Avenue");
    	spaces[10] = new JailSpace("In Jail/Just Visiting");
    	spaces[11] = new PropertySpace("St. Charles Place");
    	spaces[12] = new Utility("Electric Company");
    	spaces[13] = new PropertySpace("States Avenue");
    	spaces[14] = new PropertySpace("Virginia Avenue");
    	spaces[15] = new Railroad("Pennsylvania Railroad");
    	spaces[16] = new PropertySpace("St. James Place");
    	spaces[17] = new BlankSpace("Community Chest");
    	spaces[18] = new PropertySpace("Tennessee Avenue");
    	spaces[19] = new PropertySpace("New York Avenue");
    	spaces[20] = new BlankSpace("Free Parking");
    	spaces[21] = new PropertySpace("Kentucky Avenue");
    	spaces[22] = new BlankSpace("Chance");
    	spaces[23] = new PropertySpace("Indiana Avenue");
    	spaces[24] = new PropertySpace("Illinois Avenue");
    	spaces[25] = new Railroad("B&O Railroad");
    	spaces[26] = new PropertySpace("Atlantic Avenue");
    	spaces[27] = new PropertySpace("Ventnor Avenue");
    	spaces[28] = new Utility("Water Works");
    	spaces[29] = new PropertySpace("Marvin Gardens");
    	spaces[30] = new GotoJailSpace("Go to Jail");
    	spaces[31] = new PropertySpace("Pacific Avenue");
    	spaces[32] = new PropertySpace("North Carolina Avenue");
    	spaces[33] = new BlankSpace("Community Chest");
    	spaces[34] = new PropertySpace("Pennsylvania Avenue");
    	spaces[35] = new Railroad("Short Line");
    	spaces[36] = new BlankSpace("Chance");
    	spaces[37] = new PropertySpace("Park Place");
    	spaces[38] = new TaxSpace("Luxury Tax");
    	spaces[39] = new PropertySpace("Boardwalk");
    	
    	
    }
    
}
