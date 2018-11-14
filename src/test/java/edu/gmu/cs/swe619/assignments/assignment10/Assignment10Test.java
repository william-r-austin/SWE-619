package edu.gmu.cs.swe619.assignments.assignment10;

import org.junit.Assert;
import org.junit.Test;

public class Assignment10Test {
	
	// Test #1
	@Test
	public void testLiskovClone() {
		IntSetLiskov myIntSet = new IntSetLiskov();
		IntSetLiskov copy = myIntSet.clone();
		Assert.assertTrue(myIntSet.equals(copy));
		Assert.assertTrue(myIntSet.hashCode() == copy.hashCode());
		Assert.assertTrue(myIntSet != copy);
	}
	
	// Test #2
	@Test(expected = ClassCastException.class)
	public void testBrokenSpecializedLiskovClone() {
		SpecializedIntSetLiskov myIntSet = new SpecializedIntSetLiskov();
		myIntSet.clone();
	}
	
	// Test #3
	@Test
	public void testCorrectIntSetClone() {
		IntSet emptyIntSet = new IntSet();
		IntSet emptyCopy = emptyIntSet.clone();
		Assert.assertTrue(emptyIntSet.equals(emptyCopy));
		Assert.assertTrue(emptyIntSet.hashCode() == emptyCopy.hashCode());
		Assert.assertTrue(emptyIntSet != emptyCopy);
		
		IntSet populatedIntSet = new IntSet();
		populatedIntSet.insert(1);
		populatedIntSet.insert(5);
		populatedIntSet.insert(8);
		IntSet populatedCopy = populatedIntSet.clone();
		Assert.assertTrue(populatedIntSet.equals(populatedCopy));
		Assert.assertTrue(populatedIntSet.hashCode() == populatedCopy.hashCode());
		Assert.assertTrue(populatedIntSet != populatedCopy);
	}
	
	// Test #4
	@Test
	public void testCorrectSpecializedClone() {
		SpecializedIntSet emptyIntSet = new SpecializedIntSet("Test string");
		SpecializedIntSet emptyCopy = emptyIntSet.clone();
		Assert.assertTrue(emptyIntSet.equals(emptyCopy));
		Assert.assertTrue(emptyIntSet.hashCode() == emptyCopy.hashCode());
		Assert.assertTrue(emptyIntSet != emptyCopy);
		
		SpecializedIntSet populatedIntSet = new SpecializedIntSet("Test string");
		populatedIntSet.insert(1);
		populatedIntSet.insert(5);
		populatedIntSet.insert(8);
		SpecializedIntSet populatedCopy = populatedIntSet.clone();
		Assert.assertTrue(populatedIntSet.equals(populatedCopy));
		Assert.assertTrue(populatedIntSet.hashCode() == populatedCopy.hashCode());
		Assert.assertTrue(populatedIntSet != populatedCopy);
	}
	
	// Test #5
	@Test
	public void testBasicIntSet() {
		// Initialize a new IntSet
		IntSet myIntSet = new IntSet();
		Assert.assertEquals(0, myIntSet.size());
		
		// Add a new element
		myIntSet.insert(4);
		Assert.assertTrue(myIntSet.isIn(4));
		Assert.assertEquals(1, myIntSet.size());
				
		// Add another element
		myIntSet.insert(5);
		Assert.assertTrue(myIntSet.isIn(4));
		Assert.assertTrue(myIntSet.isIn(5));
		Assert.assertEquals(2, myIntSet.size());
		
		// Add a third element
		myIntSet.insert(6);
		Assert.assertTrue(myIntSet.isIn(4));
		Assert.assertTrue(myIntSet.isIn(5));
		Assert.assertTrue(myIntSet.isIn(6));
		Assert.assertEquals(3, myIntSet.size());
		
		// Remove the first element
		myIntSet.remove(4);
		Assert.assertFalse(myIntSet.isIn(4));
		Assert.assertTrue(myIntSet.isIn(5));
		Assert.assertTrue(myIntSet.isIn(6));
		Assert.assertEquals(2, myIntSet.size());
		
		// Add an element that is already present
		myIntSet.insert(5);
		Assert.assertTrue(myIntSet.isIn(5));
		Assert.assertTrue(myIntSet.isIn(6));
		Assert.assertEquals(2, myIntSet.size());
	}
	
	// Test #6
	@Test
	public void testEqualIntSets() {		
		IntSet set1 = new IntSet();
		set1.insert(45);
		set1.insert(46);
		
		IntSet set2 = new IntSet();
		set2.insert(45);
		set2.insert(46);
		
		// Test reflexive property
		Assert.assertTrue(set1.equals(set1));
		Assert.assertTrue(set2.equals(set2));
		
		// Test null equality
		Assert.assertFalse(set1.equals(null));
		Assert.assertFalse(set2.equals(null));
		
		// Test Commutativity
		Assert.assertTrue(set1.equals(set2));
		Assert.assertTrue(set2.equals(set1));
		
		// Test object equals
		Assert.assertTrue(set1 == set1);
		Assert.assertTrue(set2 == set2);
		Assert.assertFalse(set1 == set2);
		
		// Verify that toString() and hashCode() are the same
		Assert.assertEquals(set1.hashCode(), set2.hashCode());
		Assert.assertEquals(set1.toString(), set2.toString());
	}
	
	// Test #7
	@Test
	public void testEqualIntSetsWithDifferentRep() {		
		IntSet set1 = new IntSet();
		set1.insert(55);
		set1.insert(56);
		
		IntSet set2 = new IntSet();
		set2.insert(56);
		set2.insert(55);
		
		// Test Commutativity
		Assert.assertTrue(set1.equals(set2));
		Assert.assertTrue(set2.equals(set1));
		
		// Verify that toString() and hashCode() are the same
		Assert.assertEquals(set1.hashCode(), set2.hashCode());
		Assert.assertNotEquals(set1.toString(), set2.toString());
	}
	
	// Test #8
	@Test
	public void testDifferentIntSets() {
		IntSet set1 = new IntSet();
		set1.insert(99);
		
		IntSet set2 = new IntSet();
		set2.insert(100);
		
		// Test Commutativity
		Assert.assertFalse(set1.equals(set2));
		Assert.assertFalse(set2.equals(set1));
		
		// Verify that toString() and hashCode() are the same
		Assert.assertNotEquals(set1.hashCode(), set2.hashCode());
		Assert.assertNotEquals(set1.toString(), set2.toString());
	}
}
