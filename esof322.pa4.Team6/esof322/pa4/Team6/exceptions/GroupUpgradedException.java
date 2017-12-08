package esof322.pa4.Team6.exceptions;

public class GroupUpgradedException extends Exception {

	public GroupUpgradedException() {
		new PopUpWarning("WHAT ARE YOU DOING!?!", "You can't mortgage a property with houses/hotels.\n"
				+"Try selling your houses first.");
	}
}
