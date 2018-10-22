package edu.gmu.cs.swe619.assignments.assignment07;

import java.util.Collection;

public class CollectionIndexer<E> implements Indexer<E> {

	private final Object[] elementArray;
	
	public CollectionIndexer(Collection<E> sourceCollection) {
		elementArray = sourceCollection.toArray();
	}
	
	@Override
	public E get(int index) {
		@SuppressWarnings("unchecked")
		E element = (E) elementArray[index];
		return element;
	}

	@Override
	public int size() {
		return elementArray.length;
	}

}
