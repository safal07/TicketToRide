package TicketToRide;

import java.util.ArrayList;
import java.util.Scanner;

public class Move {
	Scanner sin = new Scanner(System.in);
	
	public Move(){
		
	}
	
	public void makeMove(Board b, Player activePlayer, String  moveChoice) {
		switch(moveChoice) {
		case "C":
			boolean claimMade;
			do {
				System.out.println("Enter the track# for the cities you want to claim");
				int trackNum = sin.nextInt();
				claimMade = claimCity(b, activePlayer, trackNum);
		
			} while (!claimMade);
			break;
		case "T":
			//activePlayer.addTrainCards(fetchTrainCards(b, activePlayer));
			//REMOVE THE LAST PARAMETER
			fetchTrainCards(b, activePlayer, "DECK", 1);
			break;
		case "D":
			//m.fetchDestinationCards(activePlayer, c);
			break;
		case "Q":
			System.out.println("GAME OVER");
			break;
		default:
			System.out.println("Wrong option: ");
			break;
		}
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
	
	//uncomment for console view of game
	
//	public void fetchTrainCards(Board b, Player activePlayer){
//		int indexChoice;
//		String cardChoice;
//		int i = 0;
//		System.out.println("You can fetch two train cards from top of deck or face up cards.");
//		do {
//			System.out.println("\nFor your first card, choose from Deck(D) OR choose from Faceup(F).");
//			cardChoice = sin.next();
//			if(cardChoice.equals("D")) {
//				activePlayer.addTrainCard(b.fetchCard("TRAIN" ,1)[0]);
//				System.out.println("Your hand updated");
//				activePlayer.printPlayer();
//				i++;
//			}
//			if(cardChoice.equals("F")) {
//				System.out.println("Pick the index of card from faceup");
//				indexChoice = sin.nextInt();
//				activePlayer.addTrainCard(b.getOneFaceupCard(indexChoice));
//				b.setOneFaceupCard(b.fetchCard("TRAIN" ,1)[0], indexChoice);
//				System.out.print("UPDATED ");
//				activePlayer.printTrainCards();
//				System.out.print("\nUPDATED ");
//				b.printFaceupCards();
//				i++;
//			}
//		} while (i<2);
//		
//	}
	
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

	
}
