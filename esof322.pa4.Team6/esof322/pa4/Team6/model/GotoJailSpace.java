package esof322.pa4.Team6.model;

import esof322.pa4.Team6.exceptions.PopUpWarning;
import esof322.pa4.Team6.gui.Console;
import esof322.pa4.Team6.gui.Facade;

/**
* @generated
*/
public class GotoJailSpace extends Space {
    
	public GotoJailSpace(Banker banker, String name) {
		super(banker, name);
    	setName(name);
    }
	
	public String getNameSpace() {
		return getName();
	}
	
	@Override
	public void takeAction(Player callingPlayer) {
		callingPlayer.toJail();	
		Console.println(callingPlayer.getName()+" has been sent to jail!");
		callingPlayer.resetDoublesCounter();
		Facade.getBanker().getGUI().updatePlayerPositions();
	}

	@Override
	public PropertySpace getSpace() {
		return null;//return nothing
	}
    
}
