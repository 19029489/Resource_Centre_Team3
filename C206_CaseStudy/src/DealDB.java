import java.util.ArrayList;
//Created by Huai Yu
public class DealDB extends Deal{
	
	//Creating deal List
	public static ArrayList<Deal> dealList = new ArrayList<Deal>();
		
		public static void main(String[] args) {
			
			//Dummy deals
			Deal deal1 = new Deal("001", "Antique Mug", "ng@gmail.com", "hy@hotmail.com", 50.0, "30th August 2020");
			Deal deal2 = new Deal("002", "Antique Bowl", "hy@hotmail.com", "ng@gmail.com", 30.0, "24th September 2020");
			
			//Add dummy deals
			addDeal(deal1);
			addDeal(deal2);
			
			//Repeat loop for the menu
			int dealOption = 0;
			while (dealOption != 4) {
				dealMenu();
				
				dealOption = Helper.readInt("Enter an option > ");
				
				
				
				//======================================================================= Adding deal ========================================================================================
				if (dealOption == 1) {
					setHeader("Add Deal");
					System.out.println("Please fill out the information of the deal:");
					
					String dealID = Helper.readString("Deal ID > ");
					String itemName = Helper.readString("Item Name > ");
					
					//Check for seller email validity
					boolean contains = true;
					String sellerEmail = Helper.readString("Seller's Email > ");					
					
					while (contains) {
						
						for(int i = 0; i<dealList.size(); i++) {
							
							if(!sellerEmail.contains("@") || !sellerEmail.contains(".")){
								
								System.out.println("Invalid email. Email should contain '@' and '.'");
								sellerEmail = Helper.readString("Seller's Email > ");
							
							}else{
								contains = false;
							}
						}
					}
					
						
					//Check for Buyer email validity
					contains = true;
					String buyerEmail = Helper.readString("Buyer's Email > ");
					
					while (contains) {
						if (buyerEmail.contains("@") == false || buyerEmail.contains(".") == false) {
							System.out.println("Your email has to include '@' and '.' to be valid.");
							buyerEmail = Helper.readString("Buyer's Email > ");
						}
						else {
							contains = false;
						}
					}
					
					double transPrice = Helper.readDouble("Transaction Price > ");
					String closeDate = Helper.readString("Closing Date > ");
					
					Deal deal3 = new Deal(dealID, itemName, sellerEmail, buyerEmail, transPrice, closeDate);
					addDeal(deal3);
					
				}
				
				
				
				//======================================================================== Deleting Deal ============================================================
				if (dealOption == 2) {
					setHeader("Delete Deal");
					String id = Helper.readString("Enter deal ID of the deal that you want to delete > ");
					delDeal(id);
					
				}
				
				
				//======================================================================== View All Deals ============================================================
				if (dealOption == 3) {
					setHeader("View All Deals");
					viewAllDeals();

				}
	
			}
		}
		
		public DealDB(String dealID, String itemName, String buyerEmail, String sellerEmail, double dealPrice, String closeDate) {
			super(dealID, itemName, buyerEmail, sellerEmail, dealPrice, closeDate);
		}
		
		
		
	
		//Add Deal
		public static void addDeal(Deal deal) {
			
			String newDealID = deal.getDealID();
			String buyerEmail = deal.getBuyerEmail();
			
			Boolean isDuplicate = false;
			
			//Check for duplicates
			for (int i=0; i<dealList.size(); i++) {
				if (dealList.get(i).getDealID().equalsIgnoreCase(newDealID)) {
					System.out.println("Duplicate ID detected, please try a different deal ID");
					
					isDuplicate = true;
					
				}
				else if (dealList.get(i).getBuyerEmail().equalsIgnoreCase(buyerEmail)) {
					System.out.println("Buyer has already made a deal, please delete old deal to make a new deal.");
					
					isDuplicate = true;
				}
				
			}
			//No duplicates, thus deal added
			if (isDuplicate == false) {
				dealList.add(deal);
				System.out.println("Deal has been added successfully.");
			}
		}
		
		
		
		//Delete deal
		public static void delDeal(String id) {
			int count = 0;
			for (int i=0; i< dealList.size(); i++){
				if (dealList.get(i).getDealID().equalsIgnoreCase(id)) {
					dealList.remove(dealList.get(i));
					System.out.println("Deal successfully deleted");

				}
				else {
					count = count + 1;
					if (count == dealList.size()) {
						System.out.println("No such deal id exists.");

					}
				}
			} 
			
		}
		
		
		
		//View all deals
		public static void viewAllDeals() {
			
			if (dealList.size() >= 1) {
				System.out.println(String.format("%-15s %-20s %-20s %-20s %-20s %-20s", "Deal ID", "Item Name", "Seller's Email", "Buyer's Email", "Deal Price", "Closing Date"));
				Helper.line(200, "-");
				for (int i=0; i<dealList.size(); i++) {
					System.out.println(dealList.get(i).toString());
				}
			}
			else {
				System.out.println("There are currently no deals made.");
				
				
			}
			
		}

		
		//Deal Menu
		private static void dealMenu() {
			System.out.println(" ");
			System.out.println("=== Deal Menu ===");
			System.out.println("1. Add Deal");
			System.out.println("2. Delete Deal");
			System.out.println("3. View All Deals");
			System.out.println("4. Quit");
		}
		
		
		
		//Header Format
		private static void setHeader(String header) {
			Helper.line(200, "-");
			System.out.println(header);
			Helper.line(200, "-");
		}
}
