package edu.gmu.cs.swe619.assignments.assignment07;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ListIndexerTest {

	@Test(expected = NullPointerException.class)
	public void testNullIndexer() {
		new ListIndexer<Boolean>(null);
	}
	
	@Test
	public void testEmptyIndexer() {
		List<String> myList = Arrays.asList(new String[]{});
		ListIndexer<String> listIndexer = new ListIndexer<String>(myList);
		Assert.assertEquals(0, listIndexer.size());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetNegativeIndexForEmpty() {
		List<String> myList = Arrays.asList(new String[]{});
		ListIndexer<String> listIndexer = new ListIndexer<String>(myList);
		Assert.assertEquals(0, listIndexer.size());
		listIndexer.get(-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet0IndexForEmpty() {
		List<String> myList = Arrays.asList(new String[]{});
		ListIndexer<String> listIndexer = new ListIndexer<String>(myList);
		Assert.assertEquals(0, listIndexer.size());
		listIndexer.get(0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetInvalidIndexForNonempty() {
		List<String> myList = Arrays.asList(new String[]{"a", "b", "c"});
		ListIndexer<String> listIndexer = new ListIndexer<String>(myList);
		Assert.assertEquals(3, listIndexer.size());
		listIndexer.get(3);
	}
	
	@Test
	public void testListIndexForNonempty() {
		List<String> myList = Arrays.asList(new String[]{"a", "b", "c"});
		ListIndexer<String> listIndexer = new ListIndexer<String>(myList);
		Assert.assertEquals(3, listIndexer.size());
		Assert.assertEquals("a", listIndexer.get(0));
		Assert.assertEquals("b", listIndexer.get(1));
		Assert.assertEquals("c", listIndexer.get(2));
	}
}
