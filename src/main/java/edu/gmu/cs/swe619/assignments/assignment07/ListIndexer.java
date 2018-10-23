package edu.gmu.cs.swe619.assignments.assignment07;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Indexer interface for List objects. 
 *
 * @param <E>  the type of objects contained in the List
 */
public class ListIndexer<E> implements Indexer<E> {

	/**
	 * A copy of the source list. Element references are copied, so behavior is undefined 
	 * if the objects in the list are modified while the ListIndexer is in use.
	 */
	private final List<E> indexedList;
	
	/**
	 * Creates a new ListIndexer
	 * 
	 * @param sourceList  the List to be indexed
	 * @throws NullPointerException  if the source List is null
	 */
	public ListIndexer(List<E> sourceList) {
		this.indexedList = new ArrayList<E>(sourceList);
	}
	
	/**
	 * Get the element in the list at the given position
	 * 
	 * @return the element at the given position
	 * @throws IndexOutOfBoundsException  if the index is not valid
	 */
	@Override
	public E get(int index) {
		return indexedList.get(index);
	}

	/**
	 * Get the number elements in the list
	 * 
	 * @return  the size of the list
	 */
	@Override
	public int size() {
		return indexedList.size();
	}
}
