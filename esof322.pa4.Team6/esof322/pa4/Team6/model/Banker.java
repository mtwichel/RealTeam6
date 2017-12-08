package esof322.pa4.Team6.model;

import java.rmi.activation.ActivationInstantiator;

import esof322.pa4.Team6.exceptions.BankruptcyException;
import esof322.pa4.Team6.exceptions.DiceDoublesException;
import esof322.pa4.Team6.exceptions.GameEnd;
import esof322.pa4.Team6.exceptions.NotEnoughFundsException;
import esof322.pa4.Team6.exceptions.PopUpWarning;
import esof322.pa4.Team6.exceptions.ThreeDoublesException;
import esof322.pa4.Team6.gui.Console;
import esof322.pa4.Team6.gui.Facade;
import esof322.pa4.Team6.gui.MainWindow;
import esof322.pa4.Team6.gui.PlayerSetUpWindow;
import javafx.stage.Stage;

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
		//GUI.updatePlayerPositions();
		//setCurrentAction(Action.ROLL_DICE);
		
	}

	public void checkWinner() {

		Player winner = players[0];
		int activePlayers = 0;
		
		for(int i = 0; i<players.length;i++) {
			if(!players[i].isBankrupt()){
				winner = players[i];
				activePlayers++;
			}
		}
		if(activePlayers < 2) {
			new GameEnd("WINNER WINNER CHICKEN DINENR", "Congratulations "+winner.getName()+" you've won!");
		}
	}
	
	public void setUpPlayers() {
		new PlayerSetUpWindow();
		String[] names = Facade.getNames();
		numPlayers = names.length;
		players = new Player[this.numPlayers];
		for(int i=0; i<players.length; i++) {
			players[i] = new Player(this, names[i], i, "FFFFFF");
		}
		
		this.currentPlayerIndex = 0;
		setCurrentPlayer(players[currentPlayerIndex]);
		setNextPlayer(players[currentPlayerIndex +1]);
		//GUI.updatePlayerPositions();
		
	}
	
	public void setUp() {
		new PlayerSetUpWindow();
		String[] names = Facade.getNames();
		for(int i=0; i<players.length; i++) {
			players[i] = new Player(this, names[i], i, "FFFFFF");
		}
		
		this.currentPlayerIndex = 0;
		setCurrentPlayer(players[currentPlayerIndex]);
		setNextPlayer(players[currentPlayerIndex +1]);
	}
	
	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
		//GUI.updateCurrentPlayer();
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
		//GUI.updateDice();
		if(dice[0].getValue() == dice[1].getValue()) {
			throw new DiceDoublesException();
		}
	}
	
	public void rigDice(int a, int b) {
		dice[0].rigDie(a);
		dice[1].rigDie(b);
	}

	private boolean changeAction = true;

	public void takeAction() throws BankruptcyException {
		changeAction = true;
		
			switch(currentAction) {
			case ROLL_DICE:
				if(!currentPlayer.isJailed()) {
					//current player can play
					try {
						rollDice();
						GUI.updateDice();
					} catch (DiceDoublesException e) {
						try {
							GUI.updateDice();
							//Console.println(currentPlayer.getName() + " rolled " + dice[0].getValue() + " and " + dice[1].getValue());
							Console.println("Doubles! Roll again!");
							currentPlayer.addDoublesCounter();
							//setNextPlayer(currentPlayer);		//Causes Graphic Glitch
							changeAction = false;		//Skip changing turn order instead. KEEP CURRENT ACTION ROLLDICE
						} catch (ThreeDoublesException e1) {
							GUI.updateDice();
							//Don't skip changing turn order
							Console.println(currentPlayer.getName() + " rolled " + dice[0].getValue() + " and " + dice[1].getValue());
							Console.println(currentPlayer.getName()+" has rolled 3 doubles! They must be Punished with Jail time!");
							currentPlayer.toJail();
						}

						//handleDoubleRoll(1);
					}
					if(!currentPlayer.isJailed()) {
						currentPlayer.movePlayer(getDiceValue());
						GUI.updatePlayerPositions();
					}
					currentPlayer.doSpaceAction();

					if(changeAction||currentPlayer.isBankrupt()) {
						setCurrentAction(Action.END_TURN);
					}
				}else {
					try {
						rollDice();
						GUI.updateDice();
						currentPlayer.addDoublesCounter();
					} catch (DiceDoublesException e) {
						GUI.updateDice();
						//setNextPlayer(currentPlayer);	//Causes Graphical Glitch
						currentPlayer.getOutOfJail();
						Console.println(currentPlayer.getName()+" rolled doubles and escaped Jail");
						currentPlayer.movePlayer(getDiceValue());
					} catch (ThreeDoublesException e) {
						GUI.updateDice();
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
				
				while(currentPlayer.isBankrupt()){//While the current player is not in the game, choose another player.
					this.currentPlayerIndex = ((this.currentPlayerIndex + 1) % this.numPlayers); //update index by 1 and wrap around if over numPlayers

					setCurrentPlayer(this.nextPlayer);
					setNextPlayer(this.players[(this.currentPlayerIndex + 1) % this.numPlayers]);
					
					if(!currentPlayer.isJailed()) {
						currentPlayer.resetDoublesCounter();
					}
					setCurrentAction(Action.ROLL_DICE);
					GUI.updatePlayerPanel();
					GUI.updateOtherPlayerPanel();
				}
				
				if(!currentPlayer.isJailed()) {
					currentPlayer.resetDoublesCounter();
				}
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
