package edu.gmu.cs.swe619.exercises.week10.exercise10A;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {
	private static final long serialVersionUID = 1L;
	private int addCount = 0;
	
	public InstrumentedHashSet() {}

   @Override public boolean add(E e){ 
      addCount++; 
      return super.add(e); 
   }
   @Override public boolean addAll(Collection<? extends E> c){ 
       // What to do with addCount?
	   addCount += c.size();
       return super.addAll(c); 
   }
   public int getAddCount(){ return addCount; }
}