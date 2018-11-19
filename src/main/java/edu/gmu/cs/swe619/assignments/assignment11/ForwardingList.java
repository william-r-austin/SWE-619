package edu.gmu.cs.swe619.assignments.assignment11;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class ForwardingList<E> implements List<E> {

	private List<E> list;
	
	public ForwardingList(List<E> source) {
		this.list = source;
	}
	
	@Override
	public boolean add(E element) {
		return list.add(element);
	}

	@Override
	public void add(int index, E element) {
		list.add(index, element);		
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		return list.addAll(collection);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> collection) {
		return list.addAll(index, collection);
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public boolean contains(Object object) {
		return list.contains(object);
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return list.containsAll(collection);
	}

	@Override
	public E get(int index) {
		return list.get(index);
	}

	@Override
	public int indexOf(Object object) {
		return list.indexOf(object);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	@Override
	public int lastIndexOf(Object object) {
		return list.lastIndexOf(object);
	}

	@Override
	public ListIterator<E> listIterator() {
		return list.listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return list.listIterator(index);
	}

	@Override
	public boolean remove(Object object) {
		return list.remove(object);
	}

	@Override
	public E remove(int index) {
		return list.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		return list.remove(collection);
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		return list.retainAll(collection);
	}

	@Override
	public E set(int index, E element) {
		return list.set(index, element);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return list.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] dummyArray) {
		return list.toArray(dummyArray);
	}
	
	@Override
	public boolean equals(Object object) {
		return list.equals(object);
	}
	
	@Override
	public int hashCode() {
		return list.hashCode();
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
}
