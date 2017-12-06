package com.esof322.pa2.model;

import com.esof322.pa2.exceptions.PopUpWarning;
import com.esof322.pa2.gui.Console;
import com.esof322.pa2.gui.Facade;

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
		Facade.getBanker().getGUI().updatePlayerPositions();
	}
    
}
