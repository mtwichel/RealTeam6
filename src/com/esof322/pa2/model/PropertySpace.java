package com.esof322.pa2;

import com.esof322.pa2.exceptions.PropertyMaxUpgratedException;
import com.esof322.pa2.exceptions.PropertyMinUpgratedException;

/**
* @generated
*/
public class PropertySpace extends Space {
    
    
    private int rentAmount;
    private int purchaseAmount;
    private int mortgageValue;  
	private int unmortgageValue;
    private Boolean isMortgaged;
    private int houseLevel; 
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
        return rentRates[i];
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
    
    
    public void upgrade() throws PropertyMaxUpgratedException {
    		if((this.houseLevel + 1) > 5) {
    			throw new PropertyMaxUpgratedException();
    		}
        this.houseLevel += 1;
        notifyPropertySpaceListeners();
    }
    
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
    
    
    private Boolean getIsMonopoly() {
        return this.isMonopoly;
    }
    
    
    private void setIsMonopoly(Boolean isMonopoly) {
        this.isMonopoly = isMonopoly;
        notifyPropertySpaceListeners();
    }
    

    //                          Operations                                  
    
    
    public void takeAction() {
        //TODO
    }
    
    
    public int calculateRent() {
        //rentRates[]
    }
    
    
    public void checkMonopoly() {
        //TODO		should be in Property Group?
    }
    
    public int getPurchaseAmount() {
    		return this.purchaseAmount;
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
		// TODO Auto-generated method stub
		
	}
    
}

