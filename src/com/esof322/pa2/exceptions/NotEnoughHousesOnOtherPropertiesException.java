package com.esof322.pa2.exceptions;

import com.esof322.pa2.model.PropertySpace;

public class NotEnoughHousesOnOtherPropertiesException extends Exception{

	//happens when you try to build a house/hotel on a Property without 
	//upgrading other properties of the same Monopoly to it's level

	private PropertySpace property;

	public NotEnoughHousesOnOtherPropertiesException(PropertySpace ps) {
		this.property = property;
	}

	public PropertySpace getCallingPlayer() {
		return property;
	}
}
