package com.example.demo.model.response.data;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.response.Employee;

public class DataBase {
	
	private static List<Employee> employees = new ArrayList<Employee>();
	
	
	static {
		Employee emp = new Employee();
		emp.setFirstName("Manish");
		emp.setLastName("Jones");
		emp.setDepartment("computers");
		emp.setEmpId("123");
		emp.setLocation("Delhi");
		employees.add(emp);
		emp = new Employee();
		emp.setFirstName("Pete");
		emp.setLastName("Gates");
		emp.setDepartment("finance");
		emp.setEmpId("1224");
		emp.setLocation("Paris");
		employees.add(emp);
		emp = new Employee();
		emp.setFirstName("Neil");
		emp.setLastName("Young");
		emp.setDepartment("computers");
		emp.setEmpId("2321");
		emp.setLocation("Delhi");
		employees.add(emp);
		emp = new Employee();
		emp.setFirstName("Sunder");
		emp.setLastName("Arora");
		emp.setDepartment("computers");
		emp.setEmpId("3213");
		emp.setLocation("New York");
		employees.add(emp);
		emp = new Employee();
		emp.setFirstName("Katja");
		emp.setLastName("Larsen");
		emp.setDepartment("admin");
		emp.setEmpId("436");
		emp.setLocation("Stockholm");
		employees.add(emp);
		emp = new Employee();
		emp.setFirstName("Test");
		emp.setLastName("Larsen");
		emp.setDepartment("admin");
		emp.setEmpId("7747");
		emp.setLocation("Gurgaon");
		employees.add(emp);
		emp = new Employee();
		emp.setFirstName("Test1");
		emp.setLastName("Larsen");
		emp.setDepartment("admin");
		emp.setEmpId("1000");
		emp.setLocation("London");
		employees.add(emp);
		
	
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Employee> getEmployees(){
			return employees;
	}
	
	/**
	 * 
	 * @param empId
	 * @return
	 */
	public static Employee getEmployeeById(String empId) {
		for(Employee e : employees) {
			if(e.getEmpId().equals(empId)) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param dept
	 * @return
	 */
	public static List<Employee> getEmployeesByDept(String dept){
		List<Employee> employeesByDept = new ArrayList<Employee>();
		for(Employee e : employees) {
			if(e.getDepartment().equalsIgnoreCase(dept)) {
				employeesByDept.add(e);
			}
		}
		return employeesByDept;
	}
	
	public static void main(String[] args) {
		List<Employee> e = getEmployees();
		List<Employee> e1 = getEmployeesByDept("computers");
		Employee e11 = getEmployeeById("123");
				
		System.out.println("");
		
	}
}
