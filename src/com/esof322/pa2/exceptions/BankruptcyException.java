package com.esof322.pa2.exceptions;

public class BankruptcyException extends Exception{
	public BankruptcyException() {
		new PopUpWarning("To Bad", "You are now bankrupt!");
	}
}
