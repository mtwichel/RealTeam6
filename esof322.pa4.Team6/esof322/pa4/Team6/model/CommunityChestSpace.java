package esof322.pa4.Team6.model;

import java.util.Random;

import esof322.pa4.Team6.exceptions.PopUpWarning;
import esof322.pa4.Team6.gui.Console;
import esof322.pa4.Team6.gui.Facade;

public class CommunityChestSpace extends Space{

	public CommunityChestSpace(Banker banker, String name) {
		super(banker, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void takeAction(Player callingPlayer) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int num = rand.nextInt(17) + 1;
		
		switch (num) {
		case 1:
			new PopUpWarning("Advance to GO","Advance To Go! Collect $200.");
			callingPlayer.position = 0;
			banker.getCurrentPlayer().movePlayer(0);
			banker.getGUI().updatePlayerPositions();
			banker.getGUI().updatePlayerPanel();
			banker.getGUI().updateOtherPlayerPanel();
			break;
		case 2:
			new PopUpWarning("Doctor's fees – Pay $50.","Doctor's fees – Pay $50.");			
			break;
		case 3:
			new PopUpWarning("Bank error in your favor – Collect $200","Bank error in your favor – Collect $200.");
			callingPlayer.addMoney(200);			
			banker.getGUI().updatePlayerPanel();
			banker.getGUI().updateOtherPlayerPanel();
			break;
		case 4:
			new PopUpWarning("From sale of stock you get $50","From sale of stock you get $50.");
			callingPlayer.addMoney(50);			
			banker.getGUI().updatePlayerPanel();
			banker.getGUI().updateOtherPlayerPanel();
			break;
		case 5:
			new PopUpWarning("Get Out of Jail Free","Get Out Of Jail Free!");
			break;
		case 6:
			new PopUpWarning("Go To Jail","Go Directly To Jail.");
			callingPlayer.toJail();
			Console.println(callingPlayer.getName()+" has been sent to jail!");
			callingPlayer.resetDoublesCounter();
			Facade.getBanker().getGUI().updatePlayerPositions();
			break;
		case 7:
			new PopUpWarning("Grand Opera Night","Grand Opera Night – Collect $50 from every player for opening night seats!");
			break;
		case 8:
			new PopUpWarning("Holiday Fund matures","Holiday Fund matures - Receive $100.");
			callingPlayer.addMoney(100);			
			banker.getGUI().updatePlayerPanel();
			banker.getGUI().updateOtherPlayerPanel();
			break;
		case 9:
			new PopUpWarning("Income tax refund","Income tax refund – Collect $20.");
			callingPlayer.addMoney(20);			
			banker.getGUI().updatePlayerPanel();
			banker.getGUI().updateOtherPlayerPanel();
			break;
		case 10:
			new PopUpWarning("It is your birthday","It is your birthday - Collect $10 from each player.");
			break;
		case 11:
			new PopUpWarning("Life insurance matures","Life insurance matures – Collect $100.");
			callingPlayer.addMoney(100);			
			banker.getGUI().updatePlayerPanel();
			banker.getGUI().updateOtherPlayerPanel();
			break;
		case 12:
			new PopUpWarning("Pay hospital fees of $100","Pay hospital fees of $100.");
			break;
		case 13:
			new PopUpWarning("Pay school fees {tax} of $150","Pay school fees of $150.");
			break;
		case 14:
			new PopUpWarning("Receive $25 consultancy fee","Receive $25 consultancy fee.");
			callingPlayer.addMoney(15);			
			banker.getGUI().updatePlayerPanel();
			banker.getGUI().updateOtherPlayerPanel();
			break;
		case 15:
			new PopUpWarning("You are assessed for street repairs","You are assessed for street repairs – $40 per house – $115 per hotel.");
			break;
		case 16:
			new PopUpWarning("You have won second prize in a beauty contest","You have won second prize in a beauty contest – Collect $10.");
			callingPlayer.addMoney(10);			
			banker.getGUI().updatePlayerPanel();
			banker.getGUI().updateOtherPlayerPanel();
			break;
		case 17:
			new PopUpWarning("You inherit $100","You inherit $100.");
			callingPlayer.addMoney(100);			
			banker.getGUI().updatePlayerPanel();
			banker.getGUI().updateOtherPlayerPanel();
			break;
		}
		
	}

	@Override
	public PropertySpace getSpace() {
		// TODO Auto-generated method stub
		return null;
	}

}

