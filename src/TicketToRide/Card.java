package TicketToRide;

public class Card {
	private String type;	//distinguishes train and destination cards.
	private String name;	//name on the card
	private int value;		//value of the card
	
	//constructor 
	public Card(String type, String name, int value){
		this.type = type;
		this.name = name;
		this.value = value;
	}
	
	//getter for value
	public int getValue() {
		return this.value;
	}
	
	//getter for name
	public String getName() {
		return this.name;
	}
	
	//getter for type
	public String getType() {
		return this.type;
	}

	@Override
	public String toString() {
		return "CARD: " + this.name + ", VALUE: " + this.value;
	}
	
}
