package edu.gmu.cs.swe619.assignments.assignment07;

/**
 * The Indexer interface provides functions that allow a collection to be searched. Implementations must 
 * provide functionality for reporting the size of the collection, and a way to look up elements by their
 * index. 
 * 
 * @param <E>  the type of object in the collection
 */
public interface Indexer<E> {
	
	/**
	 * Get the element at the specified index. If the underlying collection does not impose an ordering on
	 * its elements, the Indexer implementation must provide one.
	 * 
	 * REQUIRES: 0 <= index < size()
	 * If the given index is not valid, the behavior is unspecified.
	 * 
	 * @param index  the index of the element to return. Indicies are 0-based and should range from 0 to n-1, where
	 *               n is the size of the collection
	 * @return       the element of the collection at the given index
	 */
	public E get(int index);
	
	/**
	 * Get the total number of elements in the collection
	 * 
	 * @return  the number of elements
	 */
	public int size();
}