import java.util.ArrayList;
//Created by Huai Yu
public class DealDB extends Deal{
	
	//Creating deal List
	public static ArrayList<Deal> dealList = new ArrayList<Deal>();
		
		public static void main(String[] args) {
			
			//Dummy deals
			Deal deal1 = new Deal("001", "Antique Mug", "ng@gmail.com", "hy@hotmail.com", 50.0, "30/8/2020");
			Deal deal2 = new Deal("002", "Antique Bowl", "hy@hotmail.com", "ng@gmail.com", 30.0, "24/9/2020");
			
			//Add dummy deals
			addDeal(deal1);
			addDeal(deal2);
			
			//Repeat loop for the menu
			int dealOption = 0;
			while (dealOption != 6) {
				dealMenu();
				
				dealOption = Helper.readInt("Enter an option > ");
				
				
				
				//======================================================================= Adding deal ========================================================================================
				if (dealOption == 1) {
					setHeader("View All Deals");
					viewAllDeals();
										
				}
				
				
				
				//======================================================================== Deleting Deal ============================================================
				else if (dealOption == 2) {

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
					
					contains = true;
					
					//Check date format
					String closeDate = Helper.readString("Closing Date (dd/mm/yyyy) > ");
					while (contains) {
						if (!closeDate.contains("/")) {
							System.out.println("Your closing date must follow the format (dd/mm/yyyy). Please enter the date again.");
							closeDate = Helper.readString("Closing Date (dd/mm/yyyy) > ");
						}
						else {
							contains = false;
						}
					}
					
					
					Deal deal3 = new Deal(dealID, itemName, sellerEmail, buyerEmail, transPrice, closeDate);
					addDeal(deal3);
	
				}
				
				
				//======================================================================== View All Deals ============================================================
				else if (dealOption == 3) {
					setHeader("Delete Deal");
					String id = Helper.readString("Enter deal ID of the deal that you want to delete > ");
					delDeal(id);

				}
				
				//======================================================================== Search Deal ============================================================
				else if (dealOption == 4) {
					setHeader("Search Deal");
					int optionSearch = 0;
					
					while (optionSearch != 6) {
						searchMenu();
						
						dealOption = Helper.readInt("Enter an option > ");
						
						if (optionSearch == 1) {
							setHeader("Search by Email");
							boolean contains = true;
							String email = Helper.readString("Enter Buyer/Seller email to search > ");
							
							//Check email validity
							while (contains) {
								if (email.contains("@") == false || email.contains(".") == false) {
									System.out.println("Your email has to include '@' and '.' to be valid.");
									email = Helper.readString("Enter Buyer/Seller email to search > ");
								}
								else {
									contains = false;
								}
							}
							
							searchDeal(optionSearch, email);
							
						}
						
						else if (optionSearch == 2) {
							setHeader("Search by Deal ID");
							String dealId = Helper.readString("Enter deal ID to search > ");
							
							searchDeal(optionSearch, dealId);
						}
						
						else if (optionSearch == 3) {
							setHeader("Search by Item Name");
							String itemName = Helper.readString("Enter item name to search > ");
							
							searchDeal(optionSearch, itemName);
						}
						
						else if (optionSearch == 4) {
							setHeader("Search by Close Date");
							boolean contains = true;
							String date = Helper.readString("Enter close date (dd/mm/yyyy) to search > ");
							
							//Check date format
							while (contains) {
								if (!date.contains("/")) {
									System.out.println("Your closing date must follow the format (dd/mm/yyyy). Please enter the date again.");
									date = Helper.readString("Enter close date (dd/mm/yyyy) to search > ");
								}
								else {
									contains = false;
								}
							}
							
							searchDeal(optionSearch, date);
						}
						
						else if (optionSearch == 5) {
							setHeader("Search by Deal Price");
							double price = Helper.readDouble("Enter deal price to search > ");
							String strPrice = "" + price;
							
							searchDeal(optionSearch, strPrice);
						}
						
						else if(optionSearch == 6) {
							System.out.println("Going back to Deal Menu...");
						}
						
						else {
							System.out.println("Invalid Option.");
						}
						
					}
					
				}
				
				//======================================================================== Update Deal ============================================================
				else if (dealOption == 5) {
					setHeader("Update Deal");
					viewAllDeals();
					boolean contains = true;
					
					String dealID = Helper.readString("Please enter the deal ID for the deal to update > ");
					System.out.println("Please enter new details to replace old details. Re-enter old details to keep those the same.");
					
					double newDealPrice = Helper.readDouble("New deal price > ");
					
					//Check date format
					String newCloseDate = Helper.readString("New closing date > ");
					while (contains) {
						if (!newCloseDate.contains("/")) {
							System.out.println("Your closing date must follow the format (dd/mm/yyyy). Please enter the date again.");
							newCloseDate = Helper.readString("New closing date > ");
						}
						else {
							contains = false;
						}
					}
					
					//Check sellerEmail validity
					contains = true;
					String newSellerEmail = Helper.readString("New seller email > ");
					while (contains) {
						if (newSellerEmail.contains("@") == false || newSellerEmail.contains(".") == false) {
							System.out.println("Your email has to include '@' and '.' to be valid.");
							newSellerEmail = Helper.readString("New seller email > ");
						}
						else {
							contains = false;
						}
					}
					
					//Check buyer email validity
					contains = true;
					String newBuyerEmail = Helper.readString("New buyer email > ");
					while (contains) {
						if (newBuyerEmail.contains("@") == false || newBuyerEmail.contains(".") == false) {
							System.out.println("Your email has to include '@' and '.' to be valid.");
							newBuyerEmail = Helper.readString("New buyer email > ");
						}
						else {
							contains = false;
						}
					}
					
					String newItemName = Helper.readString("New Item Name > ");
					
					DealDB.updateDeal(dealID, newItemName, newDealPrice, newSellerEmail, newBuyerEmail, newCloseDate);
					
				}
				
				else {
					System.out.println("Invalid Option.");
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
		
		
		//Search Deal
		public static boolean searchDeal(int option, String search) {
			Boolean check = false;
			
			System.out.println(String.format("%-15s %-20s %-20s %-20s %-20s %-20s", "Deal ID", "Item Name", "Seller's Email", "Buyer's Email", "Deal Price", "Closing Date"));
			Helper.line(200, "-");
			
			if (option == 1) {
				for(int i=0; i<DealDB.dealList.size(); i++) {
					if (DealDB.dealList.get(i).getBuyerEmail().equalsIgnoreCase(search) || DealDB.dealList.get(i).getSellerEmail().equalsIgnoreCase(search)) {
						System.out.println(dealList.get(i).toString());
						
						check = true;
						
					}
				}
			} 
			else if (option == 2) {
				for(int i=0; i<DealDB.dealList.size(); i++) {
					
					if (DealDB.dealList.get(i).getDealID().equalsIgnoreCase(search)) {
						System.out.println(dealList.get(i).toString());
						
						check = true;	
					}
				}
					
			}
			else if(option == 3) {
				for(int i=0; i<DealDB.dealList.size(); i++) {
					
					
					if (DealDB.dealList.get(i).getItemName().equalsIgnoreCase(search)) {
						System.out.println(dealList.get(i).toString());
						
						check = true;	
					}
				}
			}
			else if(option == 4) {
				for(int i=0; i<DealDB.dealList.size(); i++) {
					
					if (DealDB.dealList.get(i).getCloseDate().equalsIgnoreCase(search)) {
						System.out.println(dealList.get(i).toString());
						
						check = true;	
					}
				}
			}
			else if(option == 5) {
				for(int i=0; i<DealDB.dealList.size(); i++) {
					
					if (DealDB.dealList.get(i).getDealPrice() == Double.parseDouble(search)){
						System.out.println(dealList.get(i).toString());
						
						check = true;	
					}
				}
			}
			
			if (check == false) {
				System.out.println("No such deal has been made.");
			}
			
					return check;
		}
		
		
		//Update Deal
		public static String updateDeal(String dealID, String name, double price, String sellerEM, String buyerEM, String date) {
			
			String msg = "";
			
			for (int i=0; i<DealDB.dealList.size(); i++) {
				if (DealDB.dealList.get(i).getDealID().equalsIgnoreCase(dealID)) {
					if (DealDB.dealList.get(i).getItemName().equalsIgnoreCase(name) && DealDB.dealList.get(i).getDealPrice() == price 
							&& DealDB.dealList.get(i).getSellerEmail().equalsIgnoreCase(sellerEM) && DealDB.dealList.get(i).getBuyerEmail().equalsIgnoreCase(buyerEM)
							&& DealDB.dealList.get(i).getCloseDate().equalsIgnoreCase(date)){
						msg = "No changes were made to the deal.";
						
					}
					else {
						DealDB.dealList.get(i).setItemName(name);
						DealDB.dealList.get(i).setDealPrice(price);
						DealDB.dealList.get(i).setSellerEmail(sellerEM);
						DealDB.dealList.get(i).setBuyerEmail(buyerEM);
						DealDB.dealList.get(i).setCloseDate(date);
						
						msg = "Changes were made successfully.";
					}
					
				}
			}
			return msg;
		}
		
	
		//Deal Menu
		private static void dealMenu() {
			System.out.println(" ");
			System.out.println("=== Deal Menu ===");
			System.out.println("1. View All Deals");
			System.out.println("2. Add Deal");
			System.out.println("3. Delete Deal");
			System.out.println("4. Search Deal");
			System.out.println("5. Update Deal");
			System.out.println("6. Quit");
		}
		
		
		//Search Menu (Options)
		private static void searchMenu() {
			System.out.println(" ");
			System.out.println("=== Search Options ===");
			System.out.println("1. Seller/Buyer Email");
			System.out.println("2. Deal ID");
			System.out.println("3. Item Name");
			System.out.println("4. Close Date");
			System.out.println("5. Deal Price");
			System.out.println("6. Back to Deal Menu");
		}
		
		
		//Header Format
		private static void setHeader(String header) {
			Helper.line(200, "-");
			System.out.println(header);
			Helper.line(200, "-");
		}


		

		
}
