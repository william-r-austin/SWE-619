package edu.gmu.cs.swe619.assignments.assignment05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * GrowList is a mutable list that only gets longer.
 */
public class GrowList <E> implements Iterable<E> {
	
	/**
	 * Map to hold values in the list
	 */
	private Map<Integer, E> values;
	
	/**
	 * Create a new GrowList
	 */
	public GrowList() {
		values = new HashMap<Integer, E>();
		
		if(!repOk()) {
			throw new RuntimeException("GrowList constructor: Rep invariant violation");
		}
	}
	
	/**
	 * Add to the end of the list
	 * 
	 * @param o  the new element to add to the list
	 * @throws   RuntimeException  if the rep invariant is violated
	 */
	public void add(E o) {
		values.put(size(), o);
		
		if(!repOk()) {
			throw new RuntimeException("GrowList.add: Rep invariant violation");
		}
	}
	
	/**
	 * Number of elements in list
	 * 
	 * @return  size of the list
	 */
	public int size() {
		return values.size();
	}

	/**
	 * Get ith value in list
	 * 
	 * @param  i  the index to retrieve an element from
	 * @return    the element at index i
	 * @throws    IndexOutOfBoundsException  if index i is not valid
	 */
	public E get(int i) {
		if(!inRange(i)) {
			throw new IndexOutOfBoundsException("GrowList.get: Index out of bounds");
		}
		
		return values.get(i);
	}
	
	/**
	 * Update ith value in list
	 * 
	 * @param i  index of element to replace
	 * @param o  new element to save at index i
	 * @return   previous value or null if none
	 * @throws   IndexOutOfBoundsException  if index i is not valid
	 * @throws   RuntimeException  if the rep invariant is violated
	 */
	public E set(int i, E o) {
		E result = null;
		
		if(!inRange(i)) {
			throw new IndexOutOfBoundsException("GrowList.set: Index out of bounds");
		}
		
		result = values.put(i, o);
		
		if(!repOk()) {
			throw new RuntimeException("GrowList.set: Rep invariant violation");
		}
		
		return result;
	}
	
	/**
	 * Private helper method to determine if the given list index is valid
	 * 
	 * @param i  the index
	 * @return   true if it is a valid list index, false otherwise
	 */
	private boolean inRange(int i) {
		return (i >= 0) && (i < size());
	}
	
	/**
	 * Serves as the abstraction function (AF) for GrowList
	 * 
	 * @return  a string representing the GrowList 
	 */
	@Override
	public String toString() {
		if(size() == 0) {
			return "[]";
		}
		
		String result = "[";
		for(int i = 0; i < size() - 1; i++) {
			result += values.get(i) + ", ";
		}
		return result + values.get(size() - 1) + "]";
	}
	
	/**
	 * Validates the rep invariant
	 * 
	 * @return  true if the rep invariant is satisfied, false otherwise, which would
	 *          indicate that the internal state of the object is corrupted
	 */
	private boolean repOk() {
		if(values == null) {
			return false;
		}
		
		Set<Integer> keySet = values.keySet();
		for(Integer i = 0; i < keySet.size(); i++) {
			if(!keySet.contains(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Returns a new iterator for the list.
	 * <p>
	 * The remove() method <b>IS NOT</b> supported in this implementation.
	 * 
	 * @return  a reference to the new iterator object
	 */
	@Override
	public Iterator<E> iterator() {
		return new GrowListIterator();
	}
	
	/**
	 * Inner class representing an iterator for the GrowList object.
	 *
	 */
	private class GrowListIterator implements Iterator<E> {
		/**
		 * Holds the index in the map of the next element to be returned by the iterator
		 * when next() is called.
		 */
		private Integer nextElementIndex = 0;
		
		/**
		 * Tests whether the iterator has more elements to return
		 * 
		 * @return  true if there are more elements to enumerate, false otherwise
		 * @see     java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return inRange(nextElementIndex);
		}

		/**
		 * Get the next element in the GrowList.
		 * 
		 * @return  the next element to enumerate.
		 * @throws  NoSuchElementException  if there are no more elements
		 * @see     java.util.Iterator#next()
		 */
		@Override
		public E next() {
			if(!inRange(nextElementIndex)) {
				throw new NoSuchElementException("GrowListIterator.next: No such element");
			}
			
			E nextElement = values.get(nextElementIndex);
			nextElementIndex++;
			return nextElement;
		}
		
		/**
		 * Not supported. Removing elements would cause our GrowList to decrease in size, violating our
		 * class contract.
		 * 
		 * @throws  UnsupportedOperationException
		 * @see     java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException("GrowListIterator.remove: A GrowList may only increase in size, so removal is not allowed.");
		}
		
	}
	
	/**
	 *  Main method with a simple test routine
	 * 
	 * @param args  command line arguments
	 */
	public static void main(String[] args) {
		GrowList<String> list = new GrowList<String>();
		
		System.out.println("list is:" + list);
		list.add("cat");
		System.out.println("list is:" + list);
		list.add("dog");
		System.out.println("list is:" + list);
		list.set(1, "bat");
		System.out.println("list is:" + list);
	}


}
