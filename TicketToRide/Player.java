package TicketToRide;

public class Player {
	String name;
	Score score;
	boolean turn;
	
	//two parameter constructor
	Player(String name){
		this.name = name;
		this.turn = true;
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
	
	//returns the turn
	public boolean hasTurn() {
		return this.turn;
	}
	
	//change the players turn
	public void switchTurn() {
		this.turn = !this.turn;
	}
	
	//display player information
		@Override
		public String toString() {
			return("Player name: " + this.name + " | "+ this.score);
		}
}
