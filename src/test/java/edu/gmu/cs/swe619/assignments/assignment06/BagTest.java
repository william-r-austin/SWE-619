package edu.gmu.cs.swe619.assignments.assignment06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class BagTest {
	
	/**
	 * This JUnit shows that sets do not contain duplicates. Because of this, the remove() method is
	 * guaranteed to remove the given element from the set.
	 */
	@Test
	public void testPropertiesRuleSet() {
		Set<Integer> testSet = new HashSet<Integer>();

		testSet.add(100);
		testSet.add(100);
		testSet.add(100);
		Assert.assertEquals(1, testSet.size());
		
		testSet.remove(100);
		Assert.assertFalse(testSet.contains(100));
	}
	
	/**
	 * This JUnit shows that multisets/bags can contain duplicates, and the remove() method will only
	 * remove one copy of the given element from the data structure.
	 * 
	 * This behavior violates the Substitution Principle!!
	 */	
	@Test
	public void testPropertiesRuleBag() {
		Bag<Integer> testBag = new Bag<Integer>();
		testBag.insert(100);
		testBag.insert(100);
		testBag.insert(100);
		
		Assert.assertEquals(3, testBag.size());
		
		testBag.remove(100);
		Assert.assertTrue(testBag.isIn(100));
	}
	
	@Test
	public void testEmptySize() {
		Bag<Boolean> test = new Bag<Boolean>();
		Assert.assertEquals(0, test.size());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testEmptyChoose() {
		Bag<Boolean> test = new Bag<Boolean>();
		test.choose();
	}
	
	@Test
	public void testOneFalse() {
		Bag<Boolean> test = new Bag<Boolean>();
		Assert.assertEquals(0, test.size());
		
		test.insert(Boolean.FALSE);
		Assert.assertEquals(1, test.size());
		Assert.assertTrue(test.isIn(Boolean.FALSE));
	}
	
	@Test
	public void testOneFalseOneTrue() {
		Bag<Boolean> test = new Bag<Boolean>();
		Assert.assertEquals(0, test.size());
		Assert.assertFalse(test.isIn(Boolean.TRUE));
		Assert.assertFalse(test.isIn(Boolean.FALSE));
		
		test.insert(Boolean.TRUE);
		Assert.assertEquals(1, test.size());
		Assert.assertTrue(test.isIn(Boolean.TRUE));
		Assert.assertFalse(test.isIn(Boolean.FALSE));
		
		test.insert(Boolean.FALSE);
		Assert.assertEquals(2, test.size());
		Assert.assertTrue(test.isIn(Boolean.TRUE));
		Assert.assertTrue(test.isIn(Boolean.FALSE));
	}
	
	@Test
	public void testTwoFalse() {
		Bag<Boolean> test = new Bag<Boolean>();
		Assert.assertEquals(0, test.size());
		Assert.assertFalse(test.isIn(Boolean.TRUE));
		Assert.assertFalse(test.isIn(Boolean.FALSE));
		
		test.insert(Boolean.FALSE);
		Assert.assertEquals(1, test.size());
		Assert.assertFalse(test.isIn(Boolean.TRUE));
		Assert.assertTrue(test.isIn(Boolean.FALSE));
		
		test.insert(Boolean.FALSE);
		Assert.assertEquals(2, test.size());
		Assert.assertFalse(test.isIn(Boolean.TRUE));
		Assert.assertTrue(test.isIn(Boolean.FALSE));
	}
	
	@Test
	public void testNullBag() {
		Bag<String> test = new Bag<String>();
		Assert.assertEquals(0, test.size());
		Assert.assertFalse(test.isIn(null));
		
		// First Element
		test.insert(null);
		Assert.assertEquals(1, test.size());
		Assert.assertTrue(test.isIn(null));
		String x = test.choose();
		Assert.assertEquals(null, x);
		
		// Second Element
		test.insert(null);
		Assert.assertEquals(2, test.size());
		Assert.assertTrue(test.isIn(null));
		x = test.choose();
		Assert.assertEquals(null, x);
		
		// Remove Second
		test.remove(null);
		Assert.assertEquals(1, test.size());
		Assert.assertTrue(test.isIn(null));
		x = test.choose();
		Assert.assertEquals(null, x);
		
		// Remove First
		test.remove(null);
		Assert.assertEquals(0, test.size());
		Assert.assertFalse(test.isIn(null));
	}
	
	@Test
	public void animalsTest() {
		int copies = 5;
		List<String> animals = Arrays.asList(new String[] {"cat", "dog", "bird"});
				
		Bag<String> test = new Bag<String>();
		for(int i = 1; i <= copies; i++) {
			for(String a : animals) {
				test.insert(a);
				Assert.assertTrue(test.isIn(a));
			}
			Assert.assertEquals(animals.size() * i, test.size());
			String x = test.choose();
			boolean validAnimal = animals.contains(x);
			Assert.assertTrue(validAnimal);
		}
		
		Set<String> removed = new HashSet<String>();
		for(String a : animals) {
			String x = test.choose();
			boolean containsRemoved = removed.contains(x);
			Assert.assertFalse(containsRemoved);
			
			removed.add(a);
			for(int i = 1; i <= copies; i++) {
				test.remove(a);
			}
			
			Assert.assertFalse(test.isIn(a));
		}
		
		Assert.assertEquals(0, test.size());
	}
	
	@Test
	public void testToString() {
		Bag<String> test = new Bag<String>();
		Assert.assertEquals("{}", test.toString());
		
		test.insert("dog");
		Assert.assertEquals("{dog=1}", test.toString());
		
		test.insert("dog");
		Assert.assertEquals("{dog=2}", test.toString());
		
		test.remove("dog");
		Assert.assertEquals("{dog=1}", test.toString());
		
		test.remove("dog");
		Assert.assertEquals("{}", test.toString());
	}
}
