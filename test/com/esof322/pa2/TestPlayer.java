package com.esof322.pa2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayer {
	
	private Banker banker;

	@Test
	public void TestMortgage() {
		setUpGame();
		
		Player player1 = banker.getPlayer(0);
		int balance = player1.getBalance();
		
		player1.mortgage();
		
	}
	
	public void setUpGame() {
		banker = new Banker();
		banker.setUpBoard(4);
		banker.startGame();
	}
	

}
