package com.esof322.pa2.model;

class Die {

	private int currentValue;
	
	public Die() {
		
	}
	
	//like actually rolling of dice
	public void rollDie() {
		int range = (6 - 1) + 1;     
		 this.currentValue = (int)(Math.random() * range) + 1;
	}
	
	public void rigDie(int i) {
		currentValue = i;
	}
	
	//returns whatever the last value was
	public int getValue() {
		return currentValue;
	}

}
