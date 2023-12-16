package com.jacaranda.employeeProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.employeeProject.model.Employee;
import com.jacaranda.employeeProject.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
//  obtiene todos los empleados	
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	
//	obtiene un empleado
	public Employee getEmployee(int id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
//	añade/actualiza un empleado
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
//	borra un empleado
	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}
}
