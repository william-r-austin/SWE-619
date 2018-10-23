package edu.gmu.cs.swe619.assignments.assignment07;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

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
		Assert.assertEquals(3, indexer.size());
		int searchResult = SearchUtility.search(indexer, "bird");
		Assert.assertTrue(searchResult >= 0);
	}
	
	@Test
	public void testSearchVector() {
		Vector<String> testVector = new Vector<String>();
		testVector.add("dog");
		testVector.add("cat");
		testVector.add("bird");
		testVector.add(null);
		
		CollectionIndexer<String> indexer = new CollectionIndexer<>(testVector);
		Assert.assertEquals(4, indexer.size());
		
		int dogResult = SearchUtility.search(indexer, "dog");
		Assert.assertEquals(0, dogResult);
		
		int catResult = SearchUtility.search(indexer, "cat");
		Assert.assertEquals(1, catResult);
		
		int birdResult = SearchUtility.search(indexer, "bird");
		Assert.assertEquals(2, birdResult);
		
		int nullResult = SearchUtility.search(indexer, null);
		Assert.assertEquals(3, nullResult);
	}

}
