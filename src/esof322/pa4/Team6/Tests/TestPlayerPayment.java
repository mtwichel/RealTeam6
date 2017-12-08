package esof322.pa4.Team6.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.esof322.pa2.exceptions.BankruptcyException;
import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.Player;

public class TestPlayerPayment {


	//Player 1 pays Player 2 $1000
	@Test
	public void testPay() throws BankruptcyException {
		Banker banker = setUpGame();
		
		Player p1 = banker.getPlayer(0);
		Player p2 = banker.getPlayer(1);
		
		//Checking both their balance
		System.out.println("Player 1:"+p1.getName()+"'s bal:"+p1.getBalance()+"\nPlayer 2:"+p2.getName()+"'s bal:"+p2.getBalance());
		p1.payPlayer(p2, 1000);
		
		assertEquals("Player 1's balance is now:"+p1.getBalance(),500, p1.getBalance());
		assertEquals("Player 2's balance is now:"+p2.getBalance(),2500, p2.getBalance());
		System.out.println("Player 1:"+p1.getName()+"'s bal:"+p1.getBalance()+"\nPlayer 2:"+p2.getName()+"'s bal:"+p2.getBalance());
	}
	
	/*//Now one player makes the other bankrupt. Dosen't pass because JUnit dosen't like windows being opened.
	@Test(expected=BankruptcyException.class)
	public void testBankrupt() throws BankruptcyException {

		Banker banker = setUpGame();

		Player p1 = banker.getPlayer(0);
		Player p2 = banker.getPlayer(1);

		//Checking both their balance
		System.out.println("\nPlayer 1:"+p1.getName()+"'s bal:"+p1.getBalance()+"\nPlayer 2:"+p2.getName()+"'s bal:"+p2.getBalance());
		p1.payPlayer(p2, 1501);
		assertEquals("Player 1's balance is now:"+p1.getBalance(),-1, p1.getBalance());
		assertEquals("Player 2's balance is now:"+p2.getBalance(),3001, p2.getBalance());
		System.out.println("Player 1:"+p1.getName()+"'s bal:"+p1.getBalance()+"\nPlayer 2:"+p2.getName()+"'s bal:"+p2.getBalance());
	}*/
	
	public Banker setUpGame() {
		Banker banker = new  Banker(null, 2);
		banker.setUpPlayers();
		
		return banker;
	}

}
