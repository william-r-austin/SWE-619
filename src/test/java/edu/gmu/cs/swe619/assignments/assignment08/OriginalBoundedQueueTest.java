package edu.gmu.cs.swe619.assignments.assignment08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class OriginalBoundedQueueTest {
	
	@Test
	public void negativeSizeQueueTest() {
		OriginalBoundedQueue queue = new OriginalBoundedQueue(-1);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		Assert.assertEquals(0, queue.getCount());

		queue.put("This is a test value.");
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
				
		Object x = queue.get();
		Assert.assertNull(x);
	}
	
	@Test
	public void zeroSizeQueueTest() {
		OriginalBoundedQueue queue = new OriginalBoundedQueue(0);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		Assert.assertEquals(0, queue.getCount());

		queue.put("This is a test value.");
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
				
		Object x = queue.get();
		Assert.assertNull(x);
	}
	
	@Test
	public void sizeOneQueueTest() {
		OriginalBoundedQueue queue = new OriginalBoundedQueue(1);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());

		queue.put("This is a test value.");
		Assert.assertEquals(false, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		Assert.assertEquals(1, queue.getCount());
				
		String x = (String) queue.get();
		Assert.assertEquals("This is a test value.", x);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
	}
	
	@Test
	public void sizeFiveQueueTest() {
		OriginalBoundedQueue queue = new OriginalBoundedQueue(5);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());

		for(int i = 1; i <= 10; i++) {
			queue.put(i);
			Assert.assertEquals(false, queue.isEmpty());
			Assert.assertEquals(Math.min(i, 5), queue.getCount());
			Assert.assertEquals(i >= 5, queue.isFull());
		}
		
		for(int i = 1; i <= 10; i++) {
			Integer x = (Integer) queue.get();
			
			Assert.assertEquals(false, queue.isFull());
			
			if(i <= 5) {
				Assert.assertEquals(i, x.intValue());
			}
			else {
				Assert.assertNull(x);
			}
			
			if(i < 5) {
				Assert.assertEquals(false, queue.isEmpty());
			}
			else {
				Assert.assertEquals(true, queue.isEmpty());
			}
		}
	}
		
	@Test
	public void putNullElementsTest() {
		OriginalBoundedQueue queue = new OriginalBoundedQueue(4);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		
		for(int i = 1; i <= 5; i++) {
			Boolean isEven = (i % 2 == 0);
			queue.put(isEven);
			
			Assert.assertEquals(false, queue.isEmpty());
			Assert.assertEquals(Math.min(i, 4), queue.getCount());
			Assert.assertEquals(i >= 4, queue.isFull());
			
			queue.put(null);
			Assert.assertEquals(false, queue.isEmpty());
			Assert.assertEquals(Math.min(i, 4), queue.getCount());
			Assert.assertEquals(i >= 4, queue.isFull());
		}
		
		List<Boolean> queueContents = new ArrayList<>();
		while(!queue.isEmpty()) {
			queueContents.add((Boolean) queue.get()); 
		}
		
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		Assert.assertEquals(Arrays.asList(new Boolean[] {false, true, false, true}), queueContents);
	}
	
	@Test
	public void boundedQueueTest() {
		OriginalBoundedQueue queue = new OriginalBoundedQueue(4);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		
	    Integer current = 1;
	    while(!queue.isFull()) {
            queue.put(current);
            current++;
        }
	    
		Assert.assertEquals(false, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		Assert.assertEquals(4, queue.getCount());
		
		List<Integer> removedElements = new ArrayList<>();
	    
        while (!queue.isEmpty()) {
            Integer queueElement = (Integer) queue.get();
            removedElements.add(queueElement);
        }
        
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		Assert.assertEquals(Arrays.asList(new Integer[] {1, 2, 3, 4}), removedElements);
	}
	
	@Test
	public void mixedTest() {
		OriginalBoundedQueue queue = new OriginalBoundedQueue(3);
	    List<Integer> removedElements = new ArrayList<>();
		
	    // null
	    removedElements.add((Integer) queue.get());
	    
	    queue.put(1);
	    queue.put(2);
	    
	    // 1
	    removedElements.add((Integer) queue.get());
	    
	    queue.put(3);
	    
	    // 2
	    removedElements.add((Integer) queue.get());
	    
	    // Not added
	    queue.put(null);
	    
	    queue.put(4);
	    queue.put(5);
	    
	    // Not added
	    queue.put(6);
	    queue.put(7);
	    
	    // 3
	    removedElements.add((Integer) queue.get());
	    
	    // 4
	    removedElements.add((Integer) queue.get());
	    
	    // 5
	    removedElements.add((Integer) queue.get());
	    
	    // null
	    removedElements.add((Integer) queue.get());
	    
	    queue.put(8);
	    
	    // 8
	    removedElements.add((Integer) queue.get());
	    
	    // null
	    removedElements.add((Integer) queue.get());
	   	    
	    Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		Assert.assertEquals(Arrays.asList(new Integer[] {null, 1, 2, 3, 4, 5, null, 8, null}), removedElements);
	}
}