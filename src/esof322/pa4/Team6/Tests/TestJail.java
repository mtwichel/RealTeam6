package esof322.pa4.Team6.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.esof322.pa2.exceptions.BankruptcyException;
import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.Player;

public class TestJail {

	private Player p1;
	
	@Test
	public void testFailsToRollDoubles() throws BankruptcyException {
		Banker banker = setUpGame();
		
		assertTrue("Player is not yet in Jail",!p1.isJailed());
		
		p1.toJail();//gets mad about new window poping up
		
		assertTrue("Player is in Jail",p1.isJailed());
		assertEquals("Player has been moved to jail",10, p1.getPosition());
		
		//Assurance of variables
		System.out.println(p1.getName()+" is in Jail and has "+ p1.getBalance()+".");
		System.out.println("It is "+ p1.isJailed() + " that "+p1.getName()+" is in jail");
		
		banker.rigDice(3, 4); //NOT DOUBLES
		(banker.getBoard().getSpace(10)).getSpace().takeAction(p1);
		
		assertTrue("Player is in Jail",p1.isJailed());
		
		(banker.getBoard().getSpace(10)).getSpace().takeAction(p1);
		
		assertTrue("Player is in Jail",p1.isJailed());
		
		(banker.getBoard().getSpace(5)).getSpace().takeAction(p1);
		
		assertTrue("Player is not in Jail",!p1.isJailed());
		
		
	}
	
	@Test
	public void testRollsDoubles() throws BankruptcyException {
		Banker banker = setUpGame();
		
		assertTrue("Player is not yet in Jail",!p1.isJailed());
		
		p1.toJail();//gets mad about new window poping up
		
		assertTrue("Player is in Jail",p1.isJailed());
		assertEquals("Player has been moved to jail",10, p1.getPosition());
		
		//Assurance of variables
		System.out.println(p1.getName()+" is in Jail and has "+ p1.getBalance()+".");
		System.out.println("It is "+ p1.isJailed() + " that "+p1.getName()+" is in jail");
		
		banker.rigDice(3, 3); //NOT DOUBLES
		(banker.getBoard().getSpace(10)).getSpace().takeAction(p1);
		
		assertTrue("Player is not in Jail",!p1.isJailed());
		
		}
	
	@Test
	public void testBankruptInJail() throws BankruptcyException {
		Banker banker = setUpGame();
		
		assertTrue("Player is not yet in Jail",!p1.isJailed());
		
		p1.toJail();//gets mad about new window poping up
		
		assertTrue("Player is in Jail",p1.isJailed());
		assertEquals("Player has been moved to jail",10, p1.getPosition());
		
		p1.subMoney(1480);
		//Assurance of variables
		System.out.println(p1.getName()+" is in Jail and has "+ p1.getBalance()+".");
		System.out.println("It is "+ p1.isJailed() + " that "+p1.getName()+" is in jail");
		
		banker.rigDice(3, 4); //NOT DOUBLES
		(banker.getBoard().getSpace(10)).getSpace().takeAction(p1);
		
		assertTrue("Player is in Jail",p1.isJailed());
		
		(banker.getBoard().getSpace(10)).getSpace().takeAction(p1);
		
		assertTrue("Player is in Jail",p1.isJailed());
		
		(banker.getBoard().getSpace(5)).getSpace().takeAction(p1);
		
		assertTrue("Player is not in Jail",!p1.isJailed());
		
		
		assertTrue("Did not get out of Jail", p1.isJailed());
		System.out.println(p1.getName()+" is in "+(banker.getBoard().getSpace(5)).getSpace().getName()+" and has "+ p1.getBalance()+".");
		System.out.println("It is "+ p1.isJailed() + " that "+p1.getName()+" is in jail");
	}

	public Banker setUpGame() {
		Banker banker = new  Banker(null, 2);
		banker.setUpPlayers();
		
		p1 = banker.getPlayer(0);
		return banker;
	}
}
