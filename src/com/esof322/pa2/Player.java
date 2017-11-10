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
    private Die[] dice = {new Die(), new Die()}; 
    private int currentIndex;
    private Space currentSpace;
    private Banker bank;
    
    
    public Player(int piece) {
    		this.piece = piece;
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
    		int ans =0;
        for(Die d : dice) {
        		ans += d.rollDie();
        }
        return ans;
    }
    
    
    
    protected void movePlayer(int spaces) {
    		this.currentIndex = ((currentIndex + spaces) % 40);
        this.currentSpace = bank.board.getSpace(currentIndex);
        goCounter += spaces;
        if(goCounter >=40) { //pass go
        		goCounter = currentIndex;
        		addMoney(200); //200 for passing go
        }
    }
    
    
    public void upgrade(PropertySpace space) throws NotEnoughFundsException, PropertyMaxUpgratedException {
    	space.upgrade();	
    	try {
			subMoney(space.getUpgradeAmount());
		} catch (NotEnoughFundsException e) {
			throw new NotEnoughFundsException(this);
		}
        
    }
    
    
    public void purchase(PropertySpace space) throws NotEnoughFundsException {
    		try {
    			subMoney(space.getPurchaseAmount());
    		} catch (NotEnoughFundsException e) {
    			throw new NotEnoughFundsException(this);
		}
    		this.ownedPropertySpaces.add(space);
    		space.setOwner(this);
    }
    
    
}
