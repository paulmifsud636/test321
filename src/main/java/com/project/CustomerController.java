package com.project;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CustomerController 
{
	@Autowired
	CustomerRepo custRepo;
	
	@Autowired
	private CustomerService customerService; 
		
		@RequestMapping("/customer")
		public String showCustomerList(Model model, @Param("criteria") String criteria)
		{
				List<Customer>listCustomer = customerService.findByOrdered_week(criteria);
				model.addAttribute("listCustomer" , listCustomer);
				model.addAttribute("criteria" , criteria);
				return "/customer";				
		}	
		
		@GetMapping("/customer/new")
		public String newCustomerForm(Model model)
		{
			model.addAttribute("customer" , new Customer());
			return "customer_form";
		}
		
		@PostMapping("/customer/save")
		public String saveCustomer(Customer customer) 
		{
		customerService.save(customer);
		return "redirect:/customer";
		}	
}
		