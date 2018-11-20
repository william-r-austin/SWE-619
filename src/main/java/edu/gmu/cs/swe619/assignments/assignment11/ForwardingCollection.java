package edu.gmu.cs.swe619.assignments.assignment11;

import java.util.Collection;
import java.util.Iterator;

/**
 * Wrapper class for the Collection interface. Uses composition to store
 * a reference to a user-specified collection object, and then provides
 * forwarding methods for all operations in the Collection interface. This
 * class is not meant to be extended, so it is marked as abstract. Rather,
 * users should extend it and provide their own functionality in the subclass.
 * 
 * @param <E>  the type of elements to store in the collection
 */
public abstract class ForwardingCollection<E> implements Collection<E> {

	/**
	 * Backing collection provided by the user.
	 */
	private final Collection<E> collection;
	
	public ForwardingCollection(Collection<E> source) {
		this.collection = source;
	}
	
	@Override
	public boolean add(E element) {
		return collection.add(element);
	}

	@Override
	public boolean addAll(Collection<? extends E> otherCollection) {
		return collection.addAll(otherCollection);
	}

	@Override
	public void clear() {
		collection.clear();
	}

	@Override
	public boolean contains(Object object) {
		return collection.contains(object);
	}

	@Override
	public boolean containsAll(Collection<?> otherCollection) {
		return collection.containsAll(otherCollection);
	}

	@Override
	public boolean isEmpty() {
		return collection.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return collection.iterator();
	}

	@Override
	public boolean remove(Object object) {
		return collection.remove(object);
	}

	@Override
	public boolean removeAll(Collection<?> otherCollection) {
		return collection.removeAll(otherCollection);
	}

	@Override
	public boolean retainAll(Collection<?> otherCollection) {
		return collection.retainAll(otherCollection);
	}

	@Override
	public int size() {
		return collection.size();
	}

	@Override
	public Object[] toArray() {
		return collection.toArray();
	}

	@Override
	public <T> T[] toArray(T[] dummyArray) {
		return collection.toArray(dummyArray);
	}
	
	@Override
	public boolean equals(Object other) {
		return collection.equals(other);
	}
	
	@Override
	public int hashCode() {
		return collection.hashCode();
	}
	
	@Override
	public String toString() {
		return collection.toString();
	}
}
