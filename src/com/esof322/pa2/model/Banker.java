package com.esof322.pa2.model;

import java.rmi.activation.ActivationInstantiator;

import com.esof322.pa2.exceptions.DiceDoublesException;
import com.esof322.pa2.exceptions.ThreeDoublesException;
import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.gui.Facade;
import com.esof322.pa2.gui.MainWindow;

public class Banker {

	private static ModelListener GUI;
	private int numPlayers;
	private int currentPlayerIndex;
	private Player currentPlayer;
	private Player nextPlayer;
	private static Board board;  
	private Die[] dice;
	private Player[] players;
	private Player currentPlayerOrder[];


	private Action currentAction;

	public Banker(MainWindow gui, int numPlayers) {
		board = new Board(this);
		this.GUI = gui;
		this.numPlayers = numPlayers;

		//create dice
		this.dice = new Die[2]; //2 dice
		this.dice[0] = new Die();
		this.dice[1] = new Die();
	}

	public void setUpBoard() {
		setUpPlayers();
		
		setCurrentAction(Action.ROLL_DICE);
		
	}

	public void tranferFunds() {
		//TODO
	}

	public void setUpPlayers() {
		players = new Player[this.numPlayers];
		String[] names = {"George", "Arjan", "Taylor", "Marcus"}; //temp for testing
		for(int i=0; i<players.length; i++) {
			//TODO initialize players
			players[i] = new Player(this, names[i], i, "FFFFFF");
		}
		
		this.currentPlayerIndex = 0;
		setCurrentPlayer(players[currentPlayerIndex]);
		setNextPlayer(players[currentPlayerIndex +1]);
		GUI.updatePlayerPositions();
		
	}
	
	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
		GUI.updateCurrentPlayer();
	}
	
	public void setNextPlayer(Player player) {
		this.nextPlayer = player;
	}
	
	public void setCurrentAction(Action action) {
		this.currentAction = action;
		GUI.updateActionButton();
	}

	public void rollDice() throws DiceDoublesException {
		dice[0].rollDie();
		dice[1].rollDie();
		if(dice[0].getValue() == dice[1].getValue()) {
			throw new DiceDoublesException();
		}
		GUI.updateDice();
	}

	public void takeAction() {
		//TODO add functionality as it comes in
		switch(currentAction) {
		case ROLL_DICE:
			if(!currentPlayer.isJailed()) {
				//current player can play
				try {
					rollDice();
				} catch (DiceDoublesException e) {
					try {
						currentPlayer.addDoublesCounter();
						setNextPlayer(currentPlayer);
					} catch (ThreeDoublesException e1) {
						currentPlayer.toJail();
					}
				}
				currentPlayer.movePlayer(getDiceValue());
				currentPlayer.doSpaceAction();
				
				setCurrentAction(Action.END_TURN);
			}else {
				try {
					rollDice();
					currentPlayer.addDoublesCounter();
				} catch (DiceDoublesException e) {
					setNextPlayer(currentPlayer);
					currentPlayer.getOutOfJail();
				} catch (ThreeDoublesException e) {
					try {
						currentPlayer.subMoney(50);
					} catch (NotEnoughFundsException e1) {
						// TODO handelMoney
						e1.printStackTrace();
					}
					setNextPlayer(currentPlayer);
					currentPlayer.getOutOfJail();
				}
				
				
			}
			break;
		case END_TURN:
			this.currentPlayerIndex = ((this.currentPlayerIndex + 1) 
					% this.numPlayers); //update index by 1 and wrap around if over numPlayers
			setCurrentPlayer(this.nextPlayer);
			setNextPlayer(this.players[(this.currentPlayerIndex + 1) % this.numPlayers]);
			setCurrentAction(Action.ROLL_DICE);
			GUI.updatePlayerPanel();
			GUI.updateOtherPlayerPanel();
			break;

		}


	}
	
	public Player[] updateCurrentPlayerOrder() {
		Player[] p = new Player[players.length];
		int beginning = currentPlayerIndex; 
		
		for(int i = 0; i < players.length;i++) {
			if(beginning > players.length-1) {
				beginning = 0;
			}
			p[i] = players[beginning++];
		}
		
		return p;
	}

	public int getDiceValue() {return dice[0].getValue() + dice[1].getValue();}
	public static ModelListener getGUI() {return GUI;}
	public static Board getBoard() {return board;}
	public Player getPlayer(int num){return players[num];}
	public Player[] getPlayerList() {return players;}
	public Player[] getCurrentPlayerNum() {return updateCurrentPlayerOrder();}
	public Player getCurrentPlayer() {return currentPlayer;}
	public String getCurrentActionString() {return Action.getActionString(currentAction);}
	public int getDiceValue(int i) {return dice[i].getValue();}



}
