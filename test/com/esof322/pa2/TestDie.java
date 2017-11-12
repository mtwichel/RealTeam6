package com.esof322.pa2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.esof322.pa2.model.Die;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDie {

	@Test
	//Tests to make sure the Dice are rolling an integer between 1 and 6
	public void testDie() {
		Die die1 = new Die();
		Die die2 = new Die();
		die1.rollDie();
		die2.rollDie();
		assertTrue(1 <= die1.getValue() && die1.getValue() <= 6);
		assertTrue(1 <= die2.getValue() && die2.getValue() <= 6);
	}

}
