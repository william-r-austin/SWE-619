package edu.gmu.cs.swe619.exercises.execise08;

import java.time.LocalDate;

public class Person {
	public enum Sex {
		MALE,
		FEMALE
	};
	
	private Sex gender;
	private String name;
	private int age;
	private LocalDate birthday; 
	private String emailAddress; 
	
	public Person(String name, Sex sex, int age) {
		this.name = name;
		this.gender = sex;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person name = " + name + ", age = " + age;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
