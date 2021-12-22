package com.project;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepo extends CrudRepository<Login, String>
{
		Login findByUsernameAndPassword(String username, String password);
		boolean existsByUsername(String string);
		Optional<Login> findByUsername(String username);
}
