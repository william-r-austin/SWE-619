package edu.gmu.cs.swe619.exercises.week03;

import java.util.ArrayList;
import java.util.List;

public class ImmutableQueue<E> {
	private List<E> elements;
	private int size;

	public ImmutableQueue() {   
		this.elements = new ArrayList<E>();
		this.size = 0;
	}
	
	private ImmutableQueue(List<E> elements, int size) {
		this.elements = new ArrayList<E>(elements);
		this.size = size;
	}
	
	private ImmutableQueue<E> copy2() {
		return new ImmutableQueue<>(elements, size);
	}
	
	private ImmutableQueue<E> copy() {
		ImmutableQueue<E> copy = new ImmutableQueue<>();
		copy.elements = new ArrayList<E>(this.elements);
		copy.size = this.size;
		return copy;
	}

	public ImmutableQueue<E> enQueue(E e) {
		ImmutableQueue<E> newQueue = copy();
		newQueue.elements.add(e);
		newQueue.size++;
		return newQueue;
	}
	
	public E nextElement() {
		if (size == 0) {
			throw new IllegalStateException("Queue.nextElement");
		}
		return elements.get(0);
	}
	
	public ImmutableQueue<E> deQueue () {
		if (size == 0) {
			throw new IllegalStateException("Queue.deQueue");
		}
		
		ImmutableQueue<E> newQueue = copy();
		newQueue.elements.remove(0);
		newQueue.size--;
		return newQueue;
   }

   public boolean isEmpty() {
      return size == 0;
   }
}
