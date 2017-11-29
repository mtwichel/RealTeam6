package com.esof322.pa2.model;

import com.esof322.pa2.exceptions.GroupUpgradedException;
import com.esof322.pa2.exceptions.IsAMonopolyException;
import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.exceptions.PropertyMaxUpgratedException;
import com.esof322.pa2.exceptions.PropertyMinUpgratedException;

public class PropertySpace extends Space {


	private int mortgageValue;  
	private int unmortgageValue;
	private Boolean isMortgaged = false;
	private int houseLevel; 
	private Boolean isInMonopoly = false;
	private PropertyGroup propertyGroup;
	private Player owner;
	private int purchaseAmount;
	private int[] rentRates;
	private int upgradeAmount;
	private int rentAmount;

	public PropertySpace(Banker banker, String name, PropertyGroup propertyGroup, 
		int purchaseAmout, int upgradeAmount,int[] rentRates) {
		super(banker, name);
		this.rentRates = rentRates;
		this.upgradeAmount = upgradeAmount;
		this.purchaseAmount = purchaseAmout;
		this.propertyGroup = propertyGroup;
		this.houseLevel = 0;
	}




	//this method add a house if possible
	public void upgrade() throws PropertyMaxUpgratedException {
		if((this.houseLevel + 1) > 5) {
			throw new PropertyMaxUpgratedException();
		}
		this.houseLevel += 1;
		calculateRent();
	}

	//this house removes a house if possible
	public void downgrade() throws PropertyMinUpgratedException {
		if((this.houseLevel - 1) < 0) {	
			throw new PropertyMinUpgratedException();
		}else {
			this.houseLevel -= 1;
		}
		calculateRent();
	}


	public void setOwner(Player owner) {
		this.owner = owner;
		calculateRent();
	}
	
	public void setIsMonopoly(Boolean isMonopoly) {this.isInMonopoly = isMonopoly;}

	public void setMortgaged() throws GroupUpgradedException {
		if(propertyGroup.hasHouses()){
			throw new GroupUpgradedException();
		}else {
			this.isMortgaged = true;
		}
	}
	public void setUnmortgaged() {this.isMortgaged = false;}


	@Override
	public void takeAction(Player callingPlayer) {
		if(owner == null) {//Allow Player to buy; need method for prompting user if they would like to buy property
			//if response:yes, make new owner and subtract purchaseAmount
			try {
				callingPlayer.purchase(this);
			} catch (NotEnoughFundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//if response:no, end turn.
		}else {
			//subtract Rent amount from player, and add it to other player (Call player pay method)
			//in subtracting the rent, check if the player goes bankrupt, or is about to go bankrupt
			//if they do go bankrupt, give them the option to mortgage a propety/sell a house/hotel
			//if they own any, or are able to own a mortgagable property
		}
	}

	public int calculateRent() {
		return rentRates[houseLevel];
		
	}
	
	public int getRentAmount() {return rentAmount;}
	public Player getOwner() {return owner;}
	public String getColor() {return propertyGroup.getColor();}
	public int getMortgageValue() {return (rentRates[0]/2);}
	public int getUnmortgageValue() {return (int)((rentRates[0]/2)*1.1);}
	public boolean isMortgaged() {return this.isMortgaged;}
	public int getHouseLevel() {return this.houseLevel;}
	public int getPurchaseAmount() {return this.purchaseAmount;}
	public Boolean getIsMonopoly() {return this.isInMonopoly;}
	public int getUpgradeAmount() {return this.upgradeAmount;}
	public int getDowngradeAmount() {return this.upgradeAmount/2;}


}

