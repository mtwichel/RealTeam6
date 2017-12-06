package com.esof322.pa2.model;

import java.rmi.activation.ActivationInstantiator;

import com.esof322.pa2.exceptions.DiceDoublesException;
import com.esof322.pa2.exceptions.ThreeDoublesException;
import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.exceptions.PopUpWarning;
import com.esof322.pa2.gui.Console;
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
	private int playing;

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
		playing = players.length;
		setCurrentAction(Action.ROLL_DICE);
		
	}

	/*public void removePlayer(Player p) {
		Player[] newPlayers = new Player[players.length-1];
		int iter = 0;
		for(int i = 0;i < players.length-1;i++) {
			if(players[i]!=null) {
				newPlayers[iter] = players[i];
				iter++;
			}
		}
		
		players = newPlayers;
		updateCurrentPlayerOrder();
		GUI.updateCurrentPlayer();
		GUI.updateCurrentPlayerMoney();
		GUI.updateOtherPlayerPanel();
		GUI.updatePlayerPanel();
		checkWinner();
	}*/
	
	public void checkWinner() {
		playing--;
		if(playing==1) {
			new PopUpWarning("WINNER WINNER CHICKEN DINENR", "Congratulations "+currentPlayer.getName()+" you've won!");
		}
	}
	
	public void setUpPlayers() {
		players = new Player[this.numPlayers];
		String[] names = {"George", "Arjan", "Taylor", "Marcus"}; //temp for testing
		for(int i=0; i<players.length; i++) {
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

	private boolean changeAction = true;
	
	public void takeAction() {
		changeAction = true;
		switch(currentAction) {
		case ROLL_DICE:
			if(!currentPlayer.isJailed()) {
				//current player can play
				try {
					rollDice();
				} catch (DiceDoublesException e) {
					try {
						Console.println(currentPlayer.getName() + " rolled " + dice[0].getValue() + " and " + dice[1].getValue());
						Console.println("Doubles! Roll again!");
						currentPlayer.addDoublesCounter();
						//setNextPlayer(currentPlayer);		//Causes Graphic Glitch
						changeAction = false;		//Skip changing turn order instead. KEEP CURRENT ACTION ROLLDICE
					} catch (ThreeDoublesException e1) {
						//Don't skip changing turn order
						Console.println(currentPlayer.getName() + " rolled " + dice[0].getValue() + " and " + dice[1].getValue());
						Console.println(currentPlayer.getName()+" has rolled 3 doubles! They must be Punished with Jail time!");
						currentPlayer.toJail();
					}

					//handleDoubleRoll(1);
				}
				currentPlayer.movePlayer(getDiceValue());
				currentPlayer.doSpaceAction();
				
				if(changeAction) {
					setCurrentAction(Action.END_TURN);
				}
			}else {
				try {
					rollDice();
					currentPlayer.addDoublesCounter();
				} catch (DiceDoublesException e) {
					//setNextPlayer(currentPlayer);	//Causes Graphical Glitch
					currentPlayer.getOutOfJail();
					Console.println(currentPlayer.getName()+" rolled doubles and escaped Jail");
					currentPlayer.movePlayer(getDiceValue());
				} catch (ThreeDoublesException e) {
					currentPlayer.getOutOfJail();
					currentPlayer.subMoney(50);
					Console.println(currentPlayer.getName()+" paid the fine and was released from prison.");
				}
				
				setCurrentAction(Action.END_TURN);
			}
			break;
		case END_TURN:
			this.currentPlayerIndex = ((this.currentPlayerIndex + 1) % this.numPlayers); //update index by 1 and wrap around if over numPlayers
			
			setCurrentPlayer(this.nextPlayer);
			setNextPlayer(this.players[(this.currentPlayerIndex + 1) % this.numPlayers]);
			/*do {
				this.currentPlayerIndex = ((this.currentPlayerIndex + 1) % this.numPlayers);
				setCurrentPlayer(this.nextPlayer);
				setNextPlayer(this.players[(this.currentPlayerIndex + 1) % this.numPlayers]);
			}while(!this.nextPlayer.isPlaying());*/
			//setCurrentPlayer(this.nextPlayer);
			//setNextPlayer(this.players[(this.currentPlayerIndex + 1) % this.numPlayers]);
			setCurrentAction(Action.ROLL_DICE);
			GUI.updatePlayerPanel();
			GUI.updateOtherPlayerPanel();
			break;

		}


	}
	
	/*public void handleDoubleRoll(int doublesDone) {
		currentPlayer.movePlayer(getDiceValue());
		currentPlayer.doSpaceAction();
		
		GUI.updateDice();
		updateCurrentPlayerOrder();
		GUI.updateOtherPlayerPanel();
		GUI.updatePlayerPositions();
		
		if(doublesDone >= 3) {
			doublesDone = 0;
			currentPlayer.toJail();
			Console.println(currentPlayer.getName()+" has rolled 3 doubles! They must be Punished with Jail time!");
		}else {
			Console.println(" + "" Doubles! Roll again "+currentPlayer.getName()+"!");
			//But what about rest of turn?
			try {
				rollDice();
			} catch (DiceDoublesException e) {
				handleDoubleRoll(++doublesDone);
			}
		}
	}*/
	
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
