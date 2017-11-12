package com.esof322.pa2.model;


/**
* @generated
*/
public class JailSpace extends Space {
    
	public JailSpace(String name) {
    	setName(name);
    }
	
	public String getNameSpace() {
		return getName();
	}

	@Override
	void takeAction(Player callingPlayer) {
		if (callingPlayer.getJailed() == true) {
			System.out.println("Choose to roll doubles or pay $50"); //Eventually change this to prompt with buttons 		
			//option to try and roll for doubles. If rolls doubles, turn still ends.
			//Pays $50 bail BEFORE attempting to roll (only an option for first 2 rounds in jail.
			//On third turn, if the player fails their roll, they must pay $50, but do get to roll.
			Die die1 = new Die();
			Die die2 = new Die();
			int iter = 0;
			die1.rollDie();
			die2.rollDie();
			if(die1.getValue()==die2.getValue()) {
				callingPlayer.removeJailedStatus(); 
				callingPlayer.takeTurn();//gets to roll
			}else if(callingPlayer.getTurnsInJail() < 3){
				callingPlayer.addTurnInJail();//dosen't get to roll
			}else {
				//callingPlayer.
			}
		}
	}


}
