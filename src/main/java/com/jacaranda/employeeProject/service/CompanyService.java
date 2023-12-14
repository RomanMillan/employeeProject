package com.jacaranda.employeeProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.employeeProject.model.Company;
import com.jacaranda.employeeProject.repository.CompanyRepository;
import java.util.List;

@Service
public class CompanyService {
	@Autowired
	CompanyRepository companyRepository;
	
//  obtine todas las compañias	
	public List<Company> getCompanies(){
		return companyRepository.findAll();
	}
	
//	guarda una compañia en la BD
	public Company addCompany(Company company) {
		return companyRepository.save(company);
	}
}
