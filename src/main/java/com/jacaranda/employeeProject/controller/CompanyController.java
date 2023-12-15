package com.jacaranda.employeeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.jacaranda.employeeProject.model.Company;
import com.jacaranda.employeeProject.service.CompanyService;

@Controller
public class CompanyController {
	@Autowired
	CompanyService companyService;
	
//	obtiene todas las compañias
	@GetMapping("/listCompanies")
	public String listCompanies (Model model) {
		List<Company> companies = companyService.getCompanies();
		model.addAttribute("companies", companies);
		return "listCompanies";
	}
	
//	agregar una compañia
	@GetMapping("/formAddCompany")
	public String addCompany(Model model) {
		model.addAttribute("company", new Company());
		return "addCompany";
	}
	
	@GetMapping("/addCompany")
	public String calculate(Model model, @ModelAttribute("company") Company company) {
		Company c = companyService.addCompany(company);
		return "addCompany";
	}
	
//	actualizar una compañia
	@GetMapping("/formUpdateCompany/{id}")
	public String formUpdateCompany(Model model, @PathVariable("id") int companyId) {
		Company c = companyService.getCompany(companyId);
		model.addAttribute("companyUpdate", c);
		return "updateCompany";
	}
	
	@GetMapping("/updateCompany")
	public String updateCompany(Model model, @ModelAttribute("companyUpdate") Company company) {
		companyService.addCompany(company);
		model.addAttribute("companyUpdate", company);
		return "updateCompany";
	}
	
	
}
