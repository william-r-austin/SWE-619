package edu.gmu.cs.swe619.assignments.assignment08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Generic BoundedQueue class representing a bounded queue for SWE-619, Assinment #8. This data
 * structure is initialized with a fixed size that represents the maximum number of elements
 * that may be contained in the queue. Queues are a FIFO data structure, so the first element
 * inserted by put() is also the first element removed by get(). Null elements are not allowed in
 * this implementation.
 * 
 * This class is required to match the way the existing class (using an array and several
 * indices to keep track of state) functioned. Therefore, we maintain the same behavior with respect
 * to method arguments, return values, and exceptions.
 */
public class BoundedQueue<E> {

	/**
	 * This is the rep. We use a List to simplify the operations in the class, leading to code
	 * that is less prone to errors.
	 */
	private final List<E> rep;
	
	/**
	 * The size represents the maximum number of elements that the queue may hold. When initialized, the
	 * queue will be empty. It may grow up to, but not exceed this size. 
	 */
	private final int size;
	
	/**
	 * Public constructor to create a new BoundedQueue object.
	 * 
	 * @param   size              the maximum number of elements that this queue may contain. If the user
	 *                            specifies a value of 0 or a negative value, an empty queue with a maximum
	 *                            capacity of 0 will be initialized.
	 * @throws  RuntimeException  if the rep invariant is violated.
	 */
	public BoundedQueue(int size) {
		this.rep = new ArrayList<E>();
		
		if(size >= 0) {
			this.size = size;
		}
		else {
			this.size = 0;
		}
		
		if(!repOk()) {
			throw new RuntimeException("BoundedQueue constructor: Rep invariant violation.");
		}
	}
	
	/**
	 * Checks to see if the queue is empty (contains no elements).
	 * 
	 * The check is: currentSize == 0
	 * 
	 * @return  true if this bounded queue does not contain any elements, false otherwise.
	 */
	public boolean isEmpty() {
		return rep.isEmpty();
	}
	
	/**
	 * Checks to see if the queue is full. The number of elements in a full queue is equal to the size parameter 
	 * used when this bounded queue was created.
	 * 
	 * The check is: currentSize == maxSize
	 * 
	 * @return  true if this bounded queue contains the maximum number of elements, false otherwise.
	 */
    public boolean isFull() {
        return (rep.size() >= size);
    }
    
    /**
     * Gets the number of elements that are currently stored in the queue.
     * 
     * This class guarantees: 0 <= currentSize <= maxSize
     * 
     * @return  the number of elements in this bounded queue
     */
    public int getCount() {
    	return rep.size();
    }
    
    /**
     * Adds an element to a non-full queue. If the queue is full, the element is not added. In
     * addition, the element is not added if it is null.
     *       
     * @param   e                 the element to be added to this queue.
     * @throws  RuntimeException  if the rep invariant is violated.
     */
    public void put(E e) {
        if (e != null && !isFull()) {
        	rep.add(e);
        }
        
		if(!repOk()) {
			throw new RuntimeException("BoundedQueue.put: Rep invariant violation.");
		}
    }
    
    /**
     * Get the next element from the queue. The order of retrieval from the queue will match the 
     * order of insertion, so the next element to be returned will be the oldest element in the 
     * queue. If the queue is empty, this method returns null.
     * 
     * As an example, if we put 1, 2, and 3 into a queue. Successive calls to get() will 
     * retrieve 1, 2, and 3. 
     * 
     * @return  the oldest element in the queue
     * @throws  RuntimeException if the rep invariant is violated
     */
    public E get() {
        E result = null;
        if (!isEmpty()) {
            result = rep.remove(0);
        }
        
		if(!repOk()) {
			throw new RuntimeException("BoundedQueue.put: Rep invariant violation.");
		}
        
        return result;
    }
    
    /**
     * This is a private helper method that implements the putAll() functionality. We 
     * create this helper method to allow us to use the iterator method for the
     * collection. This is not possible using wildcards because we must use the actual
     * type (T) during the iteration.
     * 
     * @param c  the collection of elements to be added to the queue
     */
    private <T extends E> void  putAllImpl(Collection<T> c) {
    	Iterator<T> iter = c.iterator();
    	
    	while(iter.hasNext() && !isFull()) {
    		T nextElement = iter.next();
    		put(nextElement);
    	}
    }
    
    /**
     * Adds all of the elements in the collection to this bounded queue, in the order specified by
     * the collection's default iterator. If this bounded queue becomes full (or already is full),
     * subsequent elements are skipped. 
     * 
     * @param  c                     the collection of elements to be added to the queue
     * @throws NullPointerException  if the collection to be added is null
     * @throws RuntimeException      if the rep invariant is violated
     */
    public void putAll(Collection<? extends E> c) {
    	putAllImpl(c);
    	
		if(!repOk()) {
			throw new RuntimeException("BoundedQueue.putAll: Rep invariant violation.");
		}
    }
    
    /**
     * Removes all elements from this bounded queue and returns them as a List. The list is ordered
     * such that the oldest elements in the queue will be at the beginning of the list. Therefore, in
     * the following 2 statements, x and y would refer to the same element.
     * 
     * 1. E x = boundedQueue.get();
     * 2. E y = boundedQueue.getAll().get(0);
     * 
     * Note that a copy of the queue is made, so the caller is free to modify the result without changing
     * changing the queue.
     * 
     * @return  a List containing a copy of the elements in the queue
     * @throws  RuntimeException  if the rep invariant is violated
     */
    public List<E> getAll() {
    	List<E> listCopy = new ArrayList<>(rep);
    	rep.clear();
    	
		if(!repOk()) {
			throw new RuntimeException("BoundedQueue.getAll: Rep invariant violation.");
		}
    	
    	return listCopy;
    }
    
	/**
	 * Validates the rep invariant. The rep invariant is that bounded queue is not null
	 * and the size of the queue is within the acceptable range. Namely, the size must
	 * be >= 0 and <= maxSize, as specified when this queue was created.
	 * 
	 * @return  true if the rep invariant is satisfied, false otherwise, which would
	 *          indicate that the internal state of the object is corrupted
	 */
	private boolean repOk() {
		if(rep != null) {
			int currentSize = rep.size();
			return (currentSize >= 0 && currentSize <= size && size >= 0);
		}
		
		return false;
	}

	/**
	 * Runs a simple test routine to show the basic BoundedQueue functionality. See the BoundedQueueTest
	 * class for a full set of JUnit tests.
	 * 
	 * @param args  CLI arguments
	 */
    public static void main(String args[]) {
        BoundedQueue<Integer> queue = new BoundedQueue<>(10);
        for (int i = 0; !queue.isFull(); i++) {
            queue.put(new Integer(i));
            System.out.println("put: " + i);
        }
        while (!queue.isEmpty()) {
            System.out.println("get: " + queue.get());
        }
    }



}
