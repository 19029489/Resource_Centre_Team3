
// Created by Qayyum
import java.util.ArrayList;

public class ItemDB extends Item{
	
	public static ArrayList<Item> itemList = new ArrayList<Item>();
	public static ArrayList<Item> blockedItemList = new ArrayList<Item>();
	
	public ItemDB(String item, String description, double minPrice, String startDate, String endDate,
			double bidIncrement) {
		super(item, description, minPrice, startDate, endDate, bidIncrement);
		// TODO Auto-generated constructor stub
	}

	
	
	//add item
	public static void addItem(Item item) {
		
		itemList.add(item);
	}
	
	//view all items
	public static String viewAllItem() {
		
		String allItems = "";
		if(!itemList.isEmpty()) {
			for(int i = 0; i < itemList.size(); i++) {
			allItems += (String.format("Item: %s\nDescription: %s\nMinimum price: %.2f\nStart date: %s\nEnd date: %s\nBid increment: %.2f\n\n", itemList.get(i).getName(), itemList.get(i).getDescription(), itemList.get(i).getMinPrice(), 
						itemList.get(i).getStartDate(),itemList.get(i).getEndDate(), itemList.get(i).getBidIncrement()));
			}
		}else {
			allItems += ("There are no items available.");
		}
		return allItems;
		
		

	}
	
	//deletes item
	public static void deleteItem(String item) {
		
		for(int i = 0; i<itemList.size(); i++) {
			if(itemList.get(i).getName().equals(item)) {
				itemList.remove(i);
			}
		}
	}
	
	//search item
	public static void searchItem(String item) {
		
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getName().equals(item)) {
				if( itemList.get(i).getName().equals(item)) {
					System.out.println (String.format("Item: %s Description: %s Minimum Price: %.2f Start Date: %s End Date: %s Bid Increment: %.2f", itemList.get(i).getName(), itemList.get(i).getDescription(), itemList.get(i).getMinPrice(), itemList.get(i).getStartDate(),itemList.get(i).getEndDate(),itemList.get(i).getBidIncrement()));
				}
				else {
					System.out.println("No Items Available");
				}
				
			}
		}
	}
	
	//block item
	public static void blockItem(String item) {
		
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getName().contentEquals(item)) {
				itemList.remove(i);
			}
		}
	}
	
	//add block item to blockedItemList
	public static void addBlockedItem(Item item) {
		
		blockedItemList.add(item);
	}
	
	//remove blocked item from blockedList
	public static void removeBlockedItem(Item item) {
		
		for(int i = 0; i<blockedItemList.size(); i++) {
			if(blockedItemList.get(i).getName().equals(item)) {
				blockedItemList.remove(i);
			}
		}
	}
	
	
	
}