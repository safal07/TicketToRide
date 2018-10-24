package TicketToRide;

public class Board {
	public String[] routes;
	public int[] trackLength;
	public boolean[] trackClaimed;
	Board(){
		routes = new String[] {"SanFrancisco - Denver", "SaltLake - Washington", 
				"Boston - NewOrleans", "NewYork - Houston", "Seattle - Toronto"};
		trackLength = new int[] {4, 11, 2, 12, 8};
		trackClaimed = new boolean[] {false, false, false, false, false};
	}
	
	//set display of the board
	public void displayBoard(){
		for(int i = 0; i < 5; i++) {
			if (trackClaimed[i])
				System.out.println("[" + routes[i] + " - " + trackLength[i] + "] (Claimed)");
			else 
				System.out.println("[" + routes[i] + " - " + trackLength[i]  + "] (Open)");
		}	
	}
}
