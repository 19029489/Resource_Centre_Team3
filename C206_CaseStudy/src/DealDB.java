import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

//Created by Huai Yu
public class DealDB extends Deal{
	
	//Creating deal List
	public static ArrayList<Deal> dealList = new ArrayList<Deal>();
	public static ArrayList<Deal> closedDealList = new ArrayList<Deal>();
		
		public static void main(String[] args) {
			
			//Dummy deals
			Deal deal1 = new Deal("001", "Antique Mug", "ng@gmail.com", "hy@hotmail.com", 50.0, "30/08/2020");
			Deal deal2 = new Deal("002", "Antique Bowl", "hy@hotmail.com", "ng@gmail.com", 30.0, "24/07/2020");
			
			//Add dummy deals
			addDeal(deal1);
			addDeal(deal2);
			
			
			//Prompt for validity check for email and date
			String prompt = "";
			
			
			//Repeat loop for the menu
			int dealOption = 0;
			while (dealOption != 8) {
				dealMenu();
				
				dealOption = Helper.readInt("\nEnter an option > ");
				
				
				
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
			
					String sellerEmail = Helper.readString("Seller's Email > ");					
					
					prompt = "Seller's Email > ";
					
					DealDB.emailValidityCheck(sellerEmail, prompt);
					
						
					//Check for Buyer email validity
					String buyerEmail = Helper.readString("Buyer's Email > ");
					
					prompt = "Buyer's Email > ";
					
					DealDB.emailValidityCheck(sellerEmail, prompt);
					
					
					double transPrice = Helper.readDouble("Transaction Price > ");
					
					
					//Check date format
					String closeDate = Helper.readString("Closing Date (dd/mm/yyyy) > ");
					
					prompt = "Closing Date (dd/mm/yyyy) > ";
					
					dateValidityCheck(closeDate, prompt);
					
					
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
						
						optionSearch = Helper.readInt("\nEnter an option > ");
						
						if (optionSearch == 1) {
							setHeader("Search by Email");
							boolean contains = true;
							String email = Helper.readString("Enter Buyer/Seller email to search > ");
							
							prompt = "Enter Buyer/Seller email to search > ";
							
							DealDB.emailValidityCheck(email, prompt);
							
							
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
							String date = Helper.readString("Enter close date (dd/mm/yyyy) to search > ");
							
							prompt = "Enter close date (dd/mm/yyyy) to search > ";
							
							dateValidityCheck(date, prompt);
							
							searchDeal(optionSearch, date);
						}
						
						else if (optionSearch == 5) {
							setHeader("Search by Deal Price");
							double price = Helper.readDouble("Enter deal price to search > ");
							String strPrice = "" + price;
							
							searchDeal(optionSearch, strPrice);
						}
						
						else if(optionSearch == 6) {
							System.out.println("\nGoing back to Deal Menu...");
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
					
					String dealID = Helper.readString("\nPlease enter the deal ID for the deal to update > ");
					System.out.println("\nPlease enter new details to replace old details. Re-enter old details to keep those the same.");
					
					double newDealPrice = Helper.readDouble("New deal price > ");
					
					//Check date format
					String newCloseDate = Helper.readString("New closing date > ");
					
					prompt = "New closing date > ";
					
					dateValidityCheck(newCloseDate, prompt);
					
				
					contains = true;
					String newSellerEmail = Helper.readString("New seller email > ");
					
					prompt = "New seller email > ";
					
					emailValidityCheck(newSellerEmail, prompt);
					
					
					contains = true;
					String newBuyerEmail = Helper.readString("New buyer email > ");
					
					prompt = "New buyer email > ";
					
					emailValidityCheck(newBuyerEmail, prompt);
					
					
					String newItemName = Helper.readString("New Item Name > ");
					System.out.println("");
					System.out.println(DealDB.updateDeal(dealID, newItemName, newDealPrice, newSellerEmail, newBuyerEmail, newCloseDate));
				}
				
				
				//======================================================================== View Seller Functions ============================================================
				else if(dealOption == 6) {
					
					int sellerOption = 0;
					while (sellerOption != 5) {
						sellerMenu();
						
						sellerOption = Helper.readInt("\nEnter an option > ");
						
						
						//===================================== Seller comment whether buyer paid after close date ==============================================
						if (sellerOption == 1) {
							setHeader("Indicate Buyer's payment");
							
							addToClosedDealList();
							
							//View List
							if (closedDealList.size() >= 1) {
								System.out.println(String.format("%-15s %-20s %-20s %-20s %-20s %-20s %-20s %-20s", "Deal ID", "Item Name", "Seller's Email", "Buyer's Email", "Deal Price", "Closing Date", "Status", "Validation of Payment"));
								Helper.line(200, "-");
								for (int o =0; o<closedDealList.size(); o++) {
									System.out.println(String.format("%-15s %-20s %-20s %-20s %-20.2f %-20s %-20s %-20s", closedDealList.get(o).getDealID(), closedDealList.get(o).getItemName(), closedDealList.get(o).getSellerEmail(), closedDealList.get(o).getBuyerEmail(), closedDealList.get(o).getDealPrice(), closedDealList.get(o).getCloseDate(), closedDealList.get(o).getCancel(), closedDealList.get(o).getValidation()));
								}
								
								String dealChosen = Helper.readString("\nWhich deal buyer to validate? Please state the deal ID > ");
								
								int count = 0;
								
								//Check if deal exists
								for (int o = 0; o < closedDealList.size(); o++) {
									if (closedDealList.get(o).getDealID().equalsIgnoreCase(dealChosen)) {
										char validation = Helper.readChar("Has buyer with email '" + closedDealList.get(o).getBuyerEmail() + "' paid? (Y/N) > ");
										
										prompt = "Has buyer with email '" + closedDealList.get(o).getBuyerEmail() + "' paid? (Y/N) > ";
										
										//Check Y/N validity
										charValidityCheck(validation, prompt);
										
										closedDealList.get(o).setValidation(validation);
										System.out.println("Validation saved");
									}
									else {
										count = count + 1;
									}
								}
								
								if (count == closedDealList.size()) {
									System.out.println("No such deal exists");
								}
								
								
							}
							else {
								System.out.println("There are currently no closed deals.");
									
							}
	
						}
						
						//============================================= Seller has to pay penalty fee for canceling deal ========================================
						else if (sellerOption == 2){
							setHeader("Cancel Deal");
							
							addToClosedDealList();
							
								
							char notice = Helper.readChar("Please note that when a seller cancels a deal, a penalty is deducted. Confirmed? (Y/N) > ");
							
							prompt = "Please note that when a seller cancels a deal, a penalty is deducted. Confirmed? (Y/N) > ";
							
							charValidityCheck(notice, prompt);
							
							if (notice == 'Y' || notice == 'y') {
								//View List
								if (closedDealList.size() >= 1) {
									System.out.println(String.format("%-15s %-20s %-20s %-20s %-20s %-20s %-20s %-20s", "Deal ID", "Item Name", "Seller's Email", "Buyer's Email", "Deal Price", "Closing Date", "Status", "Validation of Payment"));
									Helper.line(200, "-");
									for (int o = 0; o<closedDealList.size(); o++) {
										System.out.println(String.format("%-15s %-20s %-20s %-20s %-20.2f %-20s %-20s %-20s", closedDealList.get(o).getDealID(), closedDealList.get(o).getItemName(), closedDealList.get(o).getSellerEmail(), closedDealList.get(o).getBuyerEmail(), closedDealList.get(o).getDealPrice(), closedDealList.get(o).getCloseDate(), closedDealList.get(o).getCancel(), closedDealList.get(o).getValidation()));
									}
									
									String sellerCancelDeal = Helper.readString("\nWhich deal to cancel? Please state the deal ID > ");
									
									for (int o = 0; o < closedDealList.size(); o++) {
										if (closedDealList.get(o).getDealID().equalsIgnoreCase(sellerCancelDeal)) {
											char confirmation = Helper.readChar("Are you sure you want to cancel deal with deal ID '" + closedDealList.get(o).getDealID() + "' ? (Y/N) > ");
											
											prompt = "Are you sure you want to cancel deal with deal ID '" + closedDealList.get(o).getDealID() + "' ? (Y/N) > ";
											
											charValidityCheck(confirmation, prompt);
											
											if (confirmation == 'Y' || confirmation == 'y') {
												closedDealList.get(o).setCancel("CANCELLED BY SELLER");
												System.out.println("Deal Cancelled");
												
											}
										}
										else {
											System.out.println("\nThere are currently no closed deals.");
										}
									}
										
									
								}
								
							}
							else {
								System.out.println("\nSeller cannot cancel deal without paying the penalty fee, returning back to Seller Menu...");
							}
						}
						
						
						//======================================= View all bids for item after close date =============================================
						else if (sellerOption == 3) {
							setHeader("View all bids for item");
							
							
						}
						
						//======================================= View transaction history =============================================
						else if (sellerOption == 4) {
							setHeader("View Transaction History");
							
							
						}
						
						//======================================= End ===================================================================
						else if (sellerOption == 5){
							System.out.println("\nBack to Deal Menu...");
						}
						
						else {
							System.out.println("\nInvalid Option");
						}
					}
				}
				
				
				//======================================================================== View Buyer Functions ============================================================
				else if(dealOption == 7) {
					
					int buyerOption = 0;
					while (buyerOption != 5) {
						buyerMenu();
						
						buyerOption = Helper.readInt("\nEnter an option > ");
						
						//=========================================================== Cancel Deal ===========================================================
						if (buyerOption == 1) {
							addToClosedDealList();

							//View List
							if (closedDealList.size() >= 1) {
								System.out.println(String.format("%-15s %-20s %-20s %-20s %-20s %-20s %-20s %-20s", "Deal ID", "Item Name", "Seller's Email", "Buyer's Email", "Deal Price", "Closing Date", "Status", "Validation of Payment"));
								Helper.line(200, "-");
								for (int o = 0; o<closedDealList.size(); o++) {
									System.out.println(String.format("%-15s %-20s %-20s %-20s %-20.2f %-20s %-20s %-20s", closedDealList.get(o).getDealID(), closedDealList.get(o).getItemName(), closedDealList.get(o).getSellerEmail(), closedDealList.get(o).getBuyerEmail(), closedDealList.get(o).getDealPrice(), closedDealList.get(o).getCloseDate(), closedDealList.get(o).getCancel(), closedDealList.get(o).getValidation()));
								}
								
								String sellerCancelDeal = Helper.readString("\nWhich deal to cancel? Please state the deal ID > ");
								
								for (int o = 0; o < closedDealList.size(); o++) {
									if (closedDealList.get(o).getDealID().equalsIgnoreCase(sellerCancelDeal)) {
										char confirmation = Helper.readChar("Are you sure you want to cancel deal with deal ID '" + closedDealList.get(o).getDealID() + "' ? (Y/N) > ");
										
										prompt = "Are you sure you want to cancel deal with deal ID '" + closedDealList.get(o).getDealID() + "' ? (Y/N) > ";
										
										charValidityCheck(confirmation, prompt);
										
										if (confirmation == 'Y' || confirmation == 'y') {
											closedDealList.get(o).setCancel("CANCELLED BY BUYER");
											System.out.println("Deal Cancelled");
											
										}
									}
									else {
										System.out.println("\nThere are currently no closed deals.");
									}
								}
									
								
							}
						
						}
						
						//=================================================================  Give Ratings and feedback to Seller ==============================================
						else if (buyerOption == 2){
							setHeader("Give")
						}
						
						else if (buyerOption == 3){
							
						}
						
						else if (buyerOption == 4){
							
						}
						
						else {
							System.out.println("\nInvalid Option");
						}
					}
					
				}
				
				
				//======================================================================== End ============================================================
				else if(dealOption == 8) {
					System.out.println("Thank you for your time.");
				}
				
				else {
					System.out.println("Invalid Option.");
				}
	
			}
		}



		//Buyer Menu
		private static void buyerMenu() {
			System.out.println(" ");
			System.out.println("=== Buyer Options ===");
			System.out.println("1. Cancel Deal");
			System.out.println("2. Give rating and feedback to seller");
			System.out.println("3. View Transaction History");
			System.out.println("4. Back to Deal Menu");
		}

		
		//Seller Menu
		private static void sellerMenu() {
			System.out.println(" ");
			System.out.println("=== Seller Options ===");
			System.out.println("1. Indicate Buyer's payment");
			System.out.println("2. Cancel Deal");
			System.out.println("3. View all bids for item");
			System.out.println("4. View Transaction History");
			System.out.println("5. Back to Deal Menu");
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
			System.out.println("6. View Seller Functions");
			System.out.println("7. View Buyer Functions");
			System.out.println("8. Quit");
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
		
		
		private static void addToClosedDealList() {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
			LocalDate currentDate = LocalDate.now();  
			
			//Change string date to date
			for (int i=0; i<dealList.size(); i++) {
				LocalDate closeDate = LocalDate.parse(dealList.get(i).getCloseDate(), dtf);
				
				//Check for duplicate addition
				if (closeDate.compareTo(currentDate) < 0) {
					if (closedDealList.size() > 0) {
						for (int o = 0; o<closedDealList.size(); o++) {
							if (!closedDealList.get(o).getDealID().equalsIgnoreCase(dealList.get(i).getDealID())) {
								DealDB.closedDealList.add(dealList.get(i));
							}
						}
					}
					else {
						DealDB.closedDealList.add(dealList.get(i));
					}
					
					
				}
			}
		}
		
	
		
		
		
		//Header Format
		private static void setHeader(String header) {
			Helper.line(200, "-");
			System.out.println(header);
			Helper.line(200, "-");
		}
		
		//Email Validity Check
		private static void emailValidityCheck(String email, String prompt) {
			boolean contains = true;
			
			while (contains) {
				if (email.contains("@") == false || email.contains(".") == false) {
					System.out.println("Your email has to include '@' and '.' to be valid.");
					email = Helper.readString(prompt);
				}
				else {
					contains = false;
				}
			}
		}
		
		//Date Validity Check
		private static void dateValidityCheck(String date, String prompt) {
			boolean contains = true;
			
			while (contains) {
				if (!date.contains("/")) {
					System.out.println("Your closing date must follow the format (dd/mm/yyyy). Please enter the date again.");
					date = Helper.readString(prompt);
				}
				else {
					contains = false;
				}
			}
		}
		
		
		//Yes No Validity Check
		private static void charValidityCheck(char yesNo, String prompt) {
			boolean contains = true;
			
			while (contains) {
				if (yesNo != 'Y' && yesNo != 'N' && yesNo != 'y' && yesNo != 'n') {
					System.out.println("You must enter Y or N, no other letter is allowed.");
					yesNo = Helper.readChar(prompt);
				}
				else {
					contains = false;
				}
			}
		}


		

		
}
