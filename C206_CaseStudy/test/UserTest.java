// Created by Haziq at 25/8/2020

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {


	private User user1, user2;

	@Before
	public void setUp() throws Exception {
		
		user1 = new User("Fish", "Member", "Fish@hotmail.com", "User");
		user2 = new User("User", "Admin", "Fishman@fishmail.com", "UserPass");
		UserDB.userList.clear();
	}

	@After
	public void tearDown() throws Exception {
		
		
		user1 = null;
		user2 = null;
		UserDB.userList.clear();
	}

	
	/* ADD USER TEST */
	
	
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
	
	/* DELETE USER TEST */
	
	@Test
	public void delUserTest() {

		// Test that the user list is not 0 before deleting users
		UserDB.addUser(user1);
		assertTrue("Test that the user list is not empty before deleting users", !UserDB.userList.isEmpty());
		
		// Test that the user list is 0 after deleting users (successful delete)
		UserDB.delUser("Fish");
		assertEquals("Test that the user list is 0 after deleting users", 0, UserDB.userList.size());
		
		// Test that user list remains at 1 if delete with incorrect username
		UserDB.addUser(user1);
		UserDB.delUser("User");
		assertEquals("Test that user list remains at 1 if delete with incorrect username", 1, UserDB.userList.size());
		
		
	}
	
	/* VIEW ALL USER TEST */
	
	@Test
	public void viewAllUserTest() {

		// Test that user list is not empty before viewing 
		String expected ="There are no users available.";
		assertEquals("Test that user list is not empty before viewing", expected,UserDB.viewAllUser());
		
		
		// Test that when user list is populated with 1 user, the returned String is properly shown
		UserDB.addUser(user1);
		String u1Test = "Username: Fish\nRole: Member\nEmail: Fish@hotmail.com\n";
		assertEquals("Test that when user list is populated with 1 user, the returned String is properly shown", u1Test, UserDB.viewAllUser());
		
		// Test that when user list is populated with 2 users, the returned String is properly shown
		UserDB.addUser(user2);
		String u2Test = "Username: Fish\nRole: Member\nEmail: Fish@hotmail.com\n";
		u2Test += "Username: User\nRole: Admin\nEmail: Fishman@fishmail.com\n";
		assertEquals("Test that when user list is populated with 2 users, the returned String is properly shown", u2Test, UserDB.viewAllUser());
	}
	
	/* SEARCH USER TEST */
	
	@Test
	public void searchUserTest() {

		// Test that user list is at 1 before searching
		UserDB.addUser(user1);
		assertEquals("Test that user list is at 1 before searching", 1, UserDB.userList.size());
		
		// Test that email input matches existing user
		assertTrue("Test that user input email matches existing user", UserDB.searchUser("Fish@hotmail.com"));
		
		// Test that incorrect email input does not match any user
		assertFalse("Test that user input email matches existing user", UserDB.searchUser("Soup@rp.edu.sg"));
	}
	
	/* LOGIN */
	
	@Test
	public void loginTest() {

		// Test that user list is at 1 before searching
		UserDB.addUser(user1);
		assertEquals("Test that user list is at 1 before searching", 1, UserDB.userList.size());
		
		// Test that email input matches existing user
		assertTrue("Test that user input email matches existing user", UserDB.searchUser("Fish@hotmail.com"));
		
		// Test that incorrect email input does not match any user
		assertFalse("Test that user input email matches existing user", UserDB.searchUser("Soup@rp.edu.sg"));
	}
	
	
}
