package com.esof322.pa2.exceptions;

import com.esof322.pa2.model.PropertySpace;

//happens when you try to build a house/hotel on a Property which is not a monopoly
public class IsNotAMonopolyException extends Exception{

	private PropertySpace property;

	public IsNotAMonopolyException(PropertySpace ps) {
		this.property = property;
	}
	
	public PropertySpace getCallingPlayer() {
		return property;
	}
}
