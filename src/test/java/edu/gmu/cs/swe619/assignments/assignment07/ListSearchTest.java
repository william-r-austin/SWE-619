package edu.gmu.cs.swe619.assignments.assignment07;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ListSearchTest {
	
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
}