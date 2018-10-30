package edu.gmu.cs.swe619.exercises.execise08;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lambdas {
	public static void main(String[] args) {
		List<Person> roster = new ArrayList<>();
		roster.add(new Person("Joe", Person.Sex.MALE, 25));
		roster.add(new Person("Frank", Person.Sex.MALE, 30));
		roster.add(new Person("Zach", Person.Sex.MALE, 35));
		roster.add(new Person("Mark", Person.Sex.MALE, 40));
		
		System.out.println("Older than 22: ");
		printPersonsOlderThan(roster, 22);
		
		System.out.println("Older than 28: ");
		printPersonsOlderThan(roster, 28);
		
		System.out.println("Age 27-37: ");
		printPersonsWithinAgeRange(roster, 27, 37);
		
		System.out.println("Eligible for Selective Service: ");
		Predicate<Person> eligibleForSelectiveService = getEligibleForSSPredicate2();
		printPersons(roster, eligibleForSelectiveService);
	}
	
	public static Predicate<Person> getEligibleForSSPredicate() {
		Predicate<Person> predicate = new Predicate<Person>() {
			@Override
			public boolean test(Person t) {
				int age = t.getAge();
				return (age >= 18 && age <= 25 && Person.Sex.MALE.equals(t.getGender()));
			}
		};
		
		return predicate;
	}
	
	public static Predicate<Person> getEligibleForSSPredicate2() {
		return p -> p.getAge() >= 18 && p.getAge() <= 25 && Person.Sex.MALE == p.getGender();
	}
	
	public static void printPersonsOlderThan(List<Person> roster, int age) {
		roster.stream()
			.filter(p -> (p.getAge() > age))
			.forEach(System.out::println);
	}
	
	public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
		roster.stream()
			.filter(p -> (p.getAge() >= low && p.getAge() <= high))
			.forEach(System.out::println);
	}
	
	public static void printPersons(List<Person> roster, Predicate<Person> predicate) {
		roster.stream().filter(predicate).forEach(System.out::println);
	}
}