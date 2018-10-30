package edu.gmu.cs.swe619.assignments.assignment08;

/**
 * Original bounded queue implementation, given in class 
 *
 */
public class OriginalBoundedQueue {

	/**
	 * This is the rep. It contains the objects of the queue.
	 */
    protected Object rep[];
    
    /**
     * Index of the array where the next element should be inserted.
     */
    protected int front = 0;
    
    /**
     * Index of the array where the next element should be retrieved.
     */
    protected int back = -1;
    
    /**
     * The maximum number of elements to store in the queue.
     */
    protected int size = 0;
    
    /**
     * The total number of elements that are currently in the queue.
     */
    protected int count = 0;

    /**
     * Creates a new bounded queue object. Initialization fails if the size is not greater than 0.
     * 
     * @param size the capacity for this bounded queue
     */
    public OriginalBoundedQueue(int size) {
        if (size > 0) {
            this.size = size;
            rep = new Object[size];
            back = size - 1;
        }
    }

    /**
     * Checks if this queue is empty (contains 0 elements).
     * 
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Checks if this queue is full (contains the maximum number of elements)
     * 
     * @return true if the queue is full, false otherwise
     */
    public boolean isFull() {
        return (count == size);
    }
    
    /**
     * Get the current number of elements in the queue
     * 
     * @return the number of elements currently stored in the queue
     */
    public int getCount() {
        return count;
    }

    /**
     * Adds a new element to the back of the queue. The element is not inserted if it
     * is null or the queue is already full.
     * 
     * @param e the element to be added to the queue
     */
    public void put(Object e) {
        if (e != null && !isFull()) {
            back++;
            if (back >= size)
                back = 0;
            rep[back] = e;
            count++;
        }
    }

    /**
     * Retrieve an element from the front of the queue.
     * 
     * @return the element at the front of the queue, or null if the queue is empty
     */
    public Object get() {
        Object result = null;
        if (!isEmpty()) {
            result = rep[front];
            rep[front] = null;
            front++;
            if (front >= size)
                front = 0;
            count--;
        }
        return result;
    }

    /**
     * Executes a simple test procedure showing the functionality of the class.
     * 
     * @param args  CLI arguments
     */
    public static void main(String args[]) {
        OriginalBoundedQueue queue = new OriginalBoundedQueue(10);
        for (int i = 0; !queue.isFull(); i++) {
            queue.put(new Integer(i));
            System.out.println("put: " + i);
        }
        while (!queue.isEmpty()) {
            System.out.println("get: " + queue.get());
        }
    }
}