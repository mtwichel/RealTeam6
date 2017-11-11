package com.esof322.pa2;

import java.util.Set;

public class PropertyGroup {
    
	//have method in propertySpace that updates this double array each time 
	private PropertySpace[][] properties = {
		{null,null}, 		//Brown Properties
		{null,null,null}, 	//Light Blue Properties
		{null,null,null},	//Pink Properties
		{null,null,null},	//Orange Properties
		{null,null,null},	//Red Properties
		{null,null,null},	//Yellow Properties
		{null,null,null},	//Green Properties
		{null,null}		//Dark Blue
		};	//Integers will be replaced with Player's piece's number.
	
	public void populateProperties(Space[] s) {
		
	}
    //private Integer color;
    
    //private Set<PropertySpace> propertySpaces;
    
    public boolean checkMonopoly(int i, int c) {//int i represents the player's piece number, int c represents property color
    	int k = properties[c].length;
    	int owned = 0;
        for(int j = 0; j <  properties[c].length; j++) {
        	if(i == properties[c][j].checkOwner()) {
        		owned++;
        	}
        }
        if(k <= owned) {
        	return true;
        }
        return false;
    }
    
    
}
