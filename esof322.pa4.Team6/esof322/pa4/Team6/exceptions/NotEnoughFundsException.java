package esof322.pa4.Team6.exceptions;

import esof322.pa4.Team6.model.Player;

public class NotEnoughFundsException extends Exception {
	
	private Player callingPlayer;

	public NotEnoughFundsException(Player callingPlayer) {
		this.callingPlayer = callingPlayer;
		new PopUpWarning("Money Problems","You need more money to do that.");
	}
	
	public Player getCallingPlayer() {
		return callingPlayer;
	}

}
