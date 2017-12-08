package esof322.pa4.Team6.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Space {
 
    private String name;
    protected Banker banker;
    private List<Player> occupyingPlayers;
    
    
    public Space(Banker banker, String name) {
		this.name = name;
		this.banker = banker;
		this.occupyingPlayers = new ArrayList<Player>();
	}


	public String getName() {
        return this.name;
    }
	
	public int calculateRent() {return 0;}
	
	public List<Player> getOccupyingPlayer(){
		return this.occupyingPlayers;
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
    public abstract PropertySpace getSpace();
    
    
}