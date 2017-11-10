package com.esof322.pa2;

public class NotEnoughFundsException extends Exception {
	
	private Player callingPlayer;

	public NotEnoughFundsException(Player callingPlayer) {
		this.callingPlayer = callingPlayer;
	}
	
	public Player getCallingPlayer() {
		return callingPlayer;
	}

}
