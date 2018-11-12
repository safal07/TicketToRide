//CONSOLE VIEW OF THE GAME


//package TicketToRide;
//
//import TicketToRide_View.*;
//import application.*;
//
//public class Setup {
//	static Views view = new Views();
//	public static Board b = new Board();
//	static Move m = new Move();
//	static public Player p1;
//	static public Player p2;
//	
//	
//	public static void setupPlayers() {		
//		p1 = new Player("Safal", b.fetchCard("TRAIN" ,4), b.fetchCard("DESTINATION", 3));
//		p2 = new Player("Aileen", b.fetchCard("TRAIN" ,4), b.fetchCard("DESTINATION", 3));
//	}
//	
//	public static void main(String[] args) {
//		String moveChoice;	
//		Player activePlayer;
//		b.shuffleCard();
//		for (Card c: b.getTrainDeck()) {
//			System.out.print(c.getName() + " |");
//		}
//		setupPlayers();
//		System.out.println(b.getTopTrainCardIndex());
//		b.turnFaceUpCard();
//		System.out.println(b.getTopTrainCardIndex());
//		p1.switchTurn();
//		do {
//			if(b.getTopTrainCardIndex() >= 18) {
//				b.shuffleCard();
//				b.setTopTrainCardIndex(0);
//			}
//			activePlayer = p1.hasTurn() ? p1 : p2;
//			view.printGame(p1, p2, b);
//			view.printMoveOptions();
//			moveChoice = view.getOption();
//			m.makeMove(b, activePlayer, moveChoice);
//			p1.switchTurn();
//			p2.switchTurn();
//		} while(!moveChoice.equals("Q"));
//	}	
//}
