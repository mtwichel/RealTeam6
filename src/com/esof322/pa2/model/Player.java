package com.esof322.pa2.model;

import java.util.ArrayList;
import java.util.List;

import com.esof322.pa2.exceptions.DiceDoublesException;
import com.esof322.pa2.exceptions.ThreeDoublesException;
import com.esof322.pa2.gui.Confirmation;
import com.esof322.pa2.gui.Console;
import com.esof322.pa2.gui.Facade;

import com.esof322.pa2.exceptions.GroupUpgradedException;
import com.esof322.pa2.exceptions.HousesOnPropertiesException;
import com.esof322.pa2.exceptions.IsNotAMonopolyException;
import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.exceptions.PopUpWarning;
import com.esof322.pa2.exceptions.PropertyIsMortgagedException;
import com.esof322.pa2.exceptions.PropertyMaxUpgratedException;
import com.esof322.pa2.exceptions.PropertyMinUpgratedException;

public class Player {
	
	private Banker banker;

	private int piece;
	private String name;
	private int balance;  
	private int position;
	private int doublesCounter;
	private boolean jailed;
	private boolean hasMonopoly;
	private int turnsInJail;
	private String color;


	private ArrayList<PropertySpace> ownedPropertySpaces = new ArrayList<PropertySpace>(); 
	private Space currentSpace;


	//constructor sets up a default player, with a piece and a color specified
	public Player(Banker banker, String name, int piece, String color) {
		//set up parameters
		this.color = color;
		this.banker = banker;
		this.piece = piece;
		this.name = name;
		
		//create default instance variables
		jailed = false;
		hasMonopoly = false;
		turnsInJail = 0;
		balance = 1500;
		doublesCounter = 0;
		position = 0;
		this.currentSpace = banker.getBoard().getSpace(0);
		this.currentSpace.addPlayer(this);
		
		
		switch (piece) {
		case 1:
			name = "Car";
			break;
		case 2:
			name = "Boot";
			break;
		case 3:
			name = "Anvil";
			break;
		case 4:
			name = "Hat";
			break;
		case 5:
			name = "Thimble";
			break;

		default:
			name = "Howitzer";
		}
	}
	
	public void doSpaceAction() {
		currentSpace.takeAction(this);
	}

	public void addMoney(int amount) {
		this.balance += amount;
	}

	public void subMoney(int amount) throws NotEnoughFundsException {
		if((this.balance - amount) < 0) {
			throw new NotEnoughFundsException(this);
		}else {
			this.balance -= amount;
		}
	}

	public void mortgage(PropertySpace space) throws GroupUpgradedException {
		space.setMortgaged();
		addMoney(space.getMortgageValue());
	}


	public void unMortgage(PropertySpace space) throws NotEnoughFundsException {
		subMoney(space.getUnmortgageValue());
		space.setUnmortgaged();
	}


	//this position moves the player the specified spaces, and awards money if let go
	public void movePlayer(int move) {
		this.currentSpace.removePlayer(this);
		
		this.position += move;
		if(this.position >= 40) {
			this.position -= 40;
			//Add money for passing Go Here, and reset position to int below 40.
			this.balance += 200;
		}
		this.currentSpace = banker.getBoard().getSpace(this.position);
		
		this.currentSpace.addPlayer(this);
		
		banker.getGUI().updatePlayerPositions();
	}

	public void toJail() {
		this.position = 10;
		this.jailed = true; 
		new PopUpWarning("JAILED",Facade.getBanker().getCurrentPlayer().getName()+" has been sent to Jail!");
	}
	public void getOutOfJail() {
		this.jailed = false; 
		new PopUpWarning("JAILED",Facade.getBanker().getCurrentPlayer().getName()+" has freed from Jail!");
	}

	public void upgrade(PropertySpace space) throws NotEnoughFundsException, PropertyMaxUpgratedException, PropertyIsMortgagedException, IsNotAMonopolyException {
		subMoney(space.getUpgradeAmount());
		space.upgrade();	
	}

	public void downgrade(PropertySpace space) throws PropertyMinUpgratedException {
		space.downgrade();//removes a house/entire hotel(no houses given)
		this.addMoney(space.getUpgradeAmount()/2);
	}

	//this method makes the player own the space
	public void purchase(PropertySpace space) throws NotEnoughFundsException {
		if(new Confirmation().display("Property Purchase", "Would you like to purchase "+space.getName()+"?")) {
			subMoney(space.getPurchaseAmount());
			this.ownedPropertySpaces.add(space);
			space.setOwner(this);
			Console.println(name+" has purchased "+space.getName());
			if(space.checkMonopoly()) {
				Console.println(name+" now has a Monopoly!");
			}
			banker.getGUI().updatePlayerPanel();
			banker.getGUI().updateOtherPlayerPanel();
		}
		
	}
	
	//this method adds to the doubles counter, and throws exception if a 3rd is thrown (and resets)
	protected void addDoublesCounter() throws ThreeDoublesException {
		this.doublesCounter += 1;
		if(this.doublesCounter>=3) { //after 3 doubles you go to jail
			this.doublesCounter = 0;
			throw new ThreeDoublesException();
		}
	}





	
	
	/***********
	 * 
	 * The GETTER BLOCK
	 * 
	 ************/
	public List getOwnedProperties() {return ownedPropertySpaces;}
	public String getName() {return name;}
	public int getPiece() {return this.piece;}
	public int getTurnsInJail() {return turnsInJail;}
	public int getPosition() {return position;}
	public int getBalance() {return this.balance;}
	public boolean isJailed() {return jailed;}
	public String getColor() {return this.color;}
	
	/***********
	 * 
	 * The Graveyard
	 * 
	 ************/
	
//	public void handOverProperties(Player p) {
//	if(p.equals(null)) {
//		resetProperties();
//	}else {
//		for(int i = 0; i < ownedPropertySpaces.size();i++) {
//			//hand over money and properties
//			p.aquireProperty(this.ownedPropertySpaces.get(i));
//			this.ownedPropertySpaces.remove(i);
//			if(balance > 0) {
//				this.payPlayer(p, balance);
//			}
//		}
//	}
//}

//public void resetProperties() {
//	for(int i = 0; i < ownedPropertySpaces.size();i++) {
//		Player empty = new Player(0, "649394");
//		this.ownedPropertySpaces.get(i).setOwner(empty);//makes it so other players can buy the property now
//		this.ownedPropertySpaces.get(i).setIsMonopoly(false);
//		this.ownedPropertySpaces.get(i).resetHouseLevel();
//	}
	
//	public void Bankrupt(Player p) {//Player p is the player they go bankrupt to, null if to bank.
//	if(p.equals(null)) {
//		resetProperties();
//		//return properties to unowned.
//		//return houses/hotels to pool.***
//	}else {
//		this.handOverProperties(p);
//	}
//	//Delete Player from list in bank (once Arjan adds it)
//}
//}
	
//	public void setHasMonopoly(boolean b) {
//		hasMonopoly = b;
//	}

//	public boolean getHasMonopoly() {
//		return hasMonopoly;
//	}
	
	
	//if Balance goes below 0, check for mortgagable properties/houses to sell if they have a monopoly
//	public void charge(Player p, int amount) {//Charge happens when player must pay(dosen't have an option)
//		this.balance -= amount;
//		this.netWorth -= amount;
//		if(this.balance <= 0) {
//			//Cry internally//
//			if(runBankruptcyCheck(p, amount)) {
//				bankrupt(p);
//			}else {
//				//Give options to sell stuff here
//				avoidBankruptcy(amount);
//				payPlayer(p, amount);
//			}
//		}
//	}
	
//	public void payPlayer(Player p, int amount) {
//		
//		if(!p.equals(null)) {
//			p.addMoney(amount);
//		}
//	}
	
//	public void aquireProperty(PropertySpace space) {
//		this.ownedPropertySpaces.add(space);
//		if(!space.isMortgaged()) {
//			this.netWorth += space.getMortgageValue();
//		}
//		space.setOwner(this);
//	}
	
//	public boolean runBankruptcyCheck(Player p, int amount) {//Player p is the player making them run the check. null if banker
//		if(ownedPropertySpaces.isEmpty()) {
//			//GameOver for player, remove them from list of players
//			return true;
//		}
//		if(amount < this.netWorth) {
//
//			return false; //Still need to sell some stuff though
//		}else {
//			return true;//You just lose. All your stuff goes to the person who you owed.
//		}
//
//	}
//
//	//Allows the player to mortgage properties from a selection/sell houses/hotels
//	public void avoidBankruptcy(int amount) {
//		//Organise Properties based on their net Value (Mortgage price + total houses price if sold)?
//		//OR give the player the option to sell their houses if they have a /mortgage properties
//		/*for(int i = 0; i < ownedPropertySpaces.size();i++) {
//    		if(this.ownedPropertySpaces.get(i).checkIsMonopoly()) {
//    			//check if houses cover debt
//    			this.ownedPropertySpaces.get(i).
//
//    		}
//			this.ownedPropertySpaces.get(i).getMortgageValue();
//
//    	}*/
//	}
	
//	public void takeTurn(){
//		if(!jailed) {
//			try {
//				banker.rollDice();
//			} catch (DiceDoublesException e) {
//				try {
//					addDoublesCounter();
//					banker.setNextPlayer(this);
//				} catch (GoToJailException e1) {
//					toJail();
//				}
//			}
//			movePlayer(banker.getDiceValue());
//		}else {
//			banker.rollDice();
//			
//		}
//
//		currentSpace.takeAction(this);//do what ever that space does
//	}


}
