package esof322.pa4.Team6.model;

import java.util.List;
import java.util.stream.Collectors;

import esof322.pa4.Team6.exceptions.BankruptcyException;
import esof322.pa4.Team6.exceptions.NotEnoughFundsException;
import esof322.pa4.Team6.exceptions.PopUpWarning;
import esof322.pa4.Team6.gui.Console;

public class Railroad extends PropertySpace {
    
	private final int type = 2;
	private PropertyGroup pg;
	
    public Railroad(Banker banker, String name, PropertyGroup propertyGroup, 
			int purchaseAmount, int upgradeAmount, int[] rentRates) {
    	super(banker, name, propertyGroup, purchaseAmount, upgradeAmount, rentRates);
    	pg = propertyGroup;
    }
  
    public int getType() {return type;}
    
    public String getNameSpace() {
		return getName();
	}
    
    public int calculateRent(Player callingPlayer) {
    	int numOwned = pg.checkAmountHeld(this);
    	if(isMortgaged()) {
			return 0;
		}
 
    	if(numOwned == 1) {
    		return 25;
    	}else if (numOwned == 2) {
    		return 50;
    	}else if (numOwned == 3) {
    		return 100;
    	}else if (numOwned == 4) {
    		return 200;
    	}
    	
		return 25;
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
			new PopUpWarning("Pay up!", callingPlayer.getName()+" has paid " + owner.getName() + " $"+rentDue +"!");
		}		
		
	}
}


