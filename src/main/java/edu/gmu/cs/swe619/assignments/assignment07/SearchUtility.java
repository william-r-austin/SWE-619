package edu.gmu.cs.swe619.assignments.assignment07;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SearchUtility {
	
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
