package com.esof322.pa2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.esof322.pa2.exceptions.BankruptcyException;
import com.esof322.pa2.exceptions.DiceDoublesException;
import com.esof322.pa2.exceptions.GroupUpgradedException;
import com.esof322.pa2.exceptions.IsNotAMonopolyException;
import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.exceptions.PropertyIsMortgagedException;
import com.esof322.pa2.exceptions.PropertyMaxUpgratedException;
import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.Player;
import com.esof322.pa2.model.PropertySpace;

public class TestSpaces {

	@Test
	public void testPropertyRent() throws NotEnoughFundsException, PropertyMaxUpgratedException, BankruptcyException, PropertyIsMortgagedException, IsNotAMonopolyException, GroupUpgradedException {
		Banker banker = setUpGame();	
		Player p = banker.getCurrentPlayer();
		
		//Empty Spaces
		assertEquals("Non-Property related spaces charge no rent.", 0, (banker.getBoard().getSpace(0)).calculateRent());
		
		//Tests Property Space rent without houses/monopoly
		assertEquals("Mediterranean Avenue charges $2 rent with no houses", 2, (banker.getBoard().getSpace(1)).calculateRent());
		
		p.aquireProperty((banker.getBoard().getSpace(1)).getSpace());
		p.aquireProperty((banker.getBoard().getSpace(3)).getSpace());
		p.aquireProperty((banker.getBoard().getSpace(5)).getSpace());
		
		//Tests Property Space rent in monopoly
		assertEquals("Mediterranean Avenue charges $4 when it is in a monopoly", 4, (banker.getBoard().getSpace(1)).calculateRent());
		
		//Tests Property Spaces with houses/hotels
		p.upgrade((banker.getBoard().getSpace(1)).getSpace());
		assertEquals("Mediterranean Avenue charges $10 rent with 1 house", 10, (banker.getBoard().getSpace(1)).calculateRent());
		
		p.upgrade((banker.getBoard().getSpace(1)).getSpace());
		assertEquals("Mediterranean Avenue charges $30 rent with 2 house", 30, (banker.getBoard().getSpace(1)).calculateRent());
		
		p.upgrade((banker.getBoard().getSpace(1)).getSpace());
		assertEquals("Mediterranean Avenue charges $90 rent with 3 house", 90, (banker.getBoard().getSpace(1)).calculateRent());
		
		p.upgrade((banker.getBoard().getSpace(1)).getSpace());
		assertEquals("Mediterranean Avenue charges $160 rent with 4 house", 160, (banker.getBoard().getSpace(1)).calculateRent());
		
		p.upgrade((banker.getBoard().getSpace(1)).getSpace());
		assertEquals("Mediterranean Avenue charges $250 rent with a hotel", 250, (banker.getBoard().getSpace(1)).calculateRent());
		
		//Tests rent when property is Mortgaged
		p.mortgage((banker.getBoard().getSpace(6)).getSpace());
		assertEquals("Oriental Avenue dosen't charge rent when mortgaged", 0, (banker.getBoard().getSpace(6)).calculateRent());
	}
	
	@Test
	public void testUtilityRent() throws NotEnoughFundsException, PropertyMaxUpgratedException, BankruptcyException, PropertyIsMortgagedException, IsNotAMonopolyException, GroupUpgradedException {
		Banker banker = setUpGame();	
		Player p = banker.getCurrentPlayer();
		
		p.aquireProperty((banker.getBoard().getSpace(12)).getSpace());
		
		//Tests Utility rent without monopoly
		try {
			banker.rollDice();
		} catch (DiceDoublesException e) {
		}
		assertTrue("Electric company charges 4 x amount shown on dice with only one owned",8 <= (banker.getBoard().getSpace(12)).calculateRent() && (banker.getBoard().getSpace(12)).calculateRent() <= 48);
		
		p.aquireProperty((banker.getBoard().getSpace(28)).getSpace());

		//Tests Utility rent with monopoly
		try {
			banker.rollDice();
		} catch (DiceDoublesException e) {
		}
		assertTrue("Electric company charges 10 x amount shown on dice with both utils owned",20 <= (banker.getBoard().getSpace(12)).calculateRent() && (banker.getBoard().getSpace(12)).calculateRent() <= 120);
		
		
		//Tests rent when property is Mortgaged
		p.mortgage((banker.getBoard().getSpace(28)).getSpace());
		assertEquals("Water Works dosen't charge rent when mortgaged", 0, (banker.getBoard().getSpace(28)).calculateRent());
	}
	
	@Test
	public void testRailRoadRent() throws NotEnoughFundsException, PropertyMaxUpgratedException, BankruptcyException, PropertyIsMortgagedException, IsNotAMonopolyException, GroupUpgradedException, DiceDoublesException {
		Banker banker = setUpGame();	
		Player p = banker.getCurrentPlayer();
		
		p.aquireProperty((banker.getBoard().getSpace(5)).getSpace());
		
		//Tests RailRoad rent when only one is owned
		assertEquals("Reading Raidroad charges $200 rent when 4 railroads are owned",200,(banker.getBoard().getSpace(5)).calculateRent());
		
	}
	
	public Banker setUpGame() {
		Banker banker = new  Banker(null, 2);
		banker.setUpPlayers();
		
		return banker;
	}

}
