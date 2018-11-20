package edu.gmu.cs.swe619.assignments.assignment11;

import java.util.ArrayList;
import java.util.Collection;
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
		// Normal HashSet
		Set<Integer> hashSet = new HashSet<>();
		hashSet.add(11);
		hashSet.add(22);
		hashSet.add(33);
		
		// Normal TreeSet
		Set<Integer> treeSet = new TreeSet<>();
		treeSet.add(11);
		treeSet.add(22);
		treeSet.add(33);
		
		// Reflexivity holds for normal sets
		Assert.assertTrue(hashSet.equals(hashSet));
		Assert.assertTrue(treeSet.equals(treeSet));
		
		// Commutativity holds for normal sets
		Assert.assertTrue(hashSet.equals(treeSet));
		Assert.assertTrue(treeSet.equals(hashSet));
		
		// Create instrumented collections based on our existing sets
		Collection<Integer> setCollection1 = new InstrumentedCollection<>(hashSet);
		Collection<Integer> setCollection2 = new InstrumentedCollection<>(treeSet);
		
		// Reflexivity DOES NOT hold for instrumented collections
		Assert.assertFalse(setCollection1.equals(setCollection1));
		Assert.assertFalse(setCollection2.equals(setCollection2));
		
		// Commutativity DOES NOT hold for instrumented collections	
		Assert.assertFalse(setCollection1.equals(setCollection2));
		Assert.assertFalse(setCollection2.equals(setCollection1));
		
		// More examples showing commutativity DOES NOT hold for instrumented collections
		Assert.assertFalse(hashSet.equals(setCollection1));
		Assert.assertTrue(setCollection1.equals(hashSet));
		
		Assert.assertFalse(treeSet.equals(setCollection1));
		Assert.assertTrue(setCollection1.equals(treeSet));
		
		Assert.assertFalse(hashSet.equals(setCollection2));
		Assert.assertTrue(setCollection2.equals(hashSet));
		
		Assert.assertFalse(treeSet.equals(setCollection2));
		Assert.assertTrue(setCollection2.equals(treeSet));
	}
	
	@Test
	public void testCollectionEqualityWithLists() {
		// Normal ArrayList
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(11);
		arrayList.add(22);
		arrayList.add(33);
		
		// Normal LinkedList
		List<Integer> linkedList = new LinkedList<>();
		linkedList.add(11);
		linkedList.add(22);
		linkedList.add(33);
		
		// Reflexivity holds for normal lists
		Assert.assertTrue(arrayList.equals(arrayList));
		Assert.assertTrue(linkedList.equals(linkedList));
		
		// Commutativity holds for normal lists
		Assert.assertTrue(arrayList.equals(linkedList));
		Assert.assertTrue(linkedList.equals(arrayList));
		
		// Create instrumented collections based on our existing lists
		Collection<Integer> listCollection1 = new InstrumentedCollection<>(arrayList);
		Collection<Integer> listCollection2 = new InstrumentedCollection<>(linkedList);
		
		// Reflexivity DOES NOT hold for instrumented collections
		Assert.assertFalse(listCollection1.equals(listCollection1));
		Assert.assertFalse(listCollection2.equals(listCollection2));
		
		// Commutativity DOES NOT hold for instrumented collections		
		Assert.assertFalse(listCollection1.equals(listCollection2));
		Assert.assertFalse(listCollection2.equals(listCollection1));
		
		// More examples showing commutativity DOES NOT hold for instrumented collections
		Assert.assertFalse(arrayList.equals(listCollection1));
		Assert.assertTrue(listCollection1.equals(arrayList));
		
		Assert.assertFalse(linkedList.equals(listCollection1));
		Assert.assertTrue(listCollection1.equals(linkedList));
		
		Assert.assertFalse(arrayList.equals(listCollection2));
		Assert.assertTrue(listCollection2.equals(arrayList));
		
		Assert.assertFalse(linkedList.equals(listCollection2));
		Assert.assertTrue(listCollection2.equals(linkedList));
		

	}

}
