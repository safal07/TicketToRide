package TicketToRide;

import java.util.ArrayList;

public class Player {
	String name;
	ArrayList<Card> destinationCards = new ArrayList<Card>();
	ArrayList<Card> trainCards = new ArrayList<Card>();
	Score score;
	boolean turn;
	int[] removedTrainCards;
	
	//constructor
	public Player(String name, Card[] _trainCards, Card[] _destinationCards){
		this.name = name;
		for(Card c : _trainCards) {
			this.trainCards.add(c);
		}
		for(Card c : _destinationCards) {
			this.destinationCards.add(c);
		}
		this.turn = false;
		score = new Score();
	}
	
	//setter for player name
	public void setName(String name) {
		this.name = name;
	}
	
	//setter for player score
	public void setScore(Score score) {
		this.score = score;
	}
	
	//getter of player name
	public String getName() {
		return this.name;
	}
	
	//setter of player score
	public Score getScore() {
		return this.score;
	}
	
	public ArrayList<Card> getTrainCards() {
		return this.trainCards;
	}
	
	public ArrayList<Card> getDestinationCards() {
		return this.destinationCards;
	}
	
	public void addTrainCard(Card newCard) {
			this.trainCards.add(newCard);
	}
	
	
	public void removeTrainCards(ArrayList<Integer> cardIndexes, int num) {
		removedTrainCards = new int[num];
		int indexDecrement = 0;
		for(int i = 0; i < num; i++) {
			int index = cardIndexes.get(i);
			this.trainCards.remove(index-indexDecrement);
			removedTrainCards[i] = index;
			indexDecrement++;
		}
	}
	
	public int[] getRemovedTrainCards() {
		return this.removedTrainCards;
	}
	
	//returns the turn
	public boolean hasTurn() {
		return this.turn;
	}
	
	//change the players turn
	public void switchTurn() {
		this.turn = !this.turn;
	}
	
	public void printTrainCards() {
		System.out.println("TRAIN CARDS :-");
		for (Card c: trainCards) {
			System.out.print(c.getName() + " | ");
		}
	}
	
	
	public void printPlayer() {
		System.out.println(this);
		System.out.println("TRAIN CARDS :-");
		for (Card c: trainCards) {
			System.out.print(c.getName() + " | ");
		}
		System.out.println("\nDESTINATION CARDS :-");
		for (Card c: destinationCards) {
			System.out.print(c.getName() + " | ");
		}
		System.out.println("\n-------------------");
	}
	//display player information
		@Override
		public String toString() {
			return("Player name: " + this.name + " | "+ this.score);
		}
}
