package edu.gmu.cs.swe619.exercises.week03;

import org.junit.Test;

import org.junit.Assert;
public class ImmutableQueueTest {

	@Test
	public void simpleTest() {
		ImmutableQueue<String> testQueue = new ImmutableQueue<>();
		Assert.assertEquals(true, testQueue.isEmpty());
		
		testQueue = testQueue.enQueue("Some");
		Assert.assertEquals(false, testQueue.isEmpty());
		Assert.assertEquals("Some", testQueue.nextElement());
		
		testQueue = testQueue.enQueue("data.");
		Assert.assertEquals(false, testQueue.isEmpty());
		Assert.assertEquals("Some", testQueue.nextElement());
		
		testQueue = testQueue.deQueue();
		Assert.assertEquals(false, testQueue.isEmpty());
		Assert.assertEquals("data.", testQueue.nextElement());
		
		testQueue = testQueue.deQueue();
		Assert.assertEquals(true, testQueue.isEmpty());
	}
}
