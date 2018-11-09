package TicketToRide_View;
import java.util.Scanner;

import TicketToRide.*;

public class Views {
	
	Scanner sin = new Scanner(System.in);
	public Views(){
		
	}
	
	public void printGame(Player p1, Player p2, Board b) {
		System.out.println("\n---------------------------------");
		b.displayBoard();
		b.printFaceupCards();
		System.out.println("\n---------------------------------");
		if (p1.hasTurn()) {
			System.out.println(p1.getName() + "\'s Turn: ");
			p1.printPlayer();
		} else {
			System.out.println(p2.getName() + "\'s Turn: ");
			p2.printPlayer();
		}
		System.out.println("We are playing at index: " + b.getTopTrainCardIndex());
	}
	
	public void printMoveOptions() {
		System.out.println("Claim city : (C) OR Fetch train cards : (T) OR Fetch destination cards : (D)");
	}
	
	public String getOption() {
		System.out.print("Please choose: ");
		return sin.next();	
	}
}
