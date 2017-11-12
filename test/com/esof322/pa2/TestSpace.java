package com.esof322.pa2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.exceptions.PropertyMaxUpgratedException;
import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.PropertySpace;

public class TestSpace {

	@Test
	public void testCalculateRent() throws NotEnoughFundsException, PropertyMaxUpgratedException {
		Banker banker = setUpGame();	
		
		assertEquals(0, ((PropertySpace) banker.board.getSpace(0)).calculateRent());
		
		banker.players[0].purchase((PropertySpace) banker.board.getSpace(0));
		
		assertEquals(2, ((PropertySpace) banker.board.getSpace(0)).calculateRent());
		
		banker.players[0].upgrade((PropertySpace) banker.board.getSpace(0));
		
		assertEquals(10, ((PropertySpace) banker.board.getSpace(0)).calculateRent());
	}
	
	@Test
	public void testTakeAction() {
		Banker banker = setUpGame();
		
		//never inits player, so is null. Should be fixed once Arjan does stuff in Banker Class
		assertEquals(1500, banker.players[0].getBalance());
		
		banker.board.getSpace(0).takeAction(banker.players[0]);;
		
		assertEquals(1440, banker.players[0].getBalance());
		
		
	}
	
	public Banker setUpGame() {
		Banker banker = new  Banker();
		banker = new Banker();
		banker.setUpBoard(4);
		banker.startGame();
		
		return banker;
	}

}
