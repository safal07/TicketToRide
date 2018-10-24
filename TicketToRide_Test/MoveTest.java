package TicketToRide_Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TicketToRide.*;

public class MoveTest {
	Move move;
	Player p;
	Board b;
	Card c1;
	Card c2;
	String[] trainHand1 = new String[]{"RED", "GREEN", "BLUE", "YELLOW", "RED"};
	String[] trainHand2 = new String[]{"RED", "GREEN", "RED", "RED", "RED"};
	
	@Before
	public void testSetup() {
		move = new Move();
		c1 = new Card(trainHand1);
		c2 = new Card(trainHand2);
	}
	
	/*
	 * 1 -"SanFrancisco - Denver" [4]
	 * 2 -"SaltLake - Washington" [11]
	 * 3 -"Boston - NewOrleans" [2]
	 * 4 -"NewYork - Houston" [12]
	 * 5 -"Seattle - Toronto" [18]
	 */
	
	
	//Tests the most common card present in trainHand
	@Test
	public void testCommonCard() {
		assertEquals(2, c1.mostCommonCard());
		assertEquals(4, c2.mostCommonCard());
	}
	
	
	//This is a failing test condition
	@Test
	public void testWrongClaimMove() {
		//NEED TO TEST
	}
	
	@Test
	public void testRightClaimMove() {
		//NEED TO TEST
	}

}
