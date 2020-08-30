import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//Created by Huai Yu
public class DealTest {

	private Deal deal1, deal2, deal3, deal4, deal5;
	
	@Before
	public void setUp() throws Exception {
		deal1 = new Deal("001", "Antique Mug", "ng@gmail.com", "hy@hotmail.com", 50.0, "30/8/2020");
		deal2 = new Deal("002", "Antique Bowl", "hy@hotmail.com", "ng@gmail.com", 30.0, "24/9/2020");
		deal3 = new Deal("003", "Push Cart", "carrot@hotmail.com", "potato@gmail.com", 79.0, "20/10/2020");
		deal4 = new Deal("004", "Fancy Glass Jar", "potato@gmail.com", "ng@gmail.com", 26.0, "24/9/2020");
		deal5 = new Deal("005", "Striped Modern Couch", "carrot@hotmail.com", "hy@hotmail.com", 56.0, "24/9/2020");
	}

	@After
	public void tearDown() throws Exception {
		deal1 = null;
		deal2 = null;
		deal3 = null;
		deal4 = null;
		deal5 = null;
		
		DealDB.dealList.clear();
	}

	@Test
	public void addDealTest() {
		
		//Test that dealList is NOT null
		assertNotNull("Test that catList is NOT null", DealDB.dealList);
		
		//Test that the size of dealList is 0 before adding any deals
		assertEquals("Test that the size of dealList is 0 before adding any deals", 0, DealDB.dealList.size());
		
		//Test that the size of dealList is 1 after adding a deal
		DealDB.addDeal(deal1);
		assertEquals("Test that the size of dealList is 1 after adding a deal", 1, DealDB.dealList.size());
		
		//Test that the first element in dealList is the same as what was added
		assertSame("Test that the first element in dealList is the same as what was added", deal1, DealDB.dealList.get(0));
	
	}
	
	@Test
	public void viewAllDealTest() {
		
		//Test that dealList is not empty
		assertTrue("Test that dealList is not empty", DealDB.dealList.isEmpty());
		assertFalse("Test that dealList is not empty", !DealDB.dealList.isEmpty());
	}
	
	@Test
	public void delDealTest() {
		
		//Test that size of dealList has at least 1 deal before deletion of deal
		DealDB.addDeal(deal1);
		DealDB.addDeal(deal2);
		assertTrue("Test that size of dealList has at least 1 deal before deletion of deal", DealDB.dealList.size() > 0);
		
		//Test that size of dealList is 1 after deletion of 1 deal of 2
		DealDB.delDeal("001");
		
		assertEquals("Test that size of dealList is 1 after deletion of 1 deal of 2", 1, DealDB.dealList.size());
		
		//Test that the deal deleted is the same as the one deleted
		assertSame("Test that the deal deleted is the same as the one deleted", "002", DealDB.dealList.get(0).getDealID());
		
	}
	
	@Test
	public void searchDealTest() {
		
		//Test that there is at least one deal before searching
		DealDB.addDeal(deal1);
		DealDB.addDeal(deal2);
		DealDB.addDeal(deal3);
		DealDB.addDeal(deal4);
		DealDB.addDeal(deal5);
		assertTrue("Test that there is at least one deal before searching", DealDB.dealList.size() > 0 );
		
		// Test that seller and buyer email input matches existing deal
		assertTrue("Test that seller and buyer email input matches existing deal", DealDB.searchDeal(1, "ng@gmail.com"));
		
		// Test that item name input matches existing deal
		assertTrue("Test that item name input matches existing deal", DealDB.searchDeal(3, "Push Cart"));
		
		// Test that deal ID input matches existing deal
		assertTrue("Test that item name input matches existing deal", DealDB.searchDeal(2, "001"));
		
		// Test that deal price input matches existing deal
		assertTrue("Test that item name input matches existing deal", DealDB.searchDeal(5, "26.0"));
		
		// Test that close date input matches existing deal
		assertTrue("Test that close date input matches existing deal", DealDB.searchDeal(4, "24/9/2020"));
		
		//Test that non-existing dealID/others will not match any deal
		assertFalse("Test that non-existing deal/others will not match any deal", DealDB.searchDeal(2, "137"));
	}
	
	@Test
	public void updateDealTest() {
		
		//Test that Deal List has at least one before updating
		DealDB.addDeal(deal1);
		assertTrue("Test that there is at least one deal before searching", DealDB.dealList.size() > 0 );
		
		// Test that seller/buyer is able to update deal
		String msg  = DealDB.updateDeal("001", "Antique Mug", 40.0, "ng@gmail.com", "hy@hotmail.com", "30/8/2020");
		assertEquals("Test that seller/buyer is able to update deal", "Changes were made successfully.", msg);
				
		// Test that user is unable to update name and password if the details are the same as the previous ones
		String msg2  = DealDB.updateDeal("001", "Antique Mug", 50.0, "ng@gmail.com", "hy@hotmail.com", "30/8/2020");
		assertEquals("Test that user is unable to update name and password if the details are the same as the previous ones", "No changes were made to the deal.", msg2);
		
	}
	

}
