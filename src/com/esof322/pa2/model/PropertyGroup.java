package com.esof322.pa2.model;

import java.util.Set;

import com.esof322.pa2.exceptions.MonopolyContainsHousesException;
import com.esof322.pa2.exceptions.NotEnoughHousesOnOtherPropertiesException;

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
	
	public PropertyGroup(Space[] s) {
		populateProperties(s);
	}
	
	//Fills Property space double array with spaces that have a certain color for purpose of checking monopolies.
	public void populateProperties (Space[] s) {
		int[] arry = {1,2,3,4,5,6,7};
		//Space s = new PropertySpace("NameHere",arry);
		//PropertySpace p = (PropertySpace) s;
		//Banker.getBanker().getBoard();
		//Space s = new PropertySpace();
		//PropertySpace p = (PropertySpace) s
		//b.getSpace(1);
		properties[0][0] = (PropertySpace) s[1];
		properties[0][1] = (PropertySpace) s[3];
		properties[1][0] = (PropertySpace) s[6];
		properties[1][1] = (PropertySpace) s[8];
		properties[1][2] = (PropertySpace) s[9];
		properties[2][0] = (PropertySpace) s[11];
		properties[2][1] = (PropertySpace) s[13];
		properties[2][2] = (PropertySpace) s[14];
		properties[3][0] = (PropertySpace) s[16];
		properties[3][1] = (PropertySpace) s[18];
		properties[3][2] = (PropertySpace) s[19];
		properties[4][0] = (PropertySpace) s[21];
		properties[4][1] = (PropertySpace) s[23];
		properties[4][2] = (PropertySpace) s[24];
		properties[5][0] = (PropertySpace) s[26];
		properties[5][1] = (PropertySpace) s[27];
		properties[5][2] = (PropertySpace) s[29];
		properties[6][0] = (PropertySpace) s[31];
		properties[6][1] = (PropertySpace) s[32];
		properties[6][2] = (PropertySpace) s[34];
		properties[7][0] = (PropertySpace) s[37];
		properties[7][1] = (PropertySpace) s[39];
		assignUpgradCost();
	}

	public void assignUpgradCost() {
		for(int i = 0; i < 8; i++) {
			for(int k = 0; k < properties[i].length; k++) {
				properties[i][k].setUpgradeAmount(50*((i/2)+1));
				properties[i][k].setColor(i);
			}
		}
	}

	//Check for monopoly every time a property is bought, sold, or mortgaged
	public void checkMonopoly(Player p, int c) {//int i represents the player's piece number, int c represents property color
		int i = p.getPiece();
		int k = properties[c].length;
		int owned = 0;
		for(int j = 0; j <  properties[c].length; j++) {
			if((i == properties[c][j].checkOwner())&&(!properties[c][j].isMortgaged())) {//If property is mortgaged, it won't count as a monopoly
				owned++;
			}
		}
		if(k <= owned) {
			for(int j = 0; j <  properties[c].length; j++) {
				properties[c][j].setMonopoly(true);
			}	
			p.setHasMonopoly(true);
		}else {
			for(int j = 0; j <  properties[c].length; j++) {
				properties[c][j].setMonopoly(false);
			}
			p.setHasMonopoly(false);
		}
		
		
	}
	
	/*public int[] getPlayerOwned(Player p) {
		int i = p.getPiece();
		for(int j = 0; j <  p.getOwnedProperties().size(); j++) {
			if((i == properties[c][j].checkOwner())) {//If property is mortgaged, it won't count as a monopoly
				
			}
		}
	}*/
	
	public boolean checkIfAbleToAddHouse(PropertySpace space) {
		int lowest = properties[space.getColor()][0].getHouseLevel();
		for(int i = 0; i < properties[space.getColor()].length;i++) {
			if(properties[space.getColor()][i].getHouseLevel()<lowest) {
				lowest = properties[space.getColor()][i].getHouseLevel();
			}
		}
			if((space.getHouseLevel()-lowest)>0) {
				try {
					throw new NotEnoughHousesOnOtherPropertiesException(space);
				} catch (NotEnoughHousesOnOtherPropertiesException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;//unable to add another house to this property, due to other 
							 //properties not having enough houses.
			}
		return true;
	}
	
	public boolean checkForHouses(int color) {//To be sure no properties have houses on them when mortgaging
		for(int i = 0; i < properties[color].length;i++) {
			if(properties[color][i].getHouseLevel()>0) {
				try {
					throw new MonopolyContainsHousesException(color);
				} catch (MonopolyContainsHousesException e) {
					// this is where the pop up would show up and tell you to sell houses
					//before trying to mortgage a property of a monopoly
					e.printStackTrace();
				}
				return false;
			}
		}
		return true;
	}

}
