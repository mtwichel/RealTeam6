package com.esof322.pa2.model;

import com.esof322.pa2.exceptions.PropertyMaxUpgratedException;
import com.esof322.pa2.exceptions.PropertyMinUpgratedException;

/**
* @generated
*/
public class PropertySpace extends Space {
    
    
    private int mortgageValue;  
	private int unmortgageValue;
    private Boolean isMortgaged;
    private int houseLevel = 0; 
    private Boolean isMonopoly;
    private PropertyGroup propertyGroup;
    private int owner = 0;
	private int upgradeAmount;
	private int[] rentRates;

	//int[] i's first index contains the cost to buy the property and the remaining 
	//values contain the rent value according to houses/hotels owned.
    public PropertySpace(String name,int[] i) {
    	setName(name);
    	rentRates = i;
    }
    
    public void setMonopoly(boolean b) {
    	isMonopoly = b;
    }
    
    public String getNameSpace() {
		return getName();
	}
    
    ///getRentAmount should get rentRates[houses]; 
    protected int getRentAmount(int i) {
        return rentRates[i+1];
    }
    
    public int getMortgageValue() {
        return (rentRates[0]/2);//When you mortgage a property, you get back halve the properties cost
    }
    public int getUnmortgageValue() {
        return (int)((rentRates[0]/2)*1.1);//Essentially repurchasing the property
    }
    
    public boolean isMortgaged() {
        return this.isMortgaged;
    }
    
    public void setMortgaged() {
        this.isMortgaged = true;
        notifyPropertySpaceListeners();//For GUI? 
    }


	public void setUnmortgaged() {
    		this.isMortgaged = false;
    		notifyPropertySpaceListeners();//update GUI
    }
    
    
    private int getHouseLevel() {
        return this.houseLevel;
    }
    
    //check if player has necessary balance to be able to upgrade first
    public void upgrade() throws PropertyMaxUpgratedException {
    		if((this.houseLevel + 1) > 5) {
    			throw new PropertyMaxUpgratedException();
    		}
        this.houseLevel += 1;
        notifyPropertySpaceListeners();
    }
    
    //Give them half the cost of a house aswell
    public void downgrade() throws PropertyMinUpgratedException {
		if((this.houseLevel - 1) < 0) {
			throw new PropertyMinUpgratedException();
		}
    		this.houseLevel -= 1;
    		notifyPropertySpaceListeners();
    }
    
    public int getUpgradeAmount() {
    		return this.upgradeAmount;
    }
    
    public void setUpgradeAmount(int ua) {
    	upgradeAmount = ua;
    }
    
    
    public Boolean getIsMonopoly() {
        return this.isMonopoly;
    }
    
    
    public void setIsMonopoly(Boolean isMonopoly) {
        this.isMonopoly = isMonopoly;
        notifyPropertySpaceListeners();
    }
    
    public void takeAction() {
        //TODO
    }
    
    
    public boolean checkIsMonopoly() {
        return isMonopoly;
    }
    
    public int getPurchaseAmount() {
    		return this.rentRates[0];
    }
    
    public void setOwner(Player owner) {
    		this.owner = owner.getPiece();
    }
    
    public int checkOwner() {
    	return owner;
    }
    
    private void notifyPropertySpaceListeners() {
		// TODO Auto-generated method stub
		
	}


	@Override
	void takeAction(Player callingPlayer) {
		if(owner == 0) {
			//Allow Player to buy; need method for prompting user if they would like to buy property
			//if response:yes, make new owner and subtract purchaseAmount
			//if response:no, end turn.
		}else {
			//subtract Rent amount from player, and add it to other player (Call player pay method)
		}
	}

	public int calculateRent() {
		
		return getRentAmount(houseLevel);
	}
    
}

