package TicketToRide;

public class Move {

	
	public Move(){
		
	}
	
	public int mostCommonCard(Card[] _trainHand) {
		Card[] trainHand = _trainHand;
		Card maxCard = null;
		int maxCount = 0;
		for(int i = 0; i < trainHand.length -1; i ++) {
			int innerCount = 1;
			for(int j = i + 1; j < trainHand.length; j ++) {
				if(trainHand[i] != null && trainHand[j] != null) {
					if (trainHand[i].getName() == trainHand[j].getName()) {
						innerCount++;
						trainHand[j] = null;
					}
				}	
			}
			maxCard = maxCount < innerCount ? trainHand[i] : maxCard;
			maxCount = maxCount < innerCount ? innerCount : maxCount;
		}
		return maxCount;
	}
	
	//Claims the given city and returns true if valid move
	public boolean claimCity(Board b, Player p, int cityToClaim) {
		int value = b.getDestinationDeck()[cityToClaim].getValue();
		for(Card c: p.getTrainCards()) {
			System.out.println(c);
		}
		int max = mostCommonCard(p.getTrainCards());
		System.out.println("val" + value);
		System.out.println("max" + max);
		
		return value == max;
	}

	//Gets two cards from the train cards deck and returns true if valid move
	public boolean fetchTrainCards(Player p, Card c) {
		return true;
	}
	
	//Gets two cards from the destination cards deck and returns true if valid move
	public boolean fetchDestinationCards(Player p, Card c) {
		return true;
	}
	
	//returns the max number of common cards
	
		//{"RED", "GREEN", "BLUE", "YELLOW", "RED"}
}
