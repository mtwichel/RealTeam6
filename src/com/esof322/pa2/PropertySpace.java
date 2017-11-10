package com.esof322.pa2;


/**
* @generated
*/
public class PropertySpace extends Space {
    
    
    private int rentAmount;
    private int mortgageValue;  
	private int unmortgageValue;
    private Boolean isMortgaged;
    private int houseLevel; 
    private Boolean isMonopoly;
    private PropertyGroup propertyGroup;
    private Player owner;

    
    
    
    private int getRentAmount() {
        return this.rentAmount;
    }
    
    
    private void setRentAmount(int rentAmount) {
        this.rentAmount = rentAmount;
    }
    
    
    public int getMortgageValue() {
        return this.mortgageValue;
    }
    public int getUnmortgageValue() {
        return this.unmortgageValue;
    }
    
    
    private boolean isMortgaged() {
        return this.isMortgaged;
    }
    
    
    public void setMortgaged() {
        this.isMortgaged = true;
    }
    
    public void setUnmortgaged() {
    		this.isMortgaged = true;
    }
    
    
    private int getHouseLevel() {
        return this.houseLevel;
    }
    
    
    private void setHouseLevel(int houseLevel) {
        this.houseLevel = houseLevel;
    }
    
    
    private Boolean getIsMonopoly() {
        return this.isMonopoly;
    }
    
    
    private void setIsMonopoly(Boolean isMonopoly) {
        this.isMonopoly = isMonopoly;
    }
    

    //                          Operations                                  
    
    
    public void takeAction() {
        //TODO
    }
    
    
    public int calculateRent() {
        //TODO
        return 0;
    }
    
    
    public void checkMonopoly() {
        //TODO
    }
    
    
}
