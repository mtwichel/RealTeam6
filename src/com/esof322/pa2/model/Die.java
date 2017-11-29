package com.esof322.pa2.model;

class Die {

	private int currentValue;
	
	public Die() {
		
	}
	
	//like actually rolling of dice
	public void rollDie() {
		this.currentValue = (int)(Math.random()*6)+1;
	}
	
	//returns whatever the last value was
	public int getValue() {
		return currentValue;
	}

}
