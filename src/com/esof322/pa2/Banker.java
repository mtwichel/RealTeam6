package com.esof322.pa2;


/**
* @generated
*/
public class Banker {
    
    private static Banker bank;
    
    protected Player[] players;
    
    
    protected Board board;   
    

    //                          Operations                                  
    
    
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
    
    public Board getBoard() {
    	return board;
    }
    
    public Player getPlayer(int num){
    		return players[num];
    }
    
}
