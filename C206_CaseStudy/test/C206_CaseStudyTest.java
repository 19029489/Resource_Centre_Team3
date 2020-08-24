import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private User user1;

	@Before
	public void setUp() throws Exception {
		
		/* Add User */
		user1 = new User("User", "Member", "Fish@hotmail.com", "User");
		UserDB.userList.clear();
	}

	@After
	public void tearDown() throws Exception {
		
		/* Reset User */
		user1 = null;
		UserDB.userList.clear();
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	
	
	/* ADD USER TEST */
	
	public void addUserTest() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	


}
