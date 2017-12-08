package esof322.pa4.Team6.model;
import java.util.Random;

import esof322.pa4.Team6.exceptions.BankruptcyException;
import esof322.pa4.Team6.exceptions.PopUpWarning;
import esof322.pa4.Team6.gui.Console;
import esof322.pa4.Team6.gui.Facade;

public class ChanceSpace extends Space{

	public ChanceSpace(Banker banker, String name) {
		super(banker, name);
		setName(name);
		// TODO Auto-generated constructor stub
	}

	private int[] cards = new int[16];
	
	@Override
	public void takeAction(Player callingPlayer) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int num = rand.nextInt(16) + 1;
		
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
			new PopUpWarning("Advance to Illinois Ave.","Advance to Illinois Ave. If you pass Go, collect $200.");
			if(callingPlayer.getPosition() >24 && callingPlayer.getPosition() <= 39) {
				callingPlayer.position = 24;
				callingPlayer.addMoney(200);
				banker.getCurrentPlayer().movePlayer(24);
				banker.getGUI().updatePlayerPositions();
			}else {
				callingPlayer.position = 24;
				banker.getCurrentPlayer().movePlayer(24);
				banker.getGUI().updatePlayerPositions();					
			}
			break;
		case 3:
			new PopUpWarning("Advance to St. Charles Place","Advance to St. Charles Place. If you pass Go, collect $200.");
			if(callingPlayer.getPosition() >11 && callingPlayer.getPosition() <= 39) {
				callingPlayer.position = 11;
				callingPlayer.addMoney(200);
				banker.getCurrentPlayer().movePlayer(11);
				banker.getGUI().updatePlayerPositions();
			}else {
				callingPlayer.position = 24;
				banker.getCurrentPlayer().movePlayer(11);
				banker.getGUI().updatePlayerPositions();					
			}
			break;
		case 4:
			new PopUpWarning("Advance to Utility","Advance to the nearest Utility.");
			break;
		case 5:
			new PopUpWarning("Advance to RailRoad","Advance to the nearest RailRoad.");
			break;
		case 6:
			new PopUpWarning("Advance to Bank Pay","Bank pays you dividend of $50.");
			callingPlayer.addMoney(50);
			break;
		case 7:
			new PopUpWarning("Get Out of Jail Free","Get Out Of Jail Free!");
			break;
		case 8:
			new PopUpWarning("Go Back 3 Spaces","Go Back 3 Spaces.");
			callingPlayer.position -= 3;
			banker.getCurrentPlayer().movePlayer(callingPlayer.getPosition());
			banker.getGUI().updatePlayerPositions();
			break;
		case 9:
			new PopUpWarning("Go To Jail","Go Directly To Jail.");
			callingPlayer.toJail();
			Console.println(callingPlayer.getName()+" has been sent to jail!");
			callingPlayer.resetDoublesCounter();
			Facade.getBanker().getGUI().updatePlayerPositions();
			break;
		case 10:
			new PopUpWarning("Repairs","Make general repairs on all your property – For each house pay $25 – For each hotel $100.");
			break;
		case 11:
			new PopUpWarning("Pay poor tax of $15","Pay poor tax of $15.");
			//callingPlayer.subMoney(15);
			break;
		case 12:
			new PopUpWarning("Take a trip to Reading Railroad","Take a trip to Reading Railroad");
			break;
		case 13:
			new PopUpWarning("Take a walk on the Boardwalk","Take a walk on the Boardwalk – Advance token to Boardwalk.");
			break;
		case 14:
			new PopUpWarning("You have been elected Chairman of the Board","You have been elected Chairman of the Board – Pay each player $50.");
			break;
		case 15:
			new PopUpWarning("Your building and loan matures","Your building and loan matures – Collect $150.");
			callingPlayer.addMoney(150);
			banker.getGUI().updatePlayerPanel();
			banker.getGUI().updateOtherPlayerPanel();
			break;
		case 16:
			new PopUpWarning("You have won a crossword competition","You have won a crossword competition - Collect $100.");
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

