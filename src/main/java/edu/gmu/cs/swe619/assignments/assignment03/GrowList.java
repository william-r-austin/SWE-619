package edu.gmu.cs.swe619.assignments.assignment03;

import java.util.HashMap;
import java.util.Map;

/**
 * GrowList is a list that only gets longer. It is immutable,
 * meaning that instances can never be changed after creation.
 * Rather, operations on a GrowList object will return a new
 * instance.
 *
 * @param <E>  the type of object to store in the list
 */
public final class GrowList<E> {

	// Use a map for the internal representation
	private final Map<Integer, E> values;

	/**
	 * Construct an empty GrowList
	 */
	public GrowList() {
		values = new HashMap<Integer, E>();
	}
	
	/**
	 * Private constructor for creating a copy of an existing list
	 * 
	 * @param existingValues  a Map to be used for initializing the
	 *                        representation of the new GrowList
	 */
	private GrowList(Map<Integer, E> existingValues) {
		this.values = new HashMap<Integer, E>(existingValues);
	}

	/**
	 * Add to the end of the list
	 * 
	 * @param o  the new element
	 */
	public GrowList<E> add(E o) {
		GrowList<E> newList = new GrowList<E>(values);
		int listSize = newList.size();
		newList.values.put(listSize, o);
		return newList;
	}

	/**
	 * Get the number of values in list
	 * 
	 * @return the list size
	 */
	public int size() {
		return values.size();
	}

	/**
	 * Get ith value in list. This list is 0-indexed.
	 * 
	 * @param i  the index in the list to retrieve an element from
	 * @return   the element in the GrowList at index i
	 */
	public E get(int i) {
		if (!inRange(i)) {
			throw new IndexOutOfBoundsException("GrowList.get");
		}
		return values.get(i);
	}

	/** 
	 * Update ith value in list
	 * 
	 * @param i  the index in the GrowList to replace
	 * @param o  the new object to save in the GrowList 
	 * @return   a new GrowList that is a copy of the 
	 *           original GrowList, with the specified 
	 *           element replaced
	 */
	public GrowList<E> set(int i, E o) {
		if (!inRange(i)) {
			throw new IndexOutOfBoundsException("GrowList.set");
		}
		
		GrowList<E> newList = new GrowList<E>(values);
		newList.values.put(i, o);
		return newList;
	}

	/** 
	 * Helper method to determine if a given index is valid for
	 * the current GrowList. The valid range is: 0 <= i < size()
	 * 
	 * @param i  the index value
	 * @return   true if the index is valid for the current
	 *           GrowList, false otherwise
	 */
	private boolean inRange(int i) {
		return (i >= 0) && (i < size());
	}

	/**
	 * String representation of the object.
	 * <p>
	 * @return  the elements of the GrowList represented as a String
	 */
	@Override
	public String toString() {
		int listSize = size();
		
		StringBuilder sb = new StringBuilder("[");
		
		for(int i = 0; i < listSize; i++) {
			E element = values.get(i);
			String elementAsString = String.valueOf(element);
			sb.append(elementAsString);
			
			if(i < listSize - 1) {
				sb.append(", ");
			}
		}
		
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Main method. Runs a simple test example.
	 *  
	 * @param args  Arguments to the program
	 */
	public static void main(String[] args) {
		GrowList<String> list = new GrowList<String>();
		System.out.println("list is: " + list);
		list = list.add("cat");
		System.out.println("list is: " + list);
		list = list.add("dog");
		System.out.println("list is: " + list);
		list = list.set(1, "bat");
		System.out.println("list is: " + list);
	}
}
