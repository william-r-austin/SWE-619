package edu.gmu.cs.swe619.assignments.assignment11;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

public class InstrumentedMapTest {
	
	@Test
	public void testEqualMaps() {
		// Normal HashMap
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(10, "ten");
		hashMap.put(20, "twenty");
		hashMap.put(30, "thirty");

		// Normal TreeMap
		Map<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(10, "ten");
		treeMap.put(20, "twenty");
		treeMap.put(30, "thirty");
		
		// Reflexivity holds for normal maps
		Assert.assertTrue(hashMap.equals(hashMap));
		Assert.assertTrue(treeMap.equals(treeMap));
		
		// Commutativity holds for normal maps
		Assert.assertTrue(hashMap.equals(treeMap));
		Assert.assertTrue(treeMap.equals(hashMap));
		
		// Create instrumented maps based on our existing maps
		Map<Integer, String> instrumentedMap1 = new InstrumentedMap<>(hashMap);
		Map<Integer, String> instrumentedMap2 = new InstrumentedMap<>(treeMap);
		
		// Reflexivity holds for instrumented maps
		Assert.assertTrue(instrumentedMap1.equals(instrumentedMap1));
		Assert.assertTrue(instrumentedMap2.equals(instrumentedMap2));
		
		// Commutativity holds for instrumented maps
		Assert.assertTrue(instrumentedMap1.equals(instrumentedMap2));
		Assert.assertTrue(instrumentedMap2.equals(instrumentedMap1));
		
		// More examples showing commutativity holds for instrumented maps
		Assert.assertTrue(hashMap.equals(instrumentedMap1));
		Assert.assertTrue(instrumentedMap1.equals(hashMap));
		
		Assert.assertTrue(treeMap.equals(instrumentedMap1));
		Assert.assertTrue(instrumentedMap1.equals(treeMap));
		
		Assert.assertTrue(hashMap.equals(instrumentedMap2));
		Assert.assertTrue(instrumentedMap2.equals(hashMap));
		
		Assert.assertTrue(treeMap.equals(instrumentedMap2));
		Assert.assertTrue(instrumentedMap2.equals(treeMap));
	}
	
	@Test
	public void testUnequalMaps() {
		// Normal HashMap
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(10, "ten");
		hashMap.put(20, "twenty");
		hashMap.put(30, "thirty");

		// Normal TreeMap - different values
		Map<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(10, "TEN");
		treeMap.put(20, "TWENTY");
		treeMap.put(30, "THIRTY");
		
		// Reflexivity still holds
		Assert.assertTrue(hashMap.equals(hashMap));
		Assert.assertTrue(treeMap.equals(treeMap));
		
		// Commutativity works as expected
		Assert.assertFalse(hashMap.equals(treeMap));
		Assert.assertFalse(treeMap.equals(hashMap));
		
		// Create instrumented maps based on our existing maps
		Map<Integer, String> instrumentedMap1 = new InstrumentedMap<>(hashMap);
		Map<Integer, String> instrumentedMap2 = new InstrumentedMap<>(treeMap);
		
		// Reflexivity holds for instrumented maps
		Assert.assertTrue(instrumentedMap1.equals(instrumentedMap1));
		Assert.assertTrue(instrumentedMap2.equals(instrumentedMap2));
		
		// Again, commutativity works as expected
		Assert.assertFalse(instrumentedMap1.equals(instrumentedMap2));
		Assert.assertFalse(instrumentedMap2.equals(instrumentedMap1));
		
		// More examples showing commutativity
		Assert.assertTrue(hashMap.equals(instrumentedMap1));
		Assert.assertTrue(instrumentedMap1.equals(hashMap));
		
		Assert.assertFalse(treeMap.equals(instrumentedMap1));
		Assert.assertFalse(instrumentedMap1.equals(treeMap));
		
		Assert.assertFalse(hashMap.equals(instrumentedMap2));
		Assert.assertFalse(instrumentedMap2.equals(hashMap));
		
		Assert.assertTrue(treeMap.equals(instrumentedMap2));
		Assert.assertTrue(instrumentedMap2.equals(treeMap));
	}
}
