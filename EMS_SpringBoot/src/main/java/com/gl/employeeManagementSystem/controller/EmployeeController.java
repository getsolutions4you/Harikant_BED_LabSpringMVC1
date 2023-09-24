package com.gl.employeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.gl.employeeManagementSystem.entity.Employee;
import com.gl.employeeManagementSystem.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService empEmployeeService) {
		this.employeeService = empEmployeeService;
	}

	@GetMapping("/employees")
	public String listEmployees(Model model) {

		// get employee from database
		List<Employee> employees = employeeService.findAll();

		// add to the spring model
		model.addAttribute("employees", employees);

		return "employees";
	}

	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}

	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		// save the book
		employeeService.saveEmployee(employee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees";
	}

	@GetMapping("/employees/edit/{id}")
	public String updateEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee) {
		// save the book
		employeeService.updateEmployee(id, employee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees";
	}

	@GetMapping("/employees/{id}")
	public String delete(@PathVariable int id) {

		// delete the employee
		employeeService.deleteEmployeeById(id);

		return "redirect:/employees";

	}

}
