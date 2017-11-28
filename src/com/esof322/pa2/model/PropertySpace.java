package com.esof322.pa2.model;

import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.exceptions.PropertyMaxUpgratedException;
import com.esof322.pa2.exceptions.PropertyMinUpgratedException;

public class PropertySpace extends Space {


	private int mortgageValue;  
	private int unmortgageValue;
	private Boolean isMortgaged = false;
	private int houseLevel = 0; 
	private Boolean isMonopoly = false;
	private PropertyGroup propertyGroup;
	private Player owner;
	private int upgradeAmount;
	private int[] rentRates;
	private int color;

	//int[] i's first index contains the cost to buy the property and the remaining 
	//values contain the rent value according to houses/hotels owned.
	public PropertySpace(String name,int[] i) {
		super(name);
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

	public boolean setMortgaged() {

		if(!isMonopoly) {
			this.isMortgaged = true;
			notifyPropertySpaceListeners();//For GUI? 
			return true;
		}else if(Banker.getBanker().getBoard().getGroups().checkForHouses(this.color)){

			this.isMortgaged = true;
			notifyPropertySpaceListeners();//For GUI? 
			return true;


		}else {
			return false;//Houses exist on monopolies property player is trying to mortgage. Don't let them.
		}
	}


	public void setUnmortgaged() {
		this.isMortgaged = false;
		notifyPropertySpaceListeners();//update GUI
	}


	public int getHouseLevel() {
		return this.houseLevel;
	}

	public int getColor() {
		return color;
	}

	public void resetHouseLevel() {
		//Re add houses/hotels to pool. if houseLevel <= 4, pool += houseLevel, else Hotel += 1
		this.houseLevel = 0;
	}

	//check if player has necessary balance to be able to upgrade first
	public void upgrade() throws PropertyMaxUpgratedException {
		if((this.houseLevel + 1) > 5) {
			throw new PropertyMaxUpgratedException();
		}
		this.houseLevel += 1;
		//remove from pool in bank//
		notifyPropertySpaceListeners();
	}

	//Give them half the cost of a house as well
	public void downgrade() throws PropertyMinUpgratedException {
		if((this.houseLevel - 1) < 0) {	
			throw new PropertyMinUpgratedException();
		}else if(this.houseLevel >= 5) {//If it is a hotel, down grading goes back to an empty lot.
			this.houseLevel = 0;
			notifyPropertySpaceListeners();
		}else {
			this.houseLevel -= 1;
			//add house to pool in Bank
			notifyPropertySpaceListeners();
		}
	}

	public int getUpgradeAmount() {
		return this.upgradeAmount;
	}

	public void setUpgradeAmount(int ua) {
		upgradeAmount = ua;
	}

	public void setColor(int c) {
		color = c;
	}

	public Boolean getIsMonopoly() {
		return this.isMonopoly;
	}


	public void setIsMonopoly(Boolean isMonopoly) {
		this.isMonopoly = isMonopoly;
		notifyPropertySpaceListeners();
	}

	//this one is useless?
	public void takeAction() {
		//TODO
	}

	public int getPurchaseAmount() {
		return this.rentRates[0];
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Player getOwner() {
		return owner;
	}

	private void notifyPropertySpaceListeners() {
		// TODO Auto-generated method stub

	}


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

		return getRentAmount(houseLevel);
	}

}

