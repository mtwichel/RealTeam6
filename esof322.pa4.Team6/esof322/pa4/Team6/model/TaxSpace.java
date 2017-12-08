package esof322.pa4.Team6.model;

import esof322.pa4.Team6.exceptions.BankruptcyException;
import esof322.pa4.Team6.exceptions.NotEnoughFundsException;
import esof322.pa4.Team6.exceptions.PopUpWarning;
import esof322.pa4.Team6.gui.Facade;

public class TaxSpace extends PropertySpace {
    
	private String name;
	private boolean taxType;
	
	public TaxSpace(Banker banker, String name,boolean b) {
		super(banker, name, new PropertyGroup(""), 0, 0, new int[0]);
    	setName(name);
    	taxType = b;
    }
	
	public String getNameSpace() {
		return getName();
	}
	
	@Override
	public void takeAction(Player callingPlayer){
		
		if(taxType) { //true is luxury tax//
			new PopUpWarning("IRS",Facade.getBanker().getCurrentPlayer().getName()+" has to pay tax fines of $75");
			try {
				callingPlayer.subMoney(75);
			} catch (BankruptcyException e) {
			};
		}else if(callingPlayer.getBalance() < 2000) {//false is income tax
			try {
				callingPlayer.subMoney((int) (callingPlayer.getBalance()*.1));
			} catch (BankruptcyException e) {
			}
			new PopUpWarning("IRS",Facade.getBanker().getCurrentPlayer().getName()+" has to pay tax fines of $"+((int) (callingPlayer.getBalance()*.1)));
			}
		else {
			try {
				callingPlayer.subMoney(200);
			} catch (BankruptcyException e) {
			}
			new PopUpWarning("IRS",Facade.getBanker().getCurrentPlayer().getName()+" has to pay tax fines of $200");
		}
		
	}

	@Override
	public PropertySpace getSpace() {
		return this;
	}
    
    
}
