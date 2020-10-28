package com.programs.employeesorting;

public class Employee {

	private String firstName;
	private String lastName;
	private Integer age;
	private String country;
	
	public Employee(String firstName, String lastName, Integer age, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", country=" + country
				+ "]";
	}
	
	
}
