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
		};	
	
	//Fills Property space double array with spaces that have a certain color for purpose of checking monopolies.
	public void populateProperties() {
		properties[0][0] = (PropertySpace) Banker.getBanker().getBoard().getSpace(1);
		properties[0][1] = (PropertySpace) Banker.getBanker().getBoard().getSpace(3);
		properties[1][0] = (PropertySpace) Banker.getBanker().getBoard().getSpace(6);
		properties[1][1] = (PropertySpace) Banker.getBanker().getBoard().getSpace(8);
		properties[1][2] = (PropertySpace) Banker.getBanker().getBoard().getSpace(9);
		properties[2][0] = (PropertySpace) Banker.getBanker().getBoard().getSpace(11);
		properties[2][1] = (PropertySpace) Banker.getBanker().getBoard().getSpace(13);
		properties[2][2] = (PropertySpace) Banker.getBanker().getBoard().getSpace(14);
		properties[3][0] = (PropertySpace) Banker.getBanker().getBoard().getSpace(16);
		properties[3][1] = (PropertySpace) Banker.getBanker().getBoard().getSpace(18);
		properties[3][2] = (PropertySpace) Banker.getBanker().getBoard().getSpace(19);
		properties[4][0] = (PropertySpace) Banker.getBanker().getBoard().getSpace(21);
		properties[4][1] = (PropertySpace) Banker.getBanker().getBoard().getSpace(23);
		properties[4][2] = (PropertySpace) Banker.getBanker().getBoard().getSpace(24);
		properties[5][0] = (PropertySpace) Banker.getBanker().getBoard().getSpace(26);
		properties[5][1] = (PropertySpace) Banker.getBanker().getBoard().getSpace(27);
		properties[5][2] = (PropertySpace) Banker.getBanker().getBoard().getSpace(29);
		properties[6][0] = (PropertySpace) Banker.getBanker().getBoard().getSpace(31);
		properties[6][1] = (PropertySpace) Banker.getBanker().getBoard().getSpace(32);
		properties[6][2] = (PropertySpace) Banker.getBanker().getBoard().getSpace(34);
		properties[7][0] = (PropertySpace) Banker.getBanker().getBoard().getSpace(37);
		properties[7][1] = (PropertySpace) Banker.getBanker().getBoard().getSpace(39);
	}
    
	public void initGroups() {
		populateProperties();
	}
	
	//Check for monopoly every time a property is bought, sold, or mortgaged
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
