package com.esof322.pa2.model;

import java.util.List;

import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.exceptions.PropertyMaxUpgratedException;
import com.esof322.pa2.exceptions.PropertyMinUpgratedException;

public class Player {
    
    
    private int piece = -1;//default, players will pick at beginning of game    
    private int balance = 1500;  
    private int position = 0;
    private int doublesCounter = 0;
    private boolean jailed = false;
    private boolean hasMonopoly = false;
    private int turnsInJail = 1500;
    private int netWorth = 1500;//Represents balance + non-mortgaged properties if mortgaged, and houses/hotels
    
    
    private List<PropertySpace> ownedPropertySpaces; 
    private Space currentSpace;
    
    
    public Player(int piece) {
    		this.piece = piece;
    }
    
    public int getPiece() {
        return this.piece;
    }
    
    public void resetTurnsInJail() {
    	turnsInJail = 0;
    }
    
    public void addTurnInJail() {
    	turnsInJail++;
    }
    
    public int getTurnsInJail() {
    	return turnsInJail;
    }
    
    public int getPosition() {
    	return position;
    }
    
    protected int getBalance() {
        return this.balance;
    }
    
    
    public void addMoney(int amount) {
    		this.netWorth += amount;
    		this.balance += amount;
    }
    
    //if Balance goes below 0, check for mortgagable properties/houses to sell if they have a monopoly
    public void charge(Player p, int amount) {//Charge happens when player must pay(dosen't have an option)
    	this.balance -= amount;
    	this.netWorth -= amount;
    	if(this.balance <= 0) {
    		//Cry internally//
    		if(runBankruptcyCheck(p, amount)) {
    			Bankrupt(p);
    		}else {
    			//Give options to sell stuff here
    			avoidBankruptcy(amount);
    			payPlayer(p, amount);
    		}
    	}
    }
    
    public boolean runBankruptcyCheck(Player p, int amount) {//Player p is the player making them run the check. null if banker
    	if(ownedPropertySpaces.isEmpty()) {
    		//GameOver for player, remove them from list of players
    		return true;
    	}
    	if(amount < this.netWorth) {
    		
    		return false; //Still need to sell some stuff though
    	}else {
    		return true;//You just lose. All your stuff goes to the person who you owed.
    	}
   
    }
    
    //Allows the player to mortgage properties from a selection/sell houses/hotels
    public void avoidBankruptcy(int amount) {
    	//Organise Properties based on their net Value (Mortgage price + total houses price if sold)?
    	//OR give the player the option to sell their houses if they have a monopoly/mortgage properties
    	/*for(int i = 0; i < ownedPropertySpaces.size();i++) {
    		if(this.ownedPropertySpaces.get(i).checkIsMonopoly()) {
    			//check if houses cover debt
    			this.ownedPropertySpaces.get(i).
    			
    		}
			this.ownedPropertySpaces.get(i).getMortgageValue();
			
    	}*/
    }
    
    public void Bankrupt(Player p) {//Player p is the player they go bankrupt to, null if to bank.
    	if(p.equals(null)) {
    		resetProperties();
    		//return properties to unowned.
    		//return houses/hotels to pool.***
    	}else {
    		this.handOverProperties(p);
    	}
    	//Delete Player from list in bank (once Arjan adds it)
    }
    
    public void handOverProperties(Player p) {
    	if(p.equals(null)) {
    		resetProperties();
    	}else {
    		for(int i = 0; i < ownedPropertySpaces.size();i++) {
    			//hand over money and properties
    			p.aquireProperty(this.ownedPropertySpaces.get(i));
    			this.ownedPropertySpaces.remove(i);
    			if(balance > 0) {
    				this.payPlayer(p, balance);
    			}
    		}
    	}
    }
    
    public void resetProperties() {
    	for(int i = 0; i < ownedPropertySpaces.size();i++) {
    		Player empty = new Player(0);
    		this.ownedPropertySpaces.get(i).setOwner(empty);//makes it so other players can buy the property now
    		this.ownedPropertySpaces.get(i).setIsMonopoly(false);
    		this.ownedPropertySpaces.get(i).resetHouseLevel();
    	}
    }
    
    private void subMoney(int amount) throws NotEnoughFundsException {
		this.balance -= amount;
		this.netWorth -= amount;
		if((this.balance - amount) < 0) {
			throw new NotEnoughFundsException(this);
		}
    }
   
    public void mortgage(PropertySpace space) {
        addMoney(space.getMortgageValue());
        this.netWorth -= space.getMortgageValue();
        space.setMortgaged();
    }
    
    
    public void unMortgage(PropertySpace space) throws NotEnoughFundsException {
    		try {
    			subMoney(space.getUnmortgageValue());
		} catch (NotEnoughFundsException e) {
			throw new NotEnoughFundsException(this);
		}
    	this.netWorth += space.getMortgageValue();
        space.setUnmortgaged();
    	
    }
    
    public boolean getJailed() {
    	return jailed; 
    }
    
    protected void movePlayer(int move) {

    	this.position += move;
    	if(this.position >= 40) {
    		this.position -= 40;
    		//Add money for passing Go Here, and reset position to int below 40.
    		this.balance += 200;
    		this.netWorth += 200;
    		
    	}

    }
    
    public void toJail() {
    	this.position = 10;
    	this.jailed = true; 
    }
    public void removeJailedStatus() {
    	this.jailed = false; 
    }

	public void upgrade(PropertySpace space) throws NotEnoughFundsException, PropertyMaxUpgratedException {
    	space.upgrade();	
    	try {
			subMoney(space.getUpgradeAmount());
	    	this.netWorth += space.getUpgradeAmount()/2;//add how much it could be sold for to netWorth
		} catch (NotEnoughFundsException e) {
			throw new NotEnoughFundsException(this);
		}
        
    }
	
	public void downgrade(PropertySpace space) throws PropertyMinUpgratedException {
		space.downgrade();//removes a house/entire hotel(no houses given)
		this.addMoney(space.getUpgradeAmount()/2);
		this.netWorth -= space.getUpgradeAmount()/2; //loses the potential to sell
	}
    
    
    public void purchase(PropertySpace space) throws NotEnoughFundsException {
    		try {
    			subMoney(space.getPurchaseAmount());
    		} catch (NotEnoughFundsException e) {
    			throw new NotEnoughFundsException(this);
		}
    		this.ownedPropertySpaces.add(space);
    		netWorth += space.getMortgageValue();
    		space.setOwner(this);
    }
    
    public void aquireProperty(PropertySpace space) {
    	this.ownedPropertySpaces.add(space);
    	if(!space.isMortgaged()) {
    		netWorth += space.getMortgageValue();
    	}
		space.setOwner(this);
    }
    
    public void payPlayer(Player p, int amount) {
    	this.charge(p,amount);
    	if(!p.equals(null)) {
    		p.addMoney(amount);
    	}
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
    	if(!jailed) {
    		movePlayer(rollDice());
        	currentSpace = Banker.getBanker().getBoard().getSpace(position);//updates position
    	}else {
    		//option to try and roll for doubles. If rolls doubles, turn still ends.
    		//Pays $50 bail BEFORE attempting to roll (only an option for first 2 rounds in jail.
    		//On third turn, if the player fails their roll, they must pay $50, but do get to roll.
    	}
        currentSpace.takeAction(this);//do what ever that space does
        
        notifyPlayerChoice();
    }
    
    
    private void notifyPlayerChoice() {
		// TODO Auto-generated method stub
		
	}

	//listener methods
    private void notifyMovementListeners() {
    		//TODO
	}
    
}
