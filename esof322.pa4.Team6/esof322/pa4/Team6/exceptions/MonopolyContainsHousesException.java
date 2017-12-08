package esof322.pa4.Team6.exceptions;

import esof322.pa4.Team6.model.PropertySpace;

public class MonopolyContainsHousesException extends Exception{


	public MonopolyContainsHousesException(int color) {
		System.out.println("Color #"+color+" contains houses, therefore cannot be mortgaged.");
	}

}

