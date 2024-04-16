package Lab7.prob1.partB;

import java.util.Objects;

public class Employee {
	private String name;
	private int salary;
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override 
	public String toString() {
		return "(" + name + ", " + salary + ")";
	}

	// Wrong implementation
	//	public boolean equals(Employee e) {
	//		return e.name.equals(name) && e.salary == salary;
	//	}

	// Proper Overridden equals() method
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(getClass() != ob.getClass()) return false;
		Employee emp = (Employee)ob;
		return emp.getName().equals(name) && emp.getSalary() == salary;
	}

//  No need to override hashCode because we are not using HashMap, Hashtable or HashSet
//	Not implemented in the given code either
//	@Override
//	public int hashCode() {
//		return Objects.hash(name, salary);
//	}
}
