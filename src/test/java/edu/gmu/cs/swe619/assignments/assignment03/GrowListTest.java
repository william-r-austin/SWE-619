package edu.gmu.cs.swe619.assignments.assignment03;

import org.junit.Assert;
import org.junit.Test;

public class GrowListTest {
	
	@Test
	public void testSize() {
		GrowList<String> empty = new GrowList<>();
		GrowList<String> aList = empty.add("a");
		GrowList<String> abList = aList.add("b");

		// Test the empty grow list
		Assert.assertEquals(0, empty.size());
		
		// Test the one-element grow list
		Assert.assertEquals(1, aList.size());

		// Test the two-element grow list
		Assert.assertEquals(2, abList.size());
	}
	
	@Test
	public void testToString() {
		GrowList<String> empty = new GrowList<>();
		GrowList<String> aList = empty.add("a");
		GrowList<String> abList = aList.add("b");

		// Test the empty grow list
		Assert.assertEquals("[]", empty.toString());
		
		// Test the one-element grow list
		Assert.assertEquals("[a]", aList.toString());

		// Test the two-element grow list
		Assert.assertEquals("[a, b]", abList.toString());
	}
	
	@Test
	public void testGet() {
		GrowList<String> empty = new GrowList<>();
		GrowList<String> aList = empty.add("a");
		GrowList<String> abList = aList.add("b");
		
		// Test the one-element grow list
		Assert.assertEquals("a", aList.get(0));

		// Test the two-element grow list
		Assert.assertEquals("a", abList.get(0));
		Assert.assertEquals("b", abList.get(1));
	}
	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetInvalid1() {
		GrowList<Double> empty = new GrowList<>();
		empty.get(0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetInvalid2() {
		GrowList<Character> empty = new GrowList<Character>().add('k');
		empty.get(1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetInvalid3() {
		GrowList<Boolean> empty = new GrowList<Boolean>().add(null);
		empty.get(-1);
	}
	
	@Test
	public void testNullElement() {
		GrowList<String> empty = new GrowList<>();
		GrowList<String> nullElementList = empty.add(null);
		
		String nullElement = nullElementList.get(0);
		
		Assert.assertEquals(1, nullElementList.size());
		Assert.assertNull(nullElement);
		Assert.assertEquals("[null]", nullElementList.toString());
	}
	
	@Test
	public void testSet() {
		GrowList<Integer> list1 = new GrowList<Integer>().add(1).add(2).add(3).add(4);
		GrowList<Integer> list2 = list1.set(0, 10).set(1, 20).set(2, 30).set(3, 40);
		
		// Test the original list
		Assert.assertEquals(4, list1.size());
		Assert.assertEquals(Integer.valueOf(1), list1.get(0));
		Assert.assertEquals(Integer.valueOf(2), list1.get(1));
		Assert.assertEquals(Integer.valueOf(3), list1.get(2));
		Assert.assertEquals(Integer.valueOf(4), list1.get(3));
		
		// Test the new list
		Assert.assertEquals(4, list2.size());
		Assert.assertEquals(Integer.valueOf(10), list2.get(0));
		Assert.assertEquals(Integer.valueOf(20), list2.get(1));
		Assert.assertEquals(Integer.valueOf(30), list2.get(2));
		Assert.assertEquals(Integer.valueOf(40), list2.get(3));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetInvalid1() {
		GrowList<Double> empty = new GrowList<>();
		empty.set(0, 3.335);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetInvalid2() {
		GrowList<Character> empty = new GrowList<Character>().add('k');
		empty.set(1, 'Z');
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetInvalid3() {
		GrowList<Boolean> empty = new GrowList<Boolean>().add(null);
		empty.set(-1, false);
	}
}
