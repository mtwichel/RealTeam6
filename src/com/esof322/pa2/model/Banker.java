package com.esof322.pa2.model;

import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.gui.MainWindow;

public class Banker {
    
    private static Banker bank;
    private static ModelListener GUI;
    private Player current;
    private Board board;  
    
    private Action currentAction;
    
    public Banker(MainWindow gui) {
    	board = new Board();
    	this.GUI = gui;
    }
    
    public Player[] players;
    

       
    
    public void tranferFunds() {
        //TODO
    }
    
    public void setUpPlayers(int numberOfPlayers) {
        players = new Player[numberOfPlayers];
        //Roll off per player, highest roll gets highest position
        
    }
    
    
    
    public static Banker getBanker() {
    		return bank;
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
				break;
			case END_TURN:
				break;
				
		}
		
		
	}
    
}
