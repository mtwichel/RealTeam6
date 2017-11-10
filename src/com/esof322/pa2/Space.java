package com.esof322.pa2;

import java.util.List;

public abstract class Space {
 
    private String name;
    private List<Player> occupyingPlayers;
    
    
    private String getName() {
        return this.name;
    }
    

    private void setName(String name) {
        this.name = name;
    }
    
    public void addPlayer(Player p) {
    		this.occupyingPlayers.add(p);
    }
    
    public void removePlayer(Player p) {
    		this.occupyingPlayers.remove(p);
    }
        
   
    abstract void takeAction(Player callingPlayer);
    
    
}
