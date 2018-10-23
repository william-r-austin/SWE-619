package edu.gmu.cs.swe619.assignments.assignment07;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Static utility class containing the generic search operation for instances
 * of Indexer. 
 */
public class SearchUtility {
	
	/**
	 * Search the given Indexer for the given element.
	 *   
	 * @param <E>  the type of elements in the collection for the Indexer
	 * @param c    an Indexer for a collection
	 * @param x    the element to search for in the collection represented by the Indexer
	 * @return     the index of the element in the Indexer object
	 * @throws NullPointerException    if the given Indexer is null
	 * @throws NoSuchElementException  if the element is not found by the Indexer (it is not in the collection)
	 */
	public static <E> int search(Indexer<E> c, E x) {
		int collectionSize = c.size();
		for(int i = 0; i < collectionSize; i++) {
			E currentElement = c.get(i);
			boolean elementsEqual = Objects.equals(currentElement, x);
			if(elementsEqual) {
				return i;
			}
		}
		
		throw new NoSuchElementException("SearchUtility.search: The element was not found in the collection.");
	}
}
