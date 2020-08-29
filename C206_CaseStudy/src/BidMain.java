// Created by Shawn Tan Jun Wei 29/08/2020

import java.util.ArrayList;

public class BidMain {
	
	private static final int OPTION_QUIT = 5;
	public static void main(String[] args) {

	Bid bid1 = new Bid("bd1", "Books", "joshlee@gmail.com", "johntan@gmail.com", 15.0);
	Bid bid2 = new Bid("bd2", "Collectables", "chrislee@gmail.com", "jookeeyuat@gmail.com", 15.0);
	
	
	BidDB.addBid(bid1);
	BidDB.addBid(bid2);
	
	int option = 0;
	while(option != OPTION_QUIT) {
		C206_CaseStudy.bidMenu();
		option = Helper.readInt("Enter an option > ");
	}
	
	if (option == 1) {
		// View all bids
		Bid.setHeader("View bids");
		Bid.viewAllCamcorder(bidList);
}
	else if(option == 2) {
		// Add Bids
		Bid.setHeader("Add a bid");			
		bidMenu();
		Bid bb = inputBid();
		addBid = Helper.readString("Enter a bid to add: ");
		Bid.addBid(bidList, bb);
	}
	
	else if(option == 3) {
		// Delete Bids
		Bid.setHeader("Delete bids");
		bidMenu();
		deleteBid = Helper.readString("Enter a bid to add: ");
		bid1 = null;
		bid2 = null;
	}
	
	else if(option == 4) {
		// Cancel Bids
		Bid.setHeader("Cancel bids");
		bidMenu();
		if(bid1 == setNull) {
			System.out.println("Bid cancelled");
		}
	}
	
	else if(option == OPTION_QUIT) {
		System.out.println("Thank you for bidding. Good bye!");
	} else {
		System.out.println("Invalid option");
	}
	
	}
	
	public static void menu() {
		Bid.setHeader("COAS - Campus Online Auction Shop");
		System.out.println("1. View all bids");
		System.out.println("2. Add bid");
		System.out.println("3. Delete bid");
		System.out.println("4. Cancel bid");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String setHeader) {
		Helper.line(80, "-");
		System.out.println(setHeader);
		Helper.line(80, "-");
	}

}
