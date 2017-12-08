package esof322.pa4.Team6.exceptions;

import esof322.pa4.Team6.model.PropertySpace;

//Happens when trying to mortgage a Monopoly without selling the houses/hotels first
public class IsAMonopolyException extends Exception{

	private PropertySpace property;

	public IsAMonopolyException(PropertySpace ps) {
		this.property = property;
	}
	
	public PropertySpace getCallingPlayer() {
		return property;
	}
}
