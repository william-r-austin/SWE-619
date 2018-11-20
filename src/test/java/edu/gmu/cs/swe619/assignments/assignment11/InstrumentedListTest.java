package edu.gmu.cs.swe619.assignments.assignment11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

public class InstrumentedListTest {
	
	@Test
	public void testEqualLists() {
		// Normal ArrayList
		List<String> arrayList = new ArrayList<>();
		arrayList.add("cat");
		arrayList.add("dog");
		arrayList.add("bird");
		
		// Normal LinkedList
		List<String> linkedList = new LinkedList<>();
		linkedList.add("cat");
		linkedList.add("dog");
		linkedList.add("bird");
		
		// Reflexivity holds for normal lists
		Assert.assertTrue(arrayList.equals(arrayList));
		Assert.assertTrue(linkedList.equals(linkedList));
		
		// Commutativity holds for normal lists
		Assert.assertTrue(arrayList.equals(linkedList));
		Assert.assertTrue(linkedList.equals(arrayList));
		
		// Create instrumented collections based on our existing lists
		List<String> instrumentedList1 = new InstrumentedList<>(arrayList);
		List<String> instrumentedList2 = new InstrumentedList<>(linkedList);
		
		// Reflexivity holds for instrumented lists
		Assert.assertTrue(instrumentedList1.equals(instrumentedList1));
		Assert.assertTrue(instrumentedList2.equals(instrumentedList2));
		
		// Commutativity holds for instrumented lists
		Assert.assertTrue(instrumentedList1.equals(instrumentedList2));
		Assert.assertTrue(instrumentedList2.equals(instrumentedList1));
		
		// More examples showing commutativity holds for instrumented lists
		Assert.assertTrue(arrayList.equals(instrumentedList1));
		Assert.assertTrue(instrumentedList1.equals(arrayList));
		
		Assert.assertTrue(linkedList.equals(instrumentedList1));
		Assert.assertTrue(instrumentedList1.equals(linkedList));
		
		Assert.assertTrue(arrayList.equals(instrumentedList2));
		Assert.assertTrue(instrumentedList2.equals(arrayList));
		
		Assert.assertTrue(linkedList.equals(instrumentedList2));
		Assert.assertTrue(instrumentedList2.equals(linkedList));
	}
	
	@Test
	public void testUnequalLists() {
		// Normal ArrayList
		List<String> arrayList = new ArrayList<>();
		arrayList.add("cat");
		arrayList.add("dog");
		arrayList.add("bird");
		
		// Normal LinkedList - different values
		List<String> linkedList = new LinkedList<>();
		linkedList.add("lion");
		linkedList.add("tiger");
		linkedList.add("bear");
		
		// Reflexivity still holds
		Assert.assertTrue(arrayList.equals(arrayList));
		Assert.assertTrue(linkedList.equals(linkedList));
		
		// Commutativity works as expected
		Assert.assertFalse(arrayList.equals(linkedList));
		Assert.assertFalse(linkedList.equals(arrayList));
		
		// Create instrumented collections based on our existing lists
		List<String> instrumentedList1 = new InstrumentedList<>(arrayList);
		List<String> instrumentedList2 = new InstrumentedList<>(linkedList);
		
		// Reflexivity holds for instrumented lists
		Assert.assertTrue(instrumentedList1.equals(instrumentedList1));
		Assert.assertTrue(instrumentedList2.equals(instrumentedList2));
		
		// Again, commutativity works as expected
		Assert.assertFalse(instrumentedList1.equals(instrumentedList2));
		Assert.assertFalse(instrumentedList2.equals(instrumentedList1));
		
		// More examples showing commutativity
		Assert.assertTrue(arrayList.equals(instrumentedList1));
		Assert.assertTrue(instrumentedList1.equals(arrayList));
		
		Assert.assertFalse(linkedList.equals(instrumentedList1));
		Assert.assertFalse(instrumentedList1.equals(linkedList));
		
		Assert.assertFalse(arrayList.equals(instrumentedList2));
		Assert.assertFalse(instrumentedList2.equals(arrayList));
		
		Assert.assertTrue(linkedList.equals(instrumentedList2));
		Assert.assertTrue(instrumentedList2.equals(linkedList));
	}
	
	// Vector implements the List interface
	@Test
	public void testListAndVector() {
		// Normal ArrayList
		List<String> arrayList = new ArrayList<>();
		arrayList.add("cat");
		arrayList.add("dog");
		arrayList.add("bird");
		
		// Normal Vector
		List<String> vector = new Vector<>();
		vector.add("cat");
		vector.add("dog");
		vector.add("bird");
		
		// Reflexivity holds for normal lists
		Assert.assertTrue(arrayList.equals(arrayList));
		Assert.assertTrue(vector.equals(vector));
		
		// Commutativity holds for normal lists
		Assert.assertTrue(arrayList.equals(vector));
		Assert.assertTrue(vector.equals(arrayList));
		
		// Create instrumented collections based on our existing lists
		List<String> instrumentedList1 = new InstrumentedList<>(arrayList);
		List<String> instrumentedList2 = new InstrumentedList<>(vector);
		
		// Reflexivity holds for instrumented lists
		Assert.assertTrue(instrumentedList1.equals(instrumentedList1));
		Assert.assertTrue(instrumentedList2.equals(instrumentedList2));
		
		// Commutativity holds for instrumented lists
		Assert.assertTrue(instrumentedList1.equals(instrumentedList2));
		Assert.assertTrue(instrumentedList2.equals(instrumentedList1));
		
		// More examples showing commutativity holds for instrumented lists
		Assert.assertTrue(arrayList.equals(instrumentedList1));
		Assert.assertTrue(instrumentedList1.equals(arrayList));
		
		Assert.assertTrue(vector.equals(instrumentedList1));
		Assert.assertTrue(instrumentedList1.equals(vector));
		
		Assert.assertTrue(arrayList.equals(instrumentedList2));
		Assert.assertTrue(instrumentedList2.equals(arrayList));
		
		Assert.assertTrue(vector.equals(instrumentedList2));
		Assert.assertTrue(instrumentedList2.equals(vector));
	}

}
