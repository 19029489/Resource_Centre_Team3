import java.util.ArrayList;

public class BidDB extends Bid{
	
	public static ArrayList<Bid> bidList = new ArrayList<Bid>();
	
	public BidDB(String bidId, String itemName, String sellerEmail, String buyerEmail, double bidPrice) {
		super(bidId, itemName, sellerEmail, buyerEmail, bidPrice);
	}
	
	/* VIEW ALL BIDS */
	
	public static viewAllBid() {
		boolean noResult = false;
		String allBid = "";
		int i = 0;
		if(!bidList.isEmpty()) {
			for(i = 0; i < bidList.size(); i++) {
				allBid = String.format("Bid ID: %s\nbidId", "Item Name: %s\nitemName", "Seller: %s\nsellerEmail", "Buyer: %s\nbuyerEmail", "Bid Price: %s\nbidPrice");
			}
		}
		
		else {
			allBid = "No Bids found";
		}
		
		return noResult;
	}
	
	/* DELETE BID */
	public static boolean searchBuyer(String buyerEmail) {
		boolean noResult = false;
		for (int i = 0; i < bidList.size(); i++) {
			if(bidList.get(i).getbuyerEmail.equals(buyerEmail)) {
				System.out.println(String.format("Bid ID: %s\nbidId", "Item Name: %s\nitemName", "Seller: %s\nsellerEmail", "Buyer: %s\nbuyerEmail", "Bid Price: %s\nbidPrice"));
		} else {
			System.out.println("No results found");
		
		}
			return noResult;
	  }
		
	}
	
	/* UPDATE BID */
	public static boolean updateBid(double bidPrice) {
		boolean noResult = false;
		for(int i = 0; i < bidList.size(); i++) {
			if(bidList.get(i).getbidPrice.equals(bidPrice)) {
				bidPrice = 1.5;
			}
			
			else {
				System.out.println("No results found to update");
			}
			
			return noResult;
		}
	}
	
	/* CHECK IF BID IS NOT MORE THAN 2 */
	public static boolean bidItem(String itemName) {
		boolean noResult = false;
		for(int i = 0; i < bidList.size(); i++) {
			if(bidItem != 2) {
				System.out.println("Sorry, you cannot bid more than 2 items.");
			}
		}
		
		return noResult;
	}
	
	/* CHECK IF THE PRICE IS NOT LOWER THAN CURRENT PRICE */
	public static boolean bidPrice(double bidPrice) {
		boolean noResult = false;
		double price = 0.0;
		int increment = 0;
		for(int i = 0; i < bidList.size(); i++) {
			if(price != 15.5) {
				System.out.println("You cannot set the price lower than the current price");
			}
			
			else if(increment != 2) {
				System.out.println("You cannot set the increment lower");
			}
		}
		
		return noResult;
	}
	
	/* VIEW ALL BUYERS */
	public static boolean viewBuyer(String buyerEmail) {
		boolean noResult = false;
		for (int i = 0; i < bidList.size(); i++) {
			if(bidList.get(i).getbuyerEmail.equals(buyerEmail)) {
				System.out.println(String.format("Bid ID: %s\nbidId", "Item Name: %s\nitemName", "Seller: %s\nsellerEmail", "Buyer: %s\nbuyerEmail", "Bid Price: %s\nbidPrice"));
		} else {
			System.out.println("No results found");
		
		}
		return noResult;
	}
  }
  
    /* VIEW REPORT  */
	public static boolean viewReport(String buyerEmail) {
		boolean noResult = false;
		for (int i = 0; i < bidList.size(); i++) {
			if(bidList.get(i).getbuyerEmail.equals(buyerEmail)) {
				System.out.println("Report:");
	    }
     }
		return noResult;
 }
		
}