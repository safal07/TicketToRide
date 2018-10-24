package TicketToRide;

public class Card {
	String[] trainHand;  //Five train cards in player's hand
	String[] destinationHand;  //Five destination cards in player's hand
	
	public Card(String[] trainHand){
		this.trainHand = trainHand;
		destinationHand = new String[]{"Boston-NewOrleans", "Boston - NewOrleans", "Seattle - Toronto"};
	}
	
	public String[] getTrainHand(){
		return this.trainHand;
	}
	
	public String[] getDestinationHand(){
		return this.destinationHand;
	}
	
	//returns the max number of common cards
	
	//{"RED", "GREEN", "BLUE", "YELLOW", "RED"}
	public int mostCommonCard() {
		String[] cardCopy = this.trainHand;
		String maxCard = "";
		int maxCount = 1;
		for(int i = 0; i < cardCopy.length -1; i ++) {
			int innerCount = 1;
			for(int j = i + 1; j < cardCopy.length; j ++) {
				if(cardCopy[i] != null && cardCopy[i] == cardCopy[j]) {
					innerCount++;
					cardCopy[j] = null;
				}	
			}
			maxCard = maxCount < innerCount ? cardCopy[i] : maxCard;
			maxCount = maxCount < innerCount ? innerCount : maxCount;
			
		}
		return maxCount;
	}
}
