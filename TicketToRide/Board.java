package TicketToRide;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
	private Card[] trainDeck = new Card[20];
	private Card[] destinationDeck = new Card[6];
	private int topTrainCardIndex;
	private int topDestinationCardIndex;
	
	//constructor initializes the trainDeck and destinationDeck
	Board(){
		topTrainCardIndex = 0;
		topDestinationCardIndex = 0;
		//stores the train color
		String[] trainColor = new String[]{"RED", "GREEN", "BLUE", "YELLOW", "RED", "RED", "GREEN", "RED", "RED", "RED",
											"GREEN", "BLUE", "YELLOW", "RED", "RED","RED", "GREEN", "BLUE", "YELLOW", "RED"};
		
		//create a deck of 20 train cards
		for(int i = 0; i < trainDeck.length; i++) {
			trainDeck[i] = new Card("TRAIN", trainColor[i], 1);
		}
		
		//stores destination name
		String[] destinationName = new String[]{"SanFrancisco-Denver", "SaltLake - Washington", "Boston-NewOrleans", 
												"Seattle-Toronto", "NewYork - Houston", "Washington-SanFrancisco"};
		//stores destination values
		int[] destinationValues = new int[]{4, 3, 2, 6, 2, 5};
		
		//creates a deck of destination cards
		for(int j = 0; j < destinationDeck.length; j++) {
			destinationDeck[j] = new Card("DESTINATION", destinationName[j], destinationValues[j]);
		}
		
	}
	
	//picks specified number of cards from the top of deck.
	public Card[] fetchCard(String type, int howMany) {
		Card[] pickedCard = new Card[howMany];
		int currentIndex = type == "TRAIN" ? topTrainCardIndex : topDestinationCardIndex;
		for(int i = 0; i < howMany; i++) {
			pickedCard[i] = type == "TRAIN" ? trainDeck[currentIndex++] : destinationDeck[currentIndex++];
		}
		if (type == "TRAIN") topTrainCardIndex = currentIndex;
		else topDestinationCardIndex = currentIndex;
		return pickedCard;
	}
	
	//randomly shuffles the cards.
	public void shuffleCard() {

		int index;
		Card holder;
		
		//shuffle trainDeck cards
		for(int i = trainDeck.length-1; i >= 0 ; i--) {
			Random rand = ThreadLocalRandom.current();		
				index = rand.nextInt(i + 1);				
		    	holder = trainDeck[index];	    	
		    	trainDeck[index] = trainDeck[i];	    		    	
		    	trainDeck[i] = holder;
		}
		
		//shuffle destinationDeck Cards
		for(int i = destinationDeck.length-1; i >= 0 ; i--) {
			Random rand = ThreadLocalRandom.current();		
				index = rand.nextInt(i + 1);				
		    	holder = destinationDeck[index];	    	
		    	destinationDeck[index] = destinationDeck[i];	    		    	
		    	destinationDeck[i] = holder;
		}
	}
	
	//getter for trainDeck
	public Card[] getTrainDeck() {
		return this.trainDeck;
	}
	
	//getter for destination deck
	public Card[] getDestinationDeck() {
		return this.destinationDeck;
	}
	
	//set display of the board
	public void displayBoard(){
	}


}
