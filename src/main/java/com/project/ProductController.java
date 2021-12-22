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
public class ProductController 
{
	@Autowired
	ProductRepo prodRepo;
	
	@Autowired
	private ProductService productService; 
		
		@RequestMapping("/product")
		public String showProductList(Model model, @Param("criteria") String criteria)
		{
				List<Product>listProduct = productService.listAll(criteria);
				model.addAttribute("listProduct", listProduct);
				model.addAttribute("criteria" , criteria);
				return "/product";
		}	
		
		@GetMapping("/product/new")
		public String newProductForm(Model model)
		{
			model.addAttribute("product" , new Product());
			return "product_form";
		}
		
		@PostMapping("/product/save")
		public String saveProduct(Product product) 
		{
		productService.save(product);
		return "redirect:/product";
		}
	}