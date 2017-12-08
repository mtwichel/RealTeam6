package esof322.pa4.Team6.exceptions;

import esof322.pa4.Team6.model.PropertySpace;

//happens when you try to build a house/hotel on a Property which is not a monopoly
public class IsNotAMonopolyException extends Exception{

	private PropertySpace property;

	public IsNotAMonopolyException(PropertySpace ps) {
		this.property = property;
		new PopUpWarning("Gotta Catch Em' All","You need a Monopoly of this Property type to do that.");
	}
	
	public PropertySpace getCallingPlayer() {
		return property;
	}
}
