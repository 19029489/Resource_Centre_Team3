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
		user1 = new User("Fish", "Member", "Fish@hotmail.com", "User");
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
		UserDB.addUser(user1);
		assertEquals("Test that the user list is 0 before adding users", 1, UserDB.userList.size());
		
		// Test that user list can only store up to 2 users
		UserDB.addUser(user2);
		UserDB.addUser(user1);
		assertTrue("Test that user list can only store up to 2 users", !(UserDB.userList.size() <= 2));
		assertFalse("Test that user list can only store up to 2 users", !(UserDB.userList.size() > 2));
	}
	
	@Test
	public void delUserTest() {

		// Test that the user list is not 0 before deleting users
		UserDB.addUser(user1);
		assertTrue("Test that the user list is not 0 before deleting users", !UserDB.userList.isEmpty());
		
		// Test that the user list is 0 after deleting users (successful delete)
		UserDB.delUser("Fish");
		assertEquals("Test that the user list is 0 after deleting users", 0, UserDB.userList.size());
		
		// Test that if the user enters an incorrect name, an error message will be displayed informing that the user doesn't exist
		UserDB.addUser(user1);
		UserDB.delUser("User");
		
		
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
		assertEquals("Test that after adding item, the same item cannot be added again",1, ItemDB.itemList.get(1));

	}
	
	//Created by Qayyum
	@Test
	public void deleteItemTest() {

		// When item is deleted, item list should decreased 
		UserDB.itemList.remove(item1);
		assertEquals("When item is deleted, item list should decreased ", ItemDB.itemList.size() > 0, ItemDB.itemList.size());
		
		// If item list is not null, item is ready to be deleted
		UserDB.itemList.add(item1);
		assertEquals("If item list is not null, item is ready to be deleted", ItemDB.itemList.size() > 0, ItemDB.itemList.size());

	}
	
	
	@Test
	public void viewAllUserTest() {

		// Test that user list is not empty 
		assertTrue("Test that user list is not empty ", UserDB.userList.isEmpty());
		assertFalse("Test that user list is not empty ", !UserDB.userList.isEmpty());
		
	}
	


}
