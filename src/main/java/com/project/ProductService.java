package com.project;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	@Service
	public class ProductService 
	{
		@Autowired
		private ProductRepo prodRepo;
		  
		public List<Product>listAll(String criteria)
		 {
			  if (criteria != null)
			  {
				return prodRepo.findAll(criteria);  
			  }
			  return (List<Product>) prodRepo.findAll();
		 }

		public void save(Product product) 
		{
			prodRepo.save(product);
		}
	}	 

	  
	  
	  
	  
	  
	  
	