package edu.gmu.cs.swe619.exercises.week02.exercise1A;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class IteratorTest {
	
	@Test
	public void testEmptyListHasNext() {
		List<String> x = new ArrayList<>();
		Iterator<String> xIter = x.iterator();
		boolean hasNext = xIter.hasNext();
		Assert.assertEquals(false, hasNext);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testEmptyList() {
		List<String> x = new ArrayList<>();
		Iterator<String> xIter = x.iterator();
		xIter.next();
	}

}
