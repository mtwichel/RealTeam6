package com.esof322.pa2.model;

import com.esof322.pa2.exceptions.BankruptcyException;
import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.exceptions.PopUpWarning;
import com.esof322.pa2.gui.Facade;

public class TaxSpace extends Space {
    
	private String name;
	private boolean taxType;
	
	public TaxSpace(Banker banker, String name,boolean b) {
		super(banker, name);
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
    
    
}
