package edu.gmu.cs.swe619.assignments.assignment07;

import org.junit.Assert;
import org.junit.Test;

public class StringSearchTest {
	
	@Test
	public void testSearchString() {
		StringIndexer indexer = new StringIndexer("The quick brown fox jumped over the lazy dog.");
		Assert.assertEquals(45, indexer.size());
		
		Assert.assertEquals(0, SearchUtility.search(indexer, 'T'));
		Assert.assertEquals(1, SearchUtility.search(indexer, 'h'));
		Assert.assertEquals(2, SearchUtility.search(indexer, 'e'));
		Assert.assertEquals(3, SearchUtility.search(indexer, ' '));
		Assert.assertEquals(4, SearchUtility.search(indexer, 'q'));
		
		
		Assert.assertEquals(44, SearchUtility.search(indexer, '.'));
	}
}
