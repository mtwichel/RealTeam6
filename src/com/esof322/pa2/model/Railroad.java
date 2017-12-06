package com.esof322.pa2.model;

import java.util.List;
import java.util.stream.Collectors;

import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.gui.Console;

public class Railroad extends PropertySpace {
    
    public Railroad(Banker banker, String name, PropertyGroup propertyGroup, 
			int purchaseAmount, int upgradeAmount, int[] rentRates) {
    	super(banker, name, propertyGroup, purchaseAmount, upgradeAmount, rentRates);
    }
  
    public String getNameSpace() {
		return getName();
	}
    
    public int calculateRent(Player callingPlayer) {
    	List<PropertySpace> props = callingPlayer.getOwnedProperties();
    	int numOwned = 0;
    	List<PropertySpace> result = props.stream()																															//converts props to stream
    			.filter(line -> "Reading Railroad".equals(line) || "Reading Railroad".equals(line) || "Reading Railroad".equals(line) || "Reading Railroad".equals(line))	//finds the railroads
    			.collect(Collectors.toList());																																//collect the output and convert streams to a list
    	 
    	numOwned = result.size();
    	if(numOwned == 1) {
    		return 25;
    	}else if (numOwned == 2) {
    		return 50;
    	}else if (numOwned == 3) {
    		return 100;
    	}else if (numOwned == 4) {
    		return 200;
    	}
    	
		return 0;
    }

	@Override
	public void takeAction(Player callingPlayer) {
		// TODO Auto-generated method stub
		if(this.getOwner() == null) {
			try {
				callingPlayer.purchase(this);
			}catch (NotEnoughFundsException e) {
				Console.println(callingPlayer.getName()+" you do not have enough money to do that!");
			}
		}else {
			Player owner = this.getOwner();
			int rentDue = calculateRent(owner);
			callingPlayer.subMoney(rentDue);
			owner.addMoney(rentDue);
			banker.getGUI().updatePlayerPanel();
			banker.getGUI().updateOtherPlayerPanel();
			Console.println(callingPlayer.getName()+" has paid" + owner.getName() + rentDue +"!");
		}		
	}
}


