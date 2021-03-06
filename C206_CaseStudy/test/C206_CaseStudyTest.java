import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Item item1, item2;
	private Category cat1, cat2, cat3;

	@Before
	public void setUp() throws Exception {
	
		/*Add Category*/
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
		
		item1 = null;
		item2 = null;
		ItemDB.itemList.clear();
		
		
		
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	
	
	
	
	
	
	




	
	//Created by Yee Hung
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
		
		// Test categories retrieved from the catList is empty
		assertEquals("Test categories retrieved from the catList is empty", 0, CategoryDB.catList.size());
		
		// Test size of catList is 3 after adding 3 categories
		CategoryDB.addCategory(cat1);
		CategoryDB.addCategory(cat2);
		CategoryDB.addCategory(cat3);
		assertEquals("Test size of catList is 3 after adding 3 categories", 3, CategoryDB.catList.size());
		
		// Test the expected output is same as the list of output
		String expectedOutput = "";
		expectedOutput += "Category [name=Foods]\n";
		expectedOutput += "Category [name=Books]\n";
		expectedOutput += "Category [name=Stationery]\n";
		assertSame("Test the expected output is same as the list of output", expectedOutput, CategoryDB.allCategory());
		
	}
	
	@Test
	public void delCategoryTest() {	
		// Test catList is NOT null
		assertNotNull("Test catList is NOT null", CategoryDB.catList);
		
		// Test categories retrieved from the catList is empty
		assertEquals("Test categories retrieved from the catList is empty", 0, CategoryDB.catList.size());

		// Test size of catList is 3 before delete any categories
		CategoryDB.addCategory(cat1);
		CategoryDB.addCategory(cat2);
		CategoryDB.addCategory(cat3);
		assertEquals("Test size of catList is 3 before delete any categories", 3, CategoryDB.catList.size());
		
		// Test size of catList is 2 after delete a category
		CategoryDB.delCategory(cat2);
		assertEquals("Test size of catList is 2 after delete a category", 2, CategoryDB.catList.size());
	
	}
	

}
