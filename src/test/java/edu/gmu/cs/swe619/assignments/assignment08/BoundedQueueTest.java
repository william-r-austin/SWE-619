package edu.gmu.cs.swe619.assignments.assignment08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BoundedQueueTest {
	
	@Test
	public void negativeSizeQueueTest() {
		BoundedQueue<String> queue = new BoundedQueue<>(-1);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		Assert.assertEquals(0, queue.getCount());

		queue.put("This is a test value.");
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
				
		String x = queue.get();
		Assert.assertNull(x);
	}
	
	@Test
	public void zeroSizeQueueTest() {
		BoundedQueue<String> queue = new BoundedQueue<>(0);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		Assert.assertEquals(0, queue.getCount());

		queue.put("This is a test value.");
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
				
		String x = queue.get();
		Assert.assertNull(x);
	}
	
	@Test
	public void sizeOneQueueTest() {
		BoundedQueue<String> queue = new BoundedQueue<>(1);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());

		queue.put("This is a test value.");
		Assert.assertEquals(false, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		Assert.assertEquals(1, queue.getCount());
				
		String x = queue.get();
		Assert.assertEquals("This is a test value.", x);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
	}
	
	@Test
	public void sizeFiveQueueTest() {
		BoundedQueue<Integer> queue = new BoundedQueue<>(5);
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
			Integer x = queue.get();
			
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
	public void putAllgetAllTest1() {
		List<String> newStrings = Arrays.asList(new String[] {"x", "y", "z"});
		
		BoundedQueue<String> queue = new BoundedQueue<>(5);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		
		queue.putAll(newStrings);
		Assert.assertEquals(false, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(3, queue.getCount());
		
		List<String> queueContents = queue.getAll();
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		Assert.assertEquals(newStrings, queueContents);
	}
	
	@Test
	public void putAllgetAllTest2() {
		List<String> newStrings = Arrays.asList(new String[] {"x", "y", "z"});
		
		BoundedQueue<String> queue = new BoundedQueue<>(2);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		
		queue.put("a");
		queue.put("b");
		Assert.assertEquals(false, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		Assert.assertEquals(2, queue.getCount());
				
		queue.putAll(newStrings);
		Assert.assertEquals(false, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		Assert.assertEquals(2, queue.getCount());
		
		List<String> queueContents = queue.getAll();
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		Assert.assertEquals(Arrays.asList(new String[] {"a", "b"}), queueContents);
	}
	
	@Test
	public void putAllgetAllTest3() {
		List<String> newStrings = Arrays.asList(new String[] {"x", "y", "z"});
		
		BoundedQueue<String> queue = new BoundedQueue<>(5);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		
		queue.put("a");
		queue.put("b");
		queue.put("c");
		Assert.assertEquals(false, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(3, queue.getCount());
				
		queue.putAll(newStrings);
		Assert.assertEquals(false, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		Assert.assertEquals(5, queue.getCount());
		
		List<String> queueContents = queue.getAll();
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		Assert.assertEquals(Arrays.asList(new String[] {"a", "b", "c", "x", "y"}), queueContents);
	}
	
	@Test
	public void putAllgetAllTest4() {
		List<String> newStrings = Arrays.asList(new String[] {null, null, null});
		
		BoundedQueue<String> queue = new BoundedQueue<>(5);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		
		// Nothing added
		queue.putAll(newStrings);
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		
		List<String> queueContents = queue.getAll();
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		Assert.assertEquals(new ArrayList<String>(), queueContents);
	}
	
	@Test
	public void putNullElementsTest() {
		BoundedQueue<Boolean> queue = new BoundedQueue<>(4);
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
		
		List<Boolean> queueContents = queue.getAll();
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		Assert.assertEquals(Arrays.asList(new Boolean[] {false, true, false, true}), queueContents);
	}
	
	@Test
	public void boundedQueueTest() {
	    BoundedQueue<Integer> queue = new BoundedQueue<>(4);
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
            Integer queueElement = queue.get();
            removedElements.add(queueElement);
        }
        
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		Assert.assertEquals(Arrays.asList(new Integer[] {1, 2, 3, 4}), removedElements);
	}
	
	@Test
	public void mixedTest() {
	    BoundedQueue<Integer> queue = new BoundedQueue<>(3);
	    List<Integer> removedElements = new ArrayList<>();
		
	    // null
	    removedElements.add(queue.get());
	    
	    queue.put(1);
	    queue.put(2);
	    
	    // 1
	    removedElements.add(queue.get());
	    
	    queue.put(3);
	    
	    // 2
	    removedElements.add(queue.get());
	    
	    // Not added
	    queue.put(null);
	    
	    queue.put(4);
	    queue.put(5);
	    
	    // Not added
	    queue.put(6);
	    queue.put(7);
	    
	    // 3
	    removedElements.add(queue.get());
	    
	    // 4
	    removedElements.add(queue.get());
	    
	    // 5
	    removedElements.add(queue.get());
	    
	    // null
	    removedElements.add(queue.get());
	    
	    queue.put(8);
	    
	    // 8
	    removedElements.add(queue.get());
	    
	    // null
	    removedElements.add(queue.get());
	   	    
	    Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		Assert.assertEquals(0, queue.getCount());
		Assert.assertEquals(Arrays.asList(new Integer[] {null, 1, 2, 3, 4, 5, null, 8, null}), removedElements);
	}
}