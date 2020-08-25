import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	
	private Item item1, item2;

	@Before
	public void setUp() throws Exception {
	
		
		
		
		/* Add Item */
		item1 = new Item("Vase","Glass Vase",10.00, "30 Aug 2020", "1 Sept 2020",5.00);
		item2 = new Item("Handphone Cover","Silicone Hello Kitty Handphone Cover", 20.00, "26 Aug 2020", "5 Sept 2020",5.00);
	}

	@After
	public void tearDown() throws Exception {
		
		
		
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	
	
	
	//Created by Qayyum
	@Test
	public void addItemTest() {
		// Test that Item list can be empty before adding
		assertEquals("Test that the item list can be empty before adding",1, ItemDB.itemList.size());
		
		
		// Test that after adding, item list size should increase 
		ItemDB.itemList.add(item1);
		assertEquals("Test that after adding, item list should increase", 2, ItemDB.itemList.size());

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
		assertTrue("If item list is not empty, it should be able to view items  ", !ItemDB.itemList.isEmpty());
		assertFalse("If item list is empty, it should not be able to view items  ", ItemDB.itemList.isEmpty());
		
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
	

	


}
