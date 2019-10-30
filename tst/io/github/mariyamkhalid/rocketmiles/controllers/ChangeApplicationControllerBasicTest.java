package io.github.mariyamkhalid.rocketmiles.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.mariyamkhalid.rocketmiles.models.CashCollection;

class ChangeApplicationControllerBasicTest {

	@Test
	void testChangeApplicationControllerBasic() {
		ChangeApplicationControllerBasic controller = new ChangeApplicationControllerBasic();
		assertEquals(0,controller.getCurrentCashCollection().getTotalValue());
	}

	@Test
	void testGetTotal() {
		ChangeApplicationControllerBasic controller = new ChangeApplicationControllerBasic();
		assertEquals(0,controller.getCurrentCashCollection().getTotalValue());
		controller.put(new CashCollection(1,2,3,4,5));
		assertEquals(160,controller.getCurrentCashCollection().getTotalValue());
	
	}

	@Test
	void testGetCurrentCashCollection() {
		ChangeApplicationControllerBasic controller = new ChangeApplicationControllerBasic();
		CashCollection c1 = new CashCollection(1,2,3,4,5);
		controller.put(c1);
		CashCollection c2 = controller.getCurrentCashCollection();
		assertEquals(c1.getOnes(), c2.getOnes());
		assertEquals(c1.getTwos(), c2.getTwos());
		assertEquals(c1.getFives(), c2.getFives());
		assertEquals(c1.getTens(), c2.getTens());
		assertEquals(c1.getTwenties(), c2.getTwenties());
	}

	@Test
	void testPut() {
		ChangeApplicationControllerBasic controller = new ChangeApplicationControllerBasic();
		CashCollection c1 = new CashCollection(5,4,3,2,1);
		controller.put(c1);
		
		CashCollection c2 = controller.getCurrentCashCollection();
		assertEquals(c1.getOnes(), c2.getOnes());
		assertEquals(c1.getTwos(), c2.getTwos());
		assertEquals(c1.getFives(), c2.getFives());
		assertEquals(c1.getTens(), c2.getTens());
		assertEquals(c1.getTwenties(), c2.getTwenties());
		assertEquals(68,c2.getTotalValue());
		
		CashCollection c3 = new CashCollection(5,0,3,2,1);
		controller.put(c3);
		c2 = controller.getCurrentCashCollection();
		assertEquals(128,c2.getTotalValue());
	}

	@Test
	void testTakeSuccess() {
		ChangeApplicationControllerBasic controller = new ChangeApplicationControllerBasic();
		CashCollection c1 = new CashCollection(5,4,3,2,1);
		CashCollection c2 = new CashCollection(5,0,3,2,1);
		CashCollection c3 = new CashCollection(10,0,3,4,1);
		controller.put(c1);
		controller.put(c2);
		controller.take(c3);
		CashCollection c4 = controller.getCurrentCashCollection();
		assertEquals(43,c4.getTotalValue());
	}

	@Test
	void testChangeCashSuccess() {
		ChangeApplicationControllerBasic controller = new ChangeApplicationControllerBasic();
		CashCollection c1 = new CashCollection(5,4,3,2,1);
		CashCollection c2 = new CashCollection(5,0,3,2,1);
		CashCollection c3 = new CashCollection(10,0,3,4,1);
		controller.put(c1);
		controller.put(c2);
		controller.take(c3);
		CashCollection c4 = controller.changeCash(11);
		assertEquals(11,c4.getTotalValue());
		CashCollection c5 = controller.getCurrentCashCollection();
		assertEquals(32,c5.getTotalValue());
	}
	
	@Test
	void testChangeCashFail() {
		ChangeApplicationControllerBasic controller = new ChangeApplicationControllerBasic();
		CashCollection c1 = new CashCollection(5,4,3,2,1);
		CashCollection c2 = new CashCollection(5,0,3,2,1);
		CashCollection c3 = new CashCollection(10,0,3,4,1);
		controller.put(c1);
		controller.put(c2);
		controller.take(c3);
		controller.changeCash(11);
		CashCollection c4 = controller.changeCash(14);
		assertNull(c4);
		CashCollection c5 = controller.getCurrentCashCollection();
		assertEquals(32,c5.getTotalValue());
	}

}
