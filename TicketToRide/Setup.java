package TicketToRide;
import org.junit.Before;

import TicketToRide_View.*;

public class Setup {
	
	public static void main(String[] args) {
		String choice;
		Views view = new Views();
		Player p1 = new Player("Safal");
		Player p2 = new Player("Aastha");
		Player activePlayer;
		Board b = new Board();
		Move m = new Move();
		//Card c = new Card();
		
		p2.switchTurn();
		view.printGame(p1, p2, b);
		view.printMoveOptions();
		//choice = view.getOption();
		activePlayer = p1.hasTurn() ? p1 : p2;
		
		
		Card c1;
		Card c2;
		String[] trainHand1 = new String[]{"RED", "GREEN", "BLUE", "YELLOW", "RED"};
		String[] trainHand2 = new String[]{"RED", "GREEN", "RED", "RED", "RED"};
		

			c1 = new Card(trainHand1);
			c2 = new Card(trainHand2);
			
			System.out.println(m.claimCity(b, p1, c1, 1));
		
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
