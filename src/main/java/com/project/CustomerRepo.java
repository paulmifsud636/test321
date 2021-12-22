package com.project;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>
{
	@Query("SELECT c FROM Customer c JOIN c.orders o WHERE o.ordered_week LIKE %?1%")
	public List<Customer> findByOrdered_week(String criteria);
}
