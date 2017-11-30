package com.esof322.pa2.model;

public enum Action {
	ROLL_DICE, END_TURN;
	
	public static String getActionString(Action action) {
		switch (action) {
		case ROLL_DICE:
			return "Roll Dice";
		case END_TURN:
			return "End Turn";
		default:
			return null;
		}
		
	}
}
