package com.esof322.pa2;


/**
* @generated
*/
public class Banker {
    
    
    
    protected Player[] players;
    
    
    protected Board board;

	private Die[] dice = {new Die(), new Die()};
    
    

    //                          Operations                                  
    
    
    public void tranferFunds() {
        //TODO
    }
    
    public int rollDice() {
		int ans =0;
    for(Die d : dice ) {
    		ans += d.rollDie();
    }
    return ans;
}
    
    
    public void setUpBoard(int numberOfPlayers) {
        //TODO
    }
    
    
    public void startGame() {
        //TODO
    }
    
    public Player getPlayer(int num){
    		return players[num];
    }
    
}
