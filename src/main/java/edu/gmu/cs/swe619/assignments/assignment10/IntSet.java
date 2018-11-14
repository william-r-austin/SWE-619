package edu.gmu.cs.swe619.assignments.assignment10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Overview: IntSets are unbounded, mutable sets of integers. This implementation
 * uses a List to store the elements, but the ordering of the elements does not
 * matter in a set. This class is based on the code given in Liskov, section 5.3.2,
 * with modifications. Specifically:
 * - The clone method shown figure 5.10 has been replaced with a correct version.
 * - the equals() and hashCode() methods have been implemented correctly.
 * - toString() and repOk() have also been implemented.
 * - As noted, this implementation uses a List instead of a Vector.
 * 
 * Example:  An IntSet with the numbers 1 through 4 could be {3, 1, 2, 4}
 */
public class IntSet implements Cloneable {
	
	/**
	 * This is the rep. We use a list to store the integer values in the set. Duplicates
	 * are not allowed in the list.
	 */
	private List<Integer> els;
	
	/**
	 * Public constructor to create a new IntSet. The set is initialized to be empty.
	 * 
	 * @throws  RuntimeException  if the rep invariant is violated
	 */
	public IntSet()	{
		els = new ArrayList<Integer>();
		
		if(!repOk()) {
			throw new RuntimeException("IntSet constructor: Rep invariant violation.");
		}
	}
	
	/**
	 * Attempts to add x to the IntSet. It is not added if this already contains x.
	 * 
	 * @param x  the integer to add to the IntSet
	 * @throws   RuntimeException  if the rep invariant is violated
	 */
	public void insert(int x) {
		Integer y = new Integer(x);
		if(getIndex(y) < 0) {
			els.add(y);
		}
		
		if(!repOk()) {
			throw new RuntimeException("IntSet.insert: Rep invariant violation.");
		}
	}
	
	/**
	 * Removes x from the IntSet.
	 * 
	 * @param x  the integer to remove from this
	 * @throws   RuntimeException  if the rep invariant is violated
	 */
	public void remove (int x) {
		int i = getIndex(new Integer(x));
		if(i < 0) {
			return;
		}
		
		Integer lastElement = els.get(els.size() - 1);
		els.set(i, lastElement);
		els.remove(els.size() - 1);
		
		if(!repOk()) {
			throw new RuntimeException("IntSet.remove: Rep invariant violation.");
		}
	}
	
	/**
	 * Checks to see if x is contained in the IntSet.
	 * 
	 * @param x  the integer to find in the IntSet
	 * @return   true if x is contained in the IntSet, false otherwise
	 */
	public boolean isIn (int x) {
		return getIndex(new Integer(x)) >= 0; 
	}
	
	/**
	 * Get the index in the IntSet where x appears. If x is not contained
	 * in the set, -1 is returned.
	 * 
	 * @param x  the integer to locate in this
	 * @return   the index of x in the IntSet, otherwise -1 if x is
	 *           not contained in this
	 */
	private int getIndex(Integer x) {
		for (int i = 0; i < els.size(); i++) {
			if (x.equals(els.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Get the size (cardinality) of the IntSet.
	 * 
	 * @return  the number of integers in the IntSet
	 */
	public int size( ){
		return els.size( );
	}
	
	/**
	 * Choose an arbitrary integer that is contained in the IntSet. Throw a NSEE
	 * if this is empty.
	 * 
	 * @return  arbitrary integer in the set
	 * @throws  NoSuchElementException if the IntSet is empty
	 */
	public int choose () {
		if (els.size() == 0) {
			throw new NoSuchElementException("IntSet.choose");
		}
		
		Integer lastElement = els.get(els.size() - 1);
		return lastElement;
	}

	/**
	 * Provide a string that represents the abstract state of the IntSet. We choose to 
	 * use a List<Integer> as our rep, so we can use that for the AF as well. 
	 * 
	 * Note that the rep does not impose an ordering constraint. Therefore, if we have
	 * two IntSets, a and b, where a = [1, 2], and b = [2, 1]:
	 * 
	 *  a.equals(b) does not imply that a.toString().equals(b.toString()) 
	 * 
	 * @return  a string representing the state of the IntSet
	 */
	@Override
	public String toString() {
		return els.toString();
	}
	
	/**
	 * Override the equals() method to determine if two IntSet objects meet the requirements for
	 * equality. For IntSet, this means that the set of elements in the two objects are the
	 * same when performing an unordered comparison.
	 * 
	 * This implementation creates a copy of both lists of integers, sorts the results,
	 * and compares the results in a pair-wise fashion. This final equality check is
	 * delegated to the equals() implementation provided by the AbstractList class. 
	 * 
	 * @return  true if the passed object is an IntSet equal to this, false otherwise
	 */
	@Override 
	public boolean equals(Object obj) {
		boolean isEqual = false;
		
		if(obj != null) {
			if(obj instanceof IntSet) {
				IntSet other = (IntSet) obj;
				List<Integer> thisCopy = new ArrayList<>(this.els);
				List<Integer> otherCopy = new ArrayList<>(other.els);

				Collections.sort(thisCopy);
				Collections.sort(otherCopy);
				
				isEqual = thisCopy.equals(otherCopy);
			}
		}
		return isEqual;
	}

	/**
	 * Override the hashCode() method to return a hash value based on the
	 * contents of the IntSet. 
	 * 
	 * This implementation makes a copy of the list of integers in the set,
	 * sorts it and generates a hash value from that. This ensures that the
	 * requirement for equal objects to have the same hashCode() value is met.
	 * Note that the final hash calculation is delegated to the implementation
	 * provided by the AbstractList class. 
	 * 
	 * @return  a hash value for the IntSet
	 */
	@Override
	public int hashCode() { 
		List<Integer> thisCopy = new ArrayList<>(this.els);
		Collections.sort(thisCopy);
		return thisCopy.hashCode();
	}

	/**
	 * A correct implementation for the clone() method, as prescribed by
	 * Bloch. It meets the contract for the clone() method, and allows us to
	 * also implement clone() in our subclasses. More specifically, for 
	 * an IntSet x:
	 * 
	 *  IntSet y = x.clone();
	 *  x != y && x.equals(y);  // true
	 * 
	 * Note that we have added the Cloneable to the list of interfaces 
	 * implemented by IntSet.
	 * 
	 * @return  an IntSet x that meets this.equals(x) and x != this 
	 */
	@Override
	public IntSet clone() { 
		IntSet clone = null;
		try {
			clone = (IntSet) super.clone();
			clone.els = new ArrayList<>(els);
		} 
		catch (CloneNotSupportedException e) {
			throw new AssertionError(e);
		}
		
		return clone;
	}
	
	/**
	 * Validates the rep invariant. We require that:
	 *   1. The rep is not null.
	 *   2. All elements in the IntSet are non-null.
	 *   3. The rep does not contain any duplicates.
	 *   
	 * @return  true if the rep invariant is satisfied, false otherwise, which would
	 *          indicate that the internal state of the object is corrupted
	 */
	private boolean repOk() {
		if(els == null) {
			return false;
		}
		
		for(int i = 0; i < els.size(); i++) {
			Integer element = els.get(i);
			if(element == null) {
				return false;
			}
			
			if(els.indexOf(element) != i) {
				return false;
			}
		}
		
		return true;
	}
}