package esof322.pa4.Team6.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import esof322.pa4.Team6.exceptions.DiceDoublesException;
import esof322.pa4.Team6.model.Banker;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDie {

	private Banker banker = new Banker(null,0);;
	
	@Test
	//Tests to make sure the Dice are rolling an integer between 1 and 6
	public void testDie() {
		try {
			banker.rollDice();
		} catch (DiceDoublesException e) {
			//Don't care about doubles here
		}
		assertTrue("Die 1 rolled a "+banker.getDiceValue(0),1 <= banker.getDiceValue(0) && banker.getDiceValue(0) <= 6);
	}
	
	@Test
	public void testDie2() {
		try {
			banker.rollDice();
		} catch (DiceDoublesException e) {
			//Don't care about doubles here
		}
		assertTrue("Die 2 rolled a "+banker.getDiceValue(1),1 <= banker.getDiceValue(1) && banker.getDiceValue(1) <= 6);
	}

}
