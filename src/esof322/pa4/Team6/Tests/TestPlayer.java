package esof322.pa4.Team6.Tests;

import static org.junit.Assert.*;

import com.esof322.pa2.exceptions.GroupUpgradedException;
import com.esof322.pa2.exceptions.HousesOnPropertiesException;
import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.Player;

public class TestPlayer {
	
	private Banker banker;

	@Test
	public void TestMortgage() throws GroupUpgradedException {
		banker = setUpGame();
		
		Player player1 = banker.getPlayer(0);
		int balance = player1.getBalance();
		
		player1.aquireProperty((banker.getBoard().getSpace(5)).getSpace());
		
		assertTrue("The Property is not Mortgaged",!(banker.getBoard().getSpace(5)).getSpace().isMortgaged());
		
		player1.mortgage((banker.getBoard().getSpace(5)).getSpace());
		
		assertTrue("The Property is now Mortgaged",(banker.getBoard().getSpace(5)).getSpace().isMortgaged());
	}
	
	public Banker setUpGame() {
		Banker banker = new  Banker(null, 2);
		banker.setUpPlayers();
		
		return banker;
	}
	

}
