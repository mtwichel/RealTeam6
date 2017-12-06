package com.esof322.pa2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.esof322.pa2.exceptions.MonopolyContainsHousesException;
import com.esof322.pa2.exceptions.NotEnoughHousesOnOtherPropertiesException;

public class PropertyGroup {
	
	private List<PropertySpace> properties;
	private String color;
	
	public PropertyGroup(String color) {
		this.color = color;
		this.properties = new ArrayList<PropertySpace>();
	}
	
	public void addProperty(PropertySpace propertySpace) {
		properties.add(propertySpace);
	}


	//This method checks to see if there is a monopoly on this group
	public boolean checkMonopoly() {
		Player current = properties.get(0).getOwner();
		if(current == null) {
			return false;
		}
		for(int i=0; i<properties.size(); i++) {	//need to change player comparison to player piece comparison?
			if(current.getPiece() != properties.get(i).getOwner().getPiece()) {
				return false;
			}
		}
		return true;
	}
	
	public int checkAmountHeld(PropertySpace ps) {
		int amount = 0;
		Player current = ps.getOwner();
		if(current == null) {
			return 0;
		}
		for(int i=0; i<properties.size(); i++) {
			if(current.getPiece() == properties.get(i).getOwner().getPiece()) {	//need to change player comparison to player piece comparison?
				amount++;
			}
		}
		return amount;
	}

//TODO add this functionality some where else I think
//	public boolean checkIfAbleToAddHouse(PropertySpace space) {
//		int lowest = properties[space.getColor()][0].getHouseLevel();
//		for(int i = 0; i < properties[space.getColor()].length;i++) {
//			if(properties[space.getColor()][i].getHouseLevel()<lowest) {
//				lowest = properties[space.getColor()][i].getHouseLevel();
//			}
//		}
//			if((space.getHouseLevel()-lowest)>0) {
//				try {
//					throw new NotEnoughHousesOnOtherPropertiesException(space);
//				} catch (NotEnoughHousesOnOtherPropertiesException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				return false;//unable to add another house to this property, due to other 
//							 //properties not having enough houses.
//			}
//		return true;
//	}
	
	//this method checks if there are any houses in the entire group
	public boolean hasHouses() {
		for(int i = 0; i < properties.size(); i++) {
			if(properties.get(i).getHouseLevel()>0) {
				return true;
			}
		}
		return false;
	}

	public String getColor() {return this.color;}

	
	/**********************
	 * 
	 * BEGIN GRAVEYARD
	 * 
	 **********************/
	
//	//Fills Property space double array with spaces that have a certain color for purpose of checking monopolies.
//	public void populateProperties (Space[] s) {
//		int[] arry = {1,2,3,4,5,6,7};
//		//Space s = new PropertySpace("NameHere",arry);
//		//PropertySpace p = (PropertySpace) s;
//		//Banker.getBanker().getBoard();
//		//Space s = new PropertySpace();
//		//PropertySpace p = (PropertySpace) s
//		//b.getSpace(1);
//		properties[0][0] = (PropertySpace) s[1];
//		properties[0][1] = (PropertySpace) s[3];
//		properties[1][0] = (PropertySpace) s[6];
//		properties[1][1] = (PropertySpace) s[8];
//		properties[1][2] = (PropertySpace) s[9];
//		properties[2][0] = (PropertySpace) s[11];
//		properties[2][1] = (PropertySpace) s[13];
//		properties[2][2] = (PropertySpace) s[14];
//		properties[3][0] = (PropertySpace) s[16];
//		properties[3][1] = (PropertySpace) s[18];
//		properties[3][2] = (PropertySpace) s[19];
//		properties[4][0] = (PropertySpace) s[21];
//		properties[4][1] = (PropertySpace) s[23];
//		properties[4][2] = (PropertySpace) s[24];
//		properties[5][0] = (PropertySpace) s[26];
//		properties[5][1] = (PropertySpace) s[27];
//		properties[5][2] = (PropertySpace) s[29];
//		properties[6][0] = (PropertySpace) s[31];
//		properties[6][1] = (PropertySpace) s[32];
//		properties[6][2] = (PropertySpace) s[34];
//		properties[7][0] = (PropertySpace) s[37];
//		properties[7][1] = (PropertySpace) s[39];
//		assignUpgradCost();
//	}
//
//	public void assignUpgradCost() {
//		for(int i = 0; i < 8; i++) {
//			for(int k = 0; k < properties[i].length; k++) {
//				properties[i][k].setUpgradeAmount(50*((i/2)+1));
//				properties[i][k].setColor(i);
//			}
//		}
//	}
}
