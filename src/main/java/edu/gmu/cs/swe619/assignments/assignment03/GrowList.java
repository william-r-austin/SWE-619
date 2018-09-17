package edu.gmu.cs.swe619.assignments.assignment03;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * GrowList is a mutable list that only gets longer.
 *
 * @param <E>
 *            The type of object to store in the list
 */
public class GrowList<E> {
	private Map<Integer, E> values;

	public GrowList() {
		values = new HashMap<Integer, E>();
	}
	
	/**
	 * Private constructor for creating a copy of an existing list
	 * 
	 * @param existingValues
	 */
	private GrowList(Map<Integer, E> existingValues) {
		this.values = new HashMap<Integer, E>(existingValues);
	}

	/**
	 * Add to the end of the list
	 * 
	 * @param o
	 *            the new element
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
	 * Get ith value in list
	 * 
	 * @param i
	 * @return
	 */
	public E get(int i) {
		if (!inRange(i)) {
			throw new IndexOutOfBoundsException("GrowList.get");
		}
		return values.get(i);
	}

	/** Update ith value in list; return previous value or null if none
	 * 
	 * @param i
	 * @param o
	 * @return
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
	 * Private helper method
	 * 
	 * @param i
	 * @return
	 */
	private boolean inRange(int i) {
		return (i >= 0) && (i < size());
	}

	/**
	 * String representation of the object. 
	 */
	@Override
	public String toString() {
		if (size() == 0) {
			return "[]";
		}

		String result = "[";
		for (int i = 0; i < size() - 1; i++) {
			result += values.get(i) + ", ";
		}
		
		return result + values.get(size() - 1) + "]";
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
