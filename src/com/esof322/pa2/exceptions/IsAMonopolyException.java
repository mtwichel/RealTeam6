package com.esof322.pa2.exceptions;

import com.esof322.pa2.model.PropertySpace;

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
