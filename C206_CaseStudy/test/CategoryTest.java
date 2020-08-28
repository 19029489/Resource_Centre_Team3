import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	
	private Category cat1, cat2, cat3;
	
	@Before
	public void setUp() throws Exception {
		cat1 = new Category("Books");
		cat2 = new Category("Stationary");
		cat3 = new Category("Foods");
	}

	@After
	public void tearDown() throws Exception {
		cat1 = null;
		cat2 = null;
		cat3 = null;
		CategoryDB.catList.clear();
	}

	@Test
	public void addCategoryTest() {
		// Test catList is NOT null
		assertNotNull("Test catList is NOT null", CategoryDB.catList);
		
		// Test size of catList is 0 before adding any categories
		assertEquals("Test size of catList is 0 before adding any categories", 0, CategoryDB.catList.size());
		
		// Test size of catList is 1 after adding a category
		CategoryDB.addCategory(cat1);
		assertEquals("Test size of catList is 1 after adding a category", 1, CategoryDB.catList.size());
		
		// Test first element in catList is the same as what was added
		assertSame("Test first element in catList is the same as what was added", cat1, CategoryDB.catList.get(0));
	}
	
	@Test
	public void viewAllCategoryTest() {
		// Test catList is NOT null
		assertNotNull("Test catList is NOT null", CategoryDB.catList);
		
		// Test catList is empty
		assertEquals("Test catList is empty", 0, CategoryDB.catList.size());
		
		// Test size of catList is 3 after adding 3 categories
		CategoryDB.addCategory(cat1);
		CategoryDB.addCategory(cat2);
		CategoryDB.addCategory(cat3);
		assertEquals("Test size of catList is 3 after adding 3 categories", 3, CategoryDB.catList.size());
		
		// Test the expected output is same as the list of output
		String expectedOutput = "";
		expectedOutput += cat1.getName().toString() + "\n";
		expectedOutput += cat2.getName().toString() + "\n";
		expectedOutput += cat3.getName().toString() + "\n";
		assertEquals("Test the expected output is same as the list of output", expectedOutput, CategoryDB.viewAllCategory());
	}
	
	@Test
	public void delCategoryTest() {	
		// Test catList is NOT null
		assertNotNull("Test catList is NOT null", CategoryDB.catList);
		
		// Test catList is empty
		assertEquals("Test catList is empty", 0, CategoryDB.catList.size());

		// Test size of catList is 3 before delete a category
		CategoryDB.addCategory(cat1);
		CategoryDB.addCategory(cat2);
		CategoryDB.addCategory(cat3);
		assertEquals("Test size of catList is 3 before delete a category", 3, CategoryDB.catList.size());
		
		// Test size of catList is 2 after delete a category
		CategoryDB.delCategory(cat2);
		assertEquals("Test size of catList is 2 after delete a category", 2, CategoryDB.catList.size());
		
		// Test the deleted category is no longer in the catList
		String expectedOutput = "";
		expectedOutput += cat1.getName().toString() + "\n";
		expectedOutput += cat3.getName().toString() + "\n";
		assertEquals("Test the expected output is same as the list of output", expectedOutput, CategoryDB.viewAllCategory());
	
	}
	
	@Test
	public void searchCategoryDB() {	
		// Test catList is NOT null
		assertNotNull("Test catList is NOT null", CategoryDB.catList);
		
		// Test catList is empty
		assertEquals("Test catList is empty", 0, CategoryDB.catList.size());

		// Test size of catList is 3
		CategoryDB.addCategory(cat1);
		CategoryDB.addCategory(cat2);
		CategoryDB.addCategory(cat3);
		assertEquals("Test size of catList is 3", 3, CategoryDB.catList.size());
		
		// Test that "Stationary" is in catList
		assertTrue("Test that input matched with category", CategoryDB.searchCategoryDB("Books"));
	}
	
	@Test
	public void updateCategoryDB() {	
		// Test catList is NOT null
		assertNotNull("Test catList is NOT null", CategoryDB.catList);
		
		// Test catList is empty
		assertEquals("Test catList is empty", 0, CategoryDB.catList.size());

		// Test size of catList is 3
		CategoryDB.addCategory(cat1);
		CategoryDB.addCategory(cat2);
		CategoryDB.addCategory(cat3);
		assertEquals("Test size of catList is 3", 3, CategoryDB.catList.size());
		
		// Test that "Stationary" is replaced to "Drinks"
		CategoryDB.updateCategory("Stationary", "Drinks");
		assertTrue("Test that 'Stationary' is replaced to 'Drinks'", CategoryDB.searchCategoryDB("Drinks"));
		assertFalse("Test that 'Stationary' is replaced to 'Drinks'", CategoryDB.searchCategoryDB("Stationary"));
	}
	
}
