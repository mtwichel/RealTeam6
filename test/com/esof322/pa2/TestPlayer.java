package com.esof322.pa2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.esof322.pa2.exceptions.HousesOnPropertiesException;
import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.Player;

public class TestPlayer {
	
	private Banker banker;

	@Test
	public void TestMortgage() {
		setUpGame();
		
		Player player1 = banker.getPlayer(0);
		int balance = player1.getBalance();
		
		try {
			player1.mortgage(null);
		} catch (HousesOnPropertiesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setUpGame() {
		banker = new Banker();
		banker.setUpBoard(4);
		banker.startGame();
	}
	

}
