package edu.gmu.cs.swe619.exercises.week03;

import java.util.ArrayList;
import java.util.List;

public class Queue <E> {

   private List<E> elements;
   private int size;

   public Queue() {   
      this.elements = new ArrayList<E>();
      this.size = 0;
   }

   public void enQueue (E e) {
     elements.add(e);
     size++;
   }

   public E deQueue () {
     if (size == 0) throw new IllegalStateException("Queue.deQueue");
     E result = elements.get(0);
     elements.remove(0);
     size--;
     return result;
   }

   public boolean isEmpty() {
      return size == 0;
   }
}
