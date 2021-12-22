package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
@Autowired
private MyRepo repo;
     
  public Login login(String username, String password) {   
	if (repo.existsByUsername("admin") != true)
	{
	  repo.save(new Login("admin","admin"));
	}
	else 
	{}
  	  
  Login user = repo.findByUsernameAndPassword(username, password);
   return user;
  }  
}