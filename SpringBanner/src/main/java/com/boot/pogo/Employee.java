package com.boot.pogo;
import java.util.List;
import java.util.ArrayList;


public class Employee {
	private int id;
	private String empName;
	private long sal;
	private String age;
	public Employee() {
		super();
	}
	public Employee(int id, String empName, long sal) {
		super();
		this.id = id;
		this.empName = empName;
		this.sal = sal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public long getSal() {
		return sal;
	}
	public void setSal(long sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", sal=" + sal + "]";
	}
	
	public static List<Employee> getEmployeeList() {
		Employee emp0 = new Employee(5, "Sankar", 900);
   	 Employee emp1 = new Employee(1, "Uma", 1000);
   	 Employee emp2 = new Employee(4, "Uma1", 7000);
   	 Employee emp3 = new Employee(2, "Uma1", 3000);
   	 Employee emp4 = new Employee(3, "Uma1", 2000);
   	 
   	 List<Employee> empList = new ArrayList<>();
   	 
   	 empList.add(emp0);
   	 empList.add(emp1);
   	 empList.add(emp2);
   	 empList.add(emp3);
   	 empList.add(emp4);
   	 return empList;
	}

}
