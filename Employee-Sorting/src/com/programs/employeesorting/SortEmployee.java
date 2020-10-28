package com.programs.employeesorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployee {
	
	static List<Employee> employeeList=new ArrayList<>();
	
	static {
		employeeList.add(new Employee("Anand", "Kumar", 26, "India"));
		employeeList.add(new Employee("Nikil", "Kumar", 37, "USA"));
		employeeList.add(new Employee("Rahul", "Kapadia", 48, "Sri Lanka"));
		employeeList.add(new Employee("Meena", "Jain", 45, "Singapore"));
		employeeList.add(new Employee("Ashok", "Karthick", 53, "Australia"));
		employeeList.add(new Employee("Meena", "Jain", 48, "Singapore"));
		employeeList.add(new Employee("Anand", "Kumar", 26, "China"));
		employeeList.add(new Employee("Vikas", "Bana", 26, "China"));
	}
	
	
	public static List<Employee> sortEmployee(List<Employee> employees,String[] sortAttributes){
		
//		employees=employees.stream().sorted(Comparator.comparing(Employee::getAge)
//												.thenComparing(Comparator.comparing(Employee::getFirstName))
//													.thenComparing(Comparator.comparing(Employee::getCountry)))
//				
//				.collect(Collectors.toList());
		
		Comparator<Employee> chainComparator=null;;
		
		for (String attribute : sortAttributes) {
			
			if(attribute.equalsIgnoreCase("country")) {
				chainComparator=(chainComparator==null?Comparator.comparing(Employee::getCountry)
							:chainComparator.thenComparing(Comparator.comparing(Employee::getCountry)));			
			}
			
			if(attribute.equalsIgnoreCase("firstName")) {
				chainComparator=(chainComparator==null?Comparator.comparing(Employee::getFirstName)
							:chainComparator.thenComparing(Comparator.comparing(Employee::getFirstName)));			
			}
			
			if(attribute.equalsIgnoreCase("lastName")) {
				chainComparator=(chainComparator==null?Comparator.comparing(Employee::getLastName)
							:chainComparator.thenComparing(Comparator.comparing(Employee::getLastName)));			
			}
			
			if(attribute.equalsIgnoreCase("age")) {
				chainComparator=(chainComparator==null?Comparator.comparing(Employee::getAge)
							:chainComparator.thenComparing(Comparator.comparing(Employee::getAge)));			
			}
			
			
		}
		
		if(chainComparator!=null) {
			employees= employees.stream().sorted(chainComparator).collect(Collectors.toList());
		}
		return employees;
	}
	
	public static void main(String[] args) {
		String[] sortAttribute= {"age","firstname","country"};
		
		sortEmployee(employeeList, sortAttribute)
			.forEach(e->System.out.println(e.toString()));
		
	}
	
	
	
}
