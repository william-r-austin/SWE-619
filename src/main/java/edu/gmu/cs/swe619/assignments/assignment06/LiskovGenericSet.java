package edu.gmu.cs.swe619.assignments.assignment06;

/**
 * Generified Liskov Set example
 * @author Paul Ammann
 */

import java.util.*;

public class LiskovGenericSet<E> {

  private List<E> elements;

  public LiskovGenericSet() {   
     this.elements = new ArrayList<E>();
  }

  public void insert (E e) {
    if (!(isIn(e))) {
       elements.add(e);
    }
  }

  public void remove (E e) {
     elements.remove(e);
  }

  public boolean isIn(E e) {
     return elements.contains(e);
  }

  public int size() {
     return elements.size();
  }

  public E choose() {
     if (elements.size() == 0) throw new IllegalArgumentException();
     return elements.get(0);
  }

  // Conveniently, the rep state is exactly the abstract state
  public String toString() { return elements.toString(); }
}