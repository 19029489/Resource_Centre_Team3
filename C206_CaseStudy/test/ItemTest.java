import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	private Item item1, item2;

	@Before
	public void setUp() throws Exception {
		/* Add Item */
		item1 = new Item("Vase","Glass Vase",10.00, "30 Aug 2020", "1 Sept 2020",5.00);
		item2 = new Item("Handphone Cover","Silicone Hello Kitty Handphone Cover", 20.00, "26 Aug 2020", "5 Sept 2020",5.00);
	}

	@After
	public void tearDown() throws Exception {
		item1 = null;
		item2 = null;
		ItemDB.itemList.clear();
	}

	
	
	//Created by Qayyum
		@Test
		public void addItemTest() {
			// Test that Item list can be empty before adding
			assertEquals("Test that the item list can be empty before adding",0, ItemDB.itemList.size());
			
			
			// Test that after adding, item list size should increase 
			ItemDB.itemList.add(item1);
			assertEquals("Test that after adding, item list should increase", 1, ItemDB.itemList.size());

		}
		
		//Created by Qayyum
		@Test
		public void deleteItemTest() {

			// When item is deleted, item list should decreased 
			ItemDB.itemList.remove(item1);
			assertEquals("When item is deleted, item list should decreased ", 0, ItemDB.itemList.size());
			
			UserDB.delUser("Vase");
			assertEquals("When item is deleted, item list should decreased", 0, ItemDB.itemList.size());
			
			// If item list is not empty, item is ready to be deleted
			ItemDB.itemList.add(item1);
			assertTrue("If item list is not empty, item is ready to be deleted", !ItemDB.itemList.isEmpty());

		}
		
		//Created by Qayyum
		@Test
		public void viewAllItemTest() {
			

			// Test that item list is not empty, it should be able to view items 
			ItemDB.itemList.add(item1);
			assertEquals("If item list is not empty, it should be able to view items  ", 1, ItemDB.itemList.size());
			
			//Test that item list is empty, it should not be able to view items
			ItemDB.itemList.remove(item1);
			assertEquals("If item list is empty, it should not be able to view items  ", 0, ItemDB.itemList.size());
			
			
			
		}
		
		//Created by Qayyum
		@Test
		public void searchItemTest() {

			// Test that item list is not empty, it should be able to search
			ItemDB.itemList.add(item1);
			assertEquals("If item list is not empty, it should be able to search", 1, ItemDB.itemList.size());
			
			// Test that item list is empty, it should not be able to search
			ItemDB.itemList.remove(item1);
			assertEquals("If item list is empty, it should not be able to search", 0,ItemDB.itemList.size());
			
			
		}
		
		//Created by Qayyum
		@Test
		public void blockItemTest() {

			// Test that item list is not empty
			ItemDB.itemList.add(item1);
			assertEquals("If item list is not empty", 1, ItemDB.itemList.size());
					
			// Test that item list is empty
			ItemDB.itemList.remove(item1);
			assertEquals("If item list is empty", 0,ItemDB.itemList.size());
			
			// Test that block item is blocked
			ItemDB.blockedItemList.add(item2);
			assertEquals("Test if item is blocked", 1, ItemDB.blockedItemList.size());
			
			// Test that block item is unblocked
			ItemDB.blockedItemList.remove(item2);
			assertEquals("Test if item is unblocked",0, ItemDB.blockedItemList.size());
					
					
		}
		
	
		
		

}
