package edu.gmu.cs.swe619.assignments.assignment11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class InstrumentedListTest {
	
	@Test
	public void testEqualLists() {
		List<String> arrayList = new ArrayList<>();
		arrayList.add("cat");
		arrayList.add("dog");
		arrayList.add("bird");
		
		List<String> linkedList = new LinkedList<>();
		linkedList.add("cat");
		linkedList.add("dog");
		linkedList.add("bird");
		
		Assert.assertTrue(arrayList.equals(linkedList));
		Assert.assertTrue(linkedList.equals(arrayList));
		
		InstrumentedList<String> instrumentedList1 = new InstrumentedList<>(arrayList);
		InstrumentedList<String> instrumentedList2 = new InstrumentedList<>(linkedList);
		
		Assert.assertTrue(instrumentedList1.equals(instrumentedList2));
		Assert.assertTrue(instrumentedList2.equals(instrumentedList1));
		
		// TODO - Fill out all reflexive and commutativity examples
	}
	
	@Test
	public void testUnequalLists() {
		List<String> arrayList = new ArrayList<>();
		arrayList.add("cat");
		arrayList.add("dog");
		arrayList.add("bird");
		
		List<String> linkedList = new LinkedList<>();
		linkedList.add("lion");
		linkedList.add("tiger");
		linkedList.add("bear");
		
		// TODO - finish implementing
	}
	
	// Vector implements the List interface
	@Test
	public void testListAndVector() {
		
	}

}
