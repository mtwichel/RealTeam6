package com.esof322.pa2;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Player {
    
    
    private int piece;    
    private int balance = 1500;  
    private int position = 0;
    private int doublesCounter = 0;
    private boolean jailed;
    
    
    private List<PropertySpace> ownedPropertySpaces; 
    private Space currentSpace;
    
    
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
    //
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
