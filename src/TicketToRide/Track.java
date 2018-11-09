package TicketToRide;

public class Track {
	String from;
	String to;
	int value;
	boolean claimStatus;
	
	Track(String from, String to, int val) {
		this.from = from;
		this.to = to;
		this.value = val;
		this.claimStatus = false;
	}
	
	public void claim() { 
		this.claimStatus = true;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public boolean getClaimStatus() {
		return this.claimStatus;
	}
	
	@Override
	public String toString() {
		return this.from + "-" + this.to + " [" + this.value + "] ";
	}
}
