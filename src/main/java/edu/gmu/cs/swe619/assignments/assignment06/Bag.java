package edu.gmu.cs.swe619.assignments.assignment06;

import java.util.*;

/**
 * Generic Bag class representing a multiset for SWE-619, 
 * Assignment #6. See Liskov exercise 7.11.
 * 
 * Example:  A bag of 2 cats and a dog is map = {cat: 2, dog: 1}
 */
public class Bag<E> {

	/**
	 * This is the rep. Use a map each object to store the values 
	 * in the Bag and their associated values.
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
	 * @param e  the element to add to the Bag
	 * @throws   RuntimeException  if the rep invariant is violated
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
	 * @param e  the element to add to the Bag
	 * @throws   RuntimeException  if the rep invariant is violated
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
		
		if(!repOk()) {
			throw new RuntimeException("Bag.remove: Rep invariant violation.");
		}
	}
	
	/** 
	 * Check if there is at least one occurrence of the given element in the Bag. 
	 * 
	 * @param e  the element to find in the Bag
	 * @return   true if there is at least one element of e in the Bag, false otherwise.
	 */
	public boolean isIn(E e) {
		return map.containsKey(e);
	}
	
	/**
	 * Return cardinality of this. Not that the Bag can contain multiple elements of the same
	 * type, and these are counted separately. For example, a bag with map = {cat: 2, dog: 1}
	 * has a size of 3.
	 * 
	 * @return  the number of types of elements in the Bag.
	 */
	public int size() {
		Integer totalElements = map.values().stream().reduce(0, Integer::sum);
		return totalElements;
	}

	/**
	 * Choose an arbitrary element from the bag. If this is empty throw an ISE.
	 * 
	 * @return  arbitrary element of this
	 * @throws  IllegalStateException if the bag is empty
	 */
	public E choose() {
		if(map.isEmpty()) {
			throw new IllegalStateException("Bag.choose: set is empty.");
		}
		
		return map.keySet().iterator().next();
	}
	
	/**
	 * Provide a string that represents the abstract state of the Bag. We choose to 
	 * use Map<E, Integer> as our rep, so we can use that for the AF as well.
	 *  
	 * @return  a string representing the state of the bag.
	 */
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
