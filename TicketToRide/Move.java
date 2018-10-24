package TicketToRide;

public class Move {

	
	public Move(){
		
	}
	
	//Claims the given city and returns true if valid move
	public boolean claimCity(Board b, Player p, Card c, int cityToClaim) {
		int neededTrakLength = b.trackLength[cityToClaim-1];
		int ourTrackLength = c.mostCommonCard();
		System.out.println(neededTrakLength);
		if (neededTrakLength <= ourTrackLength) {
			return true;
		}	
		else return false;
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
