package com.esof322.pa2.model;

import com.esof322.pa2.exceptions.DiceDoublesException;
import com.esof322.pa2.exceptions.GoToJailException;
import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.gui.MainWindow;

public class Banker {

	private static ModelListener GUI;
	private Player current;
	private Board board;  
	private Die[] dice;

	private Action currentAction;

	public Banker(MainWindow gui) {
		board = new Board();
		this.GUI = gui;

		//create dice
		this.dice = new Die[2]; //2 dice
		this.dice[0] = new Die();
		this.dice[1] = new Die();
	}

	public Player[] players;




	public void tranferFunds() {
		//TODO
	}

	public void setUpPlayers(int numberOfPlayers) {
		players = new Player[numberOfPlayers];
		//Roll off per player, highest roll gets highest position

	}

	public void rollDice() throws DiceDoublesException {
		dice[0].rollDie();
		dice[1].rollDie();
		if(dice[0].getValue() == dice[1].getValue()) {
			throw new DiceDoublesException();
		}
	}

	public static ModelListener getGUI() {
		return GUI;
	}

	public Board getBoard() {
		return board;
	}

	public Player getPlayer(int num){
		return players[num];
	}

	public Player getCurrentPlayer() {
		return current;
	}

	public void takeAction() {
		//		 TODO add functionality as it comes in
		switch(currentAction) {
		case ROLL_DICE:
			getCurrentPlayer().rollDice();
			
			break;
		case END_TURN:
			break;

		}


	}

	public int getDiceValue() {return dice[0].getValue() + dice[1].getValue();}

}
