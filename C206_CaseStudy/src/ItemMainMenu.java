import java.util.ArrayList;

public class ItemMainMenu  {
	private static final int OPTION_QUIT = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		ArrayList<Item> blockedItemList = new ArrayList<Item>();
		
		//add items
		Item item1 = new Item("Vase","Glass Vase",10.00, "30 Aug 2020", "1 Sept 2020",5.00);
		Item item2 = new Item("Handphone Cover","Silicone Hello Kitty Handphone Cover", 20.00, "26 Aug 2020", "5 Sept 2020",5.00);
				
		ItemDB.addItem(item1);
		ItemDB.addItem(item2);
		
		int option = 0;
		
		
		while (option != OPTION_QUIT) {
			ItemMainMenu.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				// View all items
				ItemMainMenu.setHeader("VIEW ITEMS");
				String output = String.format("%-10s\n", "ITEM");
				output += ItemDB.viewAllItem();
				System.out.println(output);
				
			} else if (option == 2) {
				// Add a new item
				ItemMainMenu.setHeader("ADD ITEM");			

				Item itemNew = inputItem();
			    ItemDB.addItem(itemNew);

				 
				
			} else if (option == 3) {
				// Delete item
				ItemMainMenu.setHeader("DELETE ITEM");
				
				String output = String.format("%-10s\n", "ITEM");
				
				output += ItemDB.viewAllItem();
				System.out.println(output);
				
				String itemDelete = Helper.readString("Enter item name to delete > ");
				ItemDB.deleteItem(itemDelete);
				
					
				
			} else if (option == 4) {
				// Search item
				ItemMainMenu.setHeader("SEARCH ITEM");
				
				
				String output = String.format("%-10s", "ITEM");
				
				String itemSearch = Helper.readString("Enter item to search > ");
				ItemDB.searchItem(itemSearch);
				
				
			}
			
		}

	}
	
	
	private static void menu() {
		// TODO Auto-generated method stub
		
		ItemMainMenu.setHeader("Campus Online Auction Shop");
		System.out.println("1. View All Items");
		System.out.println("2. Add item");
		System.out.println("3. Delete item");
		System.out.println("4. Search item");
		System.out.println("5. Quit");
		Helper.line(80, "-");
		
	}
	
	
	
	//option 1 view all items
		public static String retrieveAllItem(ArrayList<Item> itemList) {
			String output = "";

			for (int i = 0; i < itemList.size(); i++) {

				output += String.format("%-10s %-30s\n", itemList.get(i).getName(),
						itemList.get(i).getDescription()); 
						
			}
			return output;
		}
		
		
		
		
		private static  void viewAllItem(ArrayList<Item> itemList) {
			// TODO Auto-generated method stub
			ItemMainMenu.setHeader("ITEM LIST");
			
			String output = "";
			
			for (int i = 0; i < itemList.size(); i++) {

				output += String.format("%-10s %-30s %-10.2f %-20s %-20s %-10.2f\n", "NAME","DESCRIPTION", "MINIMUM PRICE","START DATE","END DATE", "BID INCREMENT");
				
				output += retrieveAllItem(itemList);
				
				System.out.println(output);
						
			}
			
			
		}
	
	
	
	//option 2 add item
	private static Item inputItem() {
		// TODO Auto-generated method stub
		String item = Helper.readString("Enter item name > ");
		String description = Helper.readString("Enter description > ");
		double minPrice = Helper.readDouble("Enter minimum price > ");
		String startDate = Helper.readString("Enter start date > ");
		String endDate = Helper.readString("Enter end date > ");
		double bidIncrement = Helper.readDouble("Enter bid increment > ");

		Item itemNew= new Item(item, description, minPrice, startDate, endDate, bidIncrement);
		return itemNew;
		
	}
	
	
	
	private static void addItem(ArrayList<Item> itemList, Item itemNew) {
		// TODO Auto-generated method stub
		itemList.add(itemNew);
		System.out.println("Item added");
		
	}


	private static void setHeader(String string) {
		// TODO Auto-generated method stub
		
		Helper.line(80, "-");
		System.out.println(string);
		Helper.line(80, "-");
		
	}

	
	
	//option 3 delete item
	private static String retriveItemDelete(ArrayList<Item> itemList) {
		// TODO Auto-generated method stub
		
		String output = "";

		for (int i = 0; i < itemList.size(); i++) {

			output += String.format("%-10s %-30s\n", itemList.get(i).getName(),
					itemList.get(i).getDescription()); 
					
		}
		return output;
		
	
		
	}
	

	private static void deleteItem(ArrayList<Item> itemList, Item itemDelete) {
		// TODO Auto-generated method stub
		itemList.remove(itemDelete);
		System.out.println("Item deleted");
		
	}
	
	
	//option 4 search item
		private static String retriveItemSearch(ArrayList<Item> itemList) {
			// TODO Auto-generated method stub
			
			String output = "";

			for (int i = 0; i < itemList.size(); i++) {
				
				output += String.format("%-10s %-30s\n", itemList.get(i).getName(),
						itemList.get(i).getDescription()); 
						
			}
			return output;
			
		
			
		}
		
		
		private static void searchItem(ArrayList<Item> itemList, Item item) {
			// TODO Auto-generated method stub
			String output ="";
			
			
			
			for(int i = 0; i < itemList.size(); i++) {
				String itemSearch = Helper.readString("Enter item to search > ");
				if(itemList.get(i).getName().equals(itemSearch)) {
					
			    output +=(String.format("%-10s %-30s\n", itemList.get(i).getName(), itemList.get(i).getDescription()));
					
			    System.out.println(output);
				}
				
			}
			
			
		}
	
	
	
	
	

}



