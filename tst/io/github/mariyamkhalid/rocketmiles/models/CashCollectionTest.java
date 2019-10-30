package io.github.mariyamkhalid.rocketmiles.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CashCollectionTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCashCollection() {
		CashCollection c = new CashCollection();
		assertEquals(0, c.getTotalValue());
	}

	@Test
	void testCashCollectionIntIntIntIntInt() {
		CashCollection c = new CashCollection(1, 2, 3, 4, 5);
		assertEquals(1, c.getOnes());
		assertEquals(2, c.getTwos());
		assertEquals(3, c.getFives());
		assertEquals(4, c.getTens());
		assertEquals(5, c.getTwenties());
		assertEquals(160, c.getTotalValue());

	}

	@Test
	void testCashCollectionCashCollection() {
		CashCollection c = new CashCollection(1, 2, 3, 4, 5);
		CashCollection copy = new CashCollection(c);
		assertEquals(1, copy.getOnes());
		assertEquals(2, copy.getTwos());
		assertEquals(3, copy.getFives());
		assertEquals(4, copy.getTens());
		assertEquals(5, copy.getTwenties());
		assertEquals(160, copy.getTotalValue());
		
	}

	@Test
	void testAddOne() {
		CashCollection c = new CashCollection();
		c.addOne();
		assertEquals(1, c.getOnes());
		assertEquals(1, c.getTotalValue());
	}

	@Test
	void testAddTwo() {
		CashCollection c = new CashCollection();
		c.addTwo();
		assertEquals(1, c.getTwos());
		assertEquals(2, c.getTotalValue());
	}

	@Test
	void testAddFive() {
		CashCollection c = new CashCollection();
		c.addFive();
		assertEquals(1, c.getFives());
		assertEquals(5, c.getTotalValue());
	}

	@Test
	void testAddTen() {
		CashCollection c = new CashCollection();
		c.addTen();
		assertEquals(1, c.getTens());
		assertEquals(10, c.getTotalValue());
	}

	@Test
	void testAddTwenty() {
		CashCollection c = new CashCollection();
		c.addTwenty();
		assertEquals(1, c.getTwenties());
		assertEquals(20, c.getTotalValue());
	}

	@Test
	void testRemoveOne() {
		CashCollection c = new CashCollection(1,0,0,0,0);
		c.removeOne();
		assertEquals(0, c.getOnes());
		assertEquals(0, c.getTotalValue());
		
	}

	@Test
	void testRemoveTwo() {
		CashCollection c = new CashCollection(0,1,0,0,0);
		c.removeTwo();
		assertEquals(0, c.getTwos());
		assertEquals(0, c.getTotalValue());
	}

	@Test
	void testRemoveFive() {
		CashCollection c = new CashCollection(0,0,1,0,0);
		c.removeFive();
		assertEquals(0, c.getFives());
		assertEquals(0, c.getTotalValue());
	}

	@Test
	void testRemoveTen() {
		CashCollection c = new CashCollection(0,0,0,1,0);
		c.removeTen();
		assertEquals(0, c.getTens());
		assertEquals(0, c.getTotalValue());
	}

	@Test
	void testRemoveTwenty() {
		CashCollection c = new CashCollection(0,0,0,0,1);
		c.removeTwenty();
		assertEquals(0, c.getTwenties());
		assertEquals(0, c.getTotalValue());
	}

	@Test
	void testGetOnes() {
		CashCollection c = new CashCollection(1,0,0,0,0);
		assertEquals(1, c.getOnes());
	}

	@Test
	void testGetTwos() {
		CashCollection c = new CashCollection(0,1,0,0,0);
		assertEquals(1, c.getTwos());
	}

	@Test
	void testGetFives() {
		CashCollection c = new CashCollection(0,0,1,0,0);
		assertEquals(1, c.getFives());
	}

	@Test
	void testGetTens() {
		CashCollection c = new CashCollection(0,0,0,1,0);
		assertEquals(1, c.getTens());
	}

	@Test
	void testGetTwenties() {
		CashCollection c = new CashCollection(0,0,0,0,1);
		assertEquals(1, c.getTwenties());
	}

	@Test
	void testGetTotalValue() {
		CashCollection c = new CashCollection(1, 2, 3, 4, 5);
		assertEquals(160, c.getTotalValue());
		
		CashCollection c2 = new CashCollection();
		assertEquals(0, c2.getTotalValue());
	}

	@Test
	void testAddCashCollection() {
		CashCollection c = new CashCollection(1, 2, 3, 4, 5);
		CashCollection c2 = new CashCollection();
		c2.addCashCollection(c);
		assertEquals(160, c2.getTotalValue());
	}

	@Test
	void testRemoveCashCollection() {
		CashCollection c = new CashCollection(1, 1, 1, 1, 1);
		CashCollection c2 = new CashCollection(1,1,1,1,1);
		c.removeCashCollection(c2);
		assertEquals(0, c.getTotalValue());
	}

}
