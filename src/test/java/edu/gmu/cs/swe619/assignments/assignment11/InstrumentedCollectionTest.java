package edu.gmu.cs.swe619.assignments.assignment11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;


public class InstrumentedCollectionTest {
	
	@Test
	public void testCollectionEqualityWithSets() {
		Set<Integer> hashSet = new HashSet<>();
		hashSet.add(11);
		hashSet.add(22);
		hashSet.add(33);
		
		Set<Integer> treeSet = new TreeSet<>();
		treeSet.add(11);
		treeSet.add(22);
		treeSet.add(33);
		
		// Reflexivity holds
		Assert.assertTrue(hashSet.equals(hashSet));
		Assert.assertTrue(treeSet.equals(treeSet));
		
		// Commutativity holds
		Assert.assertTrue(hashSet.equals(treeSet));
		Assert.assertTrue(treeSet.equals(hashSet));
		
		InstrumentedCollection<Integer> setCollection1 = new InstrumentedCollection<>(hashSet);
		InstrumentedCollection<Integer> setCollection2 = new InstrumentedCollection<>(treeSet);
		
		// Reflexivity DOES NOT hold
		Assert.assertFalse(setCollection1.equals(setCollection1));
		Assert.assertFalse(setCollection2.equals(setCollection2));
		
		// Commutativity DOES NOT hold
		Assert.assertFalse(hashSet.equals(setCollection1));
		Assert.assertTrue(setCollection1.equals(hashSet));
		
		Assert.assertFalse(treeSet.equals(setCollection1));
		Assert.assertTrue(setCollection1.equals(treeSet));
		
		Assert.assertFalse(hashSet.equals(setCollection2));
		Assert.assertTrue(setCollection2.equals(hashSet));
		
		Assert.assertFalse(treeSet.equals(setCollection2));
		Assert.assertTrue(setCollection2.equals(treeSet));
		
		// The contract is also broken in the case of 2 
		// instrumented sets. This should return true.
		Assert.assertFalse(setCollection1.equals(setCollection2));
		Assert.assertFalse(setCollection2.equals(setCollection1));
	}
	
	@Test
	public void testCollectionEqualityWithLists() {
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(11);
		arrayList.add(22);
		arrayList.add(33);
		
		List<Integer> linkedList = new LinkedList<>();
		linkedList.add(11);
		linkedList.add(22);
		linkedList.add(33);
		
		// Reflexivity holds
		Assert.assertTrue(arrayList.equals(arrayList));
		Assert.assertTrue(linkedList.equals(linkedList));
		
		// Commutativity holds
		Assert.assertTrue(arrayList.equals(linkedList));
		Assert.assertTrue(linkedList.equals(arrayList));
		
		InstrumentedCollection<Integer> listCollection1 = new InstrumentedCollection<>(arrayList);
		InstrumentedCollection<Integer> listCollection2 = new InstrumentedCollection<>(linkedList);
		
		// Reflexivity DOES NOT hold
		Assert.assertFalse(listCollection1.equals(listCollection1));
		Assert.assertFalse(listCollection2.equals(listCollection2));
		
		// Commutativity DOES NOT hold
		Assert.assertFalse(arrayList.equals(listCollection1));
		Assert.assertTrue(listCollection1.equals(arrayList));
		
		Assert.assertFalse(linkedList.equals(listCollection1));
		Assert.assertTrue(listCollection1.equals(linkedList));
		
		Assert.assertFalse(arrayList.equals(listCollection2));
		Assert.assertTrue(listCollection2.equals(arrayList));
		
		Assert.assertFalse(linkedList.equals(listCollection2));
		Assert.assertTrue(listCollection2.equals(linkedList));
		
		// The contract is also broken in the case of 2
		// instrumented lists. This should return true.		
		Assert.assertFalse(listCollection1.equals(listCollection2));
		Assert.assertFalse(listCollection2.equals(listCollection1));
	}

}
