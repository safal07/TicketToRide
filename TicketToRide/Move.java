package TicketToRide;

public class Move {

	
	public Move(){
		
	}
	
	//Claims the given city and returns true if valid move
	public boolean claimCity(Board b, Player p, Card c, int cityToClaim) {
		int[] trackLength = new int[] {4, 11, 2, 12, 8};//a sample of track length
		return trackLength[cityToClaim-1] <= c.mostCommonCard();
	}

	//Gets two cards from the train cards deck and returns true if valid move
	public boolean fetchTrainCards(Player p, Card c) {
		return true;
	}
	
	//Gets two cards from the destination cards deck and returns true if valid move
	public boolean fetchDestinationCards(Player p, Card c) {
		return true;
	}
}
