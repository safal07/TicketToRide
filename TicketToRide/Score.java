package TicketToRide;

public class Score {
	int val;
	
	//default constructor
	Score() {
		this.val = 0;
	}
	
	//getter for score value
	public int getValue() {
		return this.val;
	}
	
	//setter of score value
	public void setValue(int newVal) {
		this.val = newVal;
	}
	
	//display score
	@Override
	public String toString() {
		return("Current Score: " + this.val);
	}
}
