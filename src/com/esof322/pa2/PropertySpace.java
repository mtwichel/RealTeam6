package com.esof322.pa2;


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
    private Player owner;
	private int upgradeAmount;

    
    
    
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
        notifyPropertySpaceListeners();
    }


	public void setUnmortgaged() {
    		this.isMortgaged = true;
    		notifyPropertySpaceListeners();
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
        //TODO
        return 0;
    }
    
    
    public void checkMonopoly() {
        //TODO
    }
    
    public int getPurchaseAmount() {
    		return this.purchaseAmount;
    }
    
    public void setOwner(Player owner) {
    		this.owner = owner;
    }
    
    private void notifyPropertySpaceListeners() {
		// TODO Auto-generated method stub
		
	}
    
}
