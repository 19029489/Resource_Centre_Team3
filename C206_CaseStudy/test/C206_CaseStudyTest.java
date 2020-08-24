import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private User user1, user2;

	@Before
	public void setUp() throws Exception {
		
		/* Add User */
		user1 = new User("Fish", "Member", "Fish@hotmail.com", "User");
		user2 = new User("User", "Staff", "Fishmanh@fishmail.com", "UserPass");
		
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
	
	// Created by Haziq at 24/8/2020
	@Test
	public void delUserTest() {
		
		
		
		// Test that the user list is not 0 before deleting users
		UserDB.addUser(user1);
		assertTrue("Test that the user list is not 0 before deleting users", !UserDB.userList.isEmpty());
		
		// Test that the user list is 0 after deleting users (successful delete)
		UserDB.delUser("Fish");
		assertEquals("Test that the user list is 0 after deleting users", 0, UserDB.userList.size());
		
		// Test that user list remains at 1 if delete with incorrect username
		UserDB.addUser(user1);
		UserDB.delUser("User");
		assertEquals("Test that user list remains at 1 if delete with incorrect username", 1, UserDB.userList.size());

		
	}
	
	// Created by Haziq at 24/8/2020
	@Test
	public void viewAllUserTest() {

		// Test that user list is not empty 
		assertTrue("Test that user list is not empty ", UserDB.userList.isEmpty());
		assertFalse("Test that user list is not empty ", !UserDB.userList.isEmpty());
		
	}
	


}
