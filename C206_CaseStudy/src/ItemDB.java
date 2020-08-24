
// Created by Qayyum
import java.util.ArrayList;

public class ItemDB extends Item{
	
	public static ArrayList<Item> itemList = new ArrayList<Item>();
	
	public ItemDB(String item, String description, double minPrice, String startDate, String endDate,
			double bidIncrement) {
		super(item, description, minPrice, startDate, endDate, bidIncrement);
		// TODO Auto-generated constructor stub
	}

	
	
	
	public static void addItem(Item item) {
		
		itemList.add(item);
	}
	
	public static void viewAllItem() {
		
		if(!itemList.isEmpty()) {
			for(int i = 0; i < itemList.size(); i++) {
				System.out.println(String.format("Item: %s\nDescription: %s\nMinimum price: %d\nStart date: %s\nEnd date: %s\nBid increment: %d\n", itemList.get(i).getName(), itemList.get(i).getDescription(), itemList.get(i).getMinPrice(), 
						itemList.get(i).getMinPrice(), itemList.get(i).getStartDate(),itemList.get(i).getEndDate(), itemList.get(i).getBidIncrement()));
			}
		}else {
			System.out.println("There are no items available.");
		}

	}
	
	public static void deleteItem(String item) {
		
		for(int i = 0; i<itemList.size(); i++) {
			if(itemList.get(i).getName().equals(item)) {
				itemList.remove(i);
			}
		}
	}
	
	
}