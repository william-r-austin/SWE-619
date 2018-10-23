package edu.gmu.cs.swe619.assignments.assignment07;

import java.util.Collection;

/**
 * Implementation of the Indexer class for the Java Collection interface. This allows any
 * Collection object (and subclasses) to be used as an Indexer.  
 *
 * @param <E>  the type of objects in the collection
 */
public class CollectionIndexer<E> implements Indexer<E> {

	/**
	 * The underlying array of elements in the collection
	 */
	private final Object[] elementArray;
	
	/**
	 * Create a CollectionIndexer from the given Collection object.
	 * 
	 * Note: If this source collection is unordered, this constructor will impose an arbitrary 
	 * ordering over the elements by calling the Collection.toArray() method.
	 * 
	 * @param sourceCollection  the source Collection object
	 * @throws NullPointerException  if the source Collection is null
	 */
	public CollectionIndexer(Collection<E> sourceCollection) {
		elementArray = sourceCollection.toArray();
	}
	
	/**
	 * Get the collection element at the given index, for the assumed ordering
	 * 
	 * @return  the collection element at the given index
	 * @throws  ArrayIndexOutOfBoundsException  if the index is not valid
	 */
	@Override
	public E get(int index) {
		@SuppressWarnings("unchecked")
		E element = (E) elementArray[index];
		return element;
	}

	/**
	 * Get the number of elements in the Collection
	 * 
	 * @return  the number of elements in the underlying Collection
	 */
	@Override
	public int size() {
		return elementArray.length;
	}

}
