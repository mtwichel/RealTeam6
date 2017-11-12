package com.esof322.pa2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.Player;

public class TestPlayer {
	
	private Banker banker;

	@Test
	public void TestMortgage() {
		setUpGame();
		
		Player player1 = banker.getPlayer(0);
		int balance = player1.getBalance();
		
		player1.mortgage(null);
		
	}
	
	public void setUpGame() {
		banker = new Banker();
		banker.setUpBoard(4);
		banker.startGame();
	}
	

}
