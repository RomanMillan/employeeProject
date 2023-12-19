package com.jacaranda.employeeProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jacaranda.employeeProject.model.Employee;
import com.jacaranda.employeeProject.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
//  obtiene todos los empleados	
	public Page<Employee> getEmployees(int pageNum, int pageSize){
		Pageable pageable = PageRequest.of(pageNum -1, pageSize);
		return employeeRepository.findAll(pageable);
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
