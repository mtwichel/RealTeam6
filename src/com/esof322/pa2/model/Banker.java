package com.esof322.pa2.model;


/**
* @generated
*/
public class Banker {
    
    private static Banker bank;
    private static ModelListener GUI;
    
    protected Player[] players;
    
    
    protected Board board;   
       
    
    public void tranferFunds() {
        //TODO
    }
    
    public void setUpBoard(int numberOfPlayers) {
        //TODO
    }
    
    
    public void startGame() {
    	bank = new Banker();
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
    
}
