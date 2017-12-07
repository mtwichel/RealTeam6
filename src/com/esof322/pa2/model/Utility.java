package com.esof322.pa2.model;

import java.util.List;
import java.util.stream.Collectors;

import com.esof322.pa2.exceptions.BankruptcyException;
import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.exceptions.PopUpWarning;
import com.esof322.pa2.gui.Console;
import com.esof322.pa2.gui.Facade;

public class Utility extends PropertySpace {
    
	private final int type = 1;
	private PropertyGroup pg;
	
	public Utility(Banker banker, String name, PropertyGroup propertyGroup, 
			int purchaseAmount, int upgradeAmount,int[] rentRates) {
    	super(banker, name, propertyGroup, purchaseAmount, upgradeAmount, rentRates);
    	pg = propertyGroup;
    }
    
	public String getNameSpace() {
		return getName();
	}
	
	public int getType() {return type;}
	
    public int calculateRent(Player callingPlayer, int roll) {
		/*Utility rent is calculated based on two factors: the roll of the player landing there, and the number of Utilities the owner owns
		 * If the Owner has One of the utilities, rent due is  4x the die roll
		 * If the Owner has Two of the utilities, rent due is 10x the due roll
		 */
    	int numOwned = pg.checkAmountHeld(this);//finds out how many utilitys are owned
    	
    	if(numOwned == 1) {
    		return 4 * roll;
    	}else if (numOwned == 2) {
    		return 10 * roll;
    	}
    	return 0; //This method should never return 0; It should only be called if someone owns the Utility, thus having rent due
    }

	@Override
	public void takeAction(Player callingPlayer) {
		//Check to see if the space has an owner
		if(this.getOwner() == null) {
			try {
				callingPlayer.purchase(this);
			} catch (NotEnoughFundsException | BankruptcyException e) {
				Console.println(callingPlayer.getName()+" you do not have enough money to do that!");
			}
		}else if(!callingPlayer.equals(this.getOwner())){ //else there is an owner and we need to pay them rent
			Player owner = this.getOwner();
			int roll = Facade.getBanker().getDiceValue();
			int rentDue = calculateRent(owner, roll); //get the rent due
			try {
				callingPlayer.subMoney(rentDue);
			} catch (BankruptcyException e) {

			}
			owner.addMoney(rentDue);
			banker.getGUI().updatePlayerPanel();
			banker.getGUI().updateOtherPlayerPanel();
			Console.println(callingPlayer.getName()+" has paid " + owner.getName() + " $"+rentDue +"!");
			new PopUpWarning("Pay up!", callingPlayer.getName()+" has paid " + owner.getName() + " "+rentDue +"!");
		}
		
		
	}
}

