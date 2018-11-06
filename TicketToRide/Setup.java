package TicketToRide;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import TicketToRide_View.*;

public class Setup {
	static Board b = new Board();
	static Move m = new Move();
	static Player p1;
	static Player p2;
	
	
	public static void setupPlayers() {		
		p1 = new Player("Safal", b.fetchCard("TRAIN" ,5), b.fetchCard("DESTINATION", 3));
		p2 = new Player("Aastha", b.fetchCard("TRAIN" ,5), b.fetchCard("DESTINATION", 3));
	}
	
	public static void main(String[] args) {
		b.shuffleCard();
		setupPlayers();		
		p1.printPlayer();
		p2.printPlayer();
		
		System.out.println(p1.getDestinationCards()[1]);
		System.out.print(m.claimCity(b, p1, 1));
//		String choice;
//		Views view = new Views();	
//		
//		Player p1 = new Player("Safal", );
		
//		Player p1 = new Player("Safal", );
//		Player p2 = new Player("Aastha");
//		Player activePlayer;
//		Board b = new Board();
//		Move m = new Move();
//		//Card c = new Card();
//		
//		p2.switchTurn();
//		view.printGame(p1, p2, b);
//		view.printMoveOptions();
//		//choice = view.getOption();
//		activePlayer = p1.hasTurn() ? p1 : p2;

//
//			c1 = new Card(trainHand1);
//			c2 = new Card(trainHand2);
//			
//			System.out.println(m.claimCity(b, p1, c1, 1));
//		
//		switch(choice) {
//		case "C":
//			//m.claimCity(b, activePlayer, c);
//			break;
//		case "T":
//			//m.fetchTrainCards(activePlayer, c);
//			break;
//		case "D":
//			//m.fetchDestinationCards(activePlayer, c);
//			break;
//		default:
//			System.out.println("Wrong option: ");
//			break;
//		}	
	}	
}
