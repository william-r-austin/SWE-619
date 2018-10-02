package edu.gmu.cs.swe619.assignments.assignment05;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class GrowListWithRemoveTest {
	
	@Test
	public void testSize() {
		// Test the empty grow list
		GrowListWithRemove<String> GrowListWithRemove = new GrowListWithRemove<>();
		Assert.assertEquals(0, GrowListWithRemove.size());
		
		// Test the one-element grow list
		GrowListWithRemove.add("a");
		Assert.assertEquals(1, GrowListWithRemove.size());

		// Test the two-element grow list
		GrowListWithRemove.add("b");
		Assert.assertEquals(2, GrowListWithRemove.size());
	}
	
	@Test
	public void testToString() {
		// Test the empty grow list
		GrowListWithRemove<String> GrowListWithRemove = new GrowListWithRemove<>();
		Assert.assertEquals("[]", GrowListWithRemove.toString());
		
		// Test the one-element grow list
		GrowListWithRemove.add("a");
		Assert.assertEquals("[a]", GrowListWithRemove.toString());

		// Test the two-element grow list
		GrowListWithRemove.add("b");
		Assert.assertEquals("[a, b]", GrowListWithRemove.toString());
	}
	
	@Test
	public void testGet() {
		// Test the one-element grow list
		GrowListWithRemove<String> GrowListWithRemove = new GrowListWithRemove<>();
		GrowListWithRemove.add("a");
		Assert.assertEquals("a", GrowListWithRemove.get(0));

		// Test the two-element grow list
		GrowListWithRemove.add("b");
		Assert.assertEquals("a", GrowListWithRemove.get(0));
		Assert.assertEquals("b", GrowListWithRemove.get(1));
	}
	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetInvalid1() {
		GrowListWithRemove<Double> empty = new GrowListWithRemove<>();
		empty.get(0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetInvalid2() {
		GrowListWithRemove<Character> oneElement = new GrowListWithRemove<Character>();
		oneElement.add('k');
		oneElement.get(1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetInvalid3() {
		GrowListWithRemove<Boolean> nullElement = new GrowListWithRemove<Boolean>();
		nullElement.add(null);
		nullElement.get(-1);
	}
	
	@Test
	public void testNullElement() {
		GrowListWithRemove<String> nullElementList = new GrowListWithRemove<>();
		nullElementList.add(null);
		
		String nullElement = nullElementList.get(0);
		
		Assert.assertEquals(1, nullElementList.size());
		Assert.assertNull(nullElement);
		Assert.assertEquals("[null]", nullElementList.toString());
	}
	
	@Test
	public void testSet() {
		GrowListWithRemove<Integer> list1 = new GrowListWithRemove<Integer>();
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
		GrowListWithRemove<Double> empty = new GrowListWithRemove<>();
		empty.set(0, 3.335);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetInvalid2() {
		GrowListWithRemove<Character> oneElement = new GrowListWithRemove<Character>();
		oneElement.add('k');
		oneElement.set(1, 'Z');
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetInvalid3() {
		GrowListWithRemove<Boolean> nullElement = new GrowListWithRemove<Boolean>();
		nullElement.add(null);
		nullElement.set(-1, false);
	}
	
	@Test
	public void testIterationEmpty() {
		GrowListWithRemove<Double> GrowListWithRemove = new GrowListWithRemove<Double>();
		
		int totalIterations = 0;
		for(Double d : GrowListWithRemove) {
			totalIterations++;
		}
		Assert.assertEquals(0, totalIterations);
	}
	
	@Test
	public void testHasNextEmpty() {
		GrowListWithRemove<Double> GrowListWithRemove = new GrowListWithRemove<Double>();
		Assert.assertEquals(false, GrowListWithRemove.iterator().hasNext());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testNextEmpty() {
		GrowListWithRemove<Double> GrowListWithRemove = new GrowListWithRemove<Double>();
		GrowListWithRemove.iterator().next();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testRemoveEmpty() {
		GrowListWithRemove<Double> GrowListWithRemove = new GrowListWithRemove<Double>();
		GrowListWithRemove.iterator().remove();
	}
	
	@Test
	public void testHasNextSingleElement() {
		GrowListWithRemove<Double> GrowListWithRemove = new GrowListWithRemove<Double>();
		GrowListWithRemove.add(3.14159);
		Assert.assertEquals(true, GrowListWithRemove.iterator().hasNext());
	}
	
	@Test
	public void testNextSingleElement() {
		GrowListWithRemove<String> GrowListWithRemove = new GrowListWithRemove<String>();
		GrowListWithRemove.add("abc");
		Iterator<String> iter = GrowListWithRemove.iterator();
		Assert.assertEquals(true, iter.hasNext());
		Assert.assertEquals("abc", iter.next());
		Assert.assertEquals(false, iter.hasNext());
	}
	
	@Test
	public void testRemoveSingleElement() {
		GrowListWithRemove<String> GrowListWithRemove = new GrowListWithRemove<String>();		
		GrowListWithRemove.add("To be deleted");
		Iterator<String> iter = GrowListWithRemove.iterator();
		
		Assert.assertEquals(1, GrowListWithRemove.size());
		Assert.assertEquals(true, iter.hasNext());
		Assert.assertEquals("To be deleted", iter.next());
		iter.remove();
		Assert.assertEquals(false, iter.hasNext());
		Assert.assertEquals(0, GrowListWithRemove.size());
	}
	
	@Test
	public void testRemoveMultipleElements() {
		GrowListWithRemove<String> GrowListWithRemove = new GrowListWithRemove<String>();		
		GrowListWithRemove.add("To be deleted 0");
		GrowListWithRemove.add("To be deleted 1");
		GrowListWithRemove.add("To be deleted 2");
		GrowListWithRemove.add("To be deleted 3");
		GrowListWithRemove.add("To be deleted 4");
		Iterator<String> iter = GrowListWithRemove.iterator();
		
		int size = 5;
		Assert.assertEquals(size, GrowListWithRemove.size());
		int elementNumber = 0;
		while(iter.hasNext()) {
			String element = iter.next();
			Assert.assertEquals("To be deleted " + elementNumber, element);
			iter.remove();
			elementNumber++;
			size--;
			Assert.assertEquals(size, GrowListWithRemove.size());
		}
		Assert.assertEquals(false, iter.hasNext());
		Assert.assertEquals(0, GrowListWithRemove.size());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testIllegalStateRemove() {
		GrowListWithRemove<Boolean> GrowListWithRemove = new GrowListWithRemove<Boolean>();		
		GrowListWithRemove.add(false);
		GrowListWithRemove.add(true);
		GrowListWithRemove.add(true);
		Iterator<Boolean> iter = GrowListWithRemove.iterator();
		
		iter.remove();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testDoubleRemove() {
		GrowListWithRemove<Integer> GrowListWithRemove = new GrowListWithRemove<Integer>();		
		GrowListWithRemove.add(351);
		GrowListWithRemove.add(null);
		GrowListWithRemove.add(353);
		Iterator<Integer> iter = GrowListWithRemove.iterator();
		
		Assert.assertEquals(3, GrowListWithRemove.size());
		Assert.assertEquals(true, iter.hasNext());
		Assert.assertEquals(351, iter.next().intValue());
		iter.remove();
		
		Assert.assertEquals(2, GrowListWithRemove.size());
		Assert.assertEquals(true, iter.hasNext());
		Assert.assertEquals(null, iter.next());
		iter.remove();
		
		Assert.assertEquals(1, GrowListWithRemove.size());
		Assert.assertEquals(true, iter.hasNext());
		// Did not call next()
		iter.remove();
	}
	
		
	@Test
	public void testMultipleElementIterator() {
		GrowListWithRemove<String> GrowListWithRemove = new GrowListWithRemove<String>();
		GrowListWithRemove.add("Dummy Element");
		GrowListWithRemove.add("Test Element 2");
		GrowListWithRemove.set(0, "Test Element 1");
		
		Iterator<String> iter = GrowListWithRemove.iterator();
		Assert.assertEquals(true, iter.hasNext());
		Assert.assertEquals("Test Element 1", iter.next());
		Assert.assertEquals(true, iter.hasNext());
		Assert.assertEquals("Test Element 2", iter.next());
		Assert.assertEquals(false, iter.hasNext());
	}
	
	@Test
	public void testIteration10Elements() {
		GrowListWithRemove<Integer> GrowListWithRemove = new GrowListWithRemove<Integer>();
		for(int i = 0; i < 10; i++) {
			GrowListWithRemove.add(100 + i);
		}
		
		int k = 0;
		for(Integer g : GrowListWithRemove) {
			Assert.assertEquals(k + 100, g.intValue());
			k++;
		}
	}
	

}
