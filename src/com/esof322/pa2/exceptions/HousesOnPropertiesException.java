package com.esof322.pa2.exceptions;
import com.esof322.pa2.model.PropertySpace;
public class HousesOnPropertiesException extends Exception{

	//happens when you try to mortgage a property with buildings on a property in the monopoly.

	private PropertySpace property;

	public HousesOnPropertiesException(PropertySpace ps) {
		this.property = property;
	}

	public PropertySpace getCallingPlayer() {
		return property;
	}
}

