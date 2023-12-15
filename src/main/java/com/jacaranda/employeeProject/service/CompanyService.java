package com.jacaranda.employeeProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.employeeProject.model.Company;
import com.jacaranda.employeeProject.repository.CompanyRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
	@Autowired
	CompanyRepository companyRepository;
	
//  obtiene todas las compañias	
	public List<Company> getCompanies(){
		return companyRepository.findAll();
	}
	
//	obtiene una compañia
	public Company getCompany(int id) {
		return companyRepository.findById(id).orElse(null);
	}
	
//	guarda una compañia en la BD
	public Company addCompany(Company company) {
		return companyRepository.save(company);
	}
	

}
