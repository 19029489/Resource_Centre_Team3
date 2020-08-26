// Created by Haziq at 25/8/2020

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {


	private User user1, user2, user3, user4, user5, user6;

	@Before
	public void setUp() throws Exception {
		
		user1 = new User("Fish", "Member", "Fish@hotmail.com", "User");
		user2 = new User("User", "Admin", "Fishman@fishmail.com", "UserPass");
		user3 = new User("User3", "Member", "User3@fishmail.com", "UserPass3");
		user4 = new User("User5", "Admin", "User4@fishmail.com", "UserPass4");
		user5 = new User("User5", "Member", "User5@fishmail.com", "UserPass5");
		user6 = new User("User6", "Member", "User6@fishmail.com", "UserPass6");
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
		
		// Test that user is unable to be added with duplicate email
		//UserDB.addUser(user1);
		//assertEquals("Test that the user list is 0 before adding users", 1, UserDB.userList.size());
		
		// Test that user list can only store up to 5 users
		UserDB.addUser(user2);
		UserDB.addUser(user3);
		UserDB.addUser(user4);
		UserDB.addUser(user5);
		/* 6th user */ UserDB.addUser(user6);
		assertEquals("Test that user list can only store up to 5 users", 5, UserDB.userList.size());
		
		
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

		// Test that user list is at 1 before logging in
		UserDB.addUser(user1);
		assertEquals("Test that user list is at 1 before searching", 1, UserDB.userList.size());
		
		// Test that user is able to login to existing user with correct email and password
		boolean logTest = UserDB.login("Fish@hotmail.com", "User");
		assertTrue("Test that user is able to login to existing user with correct email and password", logTest);
		
		// Test that user is able to login to existing user with correct email (not case sensitive) and password
		logTest = UserDB.login("FiSh@hOtMaIl.CoM", "User");
		assertTrue("Test that user is able to login to existing user with correct email (not case sensitive) and password", logTest);
		
		// Test that user is unable to login to existing user with correct email but wrong password (case sensitive)
		logTest = UserDB.login("Fish@hotmail.com", "user");
		assertFalse("Test that user is unable to login to existing user with correct email but wrong password (case sensitive)", logTest);
	
		// Test that user is unable to login to existing user with wrong email
		logTest = UserDB.login("Fisher@hotmail.com", "User");
		assertFalse("Test that user is unable to login to existing user with wrong email", logTest);
		
	}
	
	@Test
	public void updateUserTest() {
		
		// Test that user list is at 1 before logging in
		UserDB.addUser(user1);
		assertEquals("Test that user list is at 1 before searching", 1, UserDB.userList.size());
		
		// Test that user is able to update name and password based off their email successfully
		String uTest = UserDB.updateUser("Fish@hotmail.com", "Johnny", "Lego");
		assertEquals("Test that user is able to update name and password based off their email successfully", "Update successful.", uTest);
		
		// Test that user is unable to update name and password if either one are the same as their previous ones
		uTest = UserDB.updateUser("Fish@hotmail.com", "Johnny", "Lego");
		assertEquals("Test that user is able to update name and password based off their email successfully", "Please do not use the same username and password.", uTest);
		
		// Test that user is unable to update name and password if email used is invalid
		uTest = UserDB.updateUser("Fisher@hotmail.com", "Johnny", "Lego");
		assertEquals("Test that user is able to update name and password based off their email successfully", "No user with that email", uTest);
	}
	
	@Test
	
	public void blockTest() {
		
	}
	
	
}
