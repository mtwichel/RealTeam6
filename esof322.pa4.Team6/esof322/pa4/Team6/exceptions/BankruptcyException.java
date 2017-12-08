package esof322.pa4.Team6.exceptions;

public class BankruptcyException extends Exception{
	public BankruptcyException() {
		new PopUpWarning("To Bad", "You are now bankrupt!");
	}
}
