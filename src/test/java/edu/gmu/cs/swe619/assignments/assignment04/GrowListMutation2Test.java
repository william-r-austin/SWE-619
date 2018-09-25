package edu.gmu.cs.swe619.assignments.assignment04;

import org.junit.Assert;
import org.junit.Test;

public class GrowListMutation2Test {
	
	@Test
	public void testSize() {
		// Test the empty grow list
		GrowListMutation2<String> growList = new GrowListMutation2<>();
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
		GrowListMutation2<String> growList = new GrowListMutation2<>();
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
		GrowListMutation2<String> growList = new GrowListMutation2<>();
		growList.add("a");
		Assert.assertEquals("a", growList.get(0));

		// Test the two-element grow list
		growList.add("b");
		Assert.assertEquals("a", growList.get(0));
		Assert.assertEquals("b", growList.get(1));
	}
	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetInvalid1() {
		GrowListMutation2<Double> empty = new GrowListMutation2<>();
		empty.get(0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetInvalid2() {
		GrowListMutation2<Character> oneElement = new GrowListMutation2<Character>();
		oneElement.add('k');
		oneElement.get(1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetInvalid3() {
		GrowListMutation2<Boolean> nullElement = new GrowListMutation2<Boolean>();
		nullElement.add(null);
		nullElement.get(-1);
	}
	
	@Test
	public void testNullElement() {
		GrowListMutation2<String> nullElementList = new GrowListMutation2<>();
		nullElementList.add(null);
		
		String nullElement = nullElementList.get(0);
		
		Assert.assertEquals(1, nullElementList.size());
		Assert.assertNull(nullElement);
		Assert.assertEquals("[null]", nullElementList.toString());
	}
	
	@Test
	public void testSet() {
		GrowListMutation2<Integer> list1 = new GrowListMutation2<Integer>();
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
		GrowListMutation2<Double> empty = new GrowListMutation2<>();
		empty.set(0, 3.335);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetInvalid2() {
		GrowListMutation2<Character> oneElement = new GrowListMutation2<Character>();
		oneElement.add('k');
		oneElement.set(1, 'Z');
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetInvalid3() {
		GrowListMutation2<Boolean> nullElement = new GrowListMutation2<Boolean>();
		nullElement.add(null);
		nullElement.set(-1, false);
	}
}
