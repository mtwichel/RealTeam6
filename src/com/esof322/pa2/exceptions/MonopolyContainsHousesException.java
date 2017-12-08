package com.esof322.pa2.exceptions;

import com.esof322.pa2.model.PropertySpace;

public class MonopolyContainsHousesException extends Exception{


	public MonopolyContainsHousesException(int color) {
		System.out.println("Color #"+color+" contains houses, therefore cannot be mortgaged.");
	}

}

