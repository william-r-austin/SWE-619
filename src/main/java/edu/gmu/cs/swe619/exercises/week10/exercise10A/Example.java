package edu.gmu.cs.swe619.exercises.week10.exercise10A;

import java.util.HashSet;
import java.util.Set;

public class Example {
	public static void main(String[] args) {
		Set<String> r = new HashSet<String>();
		r.add("ant"); 
		r.add("bee");
		
		System.out.println("1. r = " + r);

		Set<String> sh = new InstrumentedHashSet<String>();
		sh.addAll(r);
		System.out.println("2. r = " + r);
		System.out.println("2. sh = " + sh);
		System.out.println("2. sh.count = " + ((InstrumentedHashSet<String>) sh).getAddCount());

		Set<String> s =  new InstrumentedSet<String>(r);
		s.add("ant"); 
		s.add("cat");
		System.out.println("3. r = " + r);
		System.out.println("3. sh = " + sh);
		System.out.println("3. sh.count = " + ((InstrumentedHashSet<String>) sh).getAddCount());
		System.out.println("3. s = " + s);

		Set<String> t = new InstrumentedSet<String>(s);
		t.add("dog");
		System.out.println("4. r = " + r);
		System.out.println("4. sh = " + sh);
		System.out.println("4. sh.count = " + ((InstrumentedHashSet<String>) sh).getAddCount());
		System.out.println("4. s = " + s);
		System.out.println("4. t = " + t);

		r.remove("bee");
		s.remove("ant");
		System.out.println("5. r = " + r);
		System.out.println("5. sh = " + sh);
		System.out.println("5. sh.count = " + ((InstrumentedHashSet<String>) sh).getAddCount());
		System.out.println("5. s = " + s);
		System.out.println("5. t = " + t);
		System.out.println("5. r.equals(s) = " + r.equals(s));
		System.out.println("5. s.equals(t) = " + s.equals(t));
		System.out.println("5. t.equals(s) = " + t.equals(s));
	}
}
