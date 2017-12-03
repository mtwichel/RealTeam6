package com.esof322.pa2.model;

import com.esof322.pa2.exceptions.NotEnoughFundsException;

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
			try {
				callingPlayer.subMoney(75);
			} catch (NotEnoughFundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}else if(callingPlayer.getBalance() < 2000) {//false is income tax
			try {
				callingPlayer.subMoney((int) (callingPlayer.getBalance()*.1));
			} catch (NotEnoughFundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		else {
			try {
				callingPlayer.subMoney(200);
			} catch (NotEnoughFundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
    
    
}
