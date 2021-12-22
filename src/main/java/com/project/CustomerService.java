package com.project;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service	
public class CustomerService 
{
	@Autowired
	private CustomerRepo custRepo;
		  
	public List<Customer> findByOrdered_week(String criteria) {
	{
		 if (criteria != null)
		 {
			return custRepo.findByOrdered_week(criteria); 
		  }
		 return custRepo.findAll();
		}
	}

	public void save(Customer customer) 
	{
		custRepo.save(customer);
	}
}