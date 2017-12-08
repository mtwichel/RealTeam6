package esof322.pa4.Team6.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.esof322.pa2.gui.MainWindow;
import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.Player;

public class GameOverTest {

	private Banker banker;
	
	@Test
	public void test() {
		
		banker = new Banker(null, 2); //Inits Banker with 2 players
		banker.setUpPlayers();
		//banker.setUpPlayers();
		/*Player[] players = {new Player(banker, "Test1", 1, "")};
		
		banker.setCurrentPlayer(players[0]);
		
		players[0].bankrupt();
		System.out.println(""+banker.getCurrentPlayer().getName());
		
		//fail("Not yet implemented");*/
		banker.getCurrentPlayer().setBankrupt();
		System.out.println("PASS");
		banker.checkWinner();
	}
	
	public void setUpPlayers() {
	
	}

}
