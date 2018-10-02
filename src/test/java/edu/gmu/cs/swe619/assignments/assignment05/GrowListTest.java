package edu.gmu.cs.swe619.assignments.assignment05;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class GrowListTest {
	
	@Test
	public void testSize() {
		// Test the empty grow list
		GrowList<String> growList = new GrowList<>();
		Assert.assertEquals(0, growList.size());
		
		// Test the one-element grow list
		growList.add("a");
		Assert.assertEquals(1, growList.size());

		// Test the two-element grow list
		growList.add("b");
		Assert.assertEquals(2, growList.size());
	}
	
	@Test
	public void testToString() {
		// Test the empty grow list
		GrowList<String> growList = new GrowList<>();
		Assert.assertEquals("[]", growList.toString());
		
		// Test the one-element grow list
		growList.add("a");
		Assert.assertEquals("[a]", growList.toString());

		// Test the two-element grow list
		growList.add("b");
		Assert.assertEquals("[a, b]", growList.toString());
	}
	
	@Test
	public void testGet() {
		// Test the one-element grow list
		GrowList<String> growList = new GrowList<>();
		growList.add("a");
		Assert.assertEquals("a", growList.get(0));

		// Test the two-element grow list
		growList.add("b");
		Assert.assertEquals("a", growList.get(0));
		Assert.assertEquals("b", growList.get(1));
	}
	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetInvalid1() {
		GrowList<Double> empty = new GrowList<>();
		empty.get(0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetInvalid2() {
		GrowList<Character> oneElement = new GrowList<Character>();
		oneElement.add('k');
		oneElement.get(1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetInvalid3() {
		GrowList<Boolean> nullElement = new GrowList<Boolean>();
		nullElement.add(null);
		nullElement.get(-1);
	}
	
	@Test
	public void testNullElement() {
		GrowList<String> nullElementList = new GrowList<>();
		nullElementList.add(null);
		
		String nullElement = nullElementList.get(0);
		
		Assert.assertEquals(1, nullElementList.size());
		Assert.assertNull(nullElement);
		Assert.assertEquals("[null]", nullElementList.toString());
	}
	
	@Test
	public void testSet() {
		GrowList<Integer> list1 = new GrowList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		// Test the original list
		Assert.assertEquals(4, list1.size());
		Assert.assertEquals(Integer.valueOf(1), list1.get(0));
		Assert.assertEquals(Integer.valueOf(2), list1.get(1));
		Assert.assertEquals(Integer.valueOf(3), list1.get(2));
		Assert.assertEquals(Integer.valueOf(4), list1.get(3));
		
		// Update the list
		list1.set(0, 10);
		list1.set(1, 20);
		list1.set(2, 30);
		list1.set(3, 40);
		

		
		// Test the new list
		Assert.assertEquals(4, list1.size());
		Assert.assertEquals(Integer.valueOf(10), list1.get(0));
		Assert.assertEquals(Integer.valueOf(20), list1.get(1));
		Assert.assertEquals(Integer.valueOf(30), list1.get(2));
		Assert.assertEquals(Integer.valueOf(40), list1.get(3));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetInvalid1() {
		GrowList<Double> empty = new GrowList<>();
		empty.set(0, 3.335);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetInvalid2() {
		GrowList<Character> oneElement = new GrowList<Character>();
		oneElement.add('k');
		oneElement.set(1, 'Z');
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetInvalid3() {
		GrowList<Boolean> nullElement = new GrowList<Boolean>();
		nullElement.add(null);
		nullElement.set(-1, false);
	}
	
	@Test
	public void testIterationEmpty() {
		GrowList<Double> growList = new GrowList<Double>();
		
		int totalIterations = 0;
		for(Double d : growList) {
			totalIterations++;
		}
		Assert.assertEquals(0, totalIterations);
	}
	
	@Test
	public void testHasNextEmpty() {
		GrowList<Double> growList = new GrowList<Double>();
		Assert.assertEquals(false, growList.iterator().hasNext());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testNextEmpty() {
		GrowList<Double> growList = new GrowList<Double>();
		growList.iterator().next();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testRemoveEmpty() {
		GrowList<Double> growList = new GrowList<Double>();
		growList.iterator().remove();
	}
	
	@Test
	public void testHasNextSingleElement() {
		GrowList<Double> growList = new GrowList<Double>();
		growList.add(3.14159);
		Assert.assertEquals(true, growList.iterator().hasNext());
	}
	
	@Test
	public void testNextSingleElement() {
		GrowList<String> growList = new GrowList<String>();
		growList.add("abc");
		Iterator<String> iter = growList.iterator();
		Assert.assertEquals(true, iter.hasNext());
		Assert.assertEquals("abc", iter.next());
		Assert.assertEquals(false, iter.hasNext());
	}
	
	@Test
	public void testRemoveSingleElement() {
		GrowList<String> growList = new GrowList<String>();		
		growList.add("To be deleted");
		Iterator<String> iter = growList.iterator();
		
		Assert.assertEquals(1, growList.size());
		Assert.assertEquals(true, iter.hasNext());
		Assert.assertEquals("To be deleted", iter.next());
		iter.remove();
		Assert.assertEquals(false, iter.hasNext());
		Assert.assertEquals(0, growList.size());
	}
	
	@Test
	public void testRemoveMultipleElements() {
		GrowList<String> growList = new GrowList<String>();		
		growList.add("To be deleted 0");
		growList.add("To be deleted 1");
		growList.add("To be deleted 2");
		growList.add("To be deleted 3");
		growList.add("To be deleted 4");
		Iterator<String> iter = growList.iterator();
		
		int size = 5;
		Assert.assertEquals(size, growList.size());
		int elementNumber = 0;
		while(iter.hasNext()) {
			String element = iter.next();
			Assert.assertEquals("To be deleted " + elementNumber, element);
			iter.remove();
			elementNumber++;
			size--;
			Assert.assertEquals(size, growList.size());
		}
		Assert.assertEquals(false, iter.hasNext());
		Assert.assertEquals(0, growList.size());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testIllegalStateRemove() {
		GrowList<Boolean> growList = new GrowList<Boolean>();		
		growList.add(false);
		growList.add(true);
		growList.add(true);
		Iterator<Boolean> iter = growList.iterator();
		
		iter.remove();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testDoubleRemove() {
		GrowList<Integer> growList = new GrowList<Integer>();		
		growList.add(351);
		growList.add(null);
		growList.add(353);
		Iterator<Integer> iter = growList.iterator();
		
		Assert.assertEquals(3, growList.size());
		Assert.assertEquals(true, iter.hasNext());
		Assert.assertEquals(351, iter.next().intValue());
		iter.remove();
		
		Assert.assertEquals(2, growList.size());
		Assert.assertEquals(true, iter.hasNext());
		Assert.assertEquals(null, iter.next());
		iter.remove();
		
		Assert.assertEquals(1, growList.size());
		Assert.assertEquals(true, iter.hasNext());
		// Did not call next()
		iter.remove();
	}
	
		
	@Test
	public void testMultipleElementIterator() {
		GrowList<String> growList = new GrowList<String>();
		growList.add("Dummy Element");
		growList.add("Test Element 2");
		growList.set(0, "Test Element 1");
		
		Iterator<String> iter = growList.iterator();
		Assert.assertEquals(true, iter.hasNext());
		Assert.assertEquals("Test Element 1", iter.next());
		Assert.assertEquals(true, iter.hasNext());
		Assert.assertEquals("Test Element 2", iter.next());
		Assert.assertEquals(false, iter.hasNext());
	}
	
	@Test
	public void testIteration10Elements() {
		GrowList<Integer> growList = new GrowList<Integer>();
		for(int i = 0; i < 10; i++) {
			growList.add(100 + i);
		}
		
		int k = 0;
		for(Integer g : growList) {
			Assert.assertEquals(k + 100, g.intValue());
			k++;
		}
	}
	

}
