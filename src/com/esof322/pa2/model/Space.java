package com.esof322.pa2.model;

import java.util.List;

public abstract class Space {
 
    private String name;
    private List<Player> occupyingPlayers;
    
    
    protected String getName() {
        return this.name;
    }
    

    protected void setName(String name) {
        this.name = name;
    }
    
    public void addPlayer(Player p) {
    		this.occupyingPlayers.add(p);
    }
    
    public void removePlayer(Player p) {
    		this.occupyingPlayers.remove(p);
    }
        
   
    public abstract void takeAction(Player callingPlayer);
    
    
}
