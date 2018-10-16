/**
 * 
 */
/**
 * @author William
 *
 */
package edu.gmu.cs.swe619.exercises.week05;

import java.util.ArrayList;
import java.util.List;

public class Exercise5AConstructorTest {
	
	
	private static class A {
		public List<String> superclassList1 = new ArrayList<String>();
		public List<String> superclassList2;
		
		public A() {
			superclassList2 = new ArrayList<String>();
			System.out.println("Executing constructor A.");
		}
	}
	
	private static class B extends A {
		
		public int x = 3;
		
		public B() {
			x = 5; 
		}
		
	}
	
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.superclassList1);
		System.out.println(a.superclassList2);
		
		B b = new B();
		System.out.println(b.superclassList1);
		System.out.println(b.superclassList2);
	}
} 