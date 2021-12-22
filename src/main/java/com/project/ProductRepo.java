package com.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>
{
	@Query("SELECT DISTINCT p FROM Product p JOIN p.orders o JOIN o.customer c WHERE c.country like %?1%")
	public List<Product>findAll(String criteria);
}

