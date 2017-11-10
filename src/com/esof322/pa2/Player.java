package com.esof322.pa2;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Player {
    
    
    private int piece;    
    private int balance;  
    private int goCounter;
    private int position;
    private int doublesCounter;
    
    
    
    private List<PropertySpace> ownedPropertySpaces; 
    private List<Die> dice; 
    private Space currentSpace;
    private Banker bank;
    
    
    public Player(int piece) {
    	
    }
    
    private int getPiece() {
        return this.piece;
    }
    
    
    protected int getBalance() {
        return this.balance;
    }
    
    
    public void addMoney(int amount) {
    		this.balance += amount;
    }
    
    private void subMoney(int amount) throws NotEnoughFundsException {
		this.balance -= amount;
		if((this.balance - amount) < 0) {
			throw new NotEnoughFundsException(this);
		}
    }
   
    
    
    private int getPosition() {
        return this.position;
    }
        
    
    public void mortgage(PropertySpace space) {
        addMoney(space.getMortgageValue());
        space.setMortgaged();
    }
    
    
    public void unMortgage(PropertySpace space) throws NotEnoughFundsException {
    		try {
    			subMoney(space.getUnmortgageValue());
		} catch (NotEnoughFundsException e) {
			throw new NotEnoughFundsException(this);
		}
        space.setUnmortgaged();
    	
    }
    
    
    public void takeTurn() {
        //TODO
    }
    
    
    private int rollDice() {
        //TODO
        return 0;
    }
    
    
    protected void movePlayer(int spaces) {
        //TODO
    }
    
    
    public void upgrade(PropertySpace space) {
        //TODO
    }
    
    
    public void purchase(PropertySpace space) {
        //TODO
    }
    
    
}
