package edu.gmu.cs.swe619.assignments.assignment07;

import java.util.List;

public class ListIndexer<E> implements Indexer<E> {

	private List<E> indexedList;
	
	public ListIndexer(List<E> sourceList) {
		this.indexedList = sourceList;
	}
	
	@Override
	public E get(int index) {
		return indexedList.get(index);
	}

	@Override
	public int size() {
		return indexedList.size();
	}
}
