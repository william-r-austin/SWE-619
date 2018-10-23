package edu.gmu.cs.swe619.assignments.assignment07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class ListSearchTest {
	
	@Test(expected = NullPointerException.class)
	public void testNullSearch() {
		ListIndexer<Boolean> listIndexer = null;
		SearchUtility.search(listIndexer, false);
	}

	@Test(expected = NoSuchElementException.class)
	public void testEmptyIndexerSearch() {
		List<String> stringList = new ArrayList<String>();
		ListIndexer<String> listIndexer = new ListIndexer<String>(stringList);
		SearchUtility.search(listIndexer, "cat");
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testEmptyIndexerNullSearch() {
		List<String> stringList = new ArrayList<String>();
		ListIndexer<String> listIndexer = new ListIndexer<String>(stringList);
		SearchUtility.search(listIndexer, null);
	}
	
	@Test
	public void testNullIndexerNullSearch() {
		List<String> stringList = new ArrayList<String>();
		stringList.add(null);
		stringList.add(null);
		stringList.add(null);
		ListIndexer<String> listIndexer = new ListIndexer<String>(stringList);
		int index = SearchUtility.search(listIndexer, null);
		Assert.assertEquals(0, index);
	}
	
	@Test
	public void testMixedIndexerSearch() {
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(100);
		myList.add(null);
		myList.add(200);
		myList.add(null);
		myList.add(300);
		myList.add(null);
		myList.add(400);
		myList.add(null);
		ListIndexer<Integer> listIndexer = new ListIndexer<Integer>(myList);
		
		int indexNull = SearchUtility.search(listIndexer, null);
		Assert.assertEquals(1, indexNull);
		
		int index100 = SearchUtility.search(listIndexer, 100);
		Assert.assertEquals(0, index100);
		
		int index200 = SearchUtility.search(listIndexer, 200);
		Assert.assertEquals(2, index200);
		
		int index300 = SearchUtility.search(listIndexer, 300);
		Assert.assertEquals(4, index300);
		
		int index400 = SearchUtility.search(listIndexer, 400);
		Assert.assertEquals(6, index400);
	}
	
	@Test
	public void testRepeatedElementsIndexerSearch() {
		List<String> myList = Arrays.asList(new String[]{"a", null, "b", "b", null, "c", "c", "c", null, "d", "d","d", "d"});
		
		ListIndexer<String> listIndexer = new ListIndexer<String>(myList);
		
		int indexNull = SearchUtility.search(listIndexer, null);
		Assert.assertEquals(1, indexNull);
		
		int aIndex = SearchUtility.search(listIndexer, "a");
		Assert.assertEquals(0, aIndex);
		
		int bIndex = SearchUtility.search(listIndexer, "b");
		Assert.assertEquals(2, bIndex);
		
		int cIndex = SearchUtility.search(listIndexer, "c");
		Assert.assertEquals(5, cIndex);
		
		int dIndex = SearchUtility.search(listIndexer, "d");
		Assert.assertEquals(9, dIndex);
	}
			
	@Test
	public void testBasicSearch() {
		List<String> stringList = Arrays.asList(new String[] {"a", "b", "c"});
		ListIndexer<String> listIndexer = new ListIndexer<String>(stringList);
		
		int aIndex = SearchUtility.search(listIndexer, "a");
		Assert.assertEquals(0, aIndex);
		
		int bIndex = SearchUtility.search(listIndexer, "b");
		Assert.assertEquals(1, bIndex);
		
		int cIndex = SearchUtility.search(listIndexer, "c");
		Assert.assertEquals(2, cIndex);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testBasicNotFoundSearch() {
		List<String> stringList = Arrays.asList(new String[] {"a", "b", "c"});
		ListIndexer<String> listIndexer = new ListIndexer<String>(stringList);
		
		SearchUtility.search(listIndexer, "d");
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testBasicNotFoundNullSearch() {
		List<String> stringList = Arrays.asList(new String[] {"a", "b", "c"});
		ListIndexer<String> listIndexer = new ListIndexer<String>(stringList);
		
		SearchUtility.search(listIndexer, null);
	}
}