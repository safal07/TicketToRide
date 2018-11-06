package TicketToRide;

public class Player {
	String name;
	Card destinationCards[];
	Card trainCards[];
	Score score;
	boolean turn;
	
	//constructor
	Player(String name, Card[] trainCards, Card[] destinationCards){
		this.name = name;
		this.trainCards = trainCards;
		this.destinationCards = destinationCards;
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
	
	public Card[] getTrainCards() {
		return this.trainCards;
	}
	
	public Card[] getDestinationCards() {
		return this.destinationCards;
	}
	
	//returns the turn
	public boolean hasTurn() {
		return this.turn;
	}
	
	//change the players turn
	public void switchTurn() {
		this.turn = !this.turn;
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
