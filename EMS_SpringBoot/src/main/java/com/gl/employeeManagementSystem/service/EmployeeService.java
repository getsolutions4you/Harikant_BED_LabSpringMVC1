package com.gl.employeeManagementSystem.service;

import java.util.List;

import com.gl.employeeManagementSystem.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();

	public Employee findById(int theId);

	public void saveEmployee(Employee employee);

	public void deleteEmployeeById(int theId);

	public Object getEmployeeById(Long id);

	public Employee updateEmployee(Long id, Employee employee);
}
