import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DealTest {

	private Deal deal1, deal2;
	
	@Before
	public void setUp() throws Exception {
		deal1 = new Deal("001", "Antique Mug", "ng@gmail.com", "hy@hotmail.com", 50.0, "30th August 2020");
		deal2 = new Deal("002", "Antique Bowl", "hy@hotmail.com", "ng@gmail.com", 30.0, "24th September 2020");
	}

	@After
	public void tearDown() throws Exception {
		deal1 = null;
		deal2 = null;
		
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
		
		//Test that size of dealLIst is 1 after deletion of 1 deal of 2
		String id = "001";
		for (int i=0; i< DealDB.dealList.size(); i++){
			if (DealDB.dealList.get(i).getDealID() == id) {
				DealDB.dealList.remove(DealDB.dealList.get(i));
			}
		}
		
		assertEquals("Test that size of dealLIst is 0 after deletion of deal", 1, DealDB.dealList.size());
		
		//Test that the deal deleted is the same as the one deleted
		assertSame("Test that the deal deleted is the same as the one deleted", "002", DealDB.dealList.get(0).getDealID());
		
	}

}
