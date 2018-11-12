package TicketToRide;

import java.util.ArrayList;

public class Move {
	
	
	public Move(){
		
	}
	
	
	//comment for console view of game.
	public void fetchTrainCards(Board b, Player activePlayer, String type, int _indexChoice){
			int indexChoice = _indexChoice;
		
			if(type == "DECK") {
				activePlayer.addTrainCard(b.fetchCard("TRAIN" ,1)[0]);
				System.out.println("Your hand updated");

			}
			else{
				activePlayer.addTrainCard(b.getOneFaceupCard(indexChoice));
				b.setOneFaceupCard(b.fetchCard("TRAIN" ,1)[0], indexChoice);
				System.out.print("UPDATED FACE UP");
			}
	
	}
	
	public Card mostCommonCard(Card[] _trainHand) {
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
		return maxCard;
	}
	
	//Claims the given city and returns true if valid move
	public boolean claimCity(Board b, Player p, int trackNum) {
		
		//Change arraylist to array
		Card[] trainCards = new Card[p.getTrainCards().size()];
		trainCards = p.getTrainCards().toArray(trainCards);
		Card[] trainCardsCopy = new Card[trainCards.length]; 
		//create the copy of player cards hand
		for(int i = 0; i < trainCardsCopy.length; i++) {
			trainCardsCopy[i] = trainCards[i];
		}
		//check for claim
		System.out.println("You want to claim : " + b.getTracks()[trackNum]);
		int trackLength = b.getTracks()[trackNum].getValue();
		Card maxCard = mostCommonCard(trainCardsCopy);
		ArrayList<Integer> maxCardIndexes = new ArrayList<Integer>();
		for(int k = 0; k < trainCards.length; k++) {
			if (trainCards[k].getName() == maxCard.getName()) {
				maxCardIndexes.add(k);
			}
		}
		int maxCardsNum = maxCardIndexes.size();
		if (b.getTracks()[trackNum].getClaimStatus() == false) {
			//if condition satisfy for claim
			if (trackLength <= maxCardsNum) {
				b.getTracks()[trackNum].claim();
				p.getScore().setValue(trackLength, true); //add score
				p.removeTrainCards(maxCardIndexes, trackLength);
				System.out.println("Claim was sucessful!");
				return true;
			}
		}
		System.out.println("ERROR: City could not be claimed!");
		return false;
	}
	
	
	//returns the winner
	public Player findWinner(Player p1, Player p2) {
		Player winner;
		int p1Score = p1.getScore().getValue();
		int p2Score = p2.getScore().getValue();
		
		if (p1Score > p2Score) winner = p1;
		else if(p1Score < p2Score) winner = p2;
		else winner = null;
		return winner;	
	}
	
}
