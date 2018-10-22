package edu.gmu.cs.swe619.assignments.assignment07;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class CollectionSearchTest {
	
	@Test
	public void testSearchSet() {
		Set<String> testSet = new HashSet<String>();
		testSet.add("dog");
		testSet.add("cat");
		testSet.add("bird");
		
		CollectionIndexer<String> indexer = new CollectionIndexer<>(testSet);
		int searchResult = SearchUtility.search(indexer, "bird");
		System.out.println("Search Result = " + searchResult);
		Assert.assertTrue(searchResult >= 0);
	}

}
