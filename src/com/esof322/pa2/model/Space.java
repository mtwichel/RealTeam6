package com.esof322.pa2.model;

import java.util.List;

public class Space {
 
    private String name;
    private String color;
    private List<Player> occupyingPlayers;
    
    
    public Space(String name) {
		this.name = name;
	}


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
        
   
    public void takeAction(Player callingPlayer) {
    	
    }
    
    
}