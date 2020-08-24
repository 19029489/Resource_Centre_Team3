import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private User user1, user2;
	private Item item1, item2;

	@Before
	public void setUp() throws Exception {
		
		/* Add User */
		user1 = new User("User", "Member", "Fish@hotmail.com", "User");
		user2 = new User("User", "Staff", "Fishmanh@fishmail.com", "UserPass");
		UserDB.userList.clear();
		
		
		/* Add Item */
		item1 = new Item("Vase","Glass Vase",10.00, "30 Aug 2020", "1 Sept 2020",5.00);
		item2 = new Item("Handphone Cover","Silicone Hello Kitty Handphone Cover", 20.00, "26 Aug 2020", "5 Sept 2020",5.00);
	}

	@After
	public void tearDown() throws Exception {
		
		/* Reset User */
		user1 = null;
		user2 = null;
		UserDB.userList.clear();
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	
	
	/* ADD USER TEST */
	
	// Created by Haziq at 24/8/2020
	
	@Test
	public void addUserTest() {

		// Test that the user list is 0 before adding users
		assertEquals("Test that the user list is 0 before adding users", 0, UserDB.userList.size());
		
		//  Test that the user list is 1 after adding user (successful adding)
		UserDB.userList.add(user1);
		assertEquals("Test that the user list is 0 before adding users", 1, UserDB.userList.size());
		
		// Test that if the user enters a duplicate name, an error message will be displayed informing the user that their name has already been taken
		assertEquals("Test that if the user enters a duplicate name, an error message will be displayed informing the user that their name has already been taken", );
	}
	
	@Test
	public void delUserTest() {

		// Test that the user list is not 0 before deleting users
		UserDB.userList.add(user1);
		assertEquals("Test that the user list is 0 before adding users", UserDB.userList.size() > 0, UserDB.userList.size());
		
		// Test that the user list is 0 after deleting users (successful delete)
		UserDB.userList.remove(user1);
		assertEquals("Test that the user list is 0 after adding users", UserDB.userList.size() > 0, UserDB.userList.size());

	}
	
	//Created by Qayyum
	@Test
	public void addItemTest() {
		// Test that Item list can be empty before adding
		assertEquals("Test that the item list can be empty before adding",0,ItemDB.itemList.size());
		
		// Test that after adding, item list size should increase 
		ItemDB.itemList.add(item1);
		assertEquals("Test that after adding, item list should increase", 1, ItemDB.itemList.size());

		 // Test that item list is not empty, item can still be added
		ItemDB.itemList.add(item2);
		assertEquals("Test that item list is not empty, item can still be added",2,ItemDB.itemList.size());
		
		// Test that after adding item, the same item cannot be added again
		assertEqeals("Test that after adding item, the same item cannot be added again",1, ItemDB.itemList.

	}
	
	


}
