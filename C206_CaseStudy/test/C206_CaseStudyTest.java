import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Bid bid1;
	private ArrayList<Bid>bidList;
	
	public C206_CaseStudyTest() {
		super();
	}

	
	
	@Before
	public void setUp() throws Exception {
		bid1 = new Bid("bd1", "Books", "joshlee@gmail.com", "johntan@gmail.com", 15.0);
		bidList = new ArrayList<Bid>();
	}

	@After
	public void tearDown() throws Exception {
		
		bid1 = null;
		bidList = null;
		
	}
	
	@Test
	public void addBidtest() {
		
		// Test that the bidList is NOT null
		assertNotNull("Test that catlist is NOT null", bidList);
		
		// Test that the size of the catlist is 0 before adding any bid
		assertEquals("Test that the size of catlist is 0 before adding any bid", 0, BidDB.bidList.size());
		
		// Test that the size of the catlist is 1 is added after adding a bid
		BidDB.addBid(bidList, bid1);
		assertEquals("Test that the size of catlist is 1 is added after adding a bid1", 1, BidDB.bidList.size());
		
		// Test that the first element in catlist is the same as what it was added
		assertSame("Test that the first element in catlist is the same as what it was added", bid1, bidList.get(0));
	}
	
	@Test
	public void viewBidTest() {
		
		// Test if bid list is not null
		assertNotNull("Test if bid list is not null", bidList);
		
		// Test if the list of bids retrieved from the BidDB is empty
		String allBid = C206_CaseStudy.retrieveAllBid(bidList);
		String testOutput = "";
		assertEquals("Check that ViewAllBidlist", testOutput, allBid);
		
		// Given that an empty list after adding a item
		C206_CaseStudy.addBid(bidList, bid1);
		assertEquals("Test that the size of bidList is 2 is added", 2, bidList.size());
		assertSame("Test that the first element is added in bidList", bid1, bidList.get(1));
	}
	
	@Test
	public void deleteBidTest() {
		
		// Test if bid list is not null
		assertNotNull("Test if bid list is not null", bidList);
		
		// Test if the list of bids retrieved from BidDB is not empty
		String allBid = C206_CaseStudy.retrieveAllBid(bidList);
		assertEquals("Test if the list of bids retrieved from BidDB is not empty", allBid);
		
		// Test if the list of bids all removed
		C206_CaseStudy.bidList.clear();
		assertSame("Test if the list of bids all removed", bid1, bidList.clear());
	}	

	@Test
	public void c206_test() {
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
