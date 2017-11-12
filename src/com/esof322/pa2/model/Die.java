package com.esof322.pa2.model;


/**
* @generated
*/
public class Die {

	//Holds last Roll
	private int currentValue;
	
	//Instantiates Die
	public Die() {
		
	}
	
	public int rollDie() {
		currentValue = (int)(Math.random()*6)+1;
		return currentValue;
	}
	
	//returns the last Roll from this die for comparisons [may need to replace with safer method]
	public int getValue() {
		return currentValue;
	}

}
