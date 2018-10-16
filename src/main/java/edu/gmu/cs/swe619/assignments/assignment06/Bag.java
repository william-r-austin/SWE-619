package edu.gmu.cs.swe619.assignments.assignment06;

import java.util.*;

/**
 * Generic Bag class representing a multiset for SWE-619, 
 * Assignment #6. See Liskov exercise 7.11.
 * 
 * Example:  A bag of 2 cats and a dog is map = { cat=2, dog=1 } 
 */
public class Bag<E> {

	/**
	 * This is the rep. Map each object to the count of that object in this.
	 */
	private Map<E, Integer> map;
	
	/**
	 * Public constructor to create a new Bag object.
	 */
	public Bag() {
		map = new HashMap<E, Integer>();
		
		if(!repOk()) {
			throw new RuntimeException("Bag constructor: Rep invariant violation.");
		}
	}
	
	/** 
	 * Add 1 occurrence of e to this
	 * 
	 * @param e  
	 */
	public void insert(E e) {
		Integer currentCount = map.get(e);
		
		if(currentCount != null) {
			map.put(e, currentCount + 1);
		}
		else {
			map.put(e, 1);
		}
		
		if(!repOk()) {
			throw new RuntimeException("Bag.insert: Rep invariant violation.");
		}
	}
	
	/** 
	 * Remove 1 occurrence of e from this
	 * 
	 * @param e
	 */
	public void remove(E e) {
		Integer currentCount = map.get(e);
		
		if(currentCount != null) {
			if(currentCount > 1) {
				map.put(e, currentCount - 1);
			}
			else {
				map.remove(e);
			}
		}
	}
	
	// return true iff e is in this
	public boolean isIn(E e) {
		return map.containsKey(e);
	}
	
	// return cardinality of this
	public int size() {
		return map.size();
	}

	// if this is empty throw ISE
	// else return arbitrary element of this
	public E choose() {
		if(map.isEmpty()) {
			throw new IllegalStateException("Bag.choose: set is empty.");
		}
		
		return map.keySet().iterator().next();
	}
	
	// conveniently, the <E,Integer> map is exactly the abstract state
	public String toString() {
		return map.toString();
	}
	
	/**
	 * Validates the rep invariant. The rep invariant is that the range of map contains 
	 * only positive integers, so we check that all quantity values are >= 1. If we 
	 * remove the last element, the key is removed from this. We do not restrict null 
	 * as a key value.
	 * 
	 * @return  true if the rep invariant is satisfied, false otherwise, which would
	 *          indicate that the internal state of the object is corrupted
	 */
	private boolean repOk() {
		if(map == null) {
			return false;
		}
		
		for(Map.Entry<E, Integer> entry : map.entrySet()) {
			Integer value = entry.getValue();
			if(value == null || value < 1) {
				return false;
			}
		}
		
		return true;
	}
}
