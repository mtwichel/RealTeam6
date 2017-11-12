package com.esof322.pa2.model;

import java.util.List;

import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.exceptions.PropertyMaxUpgratedException;

public class Player {
    
    
    private int piece;  
    private String name;
    private int balance;  
    private int position;
    private int doublesCounter;
    private boolean jailed;
    
    
    private List<PropertySpace> ownedPropertySpaces; 
    private Space currentSpace;
	
    
    
    public Player(int piece, String name) {
    		this.piece = piece;
    		this.name = name;
    		this.balance = 1500;
    		this.position = 0;
    		this.doublesCounter = 0;
    }
    
    public int getPiece() {
        return this.piece;
    }
    
    public String getName() {
    		return this.name;
    }
    
    
    public int getBalance() {
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
    
    public boolean getJailed() {
    	return jailed; 
    }
    
    protected void movePlayer(int move) {

    	position += move;
    	if(position >= 40) {
    		position -= 40;
    		//Add money for passing Go Here, and reset position to int below 40.
    		balance += 200;
    		
    	}

    }
    
    public void toJail() {
    	position = 10;
    	jailed = true; 
    }
    public void removeJailedStatus() {
    	jailed = false; 
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
    
    public int rollDice() {
		Die die1 = new Die();
		Die die2 = new Die();
		
		die1.rollDie();
		die2.rollDie();
		
		if(die1.getValue()==die2.getValue()) {
			doublesCounter++;
		}else{ doublesCounter = 0;}
		return(die1.getValue()+die2.getValue());
	}
    

    public void takeTurn() {
    	movePlayer(rollDice()); //switch to other dice method
    	currentSpace = Banker.getBanker().getBoard().getSpace(position);//updates position
        currentSpace.takeAction(this);//do what ever that space does
        
        notifyPlayerChoice();
        
        //TODO finish
    }
    
    
    private void notifyPlayerChoice() {
		// TODO Auto-generated method stub
		
	}

	//listener methods
    private void notifyMovementListeners() {
    		//TODO
	}
    
}
