package com.jacaranda.employeeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jacaranda.employeeProject.model.Company;
import com.jacaranda.employeeProject.model.Employee;
import com.jacaranda.employeeProject.service.CompanyService;
import com.jacaranda.employeeProject.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CompanyService companyService;
	
//	muestra todos los empleados
	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> employees = employeeService.getEmployees();
		model.addAttribute("employees", employees);
		return "listEmployee";
	}
	
//	añade un empleado
	@GetMapping("/formAdd")
	public String  formAddEmployee(Model model) {
		List<Company> companies = companyService.getCompanies();
		model.addAttribute("companies", companies);
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@GetMapping("/add")
	public String  addEmployee(Model model, @ModelAttribute("employee") Employee employee) {
		employee.setAdmin('0');
		employeeService.saveEmployee(employee);
		model.addAttribute("employee", employee);
		List<Company> companies = companyService.getCompanies();
		model.addAttribute("companies", companies);
		model.addAttribute("added", "Empleado añadido correctamente");
		return "addEmployee";
	}
	
//	actualiza un empleado
	@GetMapping("/formUpdate/{id}")
	public String  formUpdateEmployee(Model model, @PathVariable("id") int idEmployee) {
		Employee employee = employeeService.getEmployee(idEmployee);
		List<Company> companies = companyService.getCompanies();
		model.addAttribute("companies", companies);
		model.addAttribute("employee", employee);
		return "updateEmployee";
	}
	
	@GetMapping("/update")
	public String  updateEmployee(Model model, @ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		model.addAttribute("employee", employee);
		List<Company> companies = companyService.getCompanies();
		model.addAttribute("companies", companies);
		model.addAttribute("employee", employee);
		model.addAttribute("updated", "Empleado actualizado correctamente");
		return "updateEmployee";
	}
	
//	borra un empleado
	@GetMapping("/formDelete/{id}")
	public String  formDeleteEmployee(Model model, @PathVariable("id") int idEmployee) {
		Employee employee = employeeService.getEmployee(idEmployee);
		List<Company> companies = companyService.getCompanies();
		model.addAttribute("companies", companies);
		model.addAttribute("employee", employee);
		return "deleteEmployee";
	}
	
	@GetMapping("/delete")
	public String  deleteEmployee(Model model, @ModelAttribute("employee") Employee employee) {
		employeeService.deleteEmployee(employee);
		model.addAttribute("employee", employee);
		List<Company> companies = companyService.getCompanies();
		model.addAttribute("companies", companies);
		model.addAttribute("employee", employee);
		model.addAttribute("updated", "Empleado borrado correctamente");
		return "deleteEmployee";
	}
	

}
