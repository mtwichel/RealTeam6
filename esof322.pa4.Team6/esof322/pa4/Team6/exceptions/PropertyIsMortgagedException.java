package esof322.pa4.Team6.exceptions;

public class PropertyIsMortgagedException extends Exception{
	public PropertyIsMortgagedException() {
		new PopUpWarning("Bad Panda.","You can't add houses to a mortgaged Property");
	}
}
