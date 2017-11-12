package com.esof322.pa2.model;


/**
* @generated
*/
public class Banker {
    
    private static Banker bank;
    private static ModelListener GUI;
    
    protected Player[] players;
    
    private Player currentPlayer;
    
    
    protected Board board;   
       
    public Banker(ModelListener gui) {
    		this.GUI = gui;
    }
    
    public void tranferFunds() {
        //TODO
    }
    
    public void setUpBoard(int numberOfPlayers) {
    		players = new Player[numberOfPlayers];
    		
        //TODO finish with acutal content
    		for(int i=0; i<numberOfPlayers; i++) {
    			players[i] = new Player(i, "#" + i);
    		}
    		this.currentPlayer = players[0];
    		Banker.getGUI().updateCurrentPlayer();
    		Banker.getGUI().updateCurrentPlayerMoney();
    }
    
    
    public void startGame() {
    		bank = this;
    		
        //TODO
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
    		return this.currentPlayer;
    }
    
}
