package com.esof322.pa2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.esof322.pa2.model.Player;

public class TestPlayerPayment {

	private Player p1 = new Player(1);
	private Player p2 = new Player(2);
	
	//Player 1 pays Player 2 $1000
	@Test
	public void testPay() {
		//Checking both their balance
		System.out.println("Player 1:"+p1.getName()+"'s bal:"+p1.getBalance()+"\nPlayer 2:"+p2.getName()+"'s bal:"+p2.getBalance());
		p1.payPlayer(p2, 1000);
		assertEquals("Player 1's balance is now:"+p1.getBalance(),500, p1.getBalance());
		assertEquals("Player 2's balance is now:"+p2.getBalance(),2500, p2.getBalance());
		System.out.println("Player 1:"+p1.getName()+"'s bal:"+p1.getBalance()+"\nPlayer 2:"+p2.getName()+"'s bal:"+p2.getBalance());
	}
	
	//Now one player makes the other bankrupt. Lets see what happens.
	@Test
	public void testBankrupt() {
		//Checking both their balance
		System.out.println("\nPlayer 1:"+p1.getName()+"'s bal:"+p1.getBalance()+"\nPlayer 2:"+p2.getName()+"'s bal:"+p2.getBalance());
		p1.payPlayer(p2, 1501);
		assertEquals("Player 1's balance is now:"+p1.getBalance(),-1, p1.getBalance());
		assertEquals("Player 2's balance is now:"+p2.getBalance(),3001, p2.getBalance());
		System.out.println("Player 1:"+p1.getName()+"'s bal:"+p1.getBalance()+"\nPlayer 2:"+p2.getName()+"'s bal:"+p2.getBalance());
	}

}
