package edu.gmu.cs.swe619.exercises.week10.exercise10A;

import java.util.Set;

public class InstrumentedSet<E> extends ForwardingSet<E> {
   private int addCount = 0;	

   public InstrumentedSet(Set<E> s) {
	   super(s);
   }
   
   @Override 
   public boolean add(E e) {
	   addCount++; return super.add(e);
   }
   
   public int getAddCount() {
	   return addCount;
   }

	@Override
	public String toString() {
		return "InstrumentedSet: addCount = " + addCount + ", values = " + super.toString();
	}
}
