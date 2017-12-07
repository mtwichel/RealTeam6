package com.esof322.pa2.model;

import java.util.List;
import java.util.stream.Collectors;

import com.esof322.pa2.exceptions.BankruptcyException;
import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.exceptions.PopUpWarning;
import com.esof322.pa2.gui.Console;

public class Railroad extends PropertySpace {
    
	private PropertyGroup pg;
	
    public Railroad(Banker banker, String name, PropertyGroup propertyGroup, 
			int purchaseAmount, int upgradeAmount, int[] rentRates) {
    	super(banker, name, propertyGroup, purchaseAmount, upgradeAmount, rentRates);
    	pg = propertyGroup;
    }
  
    public String getNameSpace() {
		return getName();
	}
    
    public int calculateRent(Player callingPlayer) {
    	int numOwned = pg.checkAmountHeld(this);
 
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
		
		if(this.getOwner() == null) {
			try {
				callingPlayer.purchase(this);
			}catch (NotEnoughFundsException | BankruptcyException e) {
				Console.println(callingPlayer.getName()+" you do not have enough money to do that!");
			}
		}else if(!callingPlayer.equals(this.getOwner())){
			Player owner = this.getOwner();
			int rentDue = calculateRent(owner);
			try {
				callingPlayer.subMoney(rentDue);
			} catch (BankruptcyException e) {
			}
			owner.addMoney(rentDue);
			banker.getGUI().updatePlayerPanel();
			banker.getGUI().updateOtherPlayerPanel();
			Console.println(callingPlayer.getName()+" has paid " + owner.getName() + " "+rentDue +"!");
			new PopUpWarning("Pay up!", callingPlayer.getName()+" has paid " + owner.getName() + " "+rentDue +"!");
		}		
	}
}


